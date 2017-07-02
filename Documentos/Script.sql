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
CODCATPAI integer,
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

CREATE PROCEDURE transferencia (IN t_data DATE, IN t_pago INT, IN T_lembrete DATE, IN T_nota VARCHAR(100), IN T_valor REAL, IN T_codconpartida INT, IN T_codcondestino INT, IN T_codusu INT)
BEGIN

  select DESCRCON 
  from CONTA
  where CODCON = T_codcondestino
  into @DESCRCON;

	INSERT INTO TRANSACAO (DESCRTRA, DATA, PAGO, LEMBRETE, NOTA, VALOR, TIPO, CODCON, CODUSU)
  VALUES(concat("Transferência para ", @DESCRCON), t_data, t_pago, T_lembrete, T_nota, T_valor, "D", T_codconpartida, T_codusu);
  
  SELECT max(CODTRA)
	FROM TRANSACAO 
  WHERE CODUSU = T_codusu
  INTO @CODTRAPART;

  select DESCRCON 
  from CONTA
  where CODCON = T_codconpartida
  into @DESCRCON;

  INSERT INTO TRANSACAO (DESCRTRA, DATA, PAGO, LEMBRETE, NOTA, VALOR, TIPO, CODCON, CODUSU, CODTRATRANSF)
	VALUES(concat("Transferência de ", @DESCRCON, " - ", @CODTRAPART), t_data, t_pago,	T_lembrete,	T_nota,	T_valor, "R",	T_codcondestino, T_codusu, @CODTRAPART);

  SELECT max(CODTRA)
	FROM TRANSACAO
  WHERE CODUSU = T_codusu
  INTO @CODTRADEST;

  UPDATE TRANSACAO
	SET CODTRATRANSF = @CODTRADEST,
  DESCRTRA = concat(DESCRTRA, " - ", @CODTRADEST)
  WHERE CODTRA = @CODTRAPART AND
        CODUSU = T_codusu;
END
