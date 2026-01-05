# JDBC → Java to MySQL Integration

## Overview

Today’s work focuses on **connecting Java applications to a MySQL database using JDBC**  
and executing real SQL queries from Java code.

This marks the transition from **theory → actual database interaction**.

---

## What Was Implemented Today

- Loaded MySQL JDBC Driver
- Established connection between Java and MySQL
- Executed SQL queries using `Statement`
- Retrieved and processed data using `ResultSet`
- Closed JDBC resources properly
- Practiced full JDBC execution flow end-to-end

---

## JDBC Flow (Core Concept)
1. Load Driver

2. Create Connection

3. Create Statement / PreparedStatement

4. Execute Query

5. Process ResultSet

6. Close Resources

This flow is followed in all programs written today.

---

## Packages Covered

### `com.pranav.jdbc.javatomysql`

This package contains programs that demonstrate **Java → MySQL connectivity**.

---

## Program 1: ConnectingMySQL

### Purpose
- Demonstrates **complete JDBC workflow**
- Connects to MySQL
- Executes a `SELECT` query
- Reads and prints table data
- Closes all resources manually

### Key Concepts Used
- `Class.forName()` to load driver
- `DriverManager.getConnection()`
- `Statement`
- `ResultSet`
- Exception handling with `try-catch`

---

## Program 2: JavaToMysql

### Purpose
- Cleaner, step-by-step implementation of JDBC flow
- Focuses on clarity and separation of steps
- Reinforces best practices

### Steps Followed
1. Load Driver
2. Create Connection
3. Create Statement
4. Execute Query
5. Process ResultSet
6. Close Resources

---

## Database Setup (MySQL)

### Databases Present
```sql
show databases;

Create Database
create database mydatabase;

Use Database
use mydatabase;

Create Database
create database mydatabase;

Use Database
use mydatabase;

Table Creation
create table employees(
id INT PRIMARY KEY,
name VARCHAR(255),
job_title VARCHAR(255),
salary DOUBLE
);

Insert Data
insert into employees(id, name, job_title, salary)
values (1, 'kunal', 'Software Developer', 75000.0);

insert into employees(id, name, job_title, salary)
values (2, 'Hemant', 'Devops Engineer', 65000.0);

Fetch Data
select * from employees;

Output

ID: 1
Name: kunal
Job Title: Software Developer
Salary: 75000

ID: 2
Name: Hemant
Job Title: Devops Engineer
Salary: 65000

```
### Commands Recap (MySQL CLI)

1. Show databases
show databases;

2. Create database
create database <database_name>;

3. Use database
use <database_name>;

4. Create table
create table <table_name>(columns);

5. Insert records
insert into <table_name> values(...);

6. Read data
select * from <table_name>;

## Key Takeaways

- **JDBC is not magic** — it follows a strict, predictable flow
- **Every JDBC object depends on the previous one** (Driver → Connection → Statement → ResultSet)
- **Connections and resources must always be closed** to avoid memory leaks
- **SQL knowledge is mandatory** for backend Java development

---

## This Is the Foundation For

- JDBC **CRUD operations**
- **PreparedStatements**
- **Spring Boot + JPA** (later)

---

## Status

✅ **Java → MySQL connectivity completed**

---

## Next Steps

- PreparedStatements
- Insert / Update / Delete from Java
- Exception-safe JDBC code  
