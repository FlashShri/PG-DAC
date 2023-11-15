# Control Flow Funtion

* CASE OPERATION
* IF FUNCTION
* IFNULL
* NULLIF

## IF Function
- same as ternary operator
```SQL
/*
mysql> HELP IF function
Name: 'IF FUNCTION'
Description:
Syntax:
IF(expr1,expr2,expr3)

If expr1 is TRUE (expr1 <> 0 and expr1 IS NOT NULL), IF() returns
expr2. Otherwise, it returns expr3.

*Note*:

There is also an IF statement, which differs from the IF() function
described here. See [HELP IF statement].

If only one of expr2 or expr3 is explicitly NULL, the result type of
the IF() function is the type of the non-NULL expression.

The default return type of IF() (which may matter when it is stored
into a temporary table) is calculated as follows:

o If expr2 or expr3 produce a string, the result is a string.

  If expr2 and expr3 are both strings, the result is case-sensitive if
  either string is case-sensitive.

o If expr2 or expr3 produce a floating-point value, the result is a
  floating-point value.

o If expr2 or expr3 produce an integer, the result is an integer.

URL: https://dev.mysql.com/doc/refman/8.0/en/flow-control-functions.html

Examples:
mysql> SELECT IF(1>2,2,3);
        -> 3
mysql> SELECT IF(1<2,'yes','no');
        -> 'yes'
mysql> SELECT IF(STRCMP('test','test1'),'no','yes');
        -> 'no'

```

```SQL
-- if books with price less than 35 or equal then not expensive else expensive
mysql> SELECT name ,price ,   IF( price <= 35 , 'not expensive' , 'expensive' ) AS category from book ;
+---------------------------------+-------+---------------+
| name                            | price | category      |
+---------------------------------+-------+---------------+
| Introduction to Programming     | 39.99 | expensive     |
| Advanced Programming Concepts   | 49.99 | expensive     |
| Web Development Basics          | 34.99 | not expensive |
| Database Design and SQL         | 44.99 | expensive     |
| Python Programming Mastery      | 54.99 | expensive     |
| Java for Beginners              | 29.99 | not expensive |
| C++ Fundamentals                | 39.99 | expensive     |
| JavaScript Essentials           | 34.99 | not expensive |
| Algorithms and Data Structures  | 49.99 | expensive     |
| Software Engineering Principles | 59.99 | expensive     |
+---------------------------------+-------+---------------+
```
```SQL
-- 0 to 35   --> not expensive
-- 35 to 40  --> moderate
-- 40 above --> very expensive

SELECT name , price , if( price > 40 , 'very expensive' , IF( price <=40 AND price > 35 , 'Moderate' , 'not expensive' )  ) from book ;


mysql> SELECT name , price , if( price > 40 , 'very expensive' , IF( price <=40 AND price > 35 , 'Moderate' , 'not expensive' )  ) AS category from book ;
+---------------------------------+-------+----------------+
| name                            | price | category       |
+---------------------------------+-------+----------------+
| Introduction to Programming     | 39.99 | Moderate       |
| Advanced Programming Concepts   | 49.99 | very expensive |
| Web Development Basics          | 34.99 | not expensive  |
| Database Design and SQL         | 44.99 | very expensive |
| Python Programming Mastery      | 54.99 | very expensive |
| Java for Beginners              | 29.99 | not expensive  |
| C++ Fundamentals                | 39.99 | Moderate       |
| JavaScript Essentials           | 34.99 | not expensive  |
| Algorithms and Data Structures  | 49.99 | very expensive |
| Software Engineering Principles | 59.99 | very expensive |
+---------------------------------+-------+----------------+
```

```SQL
-- print all subject name before space , first word of subject
mysql> SELECT subject , LEFT( subject, INSTR(subject , ' ')) from book ;
+----------------------+--------------------------------------+
| subject              | LEFT( subject, INSTR(subject , ' ')) |
+----------------------+--------------------------------------+
| Programming          |                                      |
| Programming          |                                      |
| Web Development      | Web                                  |
| Database Management  | Database                             |
| Programming          |                                      |
| Programming          |                                      |
| Programming          |                                      |
| Web Development      | Web                                  |
| Programming          |                                      |
| Software Engineering | Software                             |
+----------------------+--------------------------------------+

-- here the problem is it is not taking thoes book which are not having swpace init

-- we just have to handle that condition where subject is not having space in it.
SELECT subject , IF( INSTR(subject , ' ') = 0 , subject , LEFT(subject , INSTR(subject , ' '))) AS first_word from book;

mysql> SELECT subject , IF( INSTR(subject , ' ') = 0 , subject , LEFT(subject , INSTR(subject , ' '))) AS first_word from book;
/* output 
+----------------------+-------------+
| subject              | first_word  |
+----------------------+-------------+
| Programming          | Programming |
| Programming          | Programming |
| Web Development      | Web         |
| Database Management  | Database    | 
| Programming          | Programming |
| Programming          | Programming |
| Programming          | Programming |
| Web Development      | Web         |
| Programming          | Programming |
| Software Engineering | Software    |
+----------------------+-------------+
```