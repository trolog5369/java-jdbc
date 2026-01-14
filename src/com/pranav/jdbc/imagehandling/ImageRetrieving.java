package com.pranav.jdbc.imagehandling;

import java.io.*;
import java.sql.*;

public class ImageRetrieving {
    static void main(String[] args) throws ClassNotFoundException, SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Drivers loaded");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "Pranav@9615";
//        String image_Path="C:\\Users\\Pranav\\Desktop\\image\\14378151.png";

//        We have to add \\ so that the image get saved inside this location
//        C:\Users\Pranav\Desktop\image
        String folderPath="C:\\Users\\Pranav\\Desktop\\image\\";

        String query="SELECT image_data FROM image_table WHERE image_id=(?)";
//        Ad image_id is primary key


        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established!");

//            Using prepared statements for retrieving data from database
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setInt(1,1);

            ResultSet resultSet=preparedStatement.executeQuery();

            if (resultSet.next()){
//                WE will store the data we received into a byte[]
                byte[] image_data =resultSet.getBytes("image_data");

//                The data is now in byte format stored in the image_date byte[]

//                Concatenating the string ie giving the name for image as we already have teh folder path
                String image_path=folderPath+"extractedImage.jpg";

//            To retrieve the image we will use my FileOutputStream,
//                FileOutputStream converts byte data into the image
                OutputStream outputStream=new FileOutputStream(image_path);

                outputStream.write(image_data);//This method writes the image_data in this path ie image_path!

            }else {
                System.out.println("Image not found!");
            }

        } catch (SQLException | IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
