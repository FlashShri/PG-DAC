![Alt text](image.png)  
![Alt text](image-1.png)
![Alt text](image-2.png)
![Alt text](image-3.png)

```SQL
CREATE USER flash@localhost IDENTIFIED BY 'flash';

CREATE DATABASE cdacdb;

GRANT ALL PRIVILEGES ON cdacdb.* TO flash@localhost;

FLUSH PRIVILEGES;

EXIT;
```
- here my user -> flash 
       -  password - > flash
        - CREATE USER flash@localhost IDENTIFIED BY 'flash';


![Alt text](image-4.png)

```CMD
mysql -u flash -p

```
pass : flash 

![Alt text](image-5.png)

- my user has some permission not all .

- TO CREATE TABLE IN DATABASE

```SQL
mysql> show databases;
+--------------------+
| Database           |
+--------------------+
| cdacdb             |
| information_schema |
| performance_schema |
+--------------------+

mysql> use cdacdb;
Database changed
mysql> show tables;
Empty set (0.04 sec)

mysql> create table student(id INT, name VARCHAR(20),marks DOUBLE);
Query OK, 0 rows affected (0.05 sec)

mysql> INSERT INTO student VALUES(1,'SHRIKANT',76.88);
Query OK, 1 row affected (0.01 sec)

mysql> SELECT * FROM STUDENT;
+------+----------+-------+
| id   | name     | marks |
+------+----------+-------+
|    1 | SHRIKANT | 76.88 |
+------+----------+-------+

mysql>  INSERT INTO student VALUES(2,'ELON',87.88);
Query OK, 1 row affected (0.00 sec)

mysql> SELECT * FROM  STUDENT;
+------+----------+-------+
| id   | name     | marks |
+------+----------+-------+
|    1 | SHRIKANT | 76.88 |
|    2 | ELON     | 87.88 |
+------+----------+-------+
2 rows in set (0.00 sec)
```

- root user can access the whole database
- standard practise to create user on grant some permission to it
- 

# root login

```SQL
mysql -u root -p
password: cdac

// check what is my user and in which database iam in now;

mysql> SELECT USER() , DATABASE();
+----------------+------------+
| USER()         | DATABASE() |
+----------------+------------+
| root@localhost | NULL       |
+----------------+------------+
1 row in set (0.00 sec)
```

- HOW TO CLEAR SCREEN in mysql
```SQL
\! cls 
```

- admin user can see all databases
```SQL
mysql> show databases;
+--------------------+
| Database           |
+--------------------+
| cdacdb             |
| information_schema |
| mysql              |
| performance_schema |
| shridb             |
| sys                |
+--------------------+
6 rows in set (0.00 sec)

-- below are system databases contains db system info
-- mysql
-- sys 
-- performance_schema
-- information_schema

-- we can see all user as we are root
mysql> SELECT user FROM mysql.user;
+------------------+
| user             |
+------------------+
| flash            |
| mysql.infoschema |
| mysql.session    |
| mysql.sys        |
| root             |
+------------------+
5 rows in set (0.00 sec)
```
# MYSQL "flash" user login
- what are different way that we can do login

```SQL
C:\Users\shrik>mysql -u flash -p
Enter password: *****

-- CHECKING 

mysql> SELECT USER() , DATABASE();
+-----------------+------------+
| USER()          | DATABASE() |
+-----------------+------------+
| flash@localhost | NULL       |
+-----------------+------------+
1 row in set (0.00 sec)

-- NOW we are at flash user 
-- flash has not all permission

--  only thoes that has permission to user
mysql> SHOW DATABASES;
+--------------------+
| Database           |
+--------------------+
| cdacdb             |
| information_schema |
| performance_schema |
+--------------------+

-- now how to activate the database

mysql> USE cdacdb;
Database changed

-- its activated
-- whats proof

-- print current user and current database
mysql> SELECT USER(), DATABASE();
+-----------------+------------+
| USER()          | DATABASE() |
+-----------------+------------+
| flash@localhost | cdacdb     |
+-----------------+------------+
-- see here user DATABASE() -> we can see cdacdb

-- print tables in current database
mysql> SHOW TABLES;
+------------------+
| Tables_in_cdacdb |
+------------------+
| student          |
+------------------+
```

- 
- 
- 
* cnd> mysql -h localhost -u flash -p
    * -h server ip address/name
        * default = localhost -- current computer
    * -u -- my sql username to login
        * admin user = root
        * created user = flash
    * -p -- password
         * password: flash
```sql
mysql -h localhost -u flash -p
Enter password: ****
-- here paswword must be of flash user
```
* CREATE USER flash@localhost IDENTIFIED BY 'flash';



## other way 

* mysql -u flash -pflash
    * password must be immediatly after -p , no space , but can insecure
- but bydafualt use null no database

#### is there is way  

```SQL
>mysql -u flash -pflash cdacdb
-- here we are login with flash user and 
--flash password on current machine mysql server and activate database 'cdacdb' in one line

-- AFTER THIS 
mysql> SELECT USER(), DATABASE();
+-----------------+------------+
| USER()          | DATABASE() |
+-----------------+------------+
| flash@localhost | cdacdb     |
+-----------------+------------+
--  we are already using cdacdb database

-- without "use cdacdb" command

```
## insert values into table

```SQL
INsert into student values(3, 'Sam', 56.5);

-- or we can write multiple input in one statement
mysql> Insert into student values(4, 'ram',89.7),(5,'mike',87.55);
Query OK, 2 rows affected (0.00 sec)
Records: 2  Duplicates: 0  Warnings: 0

-- lets see what happend in our table

mysql> select * from student;
+------+----------+-------+
| id   | name     | marks |
+------+----------+-------+
|    1 | SHRIKANT | 76.88 |
|    2 | ELON     | 87.88 |
|    3 | Sam      |  56.5 |
|    4 | ram      |  89.7 |
|    5 | mike     | 87.55 |
+------+----------+-------+
5 rows in set (0.00 sec)

-- rows -> records, entities

```
## Logical layout
 ![Alt text](image-6.png)
 ![Alt text](image-7.png)

### to show table structure 
```SQL
-- use desc command to describe its structure , its metadata.

mysql> DESCRIBE student;
+-------+-------------+------+-----+---------+-------+
| Field | Type        | Null | Key | Default | Extra |
+-------+-------------+------+-----+---------+-------+
| id    | int         | YES  |     | NULL    |       |
| name  | varchar(20) | YES  |     | NULL    |       |
| marks | double      | YES  |     | NULL    |       |
+-------+-------------+------+-----+---------+-------+

-- thid whole info is meta data abt my TABLE

```
## physical layout
![Alt text](image-8.png)

* this physical layout understanding is only for general knowedge.

### importing into database
- can be done using source command
```SQL
-- SOURCE /path/to/the/sql/file

-- SOURCE C:\BraveDownloads\DBT\Sample-SQL-File-10-Rows.sql

mysql> SOURCE C:\BraveDownloads\DBT\Sample-SQL-File-10-Rows.sql
Query OK, 0 rows affected, 2 warnings (0.05 sec)

Query OK, 10 rows affected (0.01 sec)
Records: 10  Duplicates: 0  Warnings: 0

mysql> SHOW TABLES;
+------------------+
| Tables_in_cdacdb |
+------------------+
| student          |
| user_details     |
+------------------+
2 rows in set (0.00 sec)

mysql> SELECT * FROM user_details;
+---------+----------+------------+-----------+--------+----------------------------------+--------+
| user_id | username | first_name | last_name | gender | password                         | status |
+---------+----------+------------+-----------+--------+----------------------------------+--------+
|       1 | rogers63 | david      | john      | Female | e6a33eee180b07e563d74fee8c2c66b8 |      1 |
|       2 | mike28   | rogers     | paul      | Male   | 2e7dc6b8a1598f4f75c3eaa47958ee2f |      1 |
|       3 | rivera92 | david      | john      | Male   | 1c3a8e03f448d211904161a6f5849b68 |      1 |
|       4 | ross95   | maria      | sanders   | Male   | 62f0a68a4179c5cdd997189760cbcf18 |      1 |
|       5 | paul85   | morris     | miller    | Female | 61bd060b07bddfecccea56a82b850ecf |      1 |
|       6 | smith34  | daniel     | michael   | Female | 7055b3d9f5cb2829c26cd7e0e601cde5 |      1 |
|       7 | james84  | sanders    | paul      | Female | b7f72d6eb92b45458020748c8d1a3573 |      1 |
|       8 | daniel53 | mark       | mike      | Male   | 299cbf7171ad1b2967408ed200b4e26c |      1 |
|       9 | brooks80 | morgan     | maria     | Female | aa736a35dc15934d67c0a999dccff8f6 |      1 |
|      10 | morgan65 | paul       | miller    | Female | a28dca31f5aa5792e1cefd1dfd098569 |      1 |
```

### how to create table
- command 'create table' ;
- CREATE TABLE table_name(column_name1 COL-TYPE, column_name2 COL-TYPE ....., constraint);

## DATA TYPES
![Alt text](image-9.png)
- all RDBMS have similar data type
- for mysql-> INT , DECIMAL , FLOAT
- for oracle-> NUMBER
- for DERBY-> INTEGER

#### numeric types: (INTEGER)
- TINYINT (1 byte): 8 bit -> 1 bit MSB ->range-> -128 to 127
- SMALLINT (2 byte): 16 bit:
- MEDIUMINT (3 byte) : 24 bit:

- INT ( 4 byte ): 32 bit
- BIGINT(8 byte): 64 bit
- BIT();
* these data types are by default signed
    * to make it unsigned
    * -- student( a1 smallint unsigned, a2 int unsiged).
*  

#### numeric type (floating point)
- not exact , 
- approx precision -> stored in IEEE - 754 format , like in all programming lang.
- same as C lang
- FLOAT (4 byte), DOUBLE (8 byte), 
- if we lookning for accuracy then use decimal
- DECIMAL(m ,n) - for excat precision
- CREATE TABLE CITY( ID DECIMAL(8 , 3));
- here 8 -> is all our 8 digit 
- and 3 -> three decimal places
- eg --> 12345.678

