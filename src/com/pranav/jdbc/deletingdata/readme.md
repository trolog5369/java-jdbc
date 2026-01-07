# JDBC – Delete Data from MySQL

## Overview
This module demonstrates how to **delete a record from a MySQL database using JDBC**.
The deletion is performed using a SQL `DELETE` query and verified through affected row count
and manual database inspection.

---

## What This Code Does

- Loads the MySQL JDBC driver
- Establishes a connection to the MySQL database
- Executes a `DELETE` SQL query using `Statement`
- Confirms deletion using the number of affected rows
- Closes all JDBC resources properly

---

## JDBC Flow Followed

1. Load JDBC Driver
2. Establish Database Connection
3. Create SQL Statement
4. Execute DELETE Query using `executeUpdate()`
5. Verify affected rows
6. Close resources (Connection, Statement)

---

## Key Concepts Used

- `Class.forName()` to load the JDBC driver
- `DriverManager.getConnection()` for database connectivity
- `Statement.executeUpdate()` for DELETE operations
- Use of **primary key (`id`)** to uniquely identify the record
- Row count validation to ensure successful deletion

---

## Database Details

- Database: `mydatabase`
- Table: `employees`

### Primary Key Usage
The deletion is performed using the `id` field, which is a **primary key**.
Using a primary key ensures:
- Only one specific record is deleted
- No accidental deletion of multiple rows
- Safer operations in large databases

---

## Result

- Before deletion: 3 records present in `employees`
- After deletion: Record with `id = 3` successfully removed
- Remaining records verified using `SELECT * FROM employees`

---

## Status

✅ JDBC DELETE operation completed successfully  
⏭️ Next: PreparedStatements for safe DELETE / UPDATE operations
