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
 

