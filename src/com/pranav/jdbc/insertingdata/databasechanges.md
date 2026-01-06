mysql> use mydatabase;
Database changed

mysql> select * from employees;
+----+--------+--------------------+--------+
| id | name   | job_title          | salary |
+----+--------+--------------------+--------+
|  1 | kunal  | Software Developer |  75000 |
|  2 | Hemant | Devops Engineer    |  65000 |
+----+--------+--------------------+--------+
2 rows in set (0.00 sec)

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

mysql> select * from employees;
+----+---------+----------------------+--------+
| id | name    | job_title            | salary |
+----+---------+----------------------+--------+
|  1 | kunal   | Software Developer   |  75000 |
|  2 | Hemant  | Devops Engineer      |  65000 |
|  3 | Harshit | Full Stack Developer |  87000 |
+----+---------+----------------------+--------+
3 rows in set (0.00 sec)
