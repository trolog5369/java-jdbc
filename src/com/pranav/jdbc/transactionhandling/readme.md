# JDBC Transaction Handling (Commit & Rollback)

This project demonstrates **transaction handling in Java using JDBC** to maintain **data consistency** during database operations such as fund transfers between accounts.

---

## 📌 Problem Statement

When performing multiple dependent database operations (like debiting one account and crediting another), **all operations must succeed together**.  
If any step fails, the database should return to its original state.

This project shows how to achieve this using **JDBC transactions**.

---

## 🧠 Data Consistency Explained

Assume the following database state:

- `account123` → 1000 Rs
- `account456` → 2000 Rs

**Total balance:** `3000 Rs`

### Transaction: Transfer 500 Rs from `account123` to `account456`

Expected result:

- `account123` → 500 Rs
- `account456` → 2500 Rs

**Total balance remains:** `3000 Rs`

This is **data consistency**.

---

## ❌ How Inconsistency Occurs

If:

1. `account123` is debited successfully
2. An error occurs before `account456` is credited

Result:

- `account123` → 500 Rs
- `account456` → 2000 Rs

**Total balance:** `2500 Rs`

This is **database inconsistency** and must be prevented.

---

## 🛡️ Solution: Transaction Handling in JDBC

JDBC provides transaction control using:

- `commit`
- `rollback`

By disabling auto-commit, we can manually control when changes are saved.

---

## 🔧 Technologies Used

- Java (JDBC)
- MySQL
- `PreparedStatement`
- MySQL Connector/J

---

## ⚙️ Database Schema

### Accounts Table

```sql
CREATE TABLE accounts (
    account_number VARCHAR(20) PRIMARY KEY,
    balance DECIMAL(10,2) NOT NULL
);
```
## Sample Data

```sql
INSERT INTO accounts(account_number, balance) VALUES
('account123', 1000.00),
('account456', 500.00),
('account789', 750.50);
```
## 🔄 Transaction Flow

- Disable auto-commit
- Debit amount from sender account
- Credit amount to receiver account
- If both operations succeed → **commit**
- If any operation fails → **rollback**

---

## ✅ Commit Scenario

- Both debit and credit succeed
- Changes are permanently saved
- Transaction completes successfully

---

## 🔁 Rollback Scenario

- Any operation fails
- Database state is restored
- No partial updates occur

---

## 📂 Key JDBC Concepts Used

- `setAutoCommit(false)`
- `commit()`
- `rollback()`
- `PreparedStatement`
- Atomic database operations

---

## 🎯 Outcome

- Prevents partial updates
- Maintains data consistency
- Ensures reliable database operations
- Demonstrates real-world JDBC transaction handling
