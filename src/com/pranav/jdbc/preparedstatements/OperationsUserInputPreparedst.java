package com.pranav.jdbc.preparedstatements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class OperationsUserInputPreparedst {
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
        String query = "INSERT INTO employees(id, name, job_title, salary) VALUES(?,?,?,?);";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established!");
            Scanner scanner=new Scanner(System.in);

            PreparedStatement preparedStatement=connection.prepareStatement(query);

            System.out.print("Enter employee id: ");
            int id=scanner.nextInt();

            System.out.print("Enter employee name: ");
            String name=scanner.next();

            System.out.print("Enter Job Title: ");
            String jobTitle=scanner.next();

            scanner.next();//New line character

            System.out.print("Enter salary of employee: ");
            double salary=scanner.nextDouble();

            preparedStatement.setInt(1,id); //As id is 1st parameter index and its value is in int
            preparedStatement.setString(2,name); //As name is 2nd parameter index and its value is in String
            preparedStatement.setString(3,jobTitle); //As job_title is 3rd parameter index and its value is in String
            preparedStatement.setDouble(4,salary); //As salary is 4th parameter index and its value is in double

            int rowsAffected=preparedStatement.executeUpdate();
//            Used executeUpdate as we're not retrieving data from the database;


            if (rowsAffected>0){
                System.out.println("Insertion Successful");
            }else {
                System.out.println("Insertion Failed!");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
