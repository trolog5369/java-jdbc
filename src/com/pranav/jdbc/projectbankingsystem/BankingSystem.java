package com.pranav.jdbc.projectbankingsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class BankingSystem {
    private static final String url="jdbc:mysql://localhost:3306/banking_system";
    private static final String username="your_username";
    private static final String password="your_password";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            Scanner scanner = new Scanner(System.in);

            User user = new User(connection, scanner);
            Accounts accounts = new Accounts(connection, scanner);
            AccountManager accountManager = new AccountManager(connection, scanner);

            String email;
            long account_number;

            while (true) {
                System.out.println("\n*** Welcome to Banking System ***");
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        user.register();
                        break;
                    case 2:
                        email = user.login();
                        if (email != null) {
                            System.out.println("\nLogin successful!");
                            if (!accounts.account_exist(email)) {
                                System.out.println("1. Open a New Bank Account");
                                System.out.println("2. Exit");
                                if (scanner.nextInt() == 1) {
                                    scanner.nextLine();
                                    account_number = accounts.openAccount(email);
                                    System.out.println("Account Created! Number: " + account_number);
                                } else {
                                    break;
                                }
                            }

                            account_number = accounts.getAccountNumber(email);
                            int choice2 = 0;
                            while (choice2 != 5) {
                                System.out.println("\n1. Debit\n2. Credit\n3. Transfer\n4. Balance\n5. Logout");
                                choice2 = scanner.nextInt();
                                scanner.nextLine();
                                switch (choice2) {
                                    case 1 -> accountManager.debit_money(account_number);
                                    case 2 -> accountManager.credit_money(account_number);
                                    case 3 -> accountManager.transfer_money(account_number);
                                    case 4 -> accountManager.check_balance(account_number);
                                }
                            }
                        } else {
                            System.out.println("Incorrect email or password!");
                        }
                        break;
                    case 3:
                        System.out.println("Exiting System...");
                        return;
                    default:
                        System.out.println("Enter valid choice!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}