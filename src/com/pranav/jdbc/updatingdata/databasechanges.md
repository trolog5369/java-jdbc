Updating Query in mysql:

******************************************
UPDATE your_table_name
SET column1=new_value1, column2=new_value2
WHERE some_column= some_value;
******************************************

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
+----+--------+--------------------+--------+
| id | name   | job_title          | salary |
+----+--------+--------------------+--------+
|  1 | kunal  | Software Developer |  75000 |
|  2 | Hemant | Devops Engineer    |  65000 |
+----+--------+--------------------+--------+
2 rows in set (0.00 sec)


To update an entry we have to specify field which we want to update the particular record
In this case it can be salary,job_title but in larger co-op databases there can be multiple entries with the same
field and values,
Hence we should choose a field which is unique in this case Primary key is id
Primary key is unique it is not repeated!

Lets us suppose we have to change Hemant's info ie from Devops Engineer,65000 to Full Stack Developer,70000
To make this change we have 2 fields job_title and salary to change we can change those but there can be multiple Hemant's
Hence we used Primary key id

The query for this will be:

UPDATE employees
SET job_title='Full Stack Developer', salary=70000.0
WHERE id = 2 ;


mysql> select * from employees;
+----+--------+----------------------+--------+
| id | name   | job_title            | salary |
+----+--------+----------------------+--------+
|  1 | kunal  | Software Developer   |  75000 |
|  2 | Hemant | Full Stack Developer |  70000 |
+----+--------+----------------------+--------+
2 rows in set (0.00 sec)

Hemant's fields are been updated successfully!