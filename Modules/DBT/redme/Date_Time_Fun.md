# DATE and TIME Functions

```SQL
-- try help first
mysql> HELP Date and time functions ;
You asked for help about help category: "Date and Time Functions"
For more information, type 'help <item>', where <item> is one of the following
topics:
   ADDDATE
   ADDTIME
   CONVERT_TZ
   CURDATE
   CURRENT_DATE
   CURRENT_TIME
   CURRENT_TIMESTAMP
   CURTIME
   DATE FUNCTION
   DATEDIFF
   DATE_ADD
   DATE_FORMAT
   DATE_SUB
   DAY
   DAYNAME
   DAYOFMONTH
   DAYOFWEEK
   DAYOFYEAR
   EXTRACT
   FROM_DAYS
   FROM_UNIXTIME
   GET_FORMAT
   HOUR
   LAST_DAY
   LOCALTIME
   LOCALTIMESTAMP
   MAKEDATE
   MAKETIME
   MICROSECOND
   MINUTE
   MONTH
   MONTHNAME
   NOW
   PERIOD_ADD
   PERIOD_DIFF
   QUARTER
   SECOND
   SEC_TO_TIME
   STR_TO_DATE
   SUBDATE
   SUBTIME
   SYSDATE
   TIME FUNCTION
   TIMEDIFF
   TIMESTAMP FUNCTION
   TIMESTAMPADD
   TIMESTAMPDIFF
   TIME_FORMAT
   TIME_TO_SEC
   TO_DAYS
   TO_SECONDS
   UNIX_TIMESTAMP
   UTC_DATE
   UTC_TIME
   UTC_TIMESTAMP
   WEEK
   WEEKDAY
   WEEKOFYEAR
   YEAR
   YEARWEEK
   ```

   - NOW() , SYSDATE() --> gives server time -- > returns current date and time
   - SLEEP(5) --> holds query execution for 5 sec
   
