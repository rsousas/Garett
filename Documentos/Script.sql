create schema GARETT;

create table USUARIO
(
CODUSU integer not null AUTO_INCREMENT,
NOMEUSU varchar(50) not null,
IDUSU varchar(20) not null,
SENHAUSU varchar(15) not null,
primary key (CODUSU));


create table CONTA
(
CODCON integer not null AUTO_INCREMENT,
DESCRCON varchar(50) not null,
SALDOCON real not null, 
ATIVOCON integer not null,
CODUSU integer not null,
primary key (CODCON, CODUSU),
foreign key (CODUSU) references USUARIO (CODUSU)
);

create table CATEGORIA
(
CODCAT integer not null AUTO_INCREMENT,
DESCRCAT varchar(50) not null,
ATIVOCAT integer not null,
CODUSU integer not null,
primary key (CODCAT, CODUSU),
foreign key (CODUSU) references USUARIO (CODUSU)
);

create table TRANSACAO
(
CODTRA integer not null AUTO_INCREMENT, 
DESCRTRA varchar(50) not null,
DATA date not null,
PAGO integer not null,
LEMBRETE date,
NOTA varchar(100),
VALOR real not null,
TIPO char(1) not null,
CODCAT integer,
CODCON integer not null,
CODUSU integer not null,
CODTRATRANSF integer,
primary key (CODTRA, CODUSU),
foreign key (CODCAT) references CATEGORIA (CODCAT),
foreign key (CODCON) references CONTA (CODCON),
foreign key (CODUSU) references USUARIO (CODUSU),
foreign key (CODTRATRANSF) references TRANSACAO (CODTRATRANSF)
);


create procedure I_transferencia (IN t_data date, IN t_pago INT, IN T_lembrete date, IN T_nota varchar(100), IN T_valor REAL, IN T_codconpartida INT, IN T_codcondestino INT, IN T_codusu INT)
begin
  select DESCRCON 
  from CONTA
  where CODCON = T_codcondestino
  into @DESCRCON;

  insert into TRANSACAO (DESCRTRA, DATA, PAGO, LEMBRETE, NOTA, VALOR, TIPO, CODCON, CODUSU)
  values(concat("Transferência para ", @DESCRCON), t_data, t_pago, T_lembrete, T_nota, T_valor, "D", T_codconpartida, T_codusu);
  
  select max(CODTRA)
  from TRANSACAO 
  where CODUSU = T_codusu
  into @CODTRAPART;

  select DESCRCON 
  from CONTA
  where CODCON = T_codconpartida
  into @DESCRCON;

  insert into TRANSACAO (DESCRTRA, DATA, PAGO, LEMBRETE, NOTA, VALOR, TIPO, CODCON, CODUSU, CODTRATRANSF)
  values(concat("Transferência de ", @DESCRCON, " - ", @CODTRAPART), t_data, t_pago,	T_lembrete,	T_nota,	T_valor, "R",	T_codcondestino, T_codusu, @CODTRAPART);

  select max(CODTRA)
  from TRANSACAO
  where CODUSU = T_codusu
  into @CODTRADEST;

  update TRANSACAO
  SET CODTRATRANSF = @CODTRADEST,
  DESCRTRA = concat(DESCRTRA, " - ", @CODTRADEST)
  where CODTRA = @CODTRAPART AND
        CODUSU = T_codusu;
end;

create procedure U_transferencia (IN t_data date, IN t_pago INT, IN T_lembrete date, IN T_nota varchar(100), IN T_valor REAL, IN T_codconpartida INT, IN T_codcondestino INT,IN T_codtrapartida INT, IN T_codtradestino INT, IN T_codusu INT)
begin
  select DESCRCON 
  from CONTA
  where CODCON = T_codcondestino
  into @DESCRCON;

  update TRANSACAO SET 
  DESCRTRA = concat("Transferência para ", @DESCRCON, " - ", T_codtradestino),
  DATA = t_data, 
  PAGO = t_pago, 
  LEMBRETE = T_lembrete,
  NOTA = T_nota,
  VALOR = T_valor,
  CODCON= T_codconpartida
  where CODTRA = T_codtrapartida AND
  CODUSU = T_codusu;

  select DESCRCON 
  from CONTA
  where CODCON = T_codconpartida
  into @DESCRCON;

  update TRANSACAO SET 
  DESCRTRA = concat("Transferência de ", @DESCRCON, " - ", T_codtrapartida),
  DATA = t_data, 
  PAGO = t_pago, 
  LEMBRETE = T_lembrete,
  NOTA = T_nota,
  VALOR = T_valor,
  CODCON= T_codcondestino
  where CODTRA = T_codtradestino AND
  CODUSU = T_codusu;
end;


create trigger AI_AtualizaCusto after insert
ON transacao
FOR EACH ROW
begin
  IF (NEW.TIPO = 'R') THEN
    update conta 
    SET saldocon = saldocon + NEW.VALOR
    where CODUSU = NEW.CODUSU AND
          CODCON = NEW.CODCON;
  ELSE
    update conta 
    SET saldocon = saldocon - NEW.VALOR
    where CODUSU = NEW.CODUSU AND
          CODCON = NEW.CODCON;  
  end IF;
end;

