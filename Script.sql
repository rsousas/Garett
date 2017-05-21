create schema GARETT;

create table USUARIO
(
CODUSU integer not null,
NOMEUSU varchar(50) not null,
IDUSU varchar(20) not null,
SENHAUSU varchar(15) not null,
primary key (CODUSU)
);

create table CONTA
(
CODCON integer not null,
DESCRCON varchar(50) not null,
SALDOCON real not null,
ATIVOCON integer not null,
CODUSU integer not null,
primary key (CODCON),
foreign key (CODUSU) references USUARIO (CODUSU)
);

create table CATEGORIA
(
CODCAT integer not null,
DESCRCAT varchar(50) not null,
CODCATPAI integer,
ATIVOCAT integer not null,
CODUSU integer not null,
primary key (CODCAT),
foreign key (CODUSU) references USUARIO (CODUSU)
);

create table TRANSACAO
(
CODTRA integer not null, 
DESCRTRA varchar(50) not null,
DATA date not null,
PAGO integer not null,
LEMBRETE date,
NOTA varchar(100),
VALOR real not null,
TIPO char(1) not null,
CODCAT integer not null,
CODCON integer not null,
CODUSU integer not null,
CODTRATRANSF integer,
primary key (CODTRA),
foreign key (CODCAT) references CATEGORIA (CODCAT),
foreign key (CODCON) references CONTA (CODCON),
foreign key (CODUSU) references USUARIO (CODUSU),
foreign key (CODTRATRANSF) references TRANSACAO (CODTRATRANSF),
);
