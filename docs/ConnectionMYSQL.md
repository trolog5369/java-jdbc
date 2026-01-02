# WorkFlow of the Project

## Steps

1.Set up a MYSQL database  
2.Create new project  
3.Add the MYSQL connector  
4.Configure the MYSQL Connector  
5.Execute SQL queries

## MYSQL Database Commands

To create a Database click on the MYSQL command Line Client and input pass

To check the databases present(Pre-existing) in the system use :
```sql
show database;
To create a database use:

create database (Database name);

Connecting Project to Database

To connect a project to a database we need MYSQL connector for java

Click on the three lines on the intellij
Click Project Structure
Then Libraries
Then click on + icon and then load Jar file

Which is downloaded from Mysql connector j(Site).zip file

https://dev.mysql.com/downloads/connector/j/?os=26

Result
Now we have successfully connected the database to Intellij