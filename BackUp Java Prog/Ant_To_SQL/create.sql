drop table ANTSQL;

create table ANTSQL(name varchar2(30),age number(10),address varchar2(30));

insert into ANTSQL values('piku',23,'Bolangir');
insert into ANTSQL values('Lilu',23,'Bolangir');
insert into ANTSQL values('Arzoo',23,'Bolangir');
insert into ANTSQL values('Arzoo',23,'Bangalore');
insert into ANTSQL values('Arzoo',23,'Baoudh');

--select * from tab;
select * from all_tables;



commit;