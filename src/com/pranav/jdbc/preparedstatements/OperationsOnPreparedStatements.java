package com.pranav.jdbc.preparedstatements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OperationsOnPreparedStatements {
    static void main(String[] args) throws ClassNotFoundException, SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Drivers loaded!");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "your_username";
        String password = "your_password";
        String query="INSERT INTO employees(id, name, job_title, salary) VALUES(?,?,?,?);";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established!");

            PreparedStatement preparedStatement=connection.prepareStatement(query);

            preparedStatement.setInt(1,3); //As id is 1st parameter index and its value is in int
            preparedStatement.setString(2,"Pranav"); //As name is 2nd parameter index and its value is in String
            preparedStatement.setString(3,"Devops Engineer"); //As job_title is 3rd parameter index and its value is in String
            preparedStatement.setDouble(4,80000); //As salary is 4th parameter index and its value is in double

            int rowsAffected=preparedStatement.executeUpdate();
//            Used executeUpdate as we're not retrieving data from the database;

            if (rowsAffected>0){
                System.out.println("Insertion successful");
            }else {
                System.out.println("Insertion failed!");
            }

            System.out.println();
            preparedStatement.close();
            connection.close();
            System.out.println("Connection closed!");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
