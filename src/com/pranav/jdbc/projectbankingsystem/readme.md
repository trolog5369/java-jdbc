# 🏦 Banking System (JDBC – Console Based)

A **terminal-based banking application** built using **Core Java + JDBC + MySQL**, focused on understanding **real backend workflows**, not UI distractions.

This project simulates core banking operations such as **user registration, login, account creation, balance management, and secure transactions**, all handled at the database level.

---

## 🎯 Purpose of This Project

This project was built to:
- Apply **Core Java + Collections + JDBC** in a realistic scenario
- Understand **database-driven backend design**
- Practice **transaction handling, validation, and state management**
- Build confidence working directly with **SQL + Java integration**

No frameworks.  
No shortcuts.  
Pure backend fundamentals.

---

## 🧠 Key Features

### 👤 User Management
- User registration with email uniqueness validation
- Secure login using email & password
- User existence check before account creation

### 🏦 Account Management
- Open bank account after login
- Auto-generated unique account numbers
- Secure PIN-based access
- Retrieve account number using email

### 💰 Banking Operations
- **Debit money** (with balance check)
- **Credit money**
- **Transfer money** between accounts
- **Check account balance**

### 🔒 Data Safety
- Uses **PreparedStatement** to prevent SQL injection
- PIN validation before sensitive operations
- Database-level validations
- Transaction handling using `commit()` and `rollback()`

---

## 🧱 Project Structure
```text
com.pranav.jdbc.projectbankingsystem
│
├── BankingSystem.java // Main driver class
├── User.java // User registration & login
├── Accounts.java // Account creation & retrieval
└── AccountManager.java // Debit, credit, transfer, balance
```


---

## ⚙️ Technologies Used

- **Language:** Java
- **Database:** MySQL
- **API:** JDBC
- **Tools:** IntelliJ IDEA, MySQL Workbench
- **Architecture:** Console-based, layered class design

---

## 🗃️ Database Schema

### Database Name
banking_system


### Tables

#### 1️⃣ user
| Column      | Type        | Description              |
|------------|------------|--------------------------|
| full_name  | VARCHAR    | User full name           |
| email      | VARCHAR    | Unique user email        |
| password   | VARCHAR    | User password            |

#### 2️⃣ accounts
| Column        | Type        | Description                    |
|--------------|------------|--------------------------------|
| account_number | BIGINT    | Primary Key                    |
| full_name     | VARCHAR    | Account holder name            |
| email         | VARCHAR    | Linked user email (unique)     |
| balance       | DOUBLE     | Account balance                |
| security_pin  | VARCHAR    | PIN for secure transactions    |

---

## 🧪 Supported Operations

- Insert user and account data from console input
- Retrieve and validate account information
- Debit, credit, and transfer funds safely
- Rollback transactions on failure
- Maintain data consistency using JDBC transactions

---

## ⚠️ Known Limitations (Intentional)

- Console-based UI only
- Plain text password & PIN (no hashing yet)
- No check-in/check-out or account history
- No logging framework
- Single database connection

These are **conscious design choices** to keep focus on **JDBC fundamentals**.

---

## 🚀 Future Enhancements

- Password & PIN hashing
- Transaction history table
- Better exception handling & logging
- Connection pooling
- Migration to Spring Boot
- REST API version

---

## 🎓 Learning Outcome

Through this project, I strengthened my understanding of:
- JDBC workflow and lifecycle
- SQL + Java integration
- Transaction management
- Backend validation logic
- Clean class responsibility separation

This project represents a **solid backend foundation**, not a finished product.

---

## 👨‍💻 Author

**Pranav Gaikwad**  
Undergraduate IT Student  
Java Backend & Full Stack Developer (in progress)

> “Strong systems are built on strong fundamentals.”

