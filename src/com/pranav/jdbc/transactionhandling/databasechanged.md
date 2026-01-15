mysql> show databases;
+--------------------+
| Database           |
+--------------------+
| hotel_db           |
| hotel_lol          |
| information_schema |
| mydatabase         |
| mysql              |
| performance_schema |
| students           |
| sys                |
+--------------------+
8 rows in set (0.00 sec)

mysql> use mydatabase;
Database changed
mysql> CREATE TABLE accounts(
-> account_number VARCHAR(20) PRIMARY KEY,
-> balance DECIMAL(10,2) NOT NULL
-> );
Query OK, 0 rows affected (0.02 sec)

mysql> show tables;
+----------------------+
| Tables_in_mydatabase |
+----------------------+
| accounts             |
| employees            |
| image_table          |
+----------------------+
3 rows in set (0.00 sec)

mysql> describe accounts;
+----------------+---------------+------+-----+---------+-------+
| Field          | Type          | Null | Key | Default | Extra |
+----------------+---------------+------+-----+---------+-------+
| account_number | varchar(20)   | NO   | PRI | NULL    |       |
| balance        | decimal(10,2) | NO   |     | NULL    |       |
+----------------+---------------+------+-----+---------+-------+
2 rows in set (0.00 sec)

mysql> INSERT INTO accounts(account_number, balance) VALUES
-> ('account123', 1000.00),
-> ('account456', 500.00),
-> ('account789', 750.50);
Query OK, 3 rows affected (0.02 sec)
Records: 3  Duplicates: 0  Warnings: 0

mysql> select * from accounts;
+----------------+---------+
| account_number | balance |
+----------------+---------+
| account123     | 1000.00 |
| account456     |  500.00 |
| account789     |  750.50 |
+----------------+---------+
3 rows in set (0.00 sec)

mysql> select * from accounts;
+----------------+---------+
| account_number | balance |
+----------------+---------+
| account123     |  500.00 |
| account456     | 1000.00 |
| account789     |  750.50 |
+----------------+---------+
3 rows in set (0.00 sec)

mysql> select * from accounts;
+----------------+---------+
| account_number | balance |
+----------------+---------+
| account123     |    0.00 |
| account456     | 1500.00 |
| account789     |  750.50 |
+----------------+---------+
3 rows in set (0.00 sec)

mysql> select * from accounts;
+----------------+---------+
| account_number | balance |
+----------------+---------+
| account123     |    0.00 |
| account456     | 1500.00 |
| account789     |  750.50 |
+----------------+---------+
3 rows in set (0.00 sec)

mysql>