create trigger AU_AtualizaCusto after update
ON transacao
FOR EACH ROW
begin
  IF (NEW.TIPO = 'R') THEN
    update conta 
    SET saldocon = saldocon + (NEW.VALOR - OLD.VALOR)
    where CODUSU = NEW.CODUSU AND
          CODCON = NEW.CODCON;
  ELSE
    update conta 
    SET saldocon = saldocon - (NEW.VALOR - OLD.VALOR)
    where CODUSU = NEW.CODUSU AND
          CODCON = NEW.CODCON;  
  end IF;
end;

create trigger AD_AtualizaCusto after delete
ON transacao
FOR EACH ROW
begin
  IF (OLD.TIPO = 'R') THEN
    update conta 
    SET saldocon = saldocon - OLD.VALOR
    where CODUSU = OLD.CODUSU AND
          CODCON = OLD.CODCON;
  ELSE
    update conta 
    SET saldocon = saldocon + OLD.VALOR
    where CODUSU = OLD.CODUSU AND
          CODCON = OLD.CODCON;  
  end IF;

  IF NOT(OLD.CODTRATRANSF = NULL) THEN
    select CODTRA from transacao where codtra = OLD.CODTRATRANSF
    into @codtra;
    IF NOT(@codtra = NULL) THEN
      DELETE FROM transacao WHERE codtra = @codtra;
    end IF;
  end IF;
end;
  
create view V_TRANSFERENCIAS as
  select concat('Transferência de ', CO.DESCRCON, ' para ', CT.DESCRCON) DESCRICAO, T.DESCRTRA DESCRORIGEM, T.DATA, 
    concat(monthname(T.DATA),'/',year(T.DATA)) as MES_ANO,
    T.PAGO, T.LEMBRETE, T.NOTA, T.VALOR, CO.DESCRCON CONTAORIGEM, TF.DESCRTRA DESCRDESTINO, CT.DESCRCON CONTADESTINO, T.CODUSU
  from TRANSACAO T
  join TRANSACAO TF on TF.CODTRA = T.CODTRATRANSF and TF.CODUSU = T.CODUSU
  inner join CONTA CO on T.CODCON = CO.CODCON and T.CODUSU = CO.CODUSU
  inner join CONTA CT on TF.CODCON = CT.CODCON and T.CODUSU = CT.CODUSU
  where T.CODTRATRANSF is not null and
        T.TIPO = 'R'  
  order by T.DATA desc;  
  
create or replace view V_TRANSACOES as 
  select DESCRTRA, DATA, MES_ANO, LEMBRETE, NOTA, VALOR, TIPO, PAGO, DESCRCAT, DESCRCONTA, CONTADESTINO, CODUSU
  from (
  select T.CODTRA, T.DESCRTRA, T.DATA,
      concat(monthname(T.DATA),'/',year(T.DATA)) as MES_ANO,
      if(T.LEMBRETE = T.DATA, '', T.LEMBRETE) LEMBRETE, T.NOTA,
      case when T.TIPO='R' then T.VALOR else T.VALOR * (-1) end as VALOR, 
      T.TIPO,
      case when T.PAGO = 1 then 'Pago' else 'Pendente' end as PAGO, 
      CA.DESCRCAT, CO.DESCRCON AS DESCRCONTA, '' CONTADESTINO, T.CODUSU
    from TRANSACAO T
    inner join CATEGORIA CA on T.CODCAT = CA.CODCAT
    inner join CONTA CO on T.CODCON = CO.CODCON
  
  union all
  
  select T.CODTRA, concat('Transferência de ', CO.DESCRCON, ' para ', CT.DESCRCON) DESCRTRA, T.DATA, 
      concat(monthname(T.DATA),'/',year(T.DATA)) as MES_ANO,
      if(T.LEMBRETE = T.DATA, '', T.LEMBRETE) LEMBRETE, T.NOTA, T.VALOR, 'T', 
      case when T.PAGO = 1 then 'Pago' else 'Pendente' end as PAGO, 
      '', CO.DESCRCON CONTAORIGEM,  CT.DESCRCON CONTADESTINO, T.CODUSU
    from TRANSACAO T
    join TRANSACAO TF on TF.CODTRA = T.CODTRATRANSF and TF.CODUSU = T.CODUSU
    inner join CONTA CO on T.CODCON = CO.CODCON and T.CODUSU = CO.CODUSU
    inner join CONTA CT on TF.CODCON = CT.CODCON and T.CODUSU = CT.CODUSU
    where T.CODTRATRANSF is not null and
          T.TIPO = 'R'
  
  ) dados
  order by dados.DATA, dados.CODTRA;
  
CREATE PROCEDURE P_CONTAS()
BEGIN
  SELECT codcon, descrcon, 
  CASE WHEN ativo = 1 THEN 'Sim' ELSE 'Não' END AS Ativo 
  from V_CONTAS;
END;
 
CREATE PROCEDURE P_CATEGORIAS()
BEGIN
  SELECT codcat, descrcat, 
  CASE WHEN ativo = 1 THEN 'Sim' ELSE 'Não' END AS Ativo
  FROM V_CATEGORIAS;
END;

create or replace view V_CATEGORIAS as
 select CODCAT, DESCRCAT, CODUSU,
 case when ATIVOCAT = 1 then 'Sim' else 'Não' end as ATIVO
 from CATEGORIA;
 
create or replace view V_CONTAS as
  select CODCON, DESCRCON, CODUSU,
  case when ATIVOCON = 1 then 'Sim' else 'Não' end as ATIVO
  from CONTA;

CALL P_CONTAS();
 
CALL P_CATEGORIAS();