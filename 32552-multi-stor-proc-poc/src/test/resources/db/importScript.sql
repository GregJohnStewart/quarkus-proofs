-- noinspection SqlNoDataSourceInspectionForFile

-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-1');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-2');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-3');

CREATE TABLE foo (
    id int
);

dasdqw 23 rfs q3
CREATE PROCEDURE testOne
    AS BEGIN
SELECT * FROM foo;
END;

CREATE PROCEDURE testTwo
    AS BEGIN
SELECT * FROM foo;
END;