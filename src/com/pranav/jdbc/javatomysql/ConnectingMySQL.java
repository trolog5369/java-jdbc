package com.pranav.jdbc.javatomysql;

import  java.sql.*;
//We imported all the drivers thr this!

//This is package includes all the packages,interfaces and classes we need to work with JDBC
//This is the SuperPackage
public class ConnectingMySQL {
    static void main(String[] args) throws ClassNotFoundException {

//        This is the Query that will run
        String query="select * from employees;";

//        To load the drivers we use Class.forName()
//        Class.forName("com.mysql.jdbc.Driver");
//        This method forName throws exception hence we have to use try catch and throws blocks
//        for the method
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Drivers loaded successfully!");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

//        Drivers are loaded successfully now we have to connect to database
//        for that we use DriverManager class and ConnectionInterface

//        For connection, we need url,username and password
//        String url="";
//        String username="";//your username
//        String password="";//your password
//        Incase if you forget the url go to MYSQL workbench left-click on the LocalInstance and then select
//         copy JDBC Connection String to ClipBoard
//        jdbc:mysql://localhost:3306/?user=root
//        This is the connection String remove ?user=root and input the database we want to connect

        String url="jdbc:mysql://localhost:3306/mydatabase";
        String username="root";//your username
        String password="Pranav@9615";//your password

//        To establish the connection we will use again try and catch blocks
//        try{
//            Connection con=DriverManager.getConnection(url,username,password);
//            System.out.println("Connection established successfully");
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        DriverManager class has a method getConnection() which accepts 3 parameters url,username,password
//        This method establishes connection with database
//        The connection which is established we stored that in the instance "con" which is off Connection interface

//        Connection interface has an instance "con" which contains the connection established by the getConnection()

//        Now we have to create statements to run queries
        try{
            Connection con=DriverManager.getConnection(url,username,password);
            System.out.println("Connection established successfully");
//            we have created a statement using the interface Statements and created its instance stmt
//            Which uses con instance of Connection interface to create Statements
            Statement stmt=con.createStatement();

//            The query which is going to be executed we store that in the instance of ResultSet named rs.
            ResultSet rs =stmt.executeQuery(query);

//            To print the data use loop
            while (rs.next()){
//                ColumnLabel are same as the MYSQL
                int id=rs.getInt("id");
                String name=rs.getString("name");
                String job_title=rs.getString("job_title");
                double salary=rs.getDouble("salary");

                System.out.println("==============================");
                System.out.println("ID: "+id);
                System.out.println("Name: "+name);
                System.out.println("Job Title: "+job_title);
                System.out.println("Salary: "+salary);
            }
//            To close the rsc
            rs.close();
            stmt.close();
            con.close();
            System.out.println("Connection closed successfully!");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

//Every instance we created its using the previous instances for working smoothly

                /*
         JDBC FLOW (VERY IMPORTANT)

         1. Load Driver
         2. Create Connection
         3. Create Statement / PreparedStatement
         4. Execute Query
         5. Process ResultSet
         6. Close resources
        */

    }
}
