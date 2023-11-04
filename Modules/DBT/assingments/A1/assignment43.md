## Assignment –4
1) Write a select command that produces the order number, amount, and date for all rows in the Orders table.
2) Write a query that produces all rows from the Customers table for which the salesperson’s number is 1001.
3) Write a query that displays the Salespeople table with the columns in the following order: city, sname, snum, comm.
4) Write a select command that produces the rating followed by the name of each customer in San Jose.
5) Write a query that will produce the snum values of all salespeople (suppress the duplicates) with orders in the Orders table.


- ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
```SQL
mysql> SELECT * FROM orders;
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
```
1) Write a select command that produces the order number, amount, and date for all rows in the Orders table.
```SQL
mysql> SELECT Onum, Ant , Odate from orders;
+------+---------+------------+
| Onum | Ant     | Odate      |
+------+---------+------------+
| 3001 |   18.69 | 1990-10-03 |
| 3003 |  767.19 | 1990-10-03 |
| 3002 | 1900.10 | 1990-10-03 |
| 3005 | 5160.45 | 1990-10-03 |
| 3006 | 1098.16 | 1990-10-03 |
| 3009 | 1713.23 | 1990-10-04 |
| 3007 |   75.75 | 1990-10-04 |
| 3008 | 4723.00 | 1990-10-05 |
| 3010 | 1309.95 | 1990-10-06 |
| 3011 | 9891.88 | 1990-10-06 |
+------+---------+------------+
```

- 2) Write a query that produces all rows from the Customers table for which the salesperson’s number is 1001.
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

-- 
mysql> SELECT * FROM customers WHERE Snum = 1001;
+------+---------+--------+--------+------+
| Cnum | Cname   | City   | Rating | Snum |
+------+---------+--------+--------+------+
| 2001 | Hoffman | London |    100 | 1001 |
| 2006 | Clemens | London |    100 | 1001 |
+------+---------+--------+--------+------+
```

- 3) Write a query that displays the Salespeople table with the columns in the following order: city, sname, snum, comm.

```SQL
mysql> SELECT * FROM salespeople;
+------+---------+-----------+------+
| Snum | Sname   | City      | Comm |
+------+---------+-----------+------+
| 1001 | Peel    | London    | 0.12 |
| 1002 | Serres  | San Jose  | 0.13 |
| 1007 | Rifkin  | Barcelona | 0.15 |
| 1003 | Axelrod | New York  | 0.10 |
| 1003 | Motika  | London    | 0.11 |
+------+---------+-----------+------+
5 rows in set (0.00 sec)

mysql> SELECT City , Sname , Snum , Comm from salespeople;
+-----------+---------+------+------+
| City      | Sname   | Snum | Comm |
+-----------+---------+------+------+
| London    | Peel    | 1001 | 0.12 |
| San Jose  | Serres  | 1002 | 0.13 |
| Barcelona | Rifkin  | 1007 | 0.15 |
| New York  | Axelrod | 1003 | 0.10 |
| London    | Motika  | 1003 | 0.11 |
```

- 4) Write a select command that produces the rating followed by the name of each customer in San Jose.
```SQL
mysql> SELECT Rating from customers WHERE city='San Jose';
+--------+
| Rating |
+--------+
|    200 |
|    300 |
+--------+
2 rows in set (0.00 sec)
```

- 5) Write a query that will produce the snum values of all salespeople (suppress the duplicates) with orders in the Orders table.