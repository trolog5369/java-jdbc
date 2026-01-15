package com.pranav.jdbc.imagehandling;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ImageHandling {
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
        String image_path="C:\\Users\\Pranav\\Desktop\\image\\14378151.png";

//        Query for inserting image into Database using prepared statements
        String query="INSERT INTO image_table(image_data) VALUES(?)";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established successful!");

//           Steps for inserting a image:
//           1.We have to select the image from folders and put into java
//           2.Then we will insert the image in mysql through java

//            Copy image path from folders and remove the excess (\ and ")
//            And store that in the variable  String image_path
//            String image_path="\"C:\\Users\\Pranav\\Desktop\\image\\14378151.png\"";
//            The removed string will be:
//            String image_path="C:\\Users\\Pranav\\Desktop\\image\\14378151.png";

//            Now we will load the image by converting it into binary format using FileInputStream class
//            FileInputStream converts any image into binary format

            FileInputStream fileInputStream=new FileInputStream(image_path);

//            To store this converted image we will use array as the image will be in binary format(0/1)
//            We will declare a byte[] and store it.
//            byte[] imageData=new byte[];
//            But now we have to specify the size of the Array we can't guess the size as if we guessed less exception will occur
//            and if guessed more we will waste space hence we used fileInputStream's available()

//            The  fileInputStream.available() tells us hiw much data is accessible without getting blocked
//            it tells whether the image is corrupted or how much space the image required

            byte[] imageData=new byte[fileInputStream.available()];

//            To read the contents of the image we used fileInputStream.read()
            fileInputStream.read(imageData);

//            Now we have successfully put the image into java variables from the folders

//            Now we will insert the image into database using prepared statements
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setBytes(1,imageData);

            int rowSAffected=preparedStatement.executeUpdate();

            if (rowSAffected>0){
                System.out.println("Image insert successful!");
            }else {
                System.out.println("Image insertion failed!");
            }
//            NOW WE HAVE SUCCESSFULLY INSERTED THE IMAGE INTO DATABASE NOW TO RETRIEVE IT LOOK FOR ImageRetrieving.java
        } catch (SQLException | IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
