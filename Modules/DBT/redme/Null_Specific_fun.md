# Null operators and Functions

* operators
    * IS NULL
    * IS NOT NULL
* Function
    * ISNULL()
    * IFNULL()
    * NULLIF()

### ISNULL()

- If expr is NULL, ISNULL() returns 1, otherwise it returns 0.
```SQL
mysql> SELECT comm , ISNULL(comm) from emp;
+---------+--------------+
| comm    | ISNULL(comm) |
+---------+--------------+
|    NULL |            1 |
|  300.00 |            0 |
|  500.00 |            0 |
|    NULL |            1 |
| 1400.00 |            0 |
|    NULL |            1 |
|    NULL |            1 |
|    NULL |            1 |
|    NULL |            1 |
|    NULL |            1 |
+---------+--------------+
```

## IFNULL()
```SQL
mysql> HELP IFNULL
Name: 'IFNULL'
Description:
Syntax:
IFNULL(expr1,expr2)

If expr1 is not NULL, IFNULL() returns expr1; otherwise it returns
expr2.

URL: https://dev.mysql.com/doc/refman/8.0/en/flow-control-functions.html

Examples:
mysql> SELECT IFNULL(1,0);
        -> 1
mysql> SELECT IFNULL(NULL,10);
        -> 10
mysql> SELECT IFNULL(1/0,10);
        -> 10
mysql> SELECT IFNULL(1/0,'yes');
        -> 'yes'
```
- IFNULL(col , value ) --> if col is null , returns given value
 ```SQL
 mysql> SELECT comm , IFNULL( comm , 0.00) from emp;;
+---------+----------------------+
| comm    | IFNULL( comm , 0.00) |
+---------+----------------------+
|    NULL |                 0.00 |
|  300.00 |               300.00 |
|  500.00 |               500.00 |
|    NULL |                 0.00 |
| 1400.00 |              1400.00 |
|    NULL |                 0.00 |
|    NULL |                 0.00 |
|    NULL |                 0.00 |
|    NULL |                 0.00 |
|    NULL |                 0.00 |
+---------+----------------------+

mysql> SELECT comm , IFNULL( comm , 'new_commer') from emp;
+---------+------------------------------+
| comm    | IFNULL( comm , 'new_commer') |
+---------+------------------------------+
|    NULL | new_commer                   |
|  300.00 | 300.00                       |
|  500.00 | 500.00                       |
|    NULL | new_commer                   |
| 1400.00 | 1400.00                      |
|    NULL | new_commer                   |
|    NULL | new_commer                   |
|    NULL | new_commer                   |
|    NULL | new_commer                   |
|    NULL | new_commer                   |
+---------+------------------------------+
 ```
 ```SQL
 -- print enmae , sal, comm , total income ==> sal+comm
 mysql> SELECT ename , sal , comm , sal+comm AS TOTAL_INCOME from emp ;
+--------+---------+---------+--------------+
| ename  | sal     | comm    | TOTAL_INCOME |
+--------+---------+---------+--------------+
| Smith  |  800.00 |    NULL |         NULL |
| Allen  | 1600.00 |  300.00 |      1900.00 |
| Ward   | 1250.00 |  500.00 |      1750.00 |
| Jones  | 2975.00 |    NULL |         NULL |
| Martin | 1250.00 | 1400.00 |      2650.00 |
| Blake  | 2850.00 |    NULL |         NULL |
| Clark  | 2450.00 |    NULL |         NULL |
| Scott  | 3000.00 |    NULL |         NULL |
| King   | 5000.00 |    NULL |         NULL |
| Ford   | 3000.00 |    NULL |         NULL |
+--------+---------+---------+--------------+

-- see the problem anything with null will become null
-- but want total income
-- 

mysql> SELECT ename, sal, comm, IFNULL(comm, 0.00)+sal AS Total_income from emp ;
+--------+---------+---------+--------------+
| ename  | sal     | comm    | Total_income |
+--------+---------+---------+--------------+
| Smith  |  800.00 |    NULL |       800.00 |
| Allen  | 1600.00 |  300.00 |      1900.00 |
| Ward   | 1250.00 |  500.00 |      1750.00 |
| Jones  | 2975.00 |    NULL |      2975.00 |
| Martin | 1250.00 | 1400.00 |      2650.00 |
| Blake  | 2850.00 |    NULL |      2850.00 |
| Clark  | 2450.00 |    NULL |      2450.00 |
| Scott  | 3000.00 |    NULL |      3000.00 |
| King   | 5000.00 |    NULL |      5000.00 |
| Ford   | 3000.00 |    NULL |      3000.00 |
+--------+---------+---------+--------------+

 ```

 ## NULLIF()

 * NULLIF(col , value) --> if col == given value then return null
 ```SQL
 mysql> SELECT ename, sal , NULLIF( sal , 3000) from emp;
+--------+---------+---------------------+
| ename  | sal     | NULLIF( sal , 3000) |
+--------+---------+---------------------+
| Smith  |  800.00 |              800.00 |
| Allen  | 1600.00 |             1600.00 |
| Ward   | 1250.00 |             1250.00 |
| Jones  | 2975.00 |             2975.00 |
| Martin | 1250.00 |             1250.00 |
| Blake  | 2850.00 |             2850.00 | 
| Clark  | 2450.00 |             2450.00 |
| Scott  | 3000.00 |                NULL |
| King   | 5000.00 |             5000.00 |
| Ford   | 3000.00 |                NULL |
+--------+---------+---------------------+
 ```

 ## COALESCE()
 ```SQL
 
 mysql> HELP Coalesce
Name: 'COALESCE'
Description:
Syntax:
COALESCE(value,...)

Returns the first non-NULL value in the list, or NULL if there are no
non-NULL values.

The return type of COALESCE() is the aggregated type of the argument
types.

URL: https://dev.mysql.com/doc/refman/8.0/en/comparison-operators.html

Examples:
mysql> SELECT COALESCE(NULL,1);
        -> 1
mysql> SELECT COALESCE(NULL,NULL,NULL);
        -> NULL
 ```

 * COALESCE(v1, v2, v3, .....) --> returns first non-null value 
 ```SQL
 mysql> SELECT COALESCE( null , null , 'abc' , 765 ,22 ) ;
+-------------------------------------------+
| COALESCE( null , null , 'abc' , 765 ,22 ) |
+-------------------------------------------+
| abc                                       |
+-------------------------------------------+
1 row in set (0.00 sec)

mysql> SELECT COALESCE( 'abc' ,null, 765 ,22 ) ;
+----------------------------------+
| COALESCE( 'abc' ,null, 765 ,22 ) |
+----------------------------------+
| abc                              |
+----------------------------------+
1 row in set (0.00 sec)

mysql> SELECT COALESCE( 'abc' , 765 ,22 ) ;
+-----------------------------+
| COALESCE( 'abc' , 765 ,22 ) |
+-----------------------------+
| abc                         |
+-----------------------------+
 ```
 ```SQL
 
mysql>  SELECT comm , sal , COALESCE ( comm , sal ) from emp ;
+---------+---------+-------------------------+
| comm    | sal     | COALESCE ( comm , sal ) |
+---------+---------+-------------------------+
|    NULL |  800.00 |                  800.00 |
|  300.00 | 1600.00 |                  300.00 |
|  500.00 | 1250.00 |                  500.00 |
|    NULL | 2975.00 |                 2975.00 |
| 1400.00 | 1250.00 |                 1400.00 |
|    NULL | 2850.00 |                 2850.00 |
|    NULL | 2450.00 |                 2450.00 |
|    NULL | 3000.00 |                 3000.00 |
|    NULL | 5000.00 |                 5000.00 |
|    NULL | 3000.00 |                 3000.00 |
+---------+---------+-------------------------+

-- here if comm is null then take sal instead
 ```