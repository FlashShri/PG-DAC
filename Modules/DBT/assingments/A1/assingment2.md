
## Assignment 2
1) Which field of the Customers table is the primary key?
2) What is the 4th column of the Customers table?
3) What is another word for row? For column?
4) Why isn’t it possible to see the first five rows of a table?

- coustomer table
```SQL

mysql> Select * from customers;
+------+----------+----------+--------+------+
| Cnum | Cname    | City     | Rating | Snum |
+------+----------+----------+--------+------+
| 2001 | Hoffman  | London   |    100 | 1001 |
| 2002 | Giovanni | Rome     |    200 | 1003 |
| 2003 | Liu      | San Jose |    200 | 1002 |
| 2004 | Grass    | Berlin   |    300 | 1002 |
| 2006 | Clemens  | London   |    100 | 1001 |
| 2008 | Cisneros | San Jose |    300 | 1007 |
| 2007 | Pereira  | Rome     |    100 | 1004 |
+------+----------+----------+--------+------+
```
- Which field of the Customers table is the primary key?
=>  Cnum 
- What is the 4th column of the Customers table?
=> Rating.
- What is another word for row? For column?
- row --> tuple
- column --> field.
- Why isn’t it possible to see the first five rows of a table?

```SQL
select * from customers limit 5 ;

mysql> select * from customers limit 5 ;
+------+----------+----------+--------+------+
| Cnum | Cname    | City     | Rating | Snum |
+------+----------+----------+--------+------+
| 2001 | Hoffman  | London   |    100 | 1001 |
| 2002 | Giovanni | Rome     |    200 | 1003 |
| 2003 | Liu      | San Jose |    200 | 1002 |
| 2004 | Grass    | Berlin   |    300 | 1002 |
| 2006 | Clemens  | London   |    100 | 1001 |
+------+----------+----------+--------+------+
```


## Assignment –3
Overview of SQL.
1) Does ANSI recognize the data type DATE?
- Yes, ANSI SQL recognizes the DATE data type as a standard data type for representing dates. The DATE data type is commonly used to store date values in a database, and it's supported by many relational database management systems (RDBMS) that adhere to the ANSI SQL standard.
2) Which subdivision of SQL is used to insert values in tables?
- DML -> Data Manipulation Language 


