mysql> my databases;
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'my databases' at line 1
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
mysql> select * from employees;
+----+---------+----------------------+--------+
| id | name    | job_title            | salary |
+----+---------+----------------------+--------+
|  1 | kunal   | Software Developer   |  75000 |
|  2 | Hemant  | Devops Engineer      |  65000 |
|  3 | Harshit | Full Stack Developer |  87000 |
+----+---------+----------------------+--------+
3 rows in set (0.00 sec)

mysql> DESCRIBE employees;
+-----------+--------------+------+-----+---------+-------+
| Field     | Type         | Null | Key | Default | Extra |
+-----------+--------------+------+-----+---------+-------+
| id        | int          | NO   | PRI | NULL    |       |
| name      | varchar(255) | YES  |     | NULL    |       |
| job_title | varchar(255) | YES  |     | NULL    |       |
| salary    | double       | YES  |     | NULL    |       |
+-----------+--------------+------+-----+---------+-------+
4 rows in set (0.01 sec)

mysql> select * from employees;
+----+--------+--------------------+--------+
| id | name   | job_title          | salary |
+----+--------+--------------------+--------+
|  1 | kunal  | Software Developer |  75000 |
|  2 | Hemant | Devops Engineer    |  65000 |
+----+--------+--------------------+--------+
2 rows in set (0.00 sec)

mysql>