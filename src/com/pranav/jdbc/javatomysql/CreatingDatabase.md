mysql> show databases;
+--------------------+
| Database           |
+--------------------+
| information_schema |
| mysql              |
| performance_schema |
| students           |
| sys                |
+--------------------+
5 rows in set (0.00 sec)

mysql> create database mydatabase;
Query OK, 1 row affected (0.01 sec)

mysql> show databases;
+--------------------+
| Database           |
+--------------------+
| information_schema |
| mydatabase         |
| mysql              |
| performance_schema |
| students           |
| sys                |
+--------------------+
6 rows in set (0.00 sec)

mysql> use mydatabase;
Database changed
mysql> create table employees(
-> id INT PRIMARY KEY,
-> name VARCHAR(255),
-> job_title VARCHAR(255),
-> salary DOUBLE
-> );
Query OK, 0 rows affected (0.03 sec)

mysql> insert into employees(id, name, job_title, salary) values(
-> 1,'kunal','Software Developer',75000.0);
Query OK, 1 row affected (0.02 sec)

mysql> insert into employees(id, name, job_title, salary) values(
-> 2,'Hemant','Devops Engineer',65000.0);
Query OK, 1 row affected (0.01 sec)

mysql> select * from employees;
+----+--------+--------------------+--------+
| id | name   | job_title          | salary |
+----+--------+--------------------+--------+
|  1 | kunal  | Software Developer |  75000 |
|  2 | Hemant | Devops Engineer    |  65000 |
+----+--------+--------------------+--------+
2 rows in set (0.00 sec)

mysql>

We have created a databases using the following commands in MyDSQL command Line
To show pre-existing databases we use: show databases;
To create a database use: create database (database name);
To use that database/do operations on that use: use (database name);
To create a table in the database use : create table (table name)(attributes_name attribute_type);
To insert into the database use:insert into (database name)(attributes name) values(attributes values);
To print the database use: select * from (database name);