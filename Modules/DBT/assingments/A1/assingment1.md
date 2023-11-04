
#### CREATE A DATABASE
- database name : assignment1
```SQL
CREATE DATABASE assignment1;

```
```sqL
INSERT INTO CUSTOMERS values(2001,'Hoffman','London',100,1001),(2002,'Giovanni','Rome',200,1003),(2003,'Liu','San Jose',200,1002),(2004,'Grass','Berlin',300,1002),(2006,'Clemens','London',100,1001),(2008,'Cisneros','San Jose',300,1007),(2007,'Pereira','Rome',100,1004);
```

#### create SALESPEOPLE
```SQL
CREATE TABLE SALESPEOPLE()
```
```SQL
INSERT INTO ORDERS VALUES(3001,18.69,'1990-10-03',2008,1007),(3003, 767.19 , '1990-10-03');

INSERT INTO ORDERS 
VALUES
    (3001, 18.69, '1990-10-03', 2008, 1007),
    (3003, 767.19, '1990-10-03', 2001, 1001),
    (3002, 1900.10, '1990-10-03', 2007, 1004),
    (3005, 5160.45, '1990-10-03', 2003, 1002),
    (3006, 1098.16, '1990-10-03', 2008, 1007),
    (3009, 1713.23, '1990-10-04',  2002, 1003),
    (3007, 75.75, '1990-10-04', 2004, 1002),
    (3008, 4723.00, '1990-10-05',  2006, 1001),
    (3010, 1309.95, '1990-10-06',  2004, 1002),
    (3011, 9891.88, '1990-10-06',  2006, 1001);

```
(3001, 18.69, '03-OCT-1990', 2008, 1007),

==================================================

### exersice 1 

```SQL
CREATE TABLE SEMP(EMPNO char(4), EMPNAME char(20), BASIC float , DEPTNO char(2), DEPTHEAD char(4));

CREATE TABLE SDEPT(DEPTNO char(2), DEPTNAME char(15));

INSERT INTO SDEPT VALUES(10 , 'Development' ),(20 ,' Training');

INSERT INTO SEMP VALUES(0001, 'SUNIL', 6000, 10 , 0003),
(0002, 'HIREN' , 8000,20 ,  0001),
(0003, 'ALI', 4000, 10, 0001),
(0004, 'GEORGE', 6000, 20,0002);
```

### QUESTION 2

```SQL

create table supplier(`S#` char(4) , Sname varchar(15) , status int , City varchar(10));

CREATE TABLE PARTS (`P#` CHAR(4), Pname char(20), Color char(20) , Weight float , City char(20) );

CREATE TABLE PROJECT ( `J#` CHAR(4), Jname CHAR(20) , CITY  CHAR(20));

CREATE TABLE SUPLIER_PARTS_PROJECT(`S#` CHAR(4), `P#` CHAR(4) , `J#` CHAR(4), QTY INT);

> alter table Supplier modify status char(10);

INSERT INTO SUPPLIER VALUES('S1' , 'Supplier 1', 10 , 'Delhi' ),
('S2', 'Supplier 2' , 20 , 'Mumbai'),
('S3', 'Supplier 3' , 10 , 'Pune'),
('S4', 'Supplier 4' , 30 , 'Nashik');

INSERT INTO SUPPLIER VALUES('S5', 'Supplier 5' , 30 , 'Mumbai'),
('S6', 'Supplier 6' , 10 , 'Nashik'),
('S7', 'Supplier 7' , 20 , 'Nashik');

insert into project
values
('J1','pro1','Mumbai'),
('J2','pro2','Delhi'),
('J3','pro3','Goa'),
('J4','pro4','Chennai');


INSERT INTO PARTS values('P1' , 'part 1' , 'blue' , 20.55 , 'Mumbai'),
('P2' , 'part 2' , 'red' , 10.2, 'Nashik'),
('P3' , 'part 3' , 'black' , 15.3 , 'Pune'),
('P4' , 'part 4' , 'white' , 30 , 'Nashik');


