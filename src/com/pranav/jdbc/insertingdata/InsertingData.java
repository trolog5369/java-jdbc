package com.pranav.jdbc.insertingdata;

import java.sql.*;

public class InsertingData {
    static void main(String[] args) throws ClassNotFoundException {
        /*
        1.Load Drivers
        2.Establish connection
        3.Create statement
        4.Execute query
        5.ProcessResult Set
        6.Close Resources
         */

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded successfully!");

        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "your_username";
        String password = "your-password";
        String query="INSERT INTO employees(id, name,job_title, salary) VALUES(3,'Harshit','Full Stack Developer',87000.0);";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established!");

            Statement statement=connection.createStatement();
//            The statement interface has 2 important methods which are executeQuery() and executeUpdate()
//            The executeQuery(): Used when we want to retrieve a particular data
//            The executeUpdate(): Used when we want insert a particular data

//            statement.executeUpdate(query);

//            We are not using ResultSet are it is used for retrieving the data in this case we're inserting the data not retrieving
//            When we insert a particular data in mysql rows gets affected hence to check if the data is inserted will store
//            The executeQuery() in the int rowsAffected variable!

            int rowsAffected=statement.executeUpdate(query);

//            If rowsAffected is greater than 0 then query is updated!
            if (rowsAffected>0){
                System.out.println("Insert successful!"+rowsAffected+"row(s) affected");
            }
            else {
                System.out.println("Insertion failed!");
            }


            connection.close();
            statement.close();
            System.out.println("connection closed successfully!");

        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
