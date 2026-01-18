_Hotel Reservation System:
## Main Menu inside Main()
1. New Reservation
2. View Reservations
3. Check Room Number
4. Update Reservation   ← includes checkout date change
5. Delete Reservation
6. Exit


while(true){
Main Menu
}Quit->return

### Database schemas:
reservations
reservation_id INT AUTO_INCREMENT PRIMARY KEY
guest_name VARCHAR(100) NOT NULL
room_number INT NOT NULL
contact_number VARCHAR(15) NOT NULL
check_in_date DATE NOT NULL
check_out_date DATE NOT NULL
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP


Database changes

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

mysql> use hotel_lol;
Database changed
mysql> show tables;
+---------------------+
| Tables_in_hotel_lol |
+---------------------+
| accounts            |
| employees           |
| image_table         |
| reservations        |
+---------------------+
4 rows in set (0.01 sec)

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
5 rows in set (0.00 sec)

mysql> select * from reservations;
Empty set (0.00 sec)

mysql> select * from reservations;
Empty set (0.00 sec)

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
5 rows in set (0.00 sec)

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

mysql> CREATE NEW DATABASE hotel_enhanced;
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'NEW DATABASE hotel_enhanced' at line 1
mysql> CREATE DATABASE hotel_enhanced;
Query OK, 1 row affected (0.01 sec)

mysql> show datbases;
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'datbases' at line 1
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
9 rows in set (0.00 sec)

mysql> use hotel_enhanced;
Database changed
mysql> create table reservations(
-> reservation_id INT AUTO_INCREMENT PRIMARY KEY,
-> guest_name VARCHAR(255) NOT NULL,
-> room_number INT NOT NULL,
-> contact_number VARCHAR(10) NOT NULL,
-> reservation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
-> );
Query OK, 0 rows affected (0.02 sec)

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
5 rows in set (0.00 sec)

