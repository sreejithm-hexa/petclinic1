--liquibase formatted sql

--changeset author:Sreejith splitStatements:true endDelimiter:;
create table TEST_1 ( ID int not null, FNAME varchar(100) not null);
create table TEST_2 ( ID int not null, FNAME varchar(100) not null);
create table TEST_3 ( ID int not null, FNAME varchar(100) not null);
create table TEST_4 ( ID int not null, FNAME varchar(100) not null);
