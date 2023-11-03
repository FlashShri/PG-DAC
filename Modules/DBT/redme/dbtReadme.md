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