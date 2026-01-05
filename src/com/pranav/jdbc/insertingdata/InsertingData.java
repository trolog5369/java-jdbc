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

//        1.Load Drivers
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded successfully!");

        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "Pranav@9615";
        String query="select * from employees;";

//        2.Establish Connection
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established!");

//            3.Create statement and execute query
            Statement statement=connection.createStatement();

//            5.Precess Result Set
            ResultSet resultSet=statement.executeQuery(query);

            while (resultSet.next()){
                int id=resultSet.getInt("id");
                String name=resultSet.getString("name");
                String job_title=resultSet.getString("job_title");
                double salary=resultSet.getDouble("salary");

                System.out.println("==============================");
                System.out.println("ID: "+id);
                System.out.println("Name: "+name);
                System.out.println("Job Title: "+job_title);
                System.out.println("Salary: "+salary);
            }

            System.out.println();

            connection.close();
            statement.close();
            resultSet.close();
            System.out.println("connection closed successfully!");

        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
