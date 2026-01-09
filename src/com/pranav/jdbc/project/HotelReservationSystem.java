package com.pranav.jdbc.project;

import java.sql.*;
import java.util.Scanner;

public class HotelReservationSystem {
    private static final String url = "jdbc:mysql://localhost:3306/hotel_db";
    private static final String username = "your_username";
    private static final String password = "your_password";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Scanner scanner = new Scanner(System.in);


            while (true) {
                System.out.println();
                System.out.println("Welcome to Hotel Reservation System");
                System.out.println("Please select your option: ");
                System.out.println("1. Reserve a room");
                System.out.println("2. View reservations");
                System.out.println("3. Get room no");
                System.out.println("4. Update reservations");
                System.out.println("5. Delete reservations");
                System.out.println("0. Exit");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        reserveRoom(scanner, connection);
                        break;
                    case 2:
                        viewReservation(scanner, connection);
                        break;
                    case 3:
                        getRoomNumber(scanner, connection);
                        break;
                    case 4:
                        updateReservation(scanner, connection);
                        break;
                    case 5:
                        deleteReservation(scanner, connection);
                        break;
                    case 0:
                        Exit();
                        scanner.close();
                        return;
                    default:
                        System.out.println("Enter a valid choice. Try again!");
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void reserveRoom(Scanner scanner,Connection connection) {
        System.out.println("Enter Guest name: ");
        String guestName = scanner.next();

        System.out.println("Enter room number: ");
        int roomNumber = scanner.nextInt();

        System.out.println("Enter contact number: ");
        String contactNumber = scanner.next();

        String sql = "INSERT INTO reservations (guest_name, room_number, contact_number) " +
                "VALUES('" + guestName + "'," + roomNumber + ",'" + contactNumber + "')";

        try (Statement statement=connection.createStatement()) {
            int rowsAffected = statement.executeUpdate(sql);
            if (rowsAffected > 0) {
                System.out.println("Reservation successful");
            } else {
                System.out.println("Reservation failed!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void viewReservation(Scanner scanner, Connection connection) throws SQLException {
        String query = "SELECT reservation_id, guest_name, room_number, contact_number, reservation_date FROM reservations;";
        try (Statement statement=connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query)) {
            System.out.println("Current Reservation: ");

            while (resultSet.next()) {
                int reservationID = resultSet.getInt("reservation_id");
                String guestName = resultSet.getString("guest_name");
                int roomNumber = resultSet.getInt("room_number");
                String contactNumber = resultSet.getString("contact_number");
                String reservationDate = resultSet.getTimestamp("reservation_date").toString();

                System.out.println("Your reservation ID is: " + reservationID);
                System.out.println("Your guest name is: " + guestName);
                System.out.println("Your room Number is: " + roomNumber);
                System.out.println("Your Contact number is: " + contactNumber);
                System.out.println("Your reservation date is: " + reservationDate);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }

    private static void getRoomNumber(Scanner scanner, Connection connection) {
        System.out.println("Enter reservation id: ");
        int reservationId = scanner.nextInt();
        System.out.println("Enter guest name: ");
        String guestName = scanner.next();

        String sql = "SELECT room_number FROM reservations " +
                "WHERE reservation_id = " + reservationId + " AND guest_name = '" + guestName + "';";

        try (Statement statement=connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)) {
            if (resultSet.next()) {
                int roomNumber = resultSet.getInt("room_number");
                System.out.println("The Room number for reservation id: " + reservationId + " and guest name: " + guestName +
                        " is: " + roomNumber);
            } else {
                System.out.println("Reservation not found for given ID an guest name!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void updateReservation(Scanner scanner, Connection connection) throws SQLException {
        System.out.println("Enter the ID you want to update: ");
        int reservationId = scanner.nextInt();

        if (!reservationExists(connection, reservationId)) {
            System.out.println("Reservation not found for given ID.");
            return;
        }

        System.out.println("Enter new guest name: ");
        String newGuestName = scanner.next();
        System.out.println("Enter new room number: ");
        int newRoomNumber = scanner.nextInt();
        System.out.println("Enter new contact number ");
        String newContactNumber = scanner.next();

        String sql = "UPDATE reservations SET guest_name='" + newGuestName + "'," +
                "room_number = " + newRoomNumber + "," +
                "contact_number = '" + newContactNumber + "' " +
                "WHERE reservation_id= " + reservationId;

        try (Statement statement=connection.createStatement()) {
            int rowsAffected = statement.executeUpdate(sql);

            if (rowsAffected > 0) {
                System.out.println("Reservation updated successfully!");
            } else {
                System.out.println("Inundation failed!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void deleteReservation(Scanner scanner, Connection connection) {
        System.out.println("Enter the id you want to delete: ");
        int deleteId = scanner.nextInt();

        if (!reservationExists(connection, deleteId)) {
            System.out.println("Reservation not found for given ID.");
            return;
        }

        String sql = "DELETE FROM reservations WHERE reservation_id= " + deleteId;

        try (Statement statement=connection.createStatement()) {
            int rowsAffected = statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    private static boolean reservationExists(Connection connection, int id) {
        String sql = "SELECT reservation_id FROM reservations WHERE reservation_id= " + id;

        try (Statement statement=connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)) {
            return resultSet.next(); //if there's a result,reservation exists
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;//Handel database errors as needed
        }
    }

    private static void Exit() throws InterruptedException {
        System.out.println("Existing system");
        int i = 5;
        while (i != 0) {
            System.out.print(".");
            Thread.sleep(450);
            i--;
        }
        System.out.println();
        System.out.println("Thanks for using Hotel Reservation System!");
    }
}