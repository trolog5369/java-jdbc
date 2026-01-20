# 🏨 Hotel Reservation System (JDBC + MySQL)

A **console-based Hotel Reservation System** built using **Java JDBC** and **MySQL**.  
This project demonstrates core **CRUD operations**, database connectivity, and a **menu-driven application flow**.

---

## 📌 Features

- Create new hotel reservations
- View all reservations
- Fetch room number using reservation ID and guest name
- Update existing reservations
- Delete reservations
- Continuous execution until user exits

---

## 🧠 Key Concepts Used

- JDBC Driver loading
- MySQL database connectivity
- `Statement` and `ResultSet`
- CRUD operations (Create, Read, Update, Delete)
- Menu-driven program using `while(true)`
- Basic validation for reservation existence

---

## 📋 Main Menu

```text
1. Reserve a room
2. View reservations
3. Get room number
4. Update reservations
5. Delete reservations
0. Exit
```
The program runs continuously until Exit is selected.

### 🗄️ Database Details
Database Name
```text
hotel_db
```
### Table Name
```text
reservations
```
### Table Schema
```sql
CREATE TABLE reservations (
reservation_id INT AUTO_INCREMENT PRIMARY KEY,
guest_name VARCHAR(255) NOT NULL,
room_number INT NOT NULL,
contact_number VARCHAR(10) NOT NULL,
reservation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```
## ⚙️ Project Structure

```text
com.pranav.jdbc.projecthotelmanagement
└── HotelReservationSystem.java
```
## 🔧 Setup Instructions 
### 1️⃣ Create Database

```sql
CREATE DATABASE hotel_db;
USE hotel_db;
```
### 2️⃣ Create Table

Run the schema provided above.

### 3️⃣ Configure Database Credentials
Update the following values in the code:
```
private static final String url = "jdbc:mysql://localhost:3306/hotel_db";
private static final String username = "your_username";
private static final String password = "your_password";
```

### 4️⃣ Run the Application
- Ensure MySQL server is running
- Compile and run the Java program
- Use the console menu to interact

## 🧪 Supported Operations

- Insert reservation data from user input
- Retrieve all reservations with timestamps
- Validate reservation existence before update or delete
- Fetch room number using reservation ID and guest name

---

## ⚠️ Current Limitations

- Uses `Statement` instead of `PreparedStatement`
- No transaction handling
- No check-in / check-out tracking
- Console-based interface only

These limitations are intentional and will be addressed in future versions.

---

## 🚀 Future Enhancements

- Replace `Statement` with `PreparedStatement`
- Add check-in and check-out dates
- Implement transaction handling
- Prevent SQL injection
- Improve input validation

---

## 🎯 Learning Outcome

This project demonstrates:

- Practical JDBC usage
- Database-driven application design
- Clean method-based structure
- Real-world CRUD logic

---

## 👨‍💻 Author

**Pranav Gaikwad**  
Undergraduate IT Student  
Java Backend & Full Stack Developer (in progress)
