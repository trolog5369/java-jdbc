# JDBC Batch Processing

This module demonstrates **batch processing in JDBC**, where multiple SQL statements
are grouped together and executed as a single batch instead of being executed individually.

Batch processing improves performance, reduces database round-trips,
and is commonly used in real-world systems for bulk operations.

---

## 📌 What Is Batch Processing?

Batch processing means:
- Collecting multiple SQL operations
- Executing them together in one go
- Committing the entire batch at once

This approach is **faster**, **resource-efficient**, and **scalable** compared to executing
each query separately.

### Real-World Use Cases
- Salary disbursement for employees
- Sending bulk emails or notifications
- Inserting large datasets
- Bulk updates or migrations

---

## 🛠 Database Used

**Database:** `mydatabase`  
**Table:** `employees`

### Table Structure
```sql
CREATE TABLE employees (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    job_title VARCHAR(255),
    salary DOUBLE
);
```
## 🔁 Batch Processing Using Simple Statement
Key Steps

- Disable auto-commit

- Add multiple SQL queries using addBatch()

- Execute batch using executeBatch()

- Commit changes manually

### Example Operations

```sql
INSERT INTO employees(name, job_title, salary)
VALUES ('Vashu', 'HR Manager', 65000);

INSERT INTO employees(name, job_title, salary)
VALUES ('Karan', 'Cyber Security Analyst', 62000);

INSERT INTO employees(name, job_title, salary)
VALUES ('Vipul', 'Devops Engineer', 67000);
```
## Characteristics

- Uses plain SQL strings

- Faster than individual execution

- No SQL injection protection

- Less flexible for dynamic input

## 🔁 Batch Processing Using PreparedStatement
Key Steps

- Disable auto-commit

- Use placeholders (?) in SQL

- Set values dynamically

- Add each execution to batch

- Execute batch and commit

Example Query
```sql
INSERT INTO employees(name, job_title, salary)
VALUES (?, ?, ?);
```
## Characteristics

- Secure (prevents SQL injection)
- Cleaner and reusable
- Best practice for dynamic data
- More maintainable than plain statements

---

## 📂 Key JDBC Concepts Used

- `setAutoCommit(false)`
- `addBatch()`
- `executeBatch()`
- `commit()`
- `rollback()`
- `Statement`
- `PreparedStatement`

---

## ⚙️ Transaction Control in Batch Processing

- Auto-commit is disabled to ensure atomic execution
- If batch execution succeeds → `commit`
- If any error occurs → batch should be rolled back
- Prevents partial or inconsistent data states

---

## 🎯 Outcome

- Efficient execution of bulk database operations
- Reduced database overhead
- Improved performance
- Demonstrates real-world JDBC batch processing patterns




