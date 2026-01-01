# JDBC Overview

JDBC is a Java-Based API for connecting to an interacting with  
relational databases. JDBC provides a Standard interface that enables Java  
applications to execute SQL queries and manage database connections.

---

## JDBC Components

1. Drivers
2. Driver Manager
3. Connection
4. Statement
5. ResultSet
6. SQL Exception

These components are interconnected.

---

## JDBC Drivers

### Type 1 — JDBC ODBC Bridge Driver
- Performance issues
- Uses ODBC driver to communicate with the database
- Not recommended for new applications

### Type 2 — Native API Driver
- Provides a JDBC interface to a specific database engine
- Translates JDBC calls into database engine native library calls
- This is a vendor specific driver hence the vendor provides the API then it is processed

### Type 3 — Network Protocol Driver
- Uses client/server architecture with middleware (application server)
- Middleware provides communication between JDBC client and database server

### Type 4 — Thin Driver
- Pure Java driver
- Translates JDBC calls into network protocol calls
- Communicates directly with the database server
- Provides best performance and scalability

---

## Driver Manager

**DRIVER MANAGER IS A CLASS, OTHER ALL ARE INTERFACES  
(Connections, Statements, ResultSet etc.)**

Driver Manager:
- This Driver Manager class manages a list of database drivers
- It establishes connections to the database using the appropriate driver and handles the  
  process of loading the driver class
- It provides a standardized method for handling multiple database  
  connections and selecting the appropriate driver
- Method that is provided = `Class.forName()`

---

## Connection Interface

**CONNECTION INTERFACE IS A PART OF DRIVER MANAGER CLASS**

Connection (Interface):
- Part of Driver Manager class
- Creation of Statements
- Transaction Management
- Retrieval of MetaData
- This interface helps in establishing the connection with the database
- This demands URL, Password, Username of the database which we want to connect

---

## Statement Interface

**STATEMENT INTERFACE IS A PART OF CONNECTION INTERFACE**

Statements (Interface):

There are 3 types of Statements:

1. **Statements**
    - The Statement interface is used for executing simple SQL queries without parameters

2. **PreparedStatements**
    - Used for executing pre-compiled SQL queries with parameters
    - More efficient and secure than Statement objects

3. **CallableStatements**
    - Used for executing database stored procedures
    - Provides a more efficient way to access them than with SQL statements

---

## ResultSet Interface

**RESULTSET INTERFACE IS A PART OF STATEMENT INTERFACE**

ResultSet (Interface):
- Retrieving data
- Scrolling through result
- Modification of data

---

## In a Nutshell
## JDBC Component Flow (Class → Interfaces)

| Level | Type       | Component        | Responsibilities / Notes |
|------:|------------|------------------|---------------------------|
| 1     | **Class**  | Driver Manager   | Manages JDBC drivers (Type 1–4), loads drivers, establishes connections |
|       |            |                  | JDBC-ODBC, Native API, Network Protocol, Thin Driver |
|       |            |                  |                           |
| ↓     |            |                  |                           |
| 2     | **Interface** | Connection     | Requires URL, USERNAME, PASSWORD |
|       |            |                  | Creates statements, manages transactions, retrieves metadata |
|       |            |                  |                           |
| ↓     |            |                  |                           |
| 3     | **Interface** | Statement      | Executes SQL queries |
|       |            |                  | Types: Statement, PreparedStatement, CallableStatement |
|       |            |                  |                           |
| ↓     |            |                  |                           |
| 4     | **Interface** | ResultSet      | Retrieves query results |
|       |            |                  | Navigate, read, and manipulate data |


---

## SQL Exception

SQL Exception:
- It is an exception class that handles errors and exceptions related to database  
  interactions
- It provides info about the type of error that occurred, and allows for more accurate  
  debugging and error resolution  
