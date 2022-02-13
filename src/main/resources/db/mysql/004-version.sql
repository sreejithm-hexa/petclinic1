--liquibase formatted sql

--changeset author:hari splitStatements:true endDelimiter:; context:test

CREATE TABLE Persons (
    PersonID int,
    LastName varchar(255),
    FirstName varchar(255),
    Address varchar(255),
    City varchar(255)
);

--changeset author:vyshak splitStatements:true endDelimiter:; context:dev



CREATE TABLE customer (
    PersonID int,
    LastName varchar(255),
    FirstName varchar(255),
    Address varchar(255),
    City varchar(255)
);
--rollback tag:roll

drop table persons;
