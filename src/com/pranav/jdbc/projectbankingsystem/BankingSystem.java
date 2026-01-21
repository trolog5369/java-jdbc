package com.pranav.jdbc.projectbankingsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class BankingSystem {
//    Database credentials!
    private static final String url="jdbc:mysql://localhost:3306/banking_system";
    private static final String username="root";
    private static final String password="Pranav@9615";

    static void main(String[] args) throws ClassNotFoundException, SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            String email;
            long account_number;
            Connection connection = DriverManager.getConnection(url, username, password);
            Scanner scanner=new Scanner(System.in);

//            We have passed the instance of scanner and connection into the constructor of the classes
//            Instead of creating new instance for every class of connection and scanner

            User user=new User(connection,scanner);
            Accounts accounts=new Accounts(connection,scanner);
            AccountManager accountManager=new AccountManager(connection,scanner);


            while (true) {
                System.out.println("Welcome to banking System!");
                System.out.println();
                System.out.println("1.Register");
                System.out.println("2.Login");
                System.out.println("3.Exit");
                System.out.println("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice){
                    case 1:
                        user.register();
                        break;
                    case 2:
                        email=user.login();
                        if (email!=null){
                            System.out.println("Login successful!");

                            if (accounts.account_exist(email)){
                                System.out.println("1.Open a New Bank Account ");
                                System.out.println("2.Exit ");

                                if (scanner.nextInt()==1){
                                    account_number= accounts.openAccount(email);
                                    System.out.println("Account Created!");
                                    System.out.println("Your account number is: "+account_number);
                                }
                            }else {
                                break;
                            }
                            account_number=accounts.getAccountNumber(email);
                            int choice2=0;
                            while (choice2!=5){
                                System.out.println();
                                System.out.println("1.Debit Money");
                                System.out.println("2.Credit Money");
                                System.out.println("3.Transfer Money");
                                System.out.println("4.Check Balance");
                                System.out.println("5.Log out");
                                System.out.println("Enter your choice");
                                choice2=scanner.nextInt();
                                switch (choice2){
                                    case 1:
                                        accountManager.debit_money(account_number);
                                        break;
                                    case 2:
                                        accountManager.credit_money(account_number);
                                        break;
                                    case 3:
                                        accountManager.transfer_money(account_number);
                                        break;
                                    case 4:
                                        accountManager.check_balance(account_number);
                                        break;
                                    case 5:
                                        break;
                                    default:
                                        System.out.println("Enter a valid choice");
                                        break;

                                }

                            }
                        }else {
                            System.out.println("Login failed!");
                            System.out.println("Incorrect email or password");
                        }
                        break;
                    case 3:
                        System.out.print("Existing System");
                        int i=5;
                        while (i!=0){
                            System.out.print(".");
                            Thread.sleep(450);
                            i--;
                        }
                        System.out.println();
                        System.out.println("Thanks for using banking system!");
                        return;
                    default:
                        System.out.println("Please enter a valid choice!");
                        break;
                }
            }

        } catch (SQLException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
