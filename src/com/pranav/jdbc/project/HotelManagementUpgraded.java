package com.pranav.jdbc.project;

import java.sql.*;
import java.util.Scanner;

public class HotelManagementUpgraded {
    private static final String url = "jdbc:mysql://localhost:3306/hotel_enhanced";
    private static final String username = "your_username";
    private static final String password = "your_password";

    static void main(String[] args) throws ClassNotFoundException, SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Drivers loaded!");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try(Connection connection=DriverManager.getConnection(url,username,password);
            Scanner scanner=new Scanner(System.in)) {
            System.out.println("Connection established!");

            while (true){
                System.out.println("Welcome to Hotel Reservation System");
                System.out.println("Enter your choice: ");
                System.out.println("1. New reservation: ");
                System.out.println("2. Check Reservation:");
                System.out.println("3. Check room number");
                System.out.println("4. Update reservation");
                System.out.println("5. Delete reservation");
                System.out.println("0. Exit");
                int choice=scanner.nextInt();
                scanner.nextLine();

                switch (choice){
                    case 1:
                        newReservation(scanner,connection);
                        break;
                    case 2:
                        checkReservation(scanner,connection);
                        break;
                    case 3:
                        getRoomNumber(scanner,connection);
                        break;
                    case 4:
                        updateReservation(scanner,connection);
                        break;
                    case 5:
                        deleteReservation(scanner,connection );
                        break;
                    case 0:
                        exit();
                        return;
                    default:
                        System.out.println("Invalid choice! please try again!");
                        continue;
                }
            }

        } catch (SQLException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
    private static void newReservation(Scanner scanner,Connection connection) throws SQLException {
        // Note: The SQL dates expect yyyy-mm-dd format
        String query="INSERT INTO reservations(guest_name, room_number, contact_number, check_in_date, check_out_date)" +
                "VALUES(?,?,?,?,?)";

        System.out.print("Enter Guest name: ");
        String guest_name=scanner.nextLine();

        System.out.print("Enter Room Number: ");
        int room_number=scanner.nextInt();

        System.out.print("Enter Contact Number: ");
        String contact_number=scanner.next();

        // 1. Get Date input as String
        System.out.print("Enter Check In Date (YYYY-MM-DD): ");
        String checkInDate = scanner.next();

        System.out.print("Enter Check Out Date (YYYY-MM-DD): ");
        String checkOutDate = scanner.next();

        // 2. Convert String to java.sql.Date
        // java.sql.Date.valueOf() automatically parses "YYYY-MM-DD"
        try(PreparedStatement preparedStatement=connection.prepareStatement(query)){
            preparedStatement.setString(1,guest_name);
            preparedStatement.setInt(2,room_number);
            preparedStatement.setString(3,contact_number);
            preparedStatement.setDate(4, java.sql.Date.valueOf(checkInDate));
            preparedStatement.setDate(5, java.sql.Date.valueOf(checkOutDate));

            int rowsAffected=preparedStatement.executeUpdate();
            if (rowsAffected>0){
                System.out.println("Reservation successful!");
            }else {
                System.out.println("reservation failed!");

            }
        }catch(IllegalArgumentException e){
            System.out.println("Error: Please enter the date in YYYY-MM-DD format.");
        }
    }
    private static void checkReservation(Scanner scanner,Connection connection) throws SQLException {

        System.out.print("Enter reservation id: ");
        int reservationId=scanner.nextInt();

        //        Checking if reservation exists
        if(!reservationExists(connection, reservationId)){
            System.out.println("Reservation do not exist");
            return;
        }

        String query="SELECT reservation_id, guest_name, room_number, contact_number, check_in_date, check_out_date FROM reservations WHERE reservation_id=?";

        try(PreparedStatement preparedStatement=connection.prepareStatement(query)){

            preparedStatement.setInt(1,reservationId);

            ResultSet resultSet=preparedStatement.executeQuery();

            while (resultSet.next()){
                int reservationID=resultSet.getInt("reservation_id");
                String guestName=resultSet.getString("guest_name");
                int roomNumber=resultSet.getInt("room_number");
                String contactNumber=resultSet.getString("contact_number");
                String checkInDate= String.valueOf(resultSet.getDate("check_in_date"));
                String checkOutDate= String.valueOf(resultSet.getDate("check_out_date"));

                System.out.print("Reservation ID:");
                System.out.println(reservationID);
                System.out.print("Guest Name: ");
                System.out.println(guestName);
                System.out.print("Room Number:");
                System.out.println(roomNumber);
                System.out.print("Contact Number:");
                System.out.println(contactNumber);
                System.out.print("Check In Date:");
                System.out.println(checkInDate);
                System.out.print("Check Out Date:");
                System.out.println(checkOutDate);
                System.out.println();
            }
            resultSet.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }

    }
    private static void getRoomNumber(Scanner scanner,Connection connection) throws SQLException {
        System.out.print("Enter Reservation id: ");
        int reservationId=scanner.nextInt();


        //        Checking if reservation exists
        if(!reservationExists(connection, reservationId)){
            System.out.println("Reservation do not exist");
            return;
        }

        String query="SELECT room_number FROM reservations WHERE reservation_id=?";

        try(PreparedStatement preparedStatement=connection.prepareStatement(query)){
            preparedStatement.setInt(1,reservationId);

            ResultSet resultSet=preparedStatement.executeQuery();

            while (resultSet.next()){
                int roomNumber=resultSet.getInt("room_number");
                System.out.println("The Room Number for reservation id"+reservationId+" is:"+roomNumber);
            }
            resultSet.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
    private static void updateReservation(Scanner scanner,Connection connection) throws SQLException {
        System.out.print("Enter Reservation id you want to Update: ");
        int reservationId=scanner.nextInt();

        scanner.nextLine();
        //        Checking if reservation exists
        if(!reservationExists(connection, reservationId)){
            System.out.println("Reservation do not exist");
            return;
        }

        System.out.print("Enter updated Guest name: ");
        String guest_name=scanner.nextLine();

        System.out.print("Enter updated Room Number: ");
        int room_number=scanner.nextInt();

        System.out.print("Enter updated Contact Number: ");
        String contact_number=scanner.next();

        String query="UPDATE reservations SET guest_name=?, room_number=?, contact_number=? WHERE reservation_id=?";

        try(PreparedStatement preparedStatement= connection.prepareStatement(query)){
            preparedStatement.setString(1,guest_name);
            preparedStatement.setInt(2,room_number);
            preparedStatement.setString(3,contact_number);
            preparedStatement.setInt(4,reservationId);

            int rowsAffected=preparedStatement.executeUpdate();

            if (rowsAffected>0){
                System.out.println("Update successful!");
            }else{
                System.out.println("Update failed!");
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }

    }
    private static void deleteReservation(Scanner scanner,Connection connection) throws SQLException {
        System.out.print("Enter Reservation id you want to Delete: ");
        int reservationId=scanner.nextInt();

        scanner.nextLine();
        //        Checking if reservation exists
        if(!reservationExists(connection, reservationId)){
            System.out.println("Reservation do not exist");
            return;
        }


        String query="DELETE FROM reservations WHERE reservation_id=?";
        try(PreparedStatement preparedStatement= connection.prepareStatement(query)){

            preparedStatement.setInt(1,reservationId);
            int rowsAffected=preparedStatement.executeUpdate();

            if (rowsAffected>0){
                System.out.println("Deletion successful!");
            }else{
                System.out.println("Deletion failed!");
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }

    }
    private static void exit() throws InterruptedException {
        try {
            System.out.print("Existing System");
            int i = 5;
            while (i != 0) {
                System.out.print(".");
                Thread.sleep(450);
                i--;
            }
            System.out.println();
            System.out.println("Thanks for using The System!");
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
    private static  boolean reservationExists(Connection connection,int id) throws SQLException {
        String query="SELECT reservation_id FROM reservations WHERE reservation_id=?";

        try(PreparedStatement preparedStatement=connection.prepareStatement(query)){
            preparedStatement.setInt(1,id);
            ResultSet resultSet=preparedStatement.executeQuery();
            return resultSet.next();//returns a boolean

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}
