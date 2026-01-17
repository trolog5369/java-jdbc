package com.pranav.jdbc.batchprocessing;

//            Batch processing using Prepared Statement

import java.sql.*;
import java.util.Scanner;

public class BatchProcessingPreparedStatement {
    static void main(String[] args) throws ClassNotFoundException, SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Drivers loaded!");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "Pranav@9615";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established!");

            connection.setAutoCommit(false);

            String query="INSERT INTO employees(name, job_title, salary)VALUES(?, ?, ?)";

            PreparedStatement preparedStatement=connection.prepareStatement(query);
            Scanner scanner=new Scanner(System.in);

            while (true){
                System.out.print("Name: ");
                String name=scanner.nextLine();

                System.out.print("Job Title: ");
                String job_title=scanner.nextLine();

                System.out.print("Salary: ");
                double salary=scanner.nextDouble();

                preparedStatement.setString(1,name);
                preparedStatement.setString(2,job_title);
                preparedStatement.setDouble(3,salary);

                scanner.nextLine();//New line character

//                now we will put all of this in a batch using addBatch()
                preparedStatement.addBatch();

//                Asking the user if he wants to add more values
                System.out.print("Add more values(Y/N):");
                String decision=scanner.nextLine();
                if (decision.toUpperCase().equals("N")){
                    break;
                }
            }

//            This array stores how many rows are affected for each query as this [] returns int
//            for 5 queries it will be return 5, int 0 or 1 based on success or failed execution
//            This is the significance of batchResult int[]
            int[] batchResult=preparedStatement.executeBatch();

            //            When the batch is ready will commit it.
            connection.commit();
            System.out.println("Batch executed successfully!");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}

