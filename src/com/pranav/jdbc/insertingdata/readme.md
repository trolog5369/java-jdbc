# JDBC – Insert Data into MySQL

## Overview
This module demonstrates how to **insert data into a MySQL database using JDBC** in Java.
The program follows the standard JDBC workflow and verifies insertion by checking affected rows.

---

## What This Code Does

- Loads the MySQL JDBC driver
- Establishes a connection to a MySQL database
- Executes an `INSERT` SQL query using `Statement`
- Confirms insertion using the number of affected rows
- Closes all JDBC resources properly

---

## JDBC Flow Followed

1. Load JDBC Driver
2. Establish Database Connection
3. Create SQL Statement
4. Execute Insert Query using `executeUpdate()`
5. Verify affected rows
6. Close resources (Connection, Statement)

---

## Key Concepts Used

- `Class.forName()` for loading JDBC driver
- `DriverManager.getConnection()` for database connection
- `Statement.executeUpdate()` for INSERT operations
- Row count validation to confirm successful insertion
- Proper resource cleanup to avoid memory leaks

---

## Database Used

- Database name: `mydatabase`
- Table name: `employees`

### Table Structure
- `id` (INT, PRIMARY KEY)
- `name` (VARCHAR)
- `job_title` (VARCHAR)
- `salary` (DOUBLE)

---

## Result

After execution, a new employee record is successfully inserted into the `employees` table and verified using a `SELECT` query in MySQL.

---

## Status

✅ JDBC INSERT operation completed successfully  
⏭️ Next: PreparedStatements & Update/Delete operations
