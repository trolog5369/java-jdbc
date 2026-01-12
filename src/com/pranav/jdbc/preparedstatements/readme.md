# JDBC Prepared Statements – Basics

This module demonstrates the usage of **PreparedStatement** in JDBC using MySQL.
It focuses on executing parameterized SQL queries safely and efficiently.

---

## 📌 What is a PreparedStatement?

A **PreparedStatement** is a JDBC interface used to execute SQL queries with
**placeholders (`?`)** instead of directly embedding values into the query.

The actual values are supplied later using setter methods like:
- `setString()`
- `setInt()`
- `setDouble()`

---

## 🧠 Why PreparedStatements?

PreparedStatements solve major problems associated with normal `Statement`:

### Advantages
1. **Protection against SQL Injection**
2. **Better Performance** (precompiled on DB server)
3. **Improved Readability & Maintainability**
4. **Automatic Data Type Handling**
5. **Vendor Neutral / Portable**

---

## 🧩 Examples Covered

### 1️⃣ Single Placeholder Query
Fetch employee details using a single condition:
```sql
SELECT * FROM employees WHERE name = ?
```
### Demonstrates:

1. Single placeholder usage
- setString(parameterIndex, value)
- Safe query execution

#### 2 Multiple Placeholder Query

Fetch employee details using multiple conditions:
```sql
SELECT * FROM employees WHERE name = ? AND job_title = ?
```
### Demonstrates:

- Multiple placeholders

- Correct parameter indexing (starts from 1)

- Cleaner alternative to string concatenation

### ⚠️ Why NOT use normal Statement with concatenation?

Using normal statements like:
```sql
SELECT * FROM employees WHERE name='Pranav' AND age=17;
```
When combined with user input:

```sql
"... WHERE name='" + userInput + "'"
```


- ❌ This approach is SQL Injection prone
- ❌ Unsafe for production systems
- ❌ Hard to maintain and debug

## PreparedStatements eliminate these risks.