#### date time types
- DATE, 
- TIME -> hr , min, sec, => its like duration , not time of day
- DATETIME , like 
- TIMESTAMP => like no of sec from 1 JAN 1997;
- YEAR = > 

### String types
- CHAR ( 1 - 255 )-> for small data
- VARCHAR (1 - 65535) -> for larger data

##### TEXT category: 

```SQL

mysql> create table test( c1 char(10) , c2 varchar(10) , c3 text(10));
Query OK, 0 rows affected (0.03 sec)

mysql> insert into test values ( 'abcd' , 'abcd' , 'abcd');
Query OK, 1 row affected (0.01 sec)

mysql> select * from test;
+------+------+------+
| c1   | c2   | c3   |
+------+------+------+
| abcd | abcd | abcd |
+------+------+------+

-- we have create c1 c2 c3 but output wise is smae
+-------+-------------+------+-----+---------+-------+
| Field | Type        | Null | Key | Default | Extra |
+-------+-------------+------+-----+---------+-------+
| c1    | char(10)    | YES  |     | NULL    |       |
| c2    | varchar(10) | YES  |     | NULL    |       |
| c3    | tinytext    | YES  |     | NULL    |       |
+-------+-------------+------+-----+---------+-------+
```

- c1 char(10) 
- c2 varchar(10) 
- c3 text(10)
 - char types are fixed size 
    * in char type of size 10 -> if we put only 4 size data , then remaining 6 spaces get unused.
- varchar is variable in size
- ![Alt text](image-10.png)
- all the text type data is stored outside of row 
- only pointer to that space is kept on row
- ![Alt text](image-11.png)

- varchar is slower than char bcoz first we need to read size then data;
- likewise text is very slow in terms of access bcoz there is pointer involed.

```SQL 
mysql> insert into test values( 'abcdefghijk' , 'abcdefghijk' , 'abcdefghijk' );
ERROR 1406 (22001): Data too long for column 'c1' at row 1

-- here it gave us en error for c1 which is char type with size 10
-- our input was size of 11
```

- now let make c1 with 10, but c2 with 11 character 
```SQL
mysql> insert into test values( 'abcdefghij' , 'abcdefghijk' , 'abcdefghijk' );
ERROR 1406 (22001): Data too long for column 'c2' at row 1
 -- again error for c2
```
- now try with only c3 which is of size 10 but input was 11 character

```SQL
mysql> insert into test values( 'abcdefghij' , 'abcdefghij' , 'abcdefghijk' );
Query OK, 1 row affected (0.01 sec)

-- bcoz in tinytext upto 255 
```
```SQL
mysql> select * from test;
+------------+------------+-------------+
| c1         | c2         | c3          |
+------------+------------+-------------+
| abcd       | abcd       | abcd        |
| abcdefghij | abcdefghij | abcdefghijk |
+------------+------------+-------------+
```
- ideally in case of text no need for size , by default 255

#### showing strict mode
```SQL
mysql> SELECT @@sql_mode;
+-----------------------------------------------------------------------------------------------------------------------+
| @@sql_mode
                      |
+-----------------------------------------------------------------------------------------------------------------------+
| ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION |
+-----------------------------------------------------------------------------------------------------------------------+
```
- i have 
- NO_ENGINE_SUBSTITUTION,
STRICT_TRANS_TABLES

- ![Alt text](image-12.png)
### binary types
- images , pdf , docs
- BINARY is same like String types
- use BLOB

### INSERT - DML
![Alt text](image-13.png)
*  INSERT INTO tablename VALUES ( v1, v2 , v3 . ..);
    * String and Date/Time must be in single quotes.
    * Other values without quotes.
    * Values must be in *same order* as of column order. 
```SQL
mysql> select * from student;
+------+----------+-------+
| id   | name     | marks |
+------+----------+-------+
|    1 | SHRIKANT | 76.88 |
|    2 | ELON     | 87.88 |
|    3 | Sam      |  56.5 |
|    4 | ram      |  89.7 |
|    5 | mike     | 87.55 |
+------+----------+-------+
5 rows in set (0.00 sec)

mysql> INSERT INTO student VALUES( 87.33 , 7, 'RAM');
ERROR 1265 (01000): Data truncated for column 'marks' at row 1
```
- order must be same 
- unless if you directed in such way
```SQL
INSERT INTO student (marks, id , name) VALUES(87.33 , 7, 'RAM');


mysql> INSERT INTO student (id , name) VALUES(10 , 'sam');
Query OK, 1 row affected (0.00 sec)

mysql> SELECT * FROM student;
+------+----------+-------+
| id   | name     | marks |
+------+----------+-------+
|    1 | SHRIKANT | 76.88 |
|    2 | ELON     | 87.88 |
|    3 | Sam      |  56.5 |
|    4 | ram      |  89.7 |
|    5 | mike     | 87.55 |
|    7 | RAM      | 87.33 |
|   10 | sam      |  NULL |
```
- is we dont provide a value to a col , then at that time it will taken as NULL.
- NULL is keyword
- we can manually put NULL also
-  INSERT INTO student (id , name) VALUES(10 , 'sam' , NULL );

#### insert data from one table into new table
- INSERT INTO  new_table SELECT * FROM student;
    * the count and order of columns in new_table must be same as old table.

-  we insert some specific column from student into new_table;
    * INSERT INTO new_table(c1, c2) SELECT c1, c2 FROM student;
    * column c1 and c2 from student into new_table;

```SQL
mysql> select * from student;
+------+----------+-------+
| id   | name     | marks |
+------+----------+-------+
|    1 | SHRIKANT | 76.88 |
|    2 | ELON     | 87.88 |
|    3 | Sam      |  56.5 |
|    4 | ram      |  89.7 |
|    5 | mike     | 87.55 |
|    7 | RAM      | 87.33 |
|   10 | sam      |  NULL |
|   10 | sam      |  NULL |
+------+----------+-------+
8 rows in set (0.00 sec)

mysql> CREATE TABLE new_table( roll INT , name CHAR(20) );
Query OK, 0 rows affected (0.04 sec)

mysql> INSERT INTO new_table(roll , name) SELECT id , name FROM student;
Query OK, 8 rows affected (0.01 sec)
Records: 8  Duplicates: 0  Warnings: 0

mysql> SELECT * FROM new_table;
+------+----------+
| roll | name     |
+------+----------+
|    1 | SHRIKANT |
|    2 | ELON     |
|    3 | Sam      |
|    4 | ram      |
|    5 | mike     |
|    7 | RAM      |
|   10 | sam      |
|   10 | sam      |
+------+----------+
8 rows in set (0.00 sec)
```

# DAY 4 

### select - DQL
![Alt text](image-14.png)
- 
```SQL
mysql> select * from student ;
+------+----------+-------+
| id   | name     | marks |
+------+----------+-------+
|    1 | SHRIKANT | 76.88 |
|    2 | ELON     | 87.88 |
|    3 | Sam      |  56.5 |
|    4 | ram      |  89.7 |
|    5 | mike     | 87.55 |
|    7 | RAM      | 87.33 |
|   10 | sam      |  NULL |
|   10 | sam      |  NULL |
+------+----------+-------+
```
- here  when we write SELECT query with *
- it will show all data in fixed order.
- the order in which we create table
- but if we want to show in custom order then 
- specify the order.
```SQL
mysql> SELECT name , marks, id from student;
+----------+-------+------+
| name     | marks | id   |
+----------+-------+------+
| SHRIKANT | 76.88 |    1 |
| ELON     | 87.88 |    2 |
| Sam      |  56.5 |    3 |
| ram      |  89.7 |    4 |
| mike     | 87.55 |    5 |
| RAM      | 87.33 |    7 |
| sam      |  NULL |   10 |
| sam      |  NULL |   10 |
+----------+-------+------+

```

-- fetch id , name and sal from emp table
```SQL
mysql> select * from emp;
+-------+--------+-----------+------+------------+---------+---------+--------+
| empno | ename  | job       | mgr  | hire       | sal     | comm    | deptno |
+-------+--------+-----------+------+------------+---------+---------+--------+
|  7369 | Smith  | Clerk     | 7902 | 1980-12-17 |  800.00 |    NULL |     20 |
|  7499 | Allen  | Salesman  | 7698 | 1981-02-20 | 1600.00 |  300.00 |     30 |
|  7521 | Ward   | Salesman  | 7698 | 1981-02-22 | 1250.00 |  500.00 |     30 |
|  7566 | Jones  | Manager   | 7839 | 1981-04-02 | 2975.00 |    NULL |     20 |
|  7654 | Martin | Salesman  | 7698 | 1981-09-28 | 1250.00 | 1400.00 |     30 |
|  7698 | Blake  | Manager   | 7839 | 1981-05-01 | 2850.00 |    NULL |     30 |
|  7782 | Clark  | Manager   | 7839 | 1981-06-09 | 2450.00 |    NULL |     10 |
|  7788 | Scott  | Analyst   | 7566 | 1982-12-09 | 3000.00 |    NULL |     20 |
|  7839 | King   | President | NULL | 1981-11-17 | 5000.00 |    NULL |     10 |
|  7902 | Ford   | Analyst   | 7566 | 1981-12-03 | 3000.00 |    NULL |     20 |
+-------+--------+-----------+------+------------+---------+---------+--------+
10 rows in set (0.00 sec)
-- -- fetch id , name and sal from emp table
mysql> SELECT  empno , ename ,sal from  emp;
+-------+--------+---------+
| empno | ename  | sal     |
+-------+--------+---------+
|  7369 | Smith  |  800.00 |
|  7499 | Allen  | 1600.00 |
|  7521 | Ward   | 1250.00 |
|  7566 | Jones  | 2975.00 |
|  7654 | Martin | 1250.00 |
|  7698 | Blake  | 2850.00 |
|  7782 | Clark  | 2450.00 |
|  7788 | Scott  | 3000.00 |
|  7839 | King   | 5000.00 |
|  7902 | Ford   | 3000.00 |
+-------+--------+---------+
``` 