```SQL
   mysql> SELECT NOW() , SLEEP(5) , SYSDATE() ;
+---------------------+----------+---------------------+
| NOW()               | SLEEP(5) | SYSDATE()           |
+---------------------+----------+---------------------+
| 2023-11-14 19:10:54 |        0 | 2023-11-14 19:10:59 |
+---------------------+----------+---------------------+
1 row in set (5.01 sec)
```
```SQL
-- date only
mysql> SELECT CURRENT_DATE() ;
+----------------+
| CURRENT_DATE() |
+----------------+
| 2023-11-14     |
+----------------+

-- time only
mysql> SELECT CURRENT_TIME();
+----------------+
| CURRENT_TIME() |
+----------------+
| 19:13:51       |
+----------------+

mysql>  SELECT CURRENT_TIMESTAMP();
+---------------------+
| CURRENT_TIMESTAMP() |
+---------------------+
| 2023-11-14 19:15:15 |
+---------------------+
```
- current_date() , current_time() , current_timestamp()
- returns server date , time and date-time respectively
-  current_timestample() similar to NOW()/sysdate() ;
```SQL
-- we take this as variable
mysql> SELECT current_date , current_time , current_timestamp ;
+--------------+--------------+---------------------+
| current_date | current_time | current_timestamp   |
+--------------+--------------+---------------------+
| 2023-11-14   | 19:18:18     | 2023-11-14 19:18:18 |
+--------------+--------------+---------------------+
```
- find current day
```SQL
-- extract the desirable part from NOW()
mysql> SELECT NOW() ;
+---------------------+
| NOW()               |
+---------------------+
| 2023-11-14 19:19:51 |
+---------------------+


mysql> SELECT DAYOFMONTH(NOW()) , MONTH(NOW()) , MONTHNAME(NOW()) , YEAR(NOW()) , DAYOFYEAR(NOW());
+-------------------+--------------+------------------+-------------+------------------+
| DAYOFMONTH(NOW()) | MONTH(NOW()) | MONTHNAME(NOW()) | YEAR(NOW()) | DAYOFYEAR(NOW()) |
+-------------------+--------------+------------------+-------------+------------------+
|                14 |           11 | November         |        2023 |              318 |
+-------------------+--------------+------------------+-------------+------------------+

mysql> SELECT DATE(NOW())  , TIME(NOW());
+-------------+-------------+
| DATE(NOW()) | TIME(NOW()) |
+-------------+-------------+
| 2023-11-14  | 19:25:04    |
+-------------+-------------+

mysql> SELECT HOUR(NOW()) , MINUTE(NOW()) , SECOND(NOW()) ;
+-------------+---------------+---------------+
| HOUR(NOW()) | MINUTE(NOW()) | SECOND(NOW()) |
+-------------+---------------+---------------+
|          19 |            26 |             1 |


```
#### DATE_ADD
```SQL
/*
mysql> HELP DATE_ADD ;
Name: 'DATE_ADD'
Description:
Syntax:
DATE_ADD(date,INTERVAL expr unit), DATE_SUB(date,INTERVAL expr unit)

These functions perform date arithmetic. The date argument specifies
the starting date or datetime value. expr is an expression specifying
the interval value to be added or subtracted from the starting date.
expr is evaluated as a string; it may start with a - for negative
intervals. unit is a keyword indicating the units in which the
expression should be interpreted.

URL: https://dev.mysql.com/doc/refman/8.0/en/date-and-time-functions.html

Examples:
mysql> SELECT DATE_ADD('2018-05-01',INTERVAL 1 DAY);
        -> '2018-05-02'
mysql> SELECT DATE_SUB('2018-05-01',INTERVAL 1 YEAR);
        -> '2017-05-01'
mysql> SELECT DATE_ADD('2020-12-31 23:59:59',
    ->                 INTERVAL 1 SECOND);
        -> '2021-01-01 00:00:00'
mysql> SELECT DATE_ADD('2018-12-31 23:59:59',
    ->                 INTERVAL 1 DAY);
        -> '2019-01-01 23:59:59'
mysql> SELECT DATE_ADD('2100-12-31 23:59:59',
    ->                 INTERVAL '1:1' MINUTE_SECOND);
        -> '2101-01-01 00:01:00'
mysql> SELECT DATE_SUB('2025-01-01 00:00:00',
    ->                 INTERVAL '1 1:1:1' DAY_SECOND);
        -> '2024-12-30 22:58:59'
mysql> SELECT DATE_ADD('1900-01-01 00:00:00',
    ->                 INTERVAL '-1 10' DAY_HOUR);
        -> '1899-12-30 14:00:00'
mysql> SELECT DATE_SUB('1998-01-02', INTERVAL 31 DAY);
        -> '1997-12-02'
mysql> SELECT DATE_ADD('1992-12-31 23:59:59.000002',
    ->            INTERVAL '1.999999' SECOND_MICROSECOND);
        -> '1993-01-01 00:00:01.000001'
```
```SQL
mysql> SELECT date_add(now() , INTERVAL 2 DAY);
+----------------------------------+
| date_add(now() , INTERVAL 2 DAY) |
+----------------------------------+
| 2023-11-16 19:31:32              |
+----------------------------------+
1 row in set (0.00 sec)

mysql> SELECT date_add(now() , INTERVAL 1 month);
+------------------------------------+
| date_add(now() , INTERVAL 1 month) |
+------------------------------------+
| 2023-12-14 19:32:02                |
+------------------------------------+
1 row in set (0.00 sec)

mysql> SELECT date_add(now() , INTERVAL 6 month);
+------------------------------------+
| date_add(now() , INTERVAL 6 month) |
+------------------------------------+
| 2024-05-14 19:32:14                |
+------------------------------------+
1 row in set (0.00 sec)

mysql> SELECT date_add(now() , INTERVAL 2 year);
+-----------------------------------+
| date_add(now() , INTERVAL 2 year) |
+-----------------------------------+
| 2025-11-14 19:32:26               |
+-----------------------------------+
```

