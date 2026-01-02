# Java JDBC – MySQL Setup & Connection

This repository documents the initial setup and basic workflow of connecting a Java application to a MySQL database using JDBC.  
It also includes a working boilerplate and a verified test connection example.

---

## WorkFlow of the Project

### Steps

1. Set up a MYSQL database
2. Create new project
3. Add the MYSQL connector
4. Configure the MYSQL Connector
5. Execute SQL queries

---

## MYSQL Database Commands

To create a Database click on the MYSQL command Line Client and input pass

To check the databases present (Pre-existing) in the system:
```sql
show database;
```
### To create a database:
create database (Database name);


### Connecting Project to Database
1. To connect a project to a database we need MYSQL connector for java
2. Steps in IntelliJ IDEA:
3. Click on the three lines (menu)
4. Click Project Structure
5. Go to Libraries
6. Click on the + icon
7. Load the JAR file
8. The JAR file is downloaded from the official MySQL Connector/J site:
https://dev.mysql.com/downloads/connector/j/?os=26

## Result
Now we have successfully connected the database to IntelliJ.

---
### Notes

1. DriverManager is a class
2. Connection, Statement, and ResultSet are interfaces
3. This setup confirms successful JDBC–MySQL integration
4. Further steps will include executing queries and handling ResultSet
---