- the select comman works
- but I want the heading of column different; 
```SQL

SELECT empno AS 'emp id' , ename AS 'emp name' , sal AS 'salary' from emp;

mysql> SELECT empno AS 'emp id' , ename AS 'emp name' , sal AS 'salary' from emp;
+--------+----------+---------+
| emp id | emp name | salary  |
+--------+----------+---------+
|   7369 | Smith    |  800.00 |
|   7499 | Allen    | 1600.00 |
|   7521 | Ward     | 1250.00 |
|   7566 | Jones    | 2975.00 |
|   7654 | Martin   | 1250.00 |
|   7698 | Blake    | 2850.00 |
|   7782 | Clark    | 2450.00 |
|   7788 | Scott    | 3000.00 |
|   7839 | King     | 5000.00 |
|   7902 | Ford     | 3000.00 |
+--------+----------+---------+ 

 -- as we can see the column name is changed 
 -- this changes are not on original table
 -- it is only on output on client 
```
 
 ### AS keyword
 - to create alias to a column
 - AS keyword is optional 
- its ok
 ```SQL
 mysql> SELECT empno 'emp id' , ename 'emp name' , sal  'salary' from emp;
 ```

 - 
 - if alias name contains space or special chars,
 - they must be quoted. ' '  or ` `
 - if alias name doesn't contain space or special char , quoets are optional .
 - 


## processing data while showing to client
```SQl
-- print book id , name , price, and gst ( 5% of price).
-- here on book table we dont have gst olumn

SELECT id , name , price , price*0.05 from book;
+----+---------+-------+------------+
| id | name    | price | price*0.05 |
+----+---------+-------+------------+
|  1 | Book 1  | 19.99 |     0.9995 |
|  2 | Book 2  | 24.95 |     1.2475 |
|  3 | Book 3  | 15.49 |     0.7745 |
|  4 | Book 4  | 29.99 |     1.4995 |
|  5 | Book 5  |  9.99 |     0.4995 |
|  6 | Book 6  | 32.50 |     1.6250 |
|  7 | Book 7  | 19.99 |     0.9995 |
|  8 | Book 8  | 21.75 |     1.0875 |
|  9 | Book 9  | 12.99 |     0.6495 |
| 10 | Book 10 | 17.25 |     0.8625 |
| 11 | Book 11 | 14.50 |     0.7250 |
| 12 | Book 12 | 23.75 |     1.1875 |
| 13 | Book 13 | 28.99 |     1.4495 |
| 14 | Book 14 |  9.99 |     0.4995 |
| 15 | Book 15 | 16.75 |     0.8375 |
+----+---------+-------+------------+

-- using alias
mysql> Select id , name , price mrp , price*0.05 AS GST from book;
+----+---------+-------+--------+
| id | name    | mrp   | GST    |
+----+---------+-------+--------+
|  1 | Book 1  | 19.99 | 0.9995 |
|  2 | Book 2  | 24.95 | 1.2475 |
|  3 | Book 3  | 15.49 | 0.7745 |
|  4 | Book 4  | 29.99 | 1.4995 |
|  5 | Book 5  |  9.99 | 0.4995 |
|  6 | Book 6  | 32.50 | 1.6250 |
|  7 | Book 7  | 19.99 | 0.9995 |
|  8 | Book 8  | 21.75 | 1.0875 |
|  9 | Book 9  | 12.99 | 0.6495 |
| 10 | Book 10 | 17.25 | 0.8625 |
| 11 | Book 11 | 14.50 | 0.7250 |
| 12 | Book 12 | 23.75 | 1.1875 |
| 13 | Book 13 | 28.99 | 1.4495 |
| 14 | Book 14 |  9.99 | 0.4995 |
| 15 | Book 15 | 16.75 | 0.8375 |
+----+---------+-------+--------+
```
- this GST column is not there in original table on hard disk.
- its a computed column . / sudo / virtual / derived column.
- its computed while run time . 

- -- print book id , name , price, and gst ( 5% of price) and total price -> price + gst ;
```SQL

mysql> SELECT id , name , price , price*0.05 GST , price+price*0.05 'Total price' from book;
+----+---------+-------+--------+-------------+
| id | name    | price | GST    | Total price |
+----+---------+-------+--------+-------------+
|  1 | Book 1  | 19.99 | 0.9995 |     20.9895 |
|  2 | Book 2  | 24.95 | 1.2475 |     26.1975 |
|  3 | Book 3  | 15.49 | 0.7745 |     16.2645 |
|  4 | Book 4  | 29.99 | 1.4995 |     31.4895 |
|  5 | Book 5  |  9.99 | 0.4995 |     10.4895 |
|  6 | Book 6  | 32.50 | 1.6250 |     34.1250 |
|  7 | Book 7  | 19.99 | 0.9995 |     20.9895 |
|  8 | Book 8  | 21.75 | 1.0875 |     22.8375 |
|  9 | Book 9  | 12.99 | 0.6495 |     13.6395 |
| 10 | Book 10 | 17.25 | 0.8625 |     18.1125 |
| 11 | Book 11 | 14.50 | 0.7250 |     15.2250 |
| 12 | Book 12 | 23.75 | 1.1875 |     24.9375 |
| 13 | Book 13 | 28.99 | 1.4495 |     30.4395 |
| 14 | Book 14 |  9.99 | 0.4995 |     10.4895 |
| 15 | Book 15 | 16.75 | 0.8375 |     17.5875 |
+----+---------+-------+--------+-------------+
```

 ```SQL
 SELECT id , name , price , price*0.05 GST , price+GST 'Total price' from book;l
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'l
SELECT id , name , price , price*0.05 GST , price+GST 'Total price' from book' at line 1
 ```
  - we cant write a GST in total price column , bcoz GST is not exists .
  -- it only shows while run time

##### Print empno , ename, sal , category of employee (emp table).
- if salary < 1500 - > poor employee
- if salary <= 2500 -> middle.
- salary > 2500 -> rich.

```SQL
SELECT empno , ename , sal from emp ;

-- we have case statement
 SELECT empno , ename, sal,
    CASE
    WHEN sal <= 1500 THEN 'Poor'
    WHEN sal > 1500 AND sal <= 2500 THEN 'Middle'
    ELSE 'Rich'
    END AS  SalaryCategory
    FROM emp;

+-------+--------+---------+----------------+
| empno | ename  | sal     | SalaryCategory |
+-------+--------+---------+----------------+
|  7369 | Smith  |  800.00 | Poor           |
|  7499 | Allen  | 1600.00 | Middle         |
|  7521 | Ward   | 1250.00 | Poor           |
|  7566 | Jones  | 2975.00 | Rich           |
|  7654 | Martin | 1250.00 | Poor           |
|  7698 | Blake  | 2850.00 | Rich           |
|  7782 | Clark  | 2450.00 | Middle         |
|  7788 | Scott  | 3000.00 | Rich           |
|  7839 | King   | 5000.00 | Rich           |
|  7902 | Ford   | 3000.00 | Rich           |
+-------+--------+---------+----------------+

-- this was example of computedd columns
```
- Print empno , ename, sal , category of employee and deptno  
- deptno -> 10 = ACCOUNTS , 20 = RESEARCH , 30=SALES , *=OPERATIONS.

```sql
 SELECT empno , ename, sal,
    CASE
    WHEN sal <= 1500 THEN 'Poor'
    WHEN sal > 1500 AND sal <= 2500 THEN 'Middle'
    ELSE 'Rich'
    END AS  SalaryCategory ,

    deptno ,

    CASE
    WHEN deptno = 10 THEN 'ACCOUNTS'
    WHEN deptno = 20 THEN 'RESEARCH'
    WHEN deptno = 30 THEN 'SALES'
    ELSE 'OPERATIONS'
    END AS department 
    FROM emp;

+-------+--------+---------+----------------+--------+------------+
| empno | ename  | sal     | SalaryCategory | deptno | department |
+-------+--------+---------+----------------+--------+------------+
|  7369 | Smith  |  800.00 | Poor           |     20 | RESEARCH   |
|  7499 | Allen  | 1600.00 | Middle         |     30 | SALES      |
|  7521 | Ward   | 1250.00 | Poor           |     30 | SALES      |
|  7566 | Jones  | 2975.00 | Rich           |     20 | RESEARCH   |
|  7654 | Martin | 1250.00 | Poor           |     30 | SALES      |
|  7698 | Blake  | 2850.00 | Rich           |     30 | SALES      |
|  7782 | Clark  | 2450.00 | Middle         |     10 | ACCOUNTS   |
|  7788 | Scott  | 3000.00 | Rich           |     20 | RESEARCH   |
|  7839 | King   | 5000.00 | Rich           |     10 | ACCOUNTS   |
|  7902 | Ford   | 3000.00 | Rich           |     20 | RESEARCH   |
+-------+--------+---------+----------------+--------+------------+
```

- how many books we have
- nos of rows
```SQL
mysql> SELECT * from book;
+----+---------+-----------+-----------+-------+
| id | name    | author    | subject   | price |
+----+---------+-----------+-----------+-------+
|  1 | Book 1  | Author 1  | Subject A | 19.99 |
|  2 | Book 2  | Author 2  | Subject B | 24.95 |
|  3 | Book 3  | Author 3  | Subject C | 15.49 |
|  4 | Book 4  | Author 4  | Subject A | 29.99 |
|  5 | Book 5  | Author 5  | Subject D |  9.99 |
|  6 | Book 6  | Author 6  | Subject B | 32.50 |
|  7 | Book 7  | Author 7  | Subject A | 19.99 |
|  8 | Book 8  | Author 8  | Subject C | 21.75 |
|  9 | Book 9  | Author 9  | Subject D | 12.99 |
| 10 | Book 10 | Author 10 | Subject B | 17.25 |
| 11 | Book 11 | Author 11 | Subject A | 14.50 |
| 12 | Book 12 | Author 12 | Subject C | 23.75 |
| 13 | Book 13 | Author 13 | Subject D | 28.99 |
| 14 | Book 14 | Author 14 | Subject B |  9.99 |
| 15 | Book 15 | Author 15 | Subject A | 16.75 |
+----+---------+-----------+-----------+-------+
```
- we have only four unique subjects A B C D only
- how to fetch uniquie 
```sql
-- fetch unique subject from book

SELECT DISTINCT subject from book;

mysql> SELECT DISTINCT subject from book;
+-----------+
| subject   |
+-----------+
| Subject A |
| Subject B |
| Subject C |
| Subject D |
+-----------+
```
- fetch unique dept from emp
```sql
mysql> SELECT DISTINCT deptno from emp;
+--------+
| deptno |
+--------+
|     20 |
|     30 |
|     10 |
+--------+
```
```SQL
-- fetch unique job from emp
mysql> SELECT DISTINCT job from emp;
+-----------+
| job       |
+-----------+
| Clerk     |
| Salesman  |
| Manager   |
| Analyst   |
| President |
```

