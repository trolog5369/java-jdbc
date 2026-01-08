package com.pranav.jdbc.updatingdata;

import java.sql.*;
public class UpdatingData {
    static void main(String[] args) throws ClassNotFoundException, SQLException {
        /*
        1.Load Drivers
        2.Establish Connections
        3.Create statement
        4.Execute query
        5.Process ResultSet
        6.Close resources
         */

        try {
            Class.forName("com.mysql.jdbc.Driver");
//            Drivers loaded successfully!
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "your_username";
        String password = "your_password";
        String query="UPDATE employees\n" +
                "SET job_title='Full Stack Developer', salary=70000.0\n" +
                "WHERE id = 2 ;";


        try {
            Connection connection = DriverManager.getConnection(url, username, password);
//            Connection establish successfully!

            Statement statement = connection.createStatement();
            int rowsAffected = statement.executeUpdate(query);

            if (rowsAffected > 0) {
                System.out.println("Update successfully! " + rowsAffected + "row(s) affected!");
            } else {
                System.out.println("Update Failed!");
            }

            connection.close();
            statement.close();
            System.out.println();
            System.out.println("Connection Closed Successfully!");
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