```

- Display all the data from the S table.
```SQL
mysql> SELECT * FROM SUPPLIER;
+------+------------+--------+--------+
| S#   | Sname      | status | City   |
+------+------------+--------+--------+
| S1   | Supplier 1 |     10 | Delhi  |
| S2   | Supplier 2 |     20 | Mumbai |
| S3   | Supplier 3 |     10 | Pune   |
| S4   | Supplier 4 |     30 | Nashik |
+------+------------+--------+--------+
4 rows in set (0.00 sec)
```

- Display only the S# and SNAME fields from the S table.
```SQL
mysql> SELECT `S#` , SNAME FROM SUPPLIER;
+------+------------+
| S#   | SNAME      |
+------+------------+
| S1   | Supplier 1 |
| S2   | Supplier 2 |
| S3   | Supplier 3 |
| S4   | Supplier 4 |
+------+------------+
4 rows in set (0.00 sec)
```

- Display the PNAME and COLOR from the P table for the CITY=”London”.
```SQL
mysql> SELECT PNAME , COLOR FROM PARTS;
+--------+-------+
| PNAME  | COLOR |
+--------+-------+
| part 1 | blue  |
| part 2 | red   |
| part 3 | black |
| part 4 | white |
+--------+-------+
```
- Display all the Suppliers from nashik.
```sql
mysql> SELECT `S#` , SNAME FROM SUPPLIER WHERE CITY='Nashik';
+------+------------+
| S#   | SNAME      |
+------+------------+
| S4   | Supplier 4 |
| S6   | Supplier 6 |
| S7   | Supplier 7 |
+------+------------+
```

- Display all the Suppliers from Pune or Nashik.
```SQL
mysql> SELECT * FROM SUPPLIER WHERE CITY='Pune' OR CITY='Nashik';
+------+------------+--------+--------+
| S#   | Sname      | status | City   |
+------+------------+--------+--------+
| S3   | Supplier 3 |     10 | Pune   |
| S4   | Supplier 4 |     30 | Nashik |
| S6   | Supplier 6 |     10 | Nashik |
| S7   | Supplier 7 |     20 | Nashik |
+------+------------+--------+--------+
```
- Display all the Projects in Athens.
```SQL
mysql> select * from project where city='mumbai';
+------+-------+--------+
| J#   | Jname | CITY   |
+------+-------+--------+
| J1   | pro1  | Mumbai |
| J5   | pro5  | Mumbai |
+------+-------+--------+
```

- Display all the Partnames with the weight between 12 and 14 (inclusive of both).

```SQL
mysql> select * from parts where weight between 5 and 25;
+------+--------+-------+--------+--------+
| P#   | Pname  | Color | Weight | City   |
+------+--------+-------+--------+--------+
| P1   | part 1 | blue  |  20.55 | Mumbai |
| P2   | part 2 | red   |   10.2 | Nashik |
| P3   | part 3 | black |   15.3 | Pune   |
+------+--------+-------+--------+--------+
```
- Display all the Suppliers with a Status greater than or equal to 20.
```sql
mysql> SELECT * FROM SUPPLIER WHERE STATUS >= 20;
+------+------------+--------+--------+
| S#   | Sname      | status | City   |
+------+------------+--------+--------+
| S2   | Supplier 2 |     20 | Mumbai |
| S4   | Supplier 4 |     30 | Nashik |
| S5   | Supplier 5 |     30 | Mumbai |
| S5   | Supplier 5 |     30 | Mumbai |
| S7   | Supplier 7 |     20 | Nashik |
+------+------------+--------+--------+
```
- Display all the Suppliers except the Suppliers from London.
```sql
mysql> SELECT * FROM supplier WHERE NOT City= 'nashik';
+------+------------+--------+--------+
| S#   | Sname      | status | City   |
+------+------------+--------+--------+
| S1   | Supplier 1 |     10 | Delhi  |
| S2   | Supplier 2 |     20 | Mumbai |
| S3   | Supplier 3 |     10 | Pune   |
| S5   | Supplier 5 |     30 | Mumbai |
| S5   | Supplier 5 |     30 | Mumbai |
+------+------------+--------+--------+
```
- Display only the Cities from where the Suppliers come from
```SQL
mysql> Select city from supplier;
+--------+
| city   |
+--------+
| Delhi  |
| Mumbai |
| Pune   |
| Nashik |
| Mumbai |
| Mumbai |
| Nashik |
| Nashik |
+--------+
```

- Assuming that the Part Weight is in GRAMS, display the same in MILLIGRAMS and KILOGRAMS.
```SQL
mysql> select `P#` , weight AS Grams, weight *1000 AS Miligram , weight / 1000 as Kilogram from parts;
+------+-------+--------------------+----------------------+
| P#   | Grams | Miligram           | Kilogram             |
+------+-------+--------------------+----------------------+
| P1   | 20.55 | 20549.999237060547 | 0.020549999237060548 |
| P2   |  10.2 | 10199.999809265137 | 0.010199999809265137 |
| P3   |  15.3 | 15300.000190734863 | 0.015300000190734863 |
| P4   |    30 |              30000 |                 0.03 |
+------+-------+--------------------+----------------------+
```

