package com.pranav.jdbc.batchprocessing;

//            Batch processing using Simple Statement

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchProcessingSimpleStatement {
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

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established!");

//            BatchProcessing first we have to set autocommit to be false as it is by default true
//            We set autocommit(false) because we have to ensure that the entire batch is ready

            connection.setAutoCommit(false);
//            Now we can commit manually

//            Batch processing using Simple Statement

            Statement statement=connection.createStatement();
//            We have started Statement instance

//            The statement interface instance has a method addBatch() which takes query as an argument
//            addBatch() helps to add queries in a batch which are further executed
            statement.addBatch("INSERT INTO employees(name, job_title, salary) VALUES('Vashu', 'HR Manager', 65000.0)");
            statement.addBatch("INSERT INTO employees(name, job_title, salary) VALUES('Karan', 'Cyber Security Analyst', 62000.0)");
            statement.addBatch("INSERT INTO employees(name, job_title, salary )VALUES('Vipul', 'Devops Engineer', 67000.0)");

//            The batch is executed by statement interface's executeBatch()
//            This executeBatch() returns an array hence we have to store it in an array
            int[] batchResult =statement.executeBatch();
//            When the batch is ready will commit it.
            connection.commit();
            System.out.println("Batch executed successfully!");


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