```SQL
mysql> select deptno , job from emp;
+--------+-----------+
| deptno | job       |
+--------+-----------+
|     20 | Clerk     |
|     30 | Salesman  |
|     30 | Salesman  |
|     20 | Manager   |
|     30 | Salesman  |
|     30 | Manager   |
|     10 | Manager   |
|     20 | Analyst   |
|     10 | President |
|     20 | Analyst   |
+--------+-----------+

-- now the questions is
-- how many unique jobs

-> deptno 10 ->  manager , president
-> deptno 20 ->  clerk , manager , analyst
-> deptno 30 ->  salesman , manager

```
- unique jobs per deptno or unique dept for per job
```SQL
mysql> SELECT DISTINCT deptno , job from emp;
+--------+-----------+
| deptno | job       |
+--------+-----------+
|     20 | Clerk     |
|     30 | Salesman  |
|     20 | Manager   |
|     30 | Manager   |
|     10 | Manager   |
|     20 | Analyst   |
|     10 | President |
+--------+-----------+

-- this puting distinct on multiple column
-> deptno 10 ->  manager , president
-> deptno 20 ->  clerk , manager , analyst
-> deptno 30 ->  salesman , manager
```

#### limit clause 

```SQL
SELECT * from books;
-- will show all books

-- but I just need to see only first 5 books

mysql> SELECT * from book limit 5;
--  get first 5 books
+----+--------+----------+-----------+-------+
| id | name   | author   | subject   | price |
+----+--------+----------+-----------+-------+
|  1 | Book 1 | Author 1 | Subject A | 19.99 |
|  2 | Book 2 | Author 2 | Subject B | 24.95 |
|  3 | Book 3 | Author 3 | Subject C | 15.49 |
|  4 | Book 4 | Author 4 | Subject A | 29.99 |
|  5 | Book 5 | Author 5 | Subject D |  9.99 |
+----+--------+----------+-----------+-------+
```
- skip first 3 books and get next 2 books .
```SQL
mysql> SELECT * from book limit 3,2;
+----+--------+----------+-----------+-------+
| id | name   | author   | subject   | price |
+----+--------+----------+-----------+-------+
|  4 | Book 4 | Author 4 | Subject A | 29.99 |
|  5 | Book 5 | Author 5 | Subject D |  9.99 |
+----+--------+----------+-----------+-------+
2 rows in set (0.00 sec)
```
### Order By clause

* SELECT cols from tablename ORDER By col;
* SELECT cols from tablename ORDER By col ASC;
    * in both cases it sorted in asc order
* to sort in decending order
* SELECT cols from tablename ORDER By col DESC;
```SQL
mysql> SELECT * from book ORDER BY price;
+----+---------+-----------+-----------+-------+
| id | name    | author    | subject   | price |
+----+---------+-----------+-----------+-------+
|  5 | Book 5  | Author 5  | Subject D |  9.99 |
| 14 | Book 14 | Author 14 | Subject B |  9.99 |
|  9 | Book 9  | Author 9  | Subject D | 12.99 |
| 11 | Book 11 | Author 11 | Subject A | 14.50 |
|  3 | Book 3  | Author 3  | Subject C | 15.49 |
| 15 | Book 15 | Author 15 | Subject A | 16.75 |
| 10 | Book 10 | Author 10 | Subject B | 17.25 |
|  1 | Book 1  | Author 1  | Subject A | 19.99 |
|  7 | Book 7  | Author 7  | Subject A | 19.99 |
|  8 | Book 8  | Author 8  | Subject C | 21.75 |
| 12 | Book 12 | Author 12 | Subject C | 23.75 |
|  2 | Book 2  | Author 2  | Subject B | 24.95 |
| 13 | Book 13 | Author 13 | Subject D | 28.99 |
|  4 | Book 4  | Author 4  | Subject A | 29.99 |
|  6 | Book 6  | Author 6  | Subject B | 32.50 |
+----+---------+-----------+-----------+-------+


mysql> SELECT * from book ORDER BY price ASC;
+----+---------+-----------+-----------+-------+
| id | name    | author    | subject   | price |
+----+---------+-----------+-----------+-------+
|  5 | Book 5  | Author 5  | Subject D |  9.99 |
| 14 | Book 14 | Author 14 | Subject B |  9.99 |
|  9 | Book 9  | Author 9  | Subject D | 12.99 |
| 11 | Book 11 | Author 11 | Subject A | 14.50 |
|  3 | Book 3  | Author 3  | Subject C | 15.49 |
| 15 | Book 15 | Author 15 | Subject A | 16.75 |
| 10 | Book 10 | Author 10 | Subject B | 17.25 |
|  1 | Book 1  | Author 1  | Subject A | 19.99 |
|  7 | Book 7  | Author 7  | Subject A | 19.99 |
|  8 | Book 8  | Author 8  | Subject C | 21.75 |
| 12 | Book 12 | Author 12 | Subject C | 23.75 |
|  2 | Book 2  | Author 2  | Subject B | 24.95 |
| 13 | Book 13 | Author 13 | Subject D | 28.99 |
|  4 | Book 4  | Author 4  | Subject A | 29.99 |
|  6 | Book 6  | Author 6  | Subject B | 32.50 |
+----+---------+-----------+-----------+-------+
15 rows in set (0.00 sec)

mysql> SELECT * from book Order BY price DESC;
+----+---------+-----------+-----------+-------+
| id | name    | author    | subject   | price |
+----+---------+-----------+-----------+-------+
|  6 | Book 6  | Author 6  | Subject B | 32.50 |
|  4 | Book 4  | Author 4  | Subject A | 29.99 |
| 13 | Book 13 | Author 13 | Subject D | 28.99 |
|  2 | Book 2  | Author 2  | Subject B | 24.95 |
| 12 | Book 12 | Author 12 | Subject C | 23.75 |
|  8 | Book 8  | Author 8  | Subject C | 21.75 |
|  1 | Book 1  | Author 1  | Subject A | 19.99 |
|  7 | Book 7  | Author 7  | Subject A | 19.99 |
| 10 | Book 10 | Author 10 | Subject B | 17.25 |
| 15 | Book 15 | Author 15 | Subject A | 16.75 |
|  3 | Book 3  | Author 3  | Subject C | 15.49 |
| 11 | Book 11 | Author 11 | Subject A | 14.50 |
|  9 | Book 9  | Author 9  | Subject D | 12.99 |
|  5 | Book 5  | Author 5  | Subject D |  9.99 |
| 14 | Book 14 | Author 14 | Subject B |  9.99 |
+----+---------+-----------+-----------+-------+
15 rows in set (0.00 sec)
```
- order by subject
```SQL
mysql> SELECT * from book ORDER by subject;
+----+---------+-----------+-----------+-------+
| id | name    | author    | subject   | price |
+----+---------+-----------+-----------+-------+
|  1 | Book 1  | Author 1  | Subject A | 19.99 |
|  4 | Book 4  | Author 4  | Subject A | 29.99 |
|  7 | Book 7  | Author 7  | Subject A | 19.99 |
| 11 | Book 11 | Author 11 | Subject A | 14.50 |
| 15 | Book 15 | Author 15 | Subject A | 16.75 |
|  2 | Book 2  | Author 2  | Subject B | 24.95 |
|  6 | Book 6  | Author 6  | Subject B | 32.50 |
| 10 | Book 10 | Author 10 | Subject B | 17.25 |
| 14 | Book 14 | Author 14 | Subject B |  9.99 |
|  3 | Book 3  | Author 3  | Subject C | 15.49 |
|  8 | Book 8  | Author 8  | Subject C | 21.75 |
| 12 | Book 12 | Author 12 | Subject C | 23.75 |
|  5 | Book 5  | Author 5  | Subject D |  9.99 |
|  9 | Book 9  | Author 9  | Subject D | 12.99 |
| 13 | Book 13 | Author 13 | Subject D | 28.99 |
+----+---------+-----------+-----------+-------+
```
```SQL

mysql> SELECT * from emp ORDER BY hire;
+-------+--------+-----------+------+------------+---------+---------+--------+
| empno | ename  | job       | mgr  | hire       | sal     | comm    | deptno |
+-------+--------+-----------+------+------------+---------+---------+--------+
|  7369 | Smith  | Clerk     | 7902 | 1980-12-17 |  800.00 |    NULL |     20 |
|  7499 | Allen  | Salesman  | 7698 | 1981-02-20 | 1600.00 |  300.00 |     30 |
|  7521 | Ward   | Salesman  | 7698 | 1981-02-22 | 1250.00 |  500.00 |     30 |
|  7566 | Jones  | Manager   | 7839 | 1981-04-02 | 2975.00 |    NULL |     20 |
|  7698 | Blake  | Manager   | 7839 | 1981-05-01 | 2850.00 |    NULL |     30 |
|  7782 | Clark  | Manager   | 7839 | 1981-06-09 | 2450.00 |    NULL |     10 |
|  7654 | Martin | Salesman  | 7698 | 1981-09-28 | 1250.00 | 1400.00 |     30 |
|  7839 | King   | President | NULL | 1981-11-17 | 5000.00 |    NULL |     10 |
|  7902 | Ford   | Analyst   | 7566 | 1981-12-03 | 3000.00 |    NULL |     20 |
|  7788 | Scott  | Analyst   | 7566 | 1982-12-09 | 3000.00 |    NULL |     20 |
+-------+--------+-----------+------+------------+---------+---------+--------+
```

