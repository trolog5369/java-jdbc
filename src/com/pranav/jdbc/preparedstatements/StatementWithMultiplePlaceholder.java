package com.pranav.jdbc.preparedstatements;

import java.sql.*;

public class StatementWithMultiplePlaceholder {
    static void main(String[] args) throws ClassNotFoundException, SQLException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded!");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        String url="jdbc:mysql://localhost:3306/mydatabase";
        String username="root";
        String password="Pranav@9615";

        String query="Select * from employees WHERE name = ? AND job_title = ?";

//        We can also run multiple queries just add the set[var_type] accordingly for this query
//        String query="Select * from employees WHERE name=? AND job_title=? AND salary=?";
//        preparedStatement.setString(1,"Hemant"); As name is in String and its parameter index is 1
//        preparedStatement.setString(2, "Full Stack Developer"); As job_title is in String and its parameter index is 2
//        preparedStatement.setDouble(3,70000); As salary is in Double and its parameter index is 3

        try{
            Connection connection= DriverManager.getConnection(url,username,password);
            System.out.println("Connection established!");

//            For normal statement
//            Statement statement=connection.createStatement();

            PreparedStatement preparedStatement=connection.prepareStatement(query);

            preparedStatement.setString(1,"Hemant");
            preparedStatement.setString(2,"Full Stack Developer");

            ResultSet resultSet=preparedStatement.executeQuery();
//            Used executeQuery as we're retrieving data from the database not Performing operations(Insertion,delete,update)

            while (resultSet.next()){
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
