create table EMPLOYEES(id bigint, firstname varchar(255),lastname varchar(255),jobname varchar(255));
create table SUPERVISOR(id bigint, firstname varchar(255),lastname varchar(255));
create table RELATION(supervisor_id bigint, employee_id bigint);
INSERT INTO RELATION VALUES  (8987,1990);
INSERT INTO RELATION VALUES  (8987,1420);
INSERT INTO RELATION VALUES  (2987,1922);
INSERT INTO SUPERVISOR VALUES  (8987, 'Marju','Hiir');
INSERT INTO SUPERVISOR VALUES  (2987, 'Peeter','Jänks');
INSERT INTO EMPLOYEES VALUES  (1990, 'Jaak','Põder','Õpetaja');
INSERT INTO EMPLOYEES VALUES  (1922, 'Maria','Kask','Valvur');
INSERT INTO EMPLOYEES VALUES  (1420, 'Kuri','Tädi','Kokk');

