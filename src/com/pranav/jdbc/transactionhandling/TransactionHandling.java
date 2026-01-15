package com.pranav.jdbc.transactionhandling;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionHandling {
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
        String withdrawQuery="UPDATE accounts SET balance=balance-? WHERE account_number = ?";
        String depositQuery="UPDATE accounts SET balance=balance+? WHERE account_number = ?";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established!");

//            Connection object by default autocommit() is true ie it gets commited automatically!
//            But in Transaction handling we have to ensure this hence we set AutoCommit as false
            connection.setAutoCommit(false);
//            Now nothing will auto-commit we will ensure first than Commit changes ie manually!

//            Always ensure using Transaction Handling using try and catch blocks
            try {
                PreparedStatement withdrawStatement = connection.prepareStatement(withdrawQuery);
                PreparedStatement depositStatement = connection.prepareStatement(depositQuery);

                withdrawStatement.setDouble(1, 500.00);
                withdrawStatement.setString(2, "account123");

                depositStatement.setDouble(1, 500.00);
                depositStatement.setString(2, "account456");


                int rowsAffectedWithdraw = withdrawStatement.executeUpdate();
                int rowsAffectedDeposit = depositStatement.executeUpdate();
//            Until we have now credited and debited

//            Now we will use TransactionHandling
                if (rowsAffectedDeposit > 0 && rowsAffectedWithdraw > 0) {
//            If the transaction goes smoothly without any errors or ambiguity from both the ends then commit
                    connection.commit();
                    System.out.println("Transaction successful");
                } else {
//                If the transaction fails or have any errors or ambiguity from any end then rollback
                    connection.rollback();
                    System.out.println("Transaction failed!");
                }

            }catch (SQLException e){
                System.out.println(e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
