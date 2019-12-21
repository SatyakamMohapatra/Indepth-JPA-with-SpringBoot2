create table person(
id integer not null,
name varchar(255) not null,
location varchar(255) not null,
birth_date timestamp,
primary key(id));

INSERT INTO person (ID, NAME, LOCATION, BIRTH_DATE)
VALUES(10001, 'Paul', 'New York', sysdate());

INSERT INTO person (ID, NAME, LOCATION, BIRTH_DATE)
VALUES(10002, 'Ron', 'Berlin', sysdate());

INSERT INTO person (ID, NAME, LOCATION, BIRTH_DATE)
VALUES(10003, 'John', 'Bay Area', sysdate());
