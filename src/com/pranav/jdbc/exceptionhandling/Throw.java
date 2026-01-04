package com.pranav.jdbc.exceptionhandling;

import java.util.Scanner;

public class Throw {
    static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int age=scanner.nextInt();

        if (age<18){
//            System.out.println("You are not eligible for vote!");
            throw new RuntimeException("You are not eligible for vote!!");
        }
        else {
            System.out.println("You are eligible for vote!");
        }
//        By using the throw keyword we can make our custom exceptions
//        16
//        Exception in thread "main" java.lang.RuntimeException: You are not eligible for vote!!
//        at com.pranav.jdbc.exceptionhandling.Throw.main(Throw.java:12)
    }
}
