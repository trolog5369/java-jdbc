package com.pranav.jdbc.projectbankingsystem;

//This class have 4 methods open_account,getAccount_number,generateAccountNumber,account_exist
import java.sql.*;
import java.util.Scanner;

public class Accounts {
    private final Connection connection;
    private final Scanner scanner;

    public Accounts(Connection connection,Scanner scanner) {
        this.connection=connection;
        this.scanner=scanner;
    }
    public long openAccount(String email) throws SQLException {
        if (!account_exist(email)) {
            System.out.print("Full Name: ");
            String fullName = scanner.nextLine();
            System.out.print("Enter initial amount: ");
            double balance = scanner.nextDouble();
            scanner.nextLine(); // Fixed: Buffer clear before reading Pin
            System.out.print("Enter security pin: ");
            String securityPin = scanner.nextLine();

            String query = "INSERT INTO accounts(account_number, full_name, email, balance, security_pin) VALUES(?,?,?,?,?)";
            long accountNumber = generateAccountNumber();

            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setLong(1, accountNumber);
                ps.setString(2, fullName);
                ps.setString(3, email);
                ps.setDouble(4, balance);
                ps.setString(5, securityPin);
                ps.executeUpdate();
                return accountNumber;
            }
        }
        return 0; // Fixed: Return 0 instead of crashing with an exception
    }


    public long getAccountNumber(String email)throws SQLException {
        String getAccountNumberQuery = "SELECT account_number FROM accounts WHERE email=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(getAccountNumberQuery);
            preparedStatement.setString(1, email);

            ResultSet resultSet=preparedStatement.executeQuery();

            if (resultSet.next()){
                return resultSet.getLong("account_number");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        throw new RuntimeException("Account do not exist!");
    }

    private long generateAccountNumber(){
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet=statement.executeQuery("SELECT account_number FROM accounts ORDER BY account_number DESC LIMIT 1");
            if (resultSet.next()){
                long last_account_number=resultSet.getLong("account_number");
                return last_account_number+1;
            }else {
                return 10000100;
//                Default account number.
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return 10000100;
    }
    public boolean account_exist(String email) throws SQLException {
//        As account_number is primary key and email is unique key! in accounts table
        String query = "SELECT account_number FROM accounts WHERE email=?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,email);

            ResultSet resultSet=preparedStatement.executeQuery();

            if (resultSet.next()){
                return true;
            }else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