mysql> ALTER TABLE reservations DROP COLUMN reservation_date;
Query OK, 0 rows affected (0.04 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> describe reservations;
+----------------+--------------+------+-----+---------+----------------+
| Field          | Type         | Null | Key | Default | Extra          |
+----------------+--------------+------+-----+---------+----------------+
| reservation_id | int          | NO   | PRI | NULL    | auto_increment |
| guest_name     | varchar(255) | NO   |     | NULL    |                |
| room_number    | int          | NO   |     | NULL    |                |
| contact_number | varchar(10)  | NO   |     | NULL    |                |
+----------------+--------------+------+-----+---------+----------------+
4 rows in set (0.00 sec)

mysql> ALTER TABLE reservations
-> ADD check_in_date TIMESTAMP NOT NULL,
-> ADD check_out_date TIMESTAMP NOT NULL,
-> ADD created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP;
Query OK, 0 rows affected (0.02 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> describe reservations;
+----------------+--------------+------+-----+-------------------+-------------------+
| Field          | Type         | Null | Key | Default           | Extra             |
+----------------+--------------+------+-----+-------------------+-------------------+
| reservation_id | int          | NO   | PRI | NULL              | auto_increment    |
| guest_name     | varchar(255) | NO   |     | NULL              |                   |
| room_number    | int          | NO   |     | NULL              |                   |
| contact_number | varchar(10)  | NO   |     | NULL              |                   |
| check_in_date  | timestamp    | NO   |     | NULL              |                   |
| check_out_date | timestamp    | NO   |     | NULL              |                   |
| created_at     | timestamp    | YES  |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
+----------------+--------------+------+-----+-------------------+-------------------+
7 rows in set (0.00 sec)

mysql> ALTER TABLE reservations
-> ALTER COLUMN check_in_date DATE NOT NULL,
-> ALTER COLUMN check_out_date DATE NOT NULL;
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'DATE NOT NULL,
ALTER COLUMN check_out_date DATE NOT NULL' at line 2
mysql> ALTER TABLE reservations
-> ALTER COLUMN check_in_date DATE NOT NULL,
-> ALTER COLUMN check_out_date DATE NOT NULL;
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'DATE NOT NULL,
ALTER COLUMN check_out_date DATE NOT NULL' at line 2
mysql> ALTER TABLE reservations
-> ALTER COLUMN check_in_date DATE NOT NULL,
-> ALTER COLUMN check_out_date DATE NOT NULL
-> );
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'DATE NOT NULL,
ALTER COLUMN check_out_date DATE NOT NULL
)' at line 2
mysql> ALTER TABLE reservations
-> ALTER COLUMN check_in_date DATE NOT NULL;
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'DATE NOT NULL' at line 2
mysql> ALTER TABLE reservations
-> ALTER COLUMN check_out_date DATE NOT NULL;
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'DATE NOT NULL' at line 2
mysql> ALTER TABLE reservations
-> MODIFY COLUMN check_in_date DATE NOT NULL,
-> MODIFY COLUMN check_out_date DATE NOT NULL,
-> ;
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near '' at line 3
mysql> ALTER TABLE reservations
-> MODIFY COLUMN check_in_date DATE NOT NULL,
-> MODIFY COLUMN check_out_date DATE NOT NULL;
Query OK, 0 rows affected (0.04 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> describe reservations;
+----------------+--------------+------+-----+-------------------+-------------------+
| Field          | Type         | Null | Key | Default           | Extra             |
+----------------+--------------+------+-----+-------------------+-------------------+
| reservation_id | int          | NO   | PRI | NULL              | auto_increment    |
| guest_name     | varchar(255) | NO   |     | NULL              |                   |
| room_number    | int          | NO   |     | NULL              |                   |
| contact_number | varchar(10)  | NO   |     | NULL              |                   |
| check_in_date  | date         | NO   |     | NULL              |                   |
| check_out_date | date         | NO   |     | NULL              |                   |
| created_at     | timestamp    | YES  |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
+----------------+--------------+------+-----+-------------------+-------------------+
7 rows in set (0.00 sec)

mysql> select * from reservations;
+----------------+------------+-------------+----------------+---------------+----------------+---------------------+
| reservation_id | guest_name | room_number | contact_number | check_in_date | check_out_date | created_at          |
+----------------+------------+-------------+----------------+---------------+----------------+---------------------+
|              1 |            |         777 | 9615222249     | 2026-01-17    | 2026-01-18     | 2026-01-17 20:55:22 |
+----------------+------------+-------------+----------------+---------------+----------------+---------------------+
1 row in set (0.00 sec)

mysql> select * from reservations;
+----------------+------------+-------------+----------------+---------------+----------------+---------------------+
| reservation_id | guest_name | room_number | contact_number | check_in_date | check_out_date | created_at          |
+----------------+------------+-------------+----------------+---------------+----------------+---------------------+
|              1 |            |         777 | 9615222249     | 2026-01-17    | 2026-01-18     | 2026-01-17 20:55:22 |
|              2 | Pranav     |         888 | 9657902071     | 2026-01-17    | 2026-01-18     | 2026-01-17 20:56:57 |
+----------------+------------+-------------+----------------+---------------+----------------+---------------------+
2 rows in set (0.00 sec)

mysql> select * from reservations;
+----------------+-----------------+-------------+----------------+---------------+----------------+---------------------+
| reservation_id | guest_name      | room_number | contact_number | check_in_date | check_out_date | created_at          |
+----------------+-----------------+-------------+----------------+---------------+----------------+---------------------+
|              1 |                 |         777 | 9615222249     | 2026-01-17    | 2026-01-18     | 2026-01-17 20:55:22 |
|              2 | Pranav          |         888 | 9657902071     | 2026-01-17    | 2026-01-18     | 2026-01-17 20:56:57 |
|              3 | Pranav Gaikwad  |        9999 | 9922222249     | 2026-01-17    | 2026-01-18     | 2026-01-17 21:04:33 |
+----------------+-----------------+-------------+----------------+---------------+----------------+---------------------+
3 rows in set (0.00 sec)_
