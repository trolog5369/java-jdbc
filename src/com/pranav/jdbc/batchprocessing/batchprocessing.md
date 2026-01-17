Instead of executing multiple statement individually we will make a batch of the 
statements and execute them all at once ie execute the entire batch
it is very beneficial because it saves resources, is fast and is very efficient for particular process

eg:Any company if they want to send salaries of employees or mail to multiple employees
they execute the tasks in batch instead of individually executing this helps
in storing resources

Achieving batch processing through JDBC 


Database changes by simple statements:

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
mysql> show tables;
+----------------------+
| Tables_in_mydatabase |
+----------------------+
| accounts             |
| employees            |
| image_table          |
+----------------------+
3 rows in set (0.01 sec)

mysql> describes employees;
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'describes employees' at line 1
mysql> describe employees;
+-----------+--------------+------+-----+---------+-------+
| Field     | Type         | Null | Key | Default | Extra |
+-----------+--------------+------+-----+---------+-------+
| id        | int          | NO   | PRI | NULL    |       |
| name      | varchar(255) | YES  |     | NULL    |       |
| job_title | varchar(255) | YES  |     | NULL    |       |
| salary    | double       | YES  |     | NULL    |       |
+-----------+--------------+------+-----+---------+-------+
4 rows in set (0.00 sec)

mysql> select * from employees;
+----+--------+----------------------+--------+
| id | name   | job_title            | salary |
+----+--------+----------------------+--------+
|  1 | kunal  | Software Developer   |  75000 |
|  2 | Hemant | Full Stack Developer |  70000 |
|  3 | Pranav | Devops Engineer      |  80000 |
|  4 | Om     | Scrum                |  90000 |
+----+--------+----------------------+--------+
4 rows in set (0.00 sec)

mysql> ALTER TABLE employees MODIFY COLUMN id INT AUTO_INCREMENT;
Query OK, 4 rows affected (0.05 sec)
Records: 4  Duplicates: 0  Warnings: 0

mysql> select * from employees;
+----+--------+----------------------+--------+
| id | name   | job_title            | salary |
+----+--------+----------------------+--------+
|  1 | kunal  | Software Developer   |  75000 |
|  2 | Hemant | Full Stack Developer |  70000 |
|  3 | Pranav | Devops Engineer      |  80000 |
|  4 | Om     | Scrum                |  90000 |
+----+--------+----------------------+--------+
4 rows in set (0.00 sec)

mysql> describe employees;
+-----------+--------------+------+-----+---------+----------------+
| Field     | Type         | Null | Key | Default | Extra          |
+-----------+--------------+------+-----+---------+----------------+
| id        | int          | NO   | PRI | NULL    | auto_increment |
| name      | varchar(255) | YES  |     | NULL    |                |
| job_title | varchar(255) | YES  |     | NULL    |                |
| salary    | double       | YES  |     | NULL    |                |
+-----------+--------------+------+-----+---------+----------------+
4 rows in set (0.00 sec)

mysql> select * from employees;
+----+--------+------------------------+--------+
| id | name   | job_title              | salary |
+----+--------+------------------------+--------+
|  1 | kunal  | Software Developer     |  75000 |
|  2 | Hemant | Full Stack Developer   |  70000 |
|  3 | Pranav | Devops Engineer        |  80000 |
|  4 | Om     | Scrum                  |  90000 |
|  5 | Vashu  | HR Manager             |  65000 |
|  6 | Karan  | Cyber Security Analyst |  62000 |
|  7 | Vipul  | Devops Engineer        |  67000 |
+----+--------+------------------------+--------+
7 rows in set (0.00 sec)

Database changes using prepared statements:

mysql> select * from employees;
+----+---------+------------------------+--------+
| id | name    | job_title              | salary |
+----+---------+------------------------+--------+
|  1 | kunal   | Software Developer     |  75000 |
|  2 | Hemant  | Full Stack Developer   |  70000 |
|  3 | Pranav  | Devops Engineer        |  80000 |
|  4 | Om      | Scrum                  |  90000 |
|  5 | Vashu   | HR Manager             |  65000 |
|  6 | Karan   | Cyber Security Analyst |  62000 |
|  7 | Vipul   | Devops Engineer        |  67000 |
|  8 | Yuvraj  | Front End Developer    |  62000 |
|  9 | Ritesh  | Back End Developer     |  65000 |
+----+---------+------------------------+--------+
9 rows in set (0.00 sec)

mysql>