```SQL

mysql> SELECT empno , ename , deptno , job FROM emp ORDER BY deptno,job;
+-------+--------+--------+-----------+
| empno | ename  | deptno | job       |
+-------+--------+--------+-----------+
|  7782 | Clark  |     10 | Manager   |
|  7839 | King   |     10 | President |
|  7788 | Scott  |     20 | Analyst   |
|  7902 | Ford   |     20 | Analyst   |
|  7369 | Smith  |     20 | Clerk     |
|  7566 | Jones  |     20 | Manager   |
|  7698 | Blake  |     30 | Manager   |
|  7499 | Allen  |     30 | Salesman  |
|  7521 | Ward   |     30 | Salesman  |
|  7654 | Martin |     30 | Salesman  |
+-------+--------+--------+-----------+

-- all deptno 10 are together
-- all deptno 20 are together
            -- and inside deptno 20 --> all are sorted by job
-- 1st level of sorting - > on deptno
-- 2nd --> on job

-- if we change the order
mysql> SELECT empno , ename , deptno , job FROM emp ORDER BY job,deptno;
+-------+--------+--------+-----------+
| empno | ename  | deptno | job       |
+-------+--------+--------+-----------+
|  7788 | Scott  |     20 | Analyst   |
|  7902 | Ford   |     20 | Analyst   |
|  7369 | Smith  |     20 | Clerk     |
|  7782 | Clark  |     10 | Manager   |
|  7566 | Jones  |     20 | Manager   |
|  7698 | Blake  |     30 | Manager   |
|  7839 | King   |     10 | President |
|  7499 | Allen  |     30 | Salesman  |
|  7521 | Ward   |     30 | Salesman  |
|  7654 | Martin |     30 | Salesman  |
+-------+--------+--------+-----------+
-- 1st level on : job column
-- 2nd level on : deptno column
```

### exersice
- sort all emp dept wise , for same dept sort salary wise in desc order
```SQL
mysql> SELECT empno, ename , deptno , sal from emp ORDER BY deptno , sal DESC;
+-------+--------+--------+---------+
| empno | ename  | deptno | sal     |
+-------+--------+--------+---------+
|  7839 | King   |     10 | 5000.00 |
|  7782 | Clark  |     10 | 2450.00 |
|  7788 | Scott  |     20 | 3000.00 |
|  7902 | Ford   |     20 | 3000.00 |
|  7566 | Jones  |     20 | 2975.00 |
|  7369 | Smith  |     20 |  800.00 |
|  7698 | Blake  |     30 | 2850.00 |
|  7499 | Allen  |     30 | 1600.00 |
|  7521 | Ward   |     30 | 1250.00 |
|  7654 | Martin |     30 | 1250.00 |
+-------+--------+--------+---------+
```
- all employee are sorted by deptno wise
- if deptno is same then 
- it sorted salary wise in descending order

```SQL
mysql> SELECT * from book;
+----+---------+-----------+-----------+-------+
| id | name    | author    | subject   | price |
+----+---------+-----------+-----------+-------+
|  1 | Book 1  | Author 1  | Subject A | 19.99 |
|  2 | Book 2  | Author 2  | Subject B | 24.95 |
|  3 | Book 3  | Author 3  | Subject C | 15.49 |
|  4 | Book 4  | Author 4  | Subject A | 29.99 |
|  5 | Book 5  | Author 5  | Subject D |  9.99 |
|  6 | Book 6  | Author 6  | Subject B | 32.50 |
|  7 | Book 7  | Author 7  | Subject A | 19.99 |
|  8 | Book 8  | Author 8  | Subject C | 21.75 |
|  9 | Book 9  | Author 9  | Subject D | 12.99 |
| 10 | Book 10 | Author 10 | Subject B | 17.25 |
| 11 | Book 11 | Author 11 | Subject A | 14.50 |
| 12 | Book 12 | Author 12 | Subject C | 23.75 |
| 13 | Book 13 | Author 13 | Subject D | 28.99 |
| 14 | Book 14 | Author 14 | Subject B |  9.99 |
| 15 | Book 15 | Author 15 | Subject A | 16.75 |
+----+---------+-----------+-----------+-------+


-- print book with highest price
mysql> SELECT * from book Order By price DESC  limit 1;
+----+--------+----------+-----------+-------+
| id | name   | author   | subject   | price |
+----+--------+----------+-----------+-------+
|  6 | Book 6 | Author 6 | Subject B | 32.50 |
+----+--------+----------+-----------+-------+
1 row in set (0.00 sec)

-- print book with lowest price

mysql> SELECT * from book ORDER BY price limit 1;
+----+--------+----------+-----------+-------+
| id | name   | author   | subject   | price |
+----+--------+----------+-----------+-------+
|  5 | Book 5 | Author 5 | Subject D |  9.99 |
+----+--------+----------+-----------+-------+
```
-  limit clause must be after Order by clause
#### problem : print book with third highest price
```SQL
mysql> SELECT * from book Order By price DESC;
+----+---------+-----------+-----------+-------+
| id | name    | author    | subject   | price |
+----+---------+-----------+-----------+-------+
|  6 | Book 6  | Author 6  | Subject B | 32.50 |
|  4 | Book 4  | Author 4  | Subject A | 29.99 |
| 13 | Book 13 | Author 13 | Subject D | 28.99 |
|  2 | Book 2  | Author 2  | Subject B | 24.95 |
| 12 | Book 12 | Author 12 | Subject C | 23.75 |
|  8 | Book 8  | Author 8  | Subject C | 21.75 |
|  1 | Book 1  | Author 1  | Subject A | 19.99 |
|  7 | Book 7  | Author 7  | Subject A | 19.99 |
| 10 | Book 10 | Author 10 | Subject B | 17.25 |
| 15 | Book 15 | Author 15 | Subject A | 16.75 |
|  3 | Book 3  | Author 3  | Subject C | 15.49 |
| 11 | Book 11 | Author 11 | Subject A | 14.50 |
|  9 | Book 9  | Author 9  | Subject D | 12.99 |
|  5 | Book 5  | Author 5  | Subject D |  9.99 |
| 14 | Book 14 | Author 14 | Subject B |  9.99 |
+----+---------+-----------+-----------+-------+

-- now to find third highest which is Book 2
-- first sort
-- then pick third one using limit clause

mysql> SELECT * from book Order By price DESC limit 2 ,1;
+----+---------+-----------+-----------+-------+
| id | name    | author    | subject   | price |
+----+---------+-----------+-----------+-------+
| 13 | Book 13 | Author 13 | Subject D | 28.99 |
+----+---------+-----------+-----------+-------+
1 row in set (0.00 sec)

-- limit 2 , 1;
-- like skip first 2 , then print 1 next
```
- this whole sorting is done on server end 
- processing is only done on server side
- but this order by doesn't modify into hard disk 
        - client 
![Alt text](image-15.png)

#### sorting on computed column


```SQL
 SELECT empno , ename, sal,
    CASE
    WHEN sal <= 1500 THEN 'Poor'
    WHEN sal > 1500 AND sal <= 2500 THEN 'Middle'
    ELSE 'Rich'
    END AS  SalaryCategory
    FROM emp
    ORDER BY SalaryCategory;
+-------+--------+---------+----------------+
| empno | ename  | sal     | SalaryCategory |
+-------+--------+---------+----------------+
|  7499 | Allen  | 1600.00 | Middle         |
|  7782 | Clark  | 2450.00 | Middle         |
|  7369 | Smith  |  800.00 | Poor           |
|  7521 | Ward   | 1250.00 | Poor           |
|  7654 | Martin | 1250.00 | Poor           |
|  7566 | Jones  | 2975.00 | Rich           |
|  7698 | Blake  | 2850.00 | Rich           |
|  7788 | Scott  | 3000.00 | Rich           |
|  7839 | King   | 5000.00 | Rich           |
|  7902 | Ford   | 3000.00 | Rich           |
+-------+--------+---------+----------------+
```
- above is allowed im mysql
```SQL
 SELECT empno , ename, sal,
    CASE
    WHEN sal <= 1500 THEN 'Poor'
    WHEN sal > 1500 AND sal <= 2500 THEN 'Middle'
    ELSE 'Rich'
    END AS  SalaryCategory
    FROM emp
    ORDER BY 4;
```
- In mySQL 
- order by can be done by alias name.
- and also can be done column number


### where clause
* select col from tablename WHERE condition;
```SQL
SELECT * from emp WHERE deptno=20;
SELECT * from emp WHERE sal > 2500 ;
SELECT * from emp WHERE job='SALESMAN';
```
- we have some relational operator
- <, >, <=, => , = , !=
- not equal to  ==> != or <>
- logical -> AND , OR , NOT

```SQL
SELECT * from emp WHERE Job='analyst' AND deptno=20;
```

# DAY 5

#### some assignment questionsd
 - select * from orders where (amt < 1000 OR NOT(odate= '1990-10-03' AND cnum > 2003));

 ```SQL
 mysql> Select * from orders;
+------+---------+------------+------+------+
| Onum | Ant     | Odate      | Cnum | Snum |
+------+---------+------------+------+------+
| 3001 |   18.69 | 1990-10-03 | 2008 | 1007 |
| 3003 |  767.19 | 1990-10-03 | 2001 | 1001 |
| 3002 | 1900.10 | 1990-10-03 | 2007 | 1004 |
| 3005 | 5160.45 | 1990-10-03 | 2003 | 1002 |
| 3006 | 1098.16 | 1990-10-03 | 2008 | 1007 |
| 3009 | 1713.23 | 1990-10-04 | 2002 | 1003 |
| 3007 |   75.75 | 1990-10-04 | 2004 | 1002 |
| 3008 | 4723.00 | 1990-10-05 | 2006 | 1001 |
| 3010 | 1309.95 | 1990-10-06 | 2004 | 1002 |
| 3011 | 9891.88 | 1990-10-06 | 2006 | 1001 |
+------+---------+------------+------+------+

mysql> select * from orders where (Ant < 1000 OR NOT(Odate= '1990-10-03' AND Cnum > 2003));
+------+---------+------------+------+------+
| Onum | Ant     | Odate      | Cnum | Snum |
+------+---------+------------+------+------+
| 3001 |   18.69 | 1990-10-03 | 2008 | 1007 |
| 3003 |  767.19 | 1990-10-03 | 2001 | 1001 |
| 3005 | 5160.45 | 1990-10-03 | 2003 | 1002 |
| 3009 | 1713.23 | 1990-10-04 | 2002 | 1003 |
| 3007 |   75.75 | 1990-10-04 | 2004 | 1002 |
| 3008 | 4723.00 | 1990-10-05 | 2006 | 1001 |
| 3010 | 1309.95 | 1990-10-06 | 2004 | 1002 |
| 3011 | 9891.88 | 1990-10-06 | 2006 | 1001 |
+------+---------+------------+------+------+
-- but how this output came 
 ```
