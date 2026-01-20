
mysql> show databases;
+--------------------+
| Database           |
+--------------------+
| hotel_db           |
| hotel_enhanced     |
| hotel_lol          |
| information_schema |
| mydatabase         |
| mysql              |
| performance_schema |
| students           |
| sys                |
+--------------------+
9 rows in set (0.04 sec)

mysql> create database banking_system;
Query OK, 1 row affected (0.01 sec)

mysql> use banking_system;
Database changed
mysql> create table accounts;
ERROR 4028 (HY000): A table must have at least one visible column.
mysql> create table accounts(
-> account_number bigint NOT NULL PRIMARY KEY,
-> full_name VARCHAR(255) NOT NULL,
-> email VARCHAR(255) NOT NULL UNIQUE KEY,
-> balance DECIMAL(10,2) NOT NULL,
-> security_pin CHAR(4) NOT NULL
-> );
Query OK, 0 rows affected (0.03 sec)

mysql> describe accounts;
+----------------+---------------+------+-----+---------+-------+
| Field          | Type          | Null | Key | Default | Extra |
+----------------+---------------+------+-----+---------+-------+
| account_number | bigint        | NO   | PRI | NULL    |       |
| full_name      | varchar(255)  | NO   |     | NULL    |       |
| email          | varchar(255)  | NO   | UNI | NULL    |       |
| balance        | decimal(10,2) | NO   |     | NULL    |       |
| security_pin   | char(4)       | NO   |     | NULL    |       |
+----------------+---------------+------+-----+---------+-------+
5 rows in set (0.01 sec)

mysql> create table user(
-> full_name VARCHAR(255) NOT NULL,
-> email VARCHAR(255) NOT NULL PRIMARY KEY,
-> password VARCHAR(255) NOT NULL
-> );
Query OK, 0 rows affected (0.01 sec)

mysql> describe accounts;
+----------------+---------------+------+-----+---------+-------+
| Field          | Type          | Null | Key | Default | Extra |
+----------------+---------------+------+-----+---------+-------+
| account_number | bigint        | NO   | PRI | NULL    |       |
| full_name      | varchar(255)  | NO   |     | NULL    |       |
| email          | varchar(255)  | NO   | UNI | NULL    |       |
| balance        | decimal(10,2) | NO   |     | NULL    |       |
| security_pin   | char(4)       | NO   |     | NULL    |       |
+----------------+---------------+------+-----+---------+-------+
5 rows in set (0.00 sec)

mysql> describe user;
+-----------+--------------+------+-----+---------+-------+
| Field     | Type         | Null | Key | Default | Extra |
+-----------+--------------+------+-----+---------+-------+
| full_name | varchar(255) | NO   |     | NULL    |       |
| email     | varchar(255) | NO   | PRI | NULL    |       |
| password  | varchar(255) | NO   |     | NULL    |       |
+-----------+--------------+------+-----+---------+-------+
3 rows in set (0.00 sec)

mysql>