package com.pranav.jdbc.exceptionhandling;

import java.util.Scanner;

public class Exceptions {
    static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int dividend=scanner.nextInt();
        int divisor=scanner.nextInt();
//        int result =dividend/divisor;
//        System.out.println("Your answer is:" +result);

//        If the user input the numbers code works
//        10
//        5
//        2

//        If he inputs 0 it throws an exception
//        10
//        0
//        Exception in thread "main" java.lang.ArithmeticException: / by zero
//        at com.pranav.jdbc.exceptionhandling.Exceptions.main(Exceptions.java:10)

//        To deal with such exception we use exception handling
        try{
            int result =dividend/divisor;
            System.out.println("Your answer is:" +result);
        }
        catch (ArithmeticException e){
            System.out.println(e.getMessage());
        }
//        10
//        0
//        / by zero
    }
//    There can be multiple try and catch block inside a block of code also nested try catch blocks
}