- our query was :
- select * from orders where (Ant < 1000 OR NOT(Odate= '1990-10-03' AND Cnum > 2003)); 
- lets break it
- select * from orders -> 10 rows
- first condition : where data is '1990-10-03'
- 
```SQL
- mysql> Select * from orders where Odate= '1990-10-03' ;
+------+---------+------------+------+------+
| Onum | Ant     | Odate      | Cnum | Snum |
+------+---------+------------+------+------+
| 3001 |   18.69 | 1990-10-03 | 2008 | 1007 |
| 3003 |  767.19 | 1990-10-03 | 2001 | 1001 |
| 3002 | 1900.10 | 1990-10-03 | 2007 | 1004 |
| 3005 | 5160.45 | 1990-10-03 | 2003 | 1002 |
| 3006 | 1098.16 | 1990-10-03 | 2008 | 1007 |
+------+---------+------------+------+------+
- 
- mysql>  Select * from orders where Odate= '1990-10-03'  AND Cnum > 2003;
+------+---------+------------+------+------+
| Onum | Ant     | Odate      | Cnum | Snum |
+------+---------+------------+------+------+
| 3001 |   18.69 | 1990-10-03 | 2008 | 1007 |
| 3002 | 1900.10 | 1990-10-03 | 2007 | 1004 |
| 3006 | 1098.16 | 1990-10-03 | 2008 | 1007 |
+------+---------+------------+------+------+
-
- but we have to exclude this from our result
- 
- mysql>  Select * from orders WHERE NOT(Odate= '1990-10-03'  AND Cnum > 2003);
+------+---------+------------+------+------+
| Onum | Ant     | Odate      | Cnum | Snum |
+------+---------+------------+------+------+
| 3003 |  767.19 | 1990-10-03 | 2001 | 1001 |
| 3005 | 5160.45 | 1990-10-03 | 2003 | 1002 |
| 3009 | 1713.23 | 1990-10-04 | 2002 | 1003 |
| 3007 |   75.75 | 1990-10-04 | 2004 | 1002 |
| 3008 | 4723.00 | 1990-10-05 | 2006 | 1001 |
| 3010 | 1309.95 | 1990-10-06 | 2004 | 1002 |
| 3011 | 9891.88 | 1990-10-06 | 2006 | 1001 |
+------+---------+------------+------+------+
- now we get remaining records where 
-
- there is one more condition 
- Select * from orders WHERE Ant < 1000 ;
- we will these records
- mysql> Select * from orders WHERE Ant < 1000 ;
+------+--------+------------+------+------+
| Onum | Ant    | Odate      | Cnum | Snum |
+------+--------+------------+------+------+
| 3001 |  18.69 | 1990-10-03 | 2008 | 1007 |
| 3003 | 767.19 | 1990-10-03 | 2001 | 1001 |
| 3007 |  75.75 | 1990-10-04 | 2004 | 1002 |
+------+--------+------------+------+------+
```
-
- now our main query was =>  select * from orders where (Ant < 1000 OR NOT(Odate= '1990-10-03' AND Cnum > 2003));

- . 
- .
- In C programming  : precedence : || << && << ! (highest) 
- In RDBMS : NOT < AND < OR  same as C

####  Write a query on Customers table whose output will exckude all customers with a rating <= 100 , unless they are located in Rome
- 

```SQL
mysql> select * from customers where NOT( rating <= 100) OR city='Rome' ;

mysql>  select * from customers where NOT(rating <= 100 AND city != 'Rome' );

-- both of the queries give same output 
```
### where vs When
- where : is to fetch selected row - for which given condition is true -- after FROM tablename.
- case...when : is for computed colunm  -- before FROM tablename;

```SQL
-- where VS when

 SELECT empno , ename,job, sal,
    CASE
    WHEN sal <= 1500 THEN 'Poor'
    WHEN sal > 1500 AND sal <= 2500 THEN 'Middle'
    ELSE 'Rich'
    END AS  'SalaryCategory'
    FROM emp
    WHERE job = 'salesman';
+-------+--------+----------+---------+----------------+
| empno | ename  | job      | sal     | SalaryCategory |
+-------+--------+----------+---------+----------------+
|  7499 | Allen  | Salesman | 1600.00 | Middle         |
|  7521 | Ward   | Salesman | 1250.00 | Poor           |
|  7654 | Martin | Salesman | 1250.00 | Poor           |
+-------+--------+----------+---------+----------------+
```



```SQL
mysql> Select * from salespeople;
+------+---------+-----------+------+
| Snum | Sname   | City      | Comm |
+------+---------+-----------+------+
| 1001 | Peel    | London    | 0.12 |
| 1002 | Serres  | San Jose  | 0.13 |
| 1007 | Rifkin  | Barcelona | 0.15 |
| 1003 | Axelrod | New York  | 0.10 |
| 1003 | Motika  | London    | 0.11 |
+------+---------+-----------+------+

```
## Dealing with NULL 

- NULL doesn't work with relational and logical operator
- need special operators here 
    * IS NULL or <=>
    * IS NOT NULL 
```SQL
-- find all emp whose comm is null
mysql> SELECt * from emp where comm = NULL ;
Empty set (0.00 sec)
-- not working with = operator

mysql> SELECT empno, ename , comm from emp where comm IS NULL ;
+-------+-------+------+
| empno | ename | comm |
+-------+-------+------+
|  7369 | Smith | NULL |
|  7566 | Jones | NULL |
|  7698 | Blake | NULL |
|  7782 | Clark | NULL |
|  7788 | Scott | NULL |
|  7839 | King  | NULL |
|  7902 | Ford  | NULL |
+-------+-------+------+

-- same optput with 
mysql> SELECT empno, ename , comm from emp where comm <=> NULL ;

-- <=>   -> this is not compatible with all RDBMS , works with mysql
-- but  IS NULL is ANSI standard 


mysql> SELECT empno, ename , comm from emp where comm IS NOT NULL ;
+-------+--------+---------+
| empno | ename  | comm    |
+-------+--------+---------+
|  7499 | Allen  |  300.00 |
|  7521 | Ward   |  500.00 |
|  7654 | Martin | 1400.00 |
+-------+--------+---------+
```

## simplification of the query
- BETWEEN operator
- more readable 
- faster
- NOT BETWEEN
```SQL
-- get all emp whose sal is between 1500 and 2000

mysql> SELECT * from emp where sal >= 1500 AND sal <= 2000 ;

-- can we do it in more simple way?
-- use between operator

SELECT * from emp where sal between 1500 AND 2000;

-- here sal is inclusive

-- now get emp hired in year 1982.
mysql> SELECT * from emp where hire BETWEEN '1982-01-01' AND '1982-12-31' ;
+-------+-------+---------+------+------------+---------+------+--------+
| empno | ename | job     | mgr  | hire       | sal     | comm | deptno |
+-------+-------+---------+------+------------+---------+------+--------+
|  7788 | Scott | Analyst | 7566 | 1982-12-09 | 3000.00 | NULL |     20 |
+-------+-------+---------+------+------------+---------+------+--------+

-- get all emp whose name is between 'F' to 'M' ;
mysql> SELECT * from emp where ename BETWEEN 'F' AND 'M' ;
+-------+-------+-----------+------+------------+---------+------+--------+
| empno | ename | job       | mgr  | hire       | sal     | comm | deptno |
+-------+-------+-----------+------+------------+---------+------+--------+
|  7566 | Jones | Manager   | 7839 | 1981-04-02 | 2975.00 | NULL |     20 |
|  7839 | King  | President | NULL | 1981-11-17 | 5000.00 | NULL |     10 |
|  7902 | Ford  | Analyst   | 7566 | 1981-12-03 | 3000.00 | NULL |     20 |
+-------+-------+-----------+------+------------+---------+------+--------+
-- but this is not giving ename with M 
-- here F is inclusive but M is not 
-- Ford 
-- Jones 
-- King 
-- Martin 
--  here Martin is after M --> means in dictionary M comes before MArtin 

-- but if 
-- F
-- Ford 
-- Jones 
-- King 
-- M
-- Martin 

-- but I want all whose start with M 
-- there is trick -- use BETWEEN 'F AND 'N' --> but not recommended
-- bcoz the record with ename == 'L' will also fetched but we dont want that

-- instead use this 
-- BETWEEN 'F AND 'N' AND ename != 'L' ; --> here we skipping the L
 
 mysql> SELECT * from emp where ename BETWEEN 'F' AND 'N' AND ename != 'L' ;
+-------+--------+-----------+------+------------+---------+---------+--------+
| empno | ename  | job       | mgr  | hire       | sal     | comm    | deptno |
+-------+--------+-----------+------+------------+---------+---------+--------+
|  7566 | Jones  | Manager   | 7839 | 1981-04-02 | 2975.00 |    NULL |     20 |
|  7654 | Martin | Salesman  | 7698 | 1981-09-28 | 1250.00 | 1400.00 |     30 |
|  7839 | King   | President | NULL | 1981-11-17 | 5000.00 |    NULL |     10 |
|  7902 | Ford   | Analyst   | 7566 | 1981-12-03 | 3000.00 |    NULL |     20 |
+-------+--------+-----------+------+------------+---------+---------+--------+
-- now see all emp between F - M inclusive came 


-- what if I want record with 'Z' then with this we cannot fetch it
```
### IN operator

```SQL
-- find all ANALYST , MANAGER , PRESIDENT 
mysql> SELECT * from emp where job='Analyst' OR job='Manager' OR job='President';
-- OR
mysql> SELECT * from emp where job IN ( 'Analyst' , 'Manager' , 'President');
-- by using IN operator 
-- more readale for comparing equallity with multiple values
-- faster than OR

-- reverse of IN --> NOT IN
```
### LIKE operator
* find similar name
* special character (wildcard)
    * '%' : any no of any characters
    * '_' : single any character
