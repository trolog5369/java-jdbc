package com.pranav.jdbc.javatomysql;

import java.sql.*;

public class JavaToMysql {
    static void main(String[] args) throws ClassNotFoundException {
                /*
         JDBC FLOW (VERY IMPORTANT)

         1. Load Driver
         2. Create Connection
         3. Create Statement / PreparedStatement
         4. Execute Query
         5. Process ResultSet
         6. Close resources
        */

//        1.Load Drivers
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded successful!");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

//        2.Create Connection
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "Pranav@9615";
        String query="Select * from employees;";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established successfully!");

//            3.Create Statements
            Statement statement=connection.createStatement();

//            4.Execute Query and 5.Process Query set
            ResultSet resultSet= statement.executeQuery(query);

//            Printing the queries
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

//            6.close resources
            connection.close();
            statement.close();
            resultSet.close();
            System.out.println("Connections closed successfully");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
