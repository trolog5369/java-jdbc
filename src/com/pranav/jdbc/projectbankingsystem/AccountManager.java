package com.pranav.jdbc.projectbankingsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AccountManager {
        private final Connection connection;
        private final Scanner scanner;

        public AccountManager(Connection connection, Scanner scanner) {
            this.connection=connection;
            this.scanner=scanner;
        }

    public void debit_money(long accountNumber) throws SQLException {
        scanner.nextLine();
        System.out.println("Enter amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Enter security pin: ");
        String security_pin = scanner.nextLine();

        try {
            connection.setAutoCommit(false);
            if (accountNumber!=0){
                PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM accounts WHERE account_number=? AND security_pin=?");
                preparedStatement.setLong(1,accountNumber);
                preparedStatement.setString(2,security_pin);

                ResultSet resultSet=preparedStatement.executeQuery();

                if (resultSet.next()){
                    double current_balance=resultSet.getDouble("balance");

                    if (amount<=current_balance){
                        String debit_query ="UPDATE accounts SET balance=balance-? WHERE account_number=?";
                        PreparedStatement preparedStatement1=connection.prepareStatement(debit_query);
                        preparedStatement1.setDouble(1,amount);
                        preparedStatement1.setLong(2,accountNumber);

                        int rowsAffected=preparedStatement1.executeUpdate();
                        if (rowsAffected>0){
                            System.out.println("Rs "+amount+" Debited successfully!");
                            connection.commit();
                            connection.setAutoCommit(true);
                            return;
                        }else {
                            System.out.println("Transaction failed!");
                            connection.rollback();
                            connection.setAutoCommit(true);
                        }

                    }else {
                        System.out.println("insufficient balance!");
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void credit_money(long accountNumber){

        scanner.nextLine();
        System.out.println("Enter amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Enter security pin: ");
        String security_pin = scanner.nextLine();

        try {
            connection.setAutoCommit(false);
            if (accountNumber!=0){
                PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM accounts WHERE account_number=? AND security_pin=?");
                preparedStatement.setLong(1,accountNumber);
                preparedStatement.setString(2,security_pin);

                ResultSet resultSet=preparedStatement.executeQuery();

                if (resultSet.next()){
                        String credit_query ="UPDATE accounts SET balance=balance+? WHERE account_number=?";
                        PreparedStatement preparedStatement1=connection.prepareStatement(credit_query);
                        preparedStatement1.setDouble(1,amount);
                        preparedStatement1.setLong(2,accountNumber);

                        int rowsAffected=preparedStatement1.executeUpdate();
                        if (rowsAffected>0){
                            System.out.println("Rs "+amount+" credited successfully!");
                            connection.commit();
                            connection.setAutoCommit(true);
                            return;
                        }else {
                            System.out.println("Transaction failed!");
                            connection.rollback();
                            connection.setAutoCommit(true);
                        }

                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    public void check_balance(long account_number) throws SQLException {
        scanner.nextLine();
        System.out.println("Enter security pin: ");
        String security_pin = scanner.nextLine();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT balance from accounts WHERE account_number=? AND security_pin=?");
            preparedStatement.setLong(1, account_number);
            preparedStatement.setString(2, security_pin);
            ResultSet resultSet=preparedStatement.executeQuery();

            if (resultSet.next()){
                double balance=resultSet.getDouble("balance");
                System.out.println("balance: "+balance);
            }else{
                System.out.println("Invalid pin!");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void transfer_money(long senderAccountNumber) throws SQLException {
        scanner.nextLine();
        System.out.println("Enter receiver Account number: ");
        long receiverAccountNumber = scanner.nextLong();
        System.out.println("Enter amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Enter security Pin: ");
        String security_pin = scanner.nextLine();

        try {
            connection.setAutoCommit(false);
            if (senderAccountNumber!=0 && receiverAccountNumber!=0){
                PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM accounts WHERE account_number=? AND security_pin=?");
                preparedStatement.setLong(1,senderAccountNumber);
                preparedStatement.setString(2,security_pin);

                ResultSet resultSet=preparedStatement.executeQuery();

                if (resultSet.next()){
                    double current_balance=resultSet.getDouble("balance");
                    if (amount<=current_balance){
                        String debit_query="UPDATE accounts SET balance=balance-? WHERE account_number=?";
                        String credit_query="UPDATE accounts SET balance=balance+? WHERE account_number=?";

                        PreparedStatement debitPreparedStatement=connection.prepareStatement(debit_query);
                        PreparedStatement creditPreparedStatement=connection.prepareStatement(credit_query);

                        debitPreparedStatement.setDouble(1,amount);
                        debitPreparedStatement.setLong(2,senderAccountNumber);

                        creditPreparedStatement.setDouble(1,amount);
                        creditPreparedStatement.setLong(2,receiverAccountNumber);

                        int rowsAffected1=debitPreparedStatement.executeUpdate();
                        int rowsAffected2=creditPreparedStatement.executeUpdate();

                        if (rowsAffected1>0 && rowsAffected2>0){
                            System.out.println("Transaction successful!");
                            connection.commit();
                            connection.setAutoCommit(true);
                        }else {
                            System.out.println("Transaction failed!");
                            connection.rollback();
                            connection.setAutoCommit(true);
                        }

                    }else {
                        System.out.println("Insufficient balance!");
                    }
                }
            }else {
                System.out.println("Invalid security pin!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}