```SQL
-- get all emp whose name start with B
SELECT * from emp where ename LIKE 'B%' ;// starts with B we dont bother after B


-- get all emp whose name ends with H
SELECT * from emp where ename LIKE '%H' ; -- here H is after % means we dont bother whatever comes before H
mysql> SELECT * from emp where ename LIKE '%H' ;
+-------+-------+-------+------+------------+--------+------+--------+
| empno | ename | job   | mgr  | hire       | sal    | comm | deptno |
+-------+-------+-------+------+------------+--------+------+--------+
|  7369 | Smith | Clerk | 7902 | 1980-12-17 | 800.00 | NULL |     20 |
+-------+-------+-------+------+------------+--------+------+--------+

-- get all emp whose name contains O anywhere in name;
SELECT * from emp where ename LIKE '%O%';
mysql> SELECT * from emp where ename LIKE '%O%';
+-------+-------+---------+------+------------+---------+------+--------+
| empno | ename | job     | mgr  | hire       | sal     | comm | deptno |
+-------+-------+---------+------+------------+---------+------+--------+
|  7566 | Jones | Manager | 7839 | 1981-04-02 | 2975.00 | NULL |     20 |
|  7788 | Scott | Analyst | 7566 | 1982-12-09 | 3000.00 | NULL |     20 |
|  7902 | Ford  | Analyst | 7566 | 1981-12-03 | 3000.00 | NULL |     20 |
+-------+-------+---------+------+------------+---------+------+--------+

-- get all emp whose name contains any four letters 
-- means name with four letters
mysql> SELECT empno , ename from emp where ename LIKE '____' ;
+-------+-------+
| empno | ename |
+-------+-------+
|  7521 | Ward  |
|  7839 | King  |
|  7902 | Ford  |
+-------+-------+
-- here we just give 4 underscores 

-- get all emp name starts with K and having only four letters 
mysql> SELECT empno , ename from emp where ename LIKE 'K___' ;
+-------+-------+
| empno | ename |
+-------+-------+
|  7839 | King  |
+-------+-------+
-- k and 3 underscores


-- get all emp name contains l twice
SELECT * from emp where ename LIKE '%L%L%';
mysql> SELECT * from emp where ename LIKE '%L%L%';
+-------+-------+----------+------+------------+---------+--------+--------+
| empno | ename | job      | mgr  | hire       | sal     | comm   | deptno |
+-------+-------+----------+------+------------+---------+--------+--------+
|  7499 | Allen | Salesman | 7698 | 1981-02-20 | 1600.00 | 300.00 |     30 |


-- get all emp name contains L only once 
SELECT * from emp where ename LIKE '%_A%';
mysql> SELECT * from emp where ename LIKE '%_A%';
+-------+--------+----------+------+------------+---------+---------+--------+
| empno | ename  | job      | mgr  | hire       | sal     | comm    | deptno |
+-------+--------+----------+------+------------+---------+---------+--------+
|  7521 | Ward   | Salesman | 7698 | 1981-02-22 | 1250.00 |  500.00 |     30 |
|  7654 | Martin | Salesman | 7698 | 1981-09-28 | 1250.00 | 1400.00 |     30 |
|  7698 | Blake  | Manager  | 7839 | 1981-05-01 | 2850.00 |    NULL |     30 |
|  7782 | Clark  | Manager  | 7839 | 1981-06-09 | 2450.00 |    NULL |     10 |
+-------+--------+----------+------+------------+---------+---------+--------+
-- name contains only one A 


mysql> SELECT * from emp where ename LIKE '%L%' AND ename NOT LIKE '%L%L%';
+-------+-------+---------+------+------------+---------+------+--------+
| empno | ename | job     | mgr  | hire       | sal     | comm | deptno |
+-------+-------+---------+------+------------+---------+------+--------+
|  7698 | Blake | Manager | 7839 | 1981-05-01 | 2850.00 | NULL |     30 |
|  7782 | Clark | Manager | 7839 | 1981-06-09 | 2450.00 | NULL |     10 |
+-------+-------+---------+------+------------+---------+------+--------+
-- this is also the right approach
-- LIKE '%L%' --> fetch all with L
-- NOT LIKE '%L%L%'  --> skip those with double ll ;
```
* "%" means 0 or more occurrences of any character.
```SQl
SELECT * from emp WHERE ename LIKE '%LL%' ;

-- here '%LL%' is for consecative type like 'Aellen' ;

-- but when character contains twice but not consecutive letter
SELECT * from emp WHERE ename LIKE '%A%A%'; 
-- this query will fetch all emp whose name contains which has A twice , not consecutive


-- finds all emp whose name contains A - either once , twice, thrice doesn't matter
SELECT * from emp WHERE ename LIKE '%A%' ;
-- here A contains A once and more than once
-- like MARTIN, ADAMS(2 A)

-- finds what if I want to find nmae contains A only once
SELECT * from emp WHERE (ename LIKE '%A%') AND (ename NOT LIKE '%A%A%') ;
-- here ADAMS will get skipped 
-- and all other name contains more than one will also get skipped.

```
```SQL
-- find all emp between F and K
SELECT * from emp WHERE ename BETWEEN 'F' AND 'K';
-- here both are inclusive but only upto K not all words 


SELECT * from emp WHERE ename BETWEEN 'F' AND 'K' OR ename LIKE 'K%' ;
-- this is other way 
mysql> SELECT empno, ename , sal from emp WHERE ename BETWEEN 'F' AND 'K' OR ename LIKE 'K%' ;
+-------+-------+---------+
| empno | ename | sal     |
+-------+-------+---------+
|  7566 | Jones | 2975.00 |
|  7839 | King  | 5000.00 |
|  7902 | Ford  | 3000.00 |
+-------+-------+---------+
-- see here king is also displayed
-- ename BETWEEN 'F' AND 'K'-- this will fetch 
-- all names starts with F to K only not king
-- here OR ename LIKE 'K%' -- this part will include words starts with K.

```
```SQL
-- finds ename starts from s to z
-- here will not invole those starts with z like zebra
SELECT empno, ename , sal from emp WHERE ename BETWEEN 'S' AND 'Z' OR ename LIKE 'Z%' ;
```

## UPDATE clause (DML) 
![Alt text](image-16.png)

```SQL
mysql> SELECT * from book;
+----+---------+-----------+-----------+-------+
| id | name    | author    | subject   | price |
+----+---------+-----------+-----------+-------+
|  1 | Book 1  | Author 1  | Subject A | 19.99 |
|  2 | Book 2  | Author 2  | Subject B | 24.95 |
|  3 | Book 3  | Author 3  | Subject C | 15.49 |
|  4 | Book 4  | Author 4  | Subject A | 29.99 |

-- now lets modify some data
mysql> UPDATE book SET price= 23.45 WHERE id= 1;
Query OK, 1 row affected (0.03 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> SELECT * from book;
+----+---------+-----------+-----------+-------+
| id | name    | author    | subject   | price |
+----+---------+-----------+-----------+-------+
|  1 | Book 1  | Author 1  | Subject A | 23.45 |
|  2 | Book 2  | Author 2  | Subject B | 24.95 |
|  3 | Book 3  | Author 3  | Subject C | 15.49 |

-- see price of book 1 is updated 
```
```SQl
-- lets modify multiple columns in one query 
mysql> UPDATE book SET author='Yashwant P Kanetkar' , subject='C programming' WHERE id = 1 ;
Query OK, 1 row affected (0.01 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> SELECT * from book;
+----+---------+---------------------+---------------+-------+
| id | name    | author              | subject       | price |
+----+---------+---------------------+---------------+-------+
|  1 | Book 1  | Yashwant P Kanetkar | C programming | 23.45 |
|  2 | Book 2  | Author 2            | Subject B     | 24.95 |
|  3 | Book 3  | Author 3            | Subject C     | 15.49 |
```

* In real world scenario we only need to change one row OR record at a time
```SQL
-- if we want to update multiple records 
-- like
-- change price of all books of Subject A
UPDATE book SET price = price + price* 0.10 WHERE subject = 'Subject A' ;

mysql> SELECT subject , price from book WHERE Subject= 'Subject A';
+-----------+-------+
| subject   | price |
+-----------+-------+
| Subject A | 32.99 |
| Subject A | 21.99 |
| Subject A | 15.95 |
| Subject A | 18.43 |
+-----------+-------+
4 rows in set (0.00 sec)

mysql> UPDATE book SET price=price + price* 0.10 WHERE subject= 'Subject A';
Query OK, 4 rows affected, 4 warnings (0.01 sec)
Rows matched: 4  Changed: 4  Warnings: 4

mysql> SELECT subject , price from book WHERE Subject= 'Subject A';
                                                                  +-----------+-------+
| subject   | price |
+-----------+-------+
| Subject A | 36.29 |
| Subject A | 24.19 |
| Subject A | 17.55 |
| Subject A | 20.27 |
+-----------+-------+
4 rows in set (0.00 sec)

-- see the 10 % change in price
```

