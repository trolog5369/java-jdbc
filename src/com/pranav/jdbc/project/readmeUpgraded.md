# Hotel Management System (Upgraded)

A console-based Java application built using **JDBC** and **MySQL** to manage hotel reservations.
This upgraded version focuses on **PreparedStatements**, **date handling**, and **cleaner database interaction**.

---

## 🚀 Features

- Create new hotel reservations
- View reservation details by reservation ID
- Fetch room number for a reservation
- Update existing reservations
- Delete reservations
- Check-in and check-out date management
- Secure database access using `PreparedStatement`
- Input validation for reservation existence

---

## 🧭 Application Menu

1. New Reservation

2. Check Reservation

3. Check Room Number

4. Update Reservation

5. Delete Reservation

6. Exit


The application runs inside a continuous loop until the user exits.

---

## 🗄️ Database Design

### Database Name
```hotel_enhanced```


### Table: `reservations`

```sql
CREATE TABLE reservations (
    reservation_id INT AUTO_INCREMENT PRIMARY KEY,
    guest_name VARCHAR(255) NOT NULL,
    room_number INT NOT NULL,
    contact_number VARCHAR(10) NOT NULL,
    check_in_date DATE NOT NULL,
    check_out_date DATE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```
## ⚙️ Project Structure

```text
com.pranav.jdbc.project
└── HotelManagementUpgraded.java
```
## 🔧 Setup Instructions
### 1️⃣ Create Database

```sql
CREATE DATABASE hotel_enhanced;
USE hotel_db;
```
### 2️⃣ Create Table

Run the schema provided above.

### 3️⃣ Configure Database Credentials
Update the following values in the code:
```
private static final String url = "jdbc:mysql://localhost:3306/hotel_enhanced";
private static final String username = "your_username";
private static final String password = "your_password";
```
## Run the Application

- Ensure the MySQL server is running
- Compile and run the Java file
- Use the console menu to interact with the system

---

## Supported Operations

- Insert reservation data using user input
- Retrieve reservation details using reservation ID
- Validate reservation existence before update or delete
- Fetch room number for a reservation
- Store and manage check-in and check-out dates

---

## JDBC Concepts Used

- PreparedStatement
- Parameterized SQL queries
- executeUpdate() and executeQuery()
- Date handling using java.sql.Date
- Try-with-resources
- Connection pooling basics

---

## Current Limitations

- No transaction handling (commit/rollback)
- No batch processing
- Console-based UI only
- No room availability validation
- No business rules for overlapping bookings

These limitations are intentional and will be implemented in future iterations.

---

## Future Enhancements

- Add transaction handling
- Implement batch operations
- Validate room availability
- Add stay extension logic
- Improve input validation
- Introduce layered architecture (DAO / Service)

---

## Learning Outcomes

This project demonstrates:

- Real-world JDBC usage
- Secure SQL execution using PreparedStatement
- Date handling in SQL and Java
- CRUD operations with validation
- Incremental project enhancement strategy

---

## Author

**Pranav Gaikwad**  
Undergraduate IT Student  
Java Backend & Full Stack Developer (in progress)
