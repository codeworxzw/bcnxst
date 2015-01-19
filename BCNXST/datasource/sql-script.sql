/**
 * table definition
 */
-- network request message

drop table NETMSG;

create table NETMSG
(
	MTI varchar(4) default "0800",
	DE07 varchar(10),
	DE11 varchar(6),
	DE37 varchar(12),
	DE70 varchar(3) default "001"
);


-- balance enquiry message
drop table BALMSG;

create table BALMSG
(
	MTI varchar(4) default "0200",
	DE02 varchar(19),
	DE03 varchar(6) default "030000",
	DE04 varchar(12) default "000000000000",
	DE07 varchar(10),
	DE11 varchar(6),
	DE12 varchar(6),
	DE13 varchar(4),
	DE14 varchar(4),
	DE15 varchar(4),
	DE18 varchar(4) default "6011",
	DE19 varchar(3) default "418",
	DE22 varchar(3) default "021",
	DE25 varchar(2) default "01",
	DE28 varchar(9) default "D00000000",
	DE32 varchar(6),
	DE35 varchar(42),
	DE37 varchar(12),
	DE41 varchar(8),
	DE42 varchar(15),
	DE43 varchar(40),
	DE49 varchar(3) default "418",
	DE52 varchar(16)
);
-- cash withdrawal message
drop table CWDMSG;
create table CWDMSG
(
	MTI varchar(4) default "0200",
	DE02 varchar(19),
	DE03 varchar(6) default "010000",
	DE04 varchar(12) default "000000000000",
	DE07 varchar(10),
	DE11 varchar(6),
	DE12 varchar(6),
	DE13 varchar(4),
	DE14 varchar(4),
	DE15 varchar(4),
	DE18 varchar(4) default "6011",
	DE19 varchar(3) default "418",
	DE22 varchar(3) default "021",
	DE25 varchar(2) default "01",
	DE28 varchar(9) default "D00002000",
	DE32 varchar(6),
	DE35 varchar(42),
	DE37 varchar(12),
	DE41 varchar(8),
	DE42 varchar(15),
	DE43 varchar(40),
	DE49 varchar(3) default "418",
	DE52 varchar(16)
);

-- reversal message
drop table REVMSG;

create table REVMSG
(
	MTI varchar(4) default "0420",
	DE02 varchar(19),
	DE03 varchar(6) default "010000",
	DE04 varchar(12) default "000000000000",
	DE07 varchar(10),
	DE11 varchar(6),
	DE12 varchar(6),
	DE13 varchar(4),
	DE14 varchar(4),
	DE15 varchar(4),
	DE18 varchar(4) default "6011",
	DE19 varchar(3) default "418",
	DE22 varchar(3) default "021",
	DE25 varchar(2) default "01",
	DE28 varchar(9) default "D00002000",
	DE32 varchar(6),
	DE35 varchar(42),
	DE37 varchar(12),
	DE39 varchar(2) default "00",
	DE41 varchar(8),
	DE42 varchar(15),
	DE43 varchar(40),
	DE49 varchar(3) default "418",
	DE90 varchar(42)
);

select * from NETMSG;

select * from CWDMSG;
select * from REVMSG;
select * from BALMSG;
select * from CARD_ACCOUNT;

select * from NETWK;

alter table NETWORKCONFIG RENAME TO NETWK;

SELECT IP, PORT FROM NETWK WHERE MODE = "ISS";

drop table CARDACCT;

create table CARDACCT
(
	ID integer primary key,
	CARD varchar(16) not null unique,
	TYPE varchar(2) default "01",
	CURR varchar(3) default "418",
	FLAG varchar(1) default "C",
	BAL double default 0,
	EXPDATE varchar(4) not null,
	CAV varchar(3) not null,
	BIN varchar(6) not null
);

select * from CARDACCT;

insert into CARDACCT (CARD,BAL,EXPDATE,CAV,BIN) VALUES ("6213541000001111",50000.00,"0719","315","621354");

delete from BALMSG;

delete from CWDMSG;

select * from CARDACCT;

select * from CWDMSG;

select * from CARDACCT;


SELECT ID, CARD, TYPE, CURR, FLAG, BAL, EXPDATE, CURR, CAV, BIN FROM CARDACCT;


UPDATE CWDMSG SET DE49="418" WHERE MTI="0200";

SELECT ID, CARD, EXPDATE, CAV, TYPE, BAL, FLAG, BIN FROM CARDACCT WHERE CARD="2254110000000001";