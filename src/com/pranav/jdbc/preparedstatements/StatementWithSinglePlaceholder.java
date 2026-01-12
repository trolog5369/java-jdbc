package com.pranav.jdbc.preparedstatements;

import java.sql.*;
public class StatementWithSinglePlaceholder {
        static void main(String[] args) throws ClassNotFoundException, SQLException {
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println("Drivers loaded successfully!");
            } catch (ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }

            String url="jdbc:mysql://localhost:3306/mydatabase";
            String username="root";
            String password="Pranav@9615";

            String query="Select * from employees where name= ?";
//        ? is a placeholder, and we have to give value to the placeholder using the set[vartype]() ie pass the arguments(values)
//        for database
//        Numbering will start 1
//        In this query "Select * from employees where name= ? AND job_title= ?"
//            1st parameter index is name
//            And 2nd is job_title!

            try{
                Connection connection= DriverManager.getConnection(url,username,password);
                System.out.println("Connection establish successfully!");
//            This is for normal statement:
//            Statement statement=connection.createStatement();

//            For   PreparedStatement use:
                PreparedStatement preparedStatement=connection.prepareStatement(query);

//            The setString() accepts 2 arguments ie parameter index and value
//                We use setString() as we want to find thr a String name
                preparedStatement.setString(1,"Hemant");

                ResultSet resultSet=preparedStatement.executeQuery();
                while(resultSet.next()){
                    int id=resultSet.getInt("id");
                    String name=resultSet.getString("name");
                    String jobTitle=resultSet.getString("job_title");
                    double salary=resultSet.getDouble("salary");

                    System.out.println("ID: "+id);
                    System.out.println("Name: "+name);
                    System.out.println("Job Title: "+jobTitle);
                    System.out.println("Salary: "+salary);

                }

                connection.close();
                resultSet.close();
                preparedStatement.close();
                System.out.println();
                System.out.println("Connection closed successfully!");

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }


