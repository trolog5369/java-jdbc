package com.pranav.jdbc.projectbankingsystem;

//This class contains register ,Login and user_exist methods

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class User {
    private final Connection connection;
    private final Scanner scanner;

    public User(Connection connection,Scanner scanner){
        this.connection=connection;
        this.scanner=scanner;
    }
    public void register() throws SQLException {
        scanner.nextLine();

        System.out.print("Full Name: ");
        String fullName = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        String registerQuery = "INSERT INTO user(full_name, email, password)VALUES(?, ?, ?)";

        if (user_exists(email)){
            System.out.println("User Already Exist for this Email Address!");
            return;
        }

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(registerQuery);
            preparedStatement.setString(1,fullName);
            preparedStatement.setString(2,email);
            preparedStatement.setString(3,password);

            int rowsAffected=preparedStatement.executeUpdate();

            if (rowsAffected>0){
                System.out.println("Registration successful!");
            }else {
                System.out.println("Registration failed!");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


//    This  return String(email) helps us to get the email of the logged-in user
//    Which we will pass onto other functions
    public String login() throws SQLException {
        scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        String loginQuery = "SELECT * FROM user WHERE email=? AND password=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(loginQuery);
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,password);
//            Using ResultSet as want to return the email
            ResultSet resultSet=preparedStatement.executeQuery();

            if (resultSet.next()){
                return email;
            }else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


    public boolean user_exists(String email) throws SQLException {
        String Query = "SELECT * FROM user WHERE email=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Query);
            preparedStatement.setString(1,email);
            ResultSet resultSet=preparedStatement.executeQuery();
            if (resultSet.next()) {
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
