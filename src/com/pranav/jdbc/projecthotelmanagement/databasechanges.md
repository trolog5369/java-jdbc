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
6 rows in set (0.01 sec)

mysql> Create database hotel_db;
Query OK, 1 row affected (0.03 sec)

mysql> show databases;
+--------------------+
| Database           |
+--------------------+
| hotel_db           |
| information_schema |
| mydatabase         |
| mysql              |
| performance_schema |
| students           |
| sys                |
+--------------------+
7 rows in set (0.00 sec)

mysql> use hotel_db;
Database changed
mysql> CREATE TABLE reservations(
    -> resservation_id INT AUTO _INCREMENT PRIMARY KEY
    -> guest_name VARCHAR(255) NOT NULL,
    -> room_number INT NOT NULL,
    -> contact_number VARCHAR(10) NOT NULL,
    -> reservation_date TIMESTAMP DEFAULT CURRENT TIMESTAMP
    -> );
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'AUTO _INCREMENT PRIMARY KEY
guest_name VARCHAR(255) NOT NULL,
room_number INT NO' at line 2
mysql> use hotel_db;
Database changed
mysql> CREATE TABLE reservations(
    -> reservation_id INT AUTO_INCREMENT PRIMARY KEY,
    -> guest_name VARCHAR(255) NOT NULL,
    -> room_number INT NOT NULL,
    -> contact_number VARCHAR(10) NOT NULL,
    -> reservation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    -> );
Query OK, 0 rows affected (0.05 sec)

mysql> describe reservations;
+------------------+--------------+------+-----+-------------------+-------------------+
| Field            | Type         | Null | Key | Default           | Extra             |
+------------------+--------------+------+-----+-------------------+-------------------+
| reservation_id   | int          | NO   | PRI | NULL              | auto_increment    |
| guest_name       | varchar(255) | NO   |     | NULL              |                   |
| room_number      | int          | NO   |     | NULL              |                   |
| contact_number   | varchar(10)  | NO   |     | NULL              |                   |
| reservation_date | timestamp    | YES  |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
+------------------+--------------+------+-----+-------------------+-------------------+
5 rows in set (0.02 sec)

mysql>
