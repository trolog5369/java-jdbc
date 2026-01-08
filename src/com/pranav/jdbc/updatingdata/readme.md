
# JDBC – Updating Data in MySQL

## Overview
This module demonstrates how to **update existing records in a MySQL database using JDBC**.
The update operation is performed using an SQL `UPDATE` query executed through the
`Statement` interface.

The program updates **multiple fields of a single record** by identifying it using the
**primary key**.

---

## Objective
To update an employee’s `job_title` and `salary` in the `employees` table using Java JDBC.

---

## JDBC Flow Used

1. Load JDBC Driver  
2. Establish Database Connection  
3. Create SQL Statement  
4. Execute UPDATE Query  
5. Verify affected rows  
6. Close JDBC resources  

---

## SQL Update Syntax

### Generic Format
```sql
UPDATE table_name
SET column1 = new_value1, column2 = new_value2
WHERE condition;
````

### Query Used in This Program

```sql
UPDATE employees
SET job_title = 'Full Stack Developer', salary = 70000.0
WHERE id = 2;
```

---

## Why Primary Key Is Used

* Names and job titles are **not guaranteed to be unique**
* Updating based on non-unique fields can affect multiple records
* The primary key (`id`) uniquely identifies a row

Using `id` ensures:

* Only the intended record is updated
* No accidental data corruption occurs

---

## Database Details

* Database: `mydatabase`
* Table: `employees`
* Primary Key: `id`

---

## Before Update

| id | name   | job_title          | salary |
| -- | ------ | ------------------ | ------ |
| 1  | kunal  | Software Developer | 75000  |
| 2  | Hemant | Devops Engineer    | 65000  |

---

## After Update

| id | name   | job_title            | salary |
| -- | ------ |----------------------|--------|
| 1  | kunal  | Software Developer   | 75000  |
| 2  | Hemant | Full Stack Developer | 70000  |

---

## Key Takeaways

* `executeUpdate()` is used for UPDATE operations
* The returned integer confirms how many rows were affected
* Always use a `WHERE` clause in UPDATE queries
* Primary keys are critical for safe database updates

---

## Status

✅ Employee record updated successfully using JDBC
⏭️ Next step: Use `PreparedStatement` for safer and cleaner updates