### DATEDIFF
```SQL
mysql> HELP datediff ;
Name: 'DATEDIFF'
Description:
Syntax:
DATEDIFF(expr1,expr2)

DATEDIFF() returns expr1 ? expr2 expressed as a value in days from
one date to the other. expr1 and expr2 are date or date-and-time
expressions. Only the date parts of the values are used in the
calculation.

URL: https://dev.mysql.com/doc/refman/8.0/en/date-and-time-functions.html

Examples:
mysql> SELECT DATEDIFF('2007-12-31 23:59:59','2007-12-30');
        -> 1
mysql> SELECT DATEDIFF('2010-11-30 23:59:59','2010-12-31');
        -> -31
```
```SQL
-- difference between current date and date after 3 months
mysql> SELECT DATEDIFF(  DATE_ADD( now() , INTERVAL 3 month ) , now()  ) ;
+------------------------------------------------------------+
| DATEDIFF(  DATE_ADD( now() , INTERVAL 3 month ) , now()  ) |
+------------------------------------------------------------+
|                                                         92 |
+------------------------------------------------------------+
```
- first argument should be higher to get +ve output
```SQL

-- how days have past since my birth
mysql> SELECT DATEDIFF( now() , '1997-01-31' );
+----------------------------------+
| DATEDIFF( now() , '1997-01-31' ) |
+----------------------------------+
|                             9783 |
+----------------------------------+
```
- now I want 
```SQL
-- timestampdiff
Examples:
mysql> SELECT TIMESTAMPDIFF(MONTH,'2003-02-01','2003-05-01');
        -> 3
mysql> SELECT TIMESTAMPDIFF(YEAR,'2002-05-01','2001-01-01');
        -> -1
mysql> SELECT TIMESTAMPDIFF(MINUTE,'2003-02-01','2003-05-01 12:05:55');
        -> 128885

```
-  

```SQl
-- my current age
-- timestampdiff

-- diff in year between now and birthdate
mysql> SELECT TIMESTAMPDIFF( YEAR , '1997-01-31' , NOW() );
+----------------------------------------------+
| TIMESTAMPDIFF( YEAR , '1997-01-31' , NOW() ) |
+----------------------------------------------+
|                                           26 |
+----------------------------------------------+
```
- in timestampdiff -> first arg --> unit ,
                      sec arg --> lower date
                      third arg --> higher date

```SQL
-- Find employee with hire date and experieance in months
mysql> SELECT ename , hire , TimeStampDiff( MONTH , hire , NOW() ) from emp ;
+--------+------------+---------------------------------------+
| ename  | hire       | TimeStampDiff( MONTH , hire , NOW() ) |
+--------+------------+---------------------------------------+
| Smith  | 1980-12-17 |                                   514 |
| Allen  | 1981-02-20 |                                   512 |
| Ward   | 1981-02-22 |                                   512 |
| Jones  | 1981-04-02 |                                   511 |
| Martin | 1981-09-28 |                                   505 |
| Blake  | 1981-05-01 |                                   510 |
| Clark  | 1981-06-09 |                                   509 |
| Scott  | 1982-12-09 |                                   491 |
| King   | 1981-11-17 |                                   503 |
| Ford   | 1981-12-03 |                                   503 |
+--------+------------+---------------------------------------+
```

### DATA TYPES
#### DATE & TIME
* DATE - 3 bytes --> stores only date range from : 01-01-1000 to 31-12-9999
    * joining date
* TIME - 3 bytes --> stores only time duration: -837 hrs to +838 hrs
* DATETIME - 5 bytes --> date & time of day : '1000-01-01
00:00:00.000000' to '9999-12-31 23:59:59.499999'
    * finiatial transactions, logs
* TIMESTAMP - 4 bytes 
    * similar to DATETIME 
    * current time/moment : internally stored as number of seconds 
    * range : '1970-01-01 00:00:01.000000' UTC to '2038-01-19 03:14:07.499999' UTC.
    * so max will be 2038-01-19 , so take it into consideration
    * TIMESTAMP values are stored as the number of seconds since the epoch time ('1970-01-01 00:00:00' UTC)
    * A TIMESTAMP cannot represent the value '1970-01-01 00:00:00' because that is equivalent to 0 seconds from the epoch
    * the value 0 is reserved for representing '0000-00-00 00:00:00', the "zero" TIMESTAMP value.
    * stores as Integer hences as 4 bytes
    
* year - 1 byte unsigned int 255
    * year from 1900 to 215
    


# SQL functions
### DATE() Functions
    * if we have datetime or timestamp and pass it to date() it will return only date which is date type.

