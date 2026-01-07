package com.pranav.jdbc.deletingdata;

import java.sql.*;

public class DeletingData {
    static void main(String[] args) throws ClassNotFoundException, SQLException {
        /*
        1. Load Drivers
        2. Establish Connection
        3. Create Statement
        4. Execute Query
        5. Process ResultSet
        6. Close resources
         */

//        1.Load Drivers
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Drivers loaded successfully!");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "your_username";
        String password = "your_password";
        String query="DELETE FROM employees where id = 3;";
//        Delete Query: DELETE FROM table_name field=value;
//        As id is set as primary key hence it is a unique identifier for the filed
//        2.Establish Connection
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established successfully!");

//            3.Create statement
            Statement statement=connection.createStatement();

            int rowsAffected=statement.executeUpdate(query);

            if (rowsAffected>0) {
                System.out.println("Deletion successfully! "+rowsAffected+" Row(s) affected");
            }
            else {
                System.out.println("Deletion failed!");
            }

            connection.close();
            statement.close();
            System.out.println("connection closed successfully!");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
//To delete an entry we have to specify field which we want to delete the particular record
//In this case it can be id,name,salary,job_title but in larger co-op databases there can be multiple entries with the same
// filed and values,
//Hence we should choose a field which is unique in this case Primary key is id
//Primary key is unique it is not repeated!