```SQL

-- increase price of all books by 5% (0.05)

mysql> SELECT * from book;
+----+---------+---------------------+---------------+-------+
| id | name    | author              | subject       | price |
+----+---------+---------------------+---------------+-------+
|  1 | Book 1  | Yashwant P Kanetkar | C programming | 23.45 |
|  2 | Book 2  | Author 2            | Subject B     | 24.95 |
|  3 | Book 3  | Author 3            | Subject C     | 15.49 |
|  4 | Book 4  | Author 4            | Subject A     | 36.29 |
|  5 | Book 5  | Author 5            | Subject D     |  9.99 |
|  6 | Book 6  | Author 6            | Subject B     | 32.50 |
|  7 | Book 7  | Author 7            | Subject A     | 24.19 |
|  8 | Book 8  | Author 8            | Subject C     | 21.75 |
|  9 | Book 9  | Author 9            | Subject D     | 12.99 |
| 10 | Book 10 | Author 10           | Subject B     | 17.25 |
| 11 | Book 11 | Author 11           | Subject A     | 17.55 |
| 12 | Book 12 | Author 12           | Subject C     | 23.75 |
| 13 | Book 13 | Author 13           | Subject D     | 28.99 |
| 14 | Book 14 | Author 14           | Subject B     |  9.99 |
| 15 | Book 15 | Author 15           | Subject A     | 20.27 |
+----+---------+---------------------+---------------+-------+
15 rows in set (0.00 sec)

mysql> UPDATE book SET price=price+price*0.05 ;
Query OK, 15 rows affected, 15 warnings (0.01 sec)
Rows matched: 15  Changed: 15  Warnings: 15

mysql> SELECT * from book;
+----+---------+---------------------+---------------+-------+
| id | name    | author              | subject       | price |
+----+---------+---------------------+---------------+-------+
|  1 | Book 1  | Yashwant P Kanetkar | C programming | 24.62 |
|  2 | Book 2  | Author 2            | Subject B     | 26.20 |
|  3 | Book 3  | Author 3            | Subject C     | 16.26 |
|  4 | Book 4  | Author 4            | Subject A     | 38.10 |
|  5 | Book 5  | Author 5            | Subject D     | 10.49 |
|  6 | Book 6  | Author 6            | Subject B     | 34.13 |
|  7 | Book 7  | Author 7            | Subject A     | 25.40 |
|  8 | Book 8  | Author 8            | Subject C     | 22.84 |
|  9 | Book 9  | Author 9            | Subject D     | 13.64 |
| 10 | Book 10 | Author 10           | Subject B     | 18.11 |
| 11 | Book 11 | Author 11           | Subject A     | 18.43 |
| 12 | Book 12 | Author 12           | Subject C     | 24.94 |
| 13 | Book 13 | Author 13           | Subject D     | 30.44 |
| 14 | Book 14 | Author 14           | Subject B     | 10.49 |
| 15 | Book 15 | Author 15           | Subject A     | 21.28 |
+----+---------+---------------------+---------------+-------+
15 rows in set (0.00 sec)


-- just we can remove WHERE clause from update query
-- to update all records in tables.
```

## DELETE clause (DML)
* can delect one or more rows
* DELETE FROM Table_name WHERE condition ;
```SQL
-- delete single row
mysql> DELETE FROM book WHERE id= 15 ;
Query OK, 1 row affected (0.01 sec)

-- check now only 14 rows are left
14 rows in set (0.00 sec)

```
```SQl
mysql> SELECT * From book ;
+----+---------+---------------------+---------------+-------+
| id | name    | author              | subject       | price |
+----+---------+---------------------+---------------+-------+
|  1 | Book 1  | Yashwant P Kanetkar | C programming | 24.62 |
|  2 | Book 2  | Author 2            | Subject B     | 26.20 |
|  3 | Book 3  | Author 3            | Subject C     | 16.26 |
|  4 | Book 4  | Author 4            | Subject A     | 38.10 |
|  5 | Book 5  | Author 5            | Subject D     | 10.49 |
|  6 | Book 6  | Author 6            | Subject B     | 34.13 |
|  7 | Book 7  | Author 7            | Subject A     | 25.40 |
|  8 | Book 8  | Author 8            | Subject C     | 22.84 |
|  9 | Book 9  | Author 9            | Subject D     | 13.64 |
| 10 | Book 10 | Author 10           | Subject B     | 18.11 |
| 11 | Book 11 | Author 11           | Subject A     | 18.43 |
| 12 | Book 12 | Author 12           | Subject C     | 24.94 |
| 13 | Book 13 | Author 13           | Subject D     | 30.44 |
| 14 | Book 14 | Author 14           | Subject B     | 10.49 |
+----+---------+---------------------+---------------+-------+
14 rows in set (0.00 sec)

```

-
-0
-
- now delete multiple rows 

```SQL
-- now delete all books from Subject C
DELETE FROM book WHERE subject = 'Subject C';

mysql> DELETE FROM book WHERE subject = 'Subject C';
Query OK, 3 rows affected (0.01 sec)

mysql> SELECT * FROM book;
+----+---------+---------------------+---------------+-------+
| id | name    | author              | subject       | price |
+----+---------+---------------------+---------------+-------+
|  1 | Book 1  | Yashwant P Kanetkar | C programming | 24.62 |
|  2 | Book 2  | Author 2            | Subject B     | 26.20 |
|  4 | Book 4  | Author 4            | Subject A     | 38.10 |
|  5 | Book 5  | Author 5            | Subject D     | 10.49 |
|  6 | Book 6  | Author 6            | Subject B     | 34.13 |
|  7 | Book 7  | Author 7            | Subject A     | 25.40 |
|  9 | Book 9  | Author 9            | Subject D     | 13.64 |
| 10 | Book 10 | Author 10           | Subject B     | 18.11 |
| 11 | Book 11 | Author 11           | Subject A     | 18.43 |
| 13 | Book 13 | Author 13           | Subject D     | 30.44 |
| 14 | Book 14 | Author 14           | Subject B     | 10.49 |
+----+---------+---------------------+---------------+-------+
11 rows in set (0.00 sec)
```

- now delete all records from table
```SQL
DELETE FROM books ;

mysql> DELETE FROM book;
Query OK, 11 rows affected (0.00 sec)

mysql> SELECT * from book;
Empty set (0.00 sec)

-- but table is there 
mysql> DESC book ;
+---------+---------------+------+-----+---------+-------+
| Field   | Type          | Null | Key | Default | Extra |
+---------+---------------+------+-----+---------+-------+
| id      | int           | NO   | PRI | NULL    |       |
| name    | varchar(255)  | YES  |     | NULL    |       |
| author  | varchar(255)  | YES  |     | NULL    |       |
| subject | varchar(255)  | YES  |     | NULL    |       |
| price   | decimal(10,2) | YES  |     | NULL    |       |
+---------+---------------+------+-----+---------+-------+
```

### DDL - to delete all rows at once
```SQL
TRUNCATE TABLE book ;
-- it will 0 rows affect 
-- same as we did above, all rows are delete but table is there

```
#### in DML it will show how many rows are affected , BUT not in DDL 

## DDL - DROP 
```SQL
DROP TABLE book ;


mysql> SELECT * from book;
+----+---------+-----------+-----------+-------+
| id | name    | author    | subject   | price |
+----+---------+-----------+-----------+-------+
|  1 | Book 1  | Author 1  | Subject A | 19.99 |
|  2 | Book 2  | Author 2  | Subject B | 24.95 |
|  3 | Book 3  | Author 3  | Subject C | 15.49 |
|  4 | Book 4  | Author 4  | Subject A | 29.99 |
|  5 | Book 5  | Author 5  | Subject D |  9.99 |
|  6 | Book 6  | Author 6  | Subject B | 32.50 |
|  7 | Book 7  | Author 7  | Subject A | 19.99 |
|  8 | Book 8  | Author 8  | Subject C | 21.75 |
|  9 | Book 9  | Author 9  | Subject D | 12.99 |
| 10 | Book 10 | Author 10 | Subject B | 17.25 |
| 11 | Book 11 | Author 11 | Subject A | 14.50 |
| 12 | Book 12 | Author 12 | Subject C | 23.75 |
| 13 | Book 13 | Author 13 | Subject D | 28.99 |
| 14 | Book 14 | Author 14 | Subject B |  9.99 |
| 15 | Book 15 | Author 15 | Subject A | 16.75 |
+----+---------+-----------+-----------+-------+
15 rows in set (0.00 sec)

mysql> DROP TABLE book;
Query OK, 0 rows affected (0.01 sec)

mysql> SELECT * from book;
ERROR 1146 (42S02): Table 'cdacdb.book' doesn't exist

-- with the DROP command table is deleted from database
-- there is nothing in database named 'book' ;
-- it deletes structure as well as data
```

```SQL
-- if we try to drop non existing table 
mysql> DROP TABLE book;
ERROR 1051 (42S02): Unknown table 'cdacdb.book'
-- we already drpoed it once

-- to avoid this unneccessary error 
-- bcoz deleteing non-existing table should not give error

```
- DELETE IF EXISTS
```SQL
DROP TABLE IF EXISTS book ;
mysql> DROP TABLE IF EXISTS book ;
Query OK, 0 rows affected, 1 warning (0.00 sec)

-- see query succefull , no error just warning 
-- but it will also successful in case table exists 
-- if table not exists then only warning 
```

![ ](image-17.png)

## DELETE (DML)vs TRUNCATE (DDL)vs DROP (DDL) 
- Query implememtation changes from RDBMS to RDBMS.
- depends on vendor
- 
- In general 
- database --> is directory 
- table --> file
- table file --> data + metadata
- 
- 
- 
- when we say we delete the row from table
![in case of DELETE ](image-18.png)
- DELETE from book ;
- marked each row to delete 
- not actually deleting
- only marked that space to reuse for next 
- space occupied by the rows can be overwritten/reused by new records
- actual table file size is not changed much 
- DELETE is DML query --> can be roll back
- 
- 
- 
- 
- TRUNCATE TABLE book;
- ![in TRUNCATE](image-19.png)
- in TRUNCATE 
- it resize the Table file 
- only structure(metadata) is kept
- all rows space is realesee
- much faster operation for huge TABLE
- TRUNCATE is DDL query --> never be roll back
- 
- 
- 
- DROP TABLE IF EXISTS book;
- it will delete entire file 
- DELETES TABLE file --> structure + data
- it is DDL query --> can't roll back
- faster than TRUNCATE 
 #### DROP SCHEMA
 - DROP DATABASE cdacdb ;


 ### SEEKING HELP
 - HELP is client commend to seek help on commands and functions
    - HELP SELECT ;
    - HELP Functions;



```SQL
mysql> SELECT empno , ename , sal from emp WHERE SUBSTRING(ename,1,1) BETWEEN '
F' AND 'K' ;
+-------+-------+---------+
| empno | ename | sal     |
+-------+-------+---------+
|  7566 | Jones | 2975.00 |
|  7839 | King  | 5000.00 |
|  7902 | Ford  | 3000.00 |
+-------+-------+---------+
3 rows in set (0.00 sec)
```







 