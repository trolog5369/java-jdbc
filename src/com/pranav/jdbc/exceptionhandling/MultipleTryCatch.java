package com.pranav.jdbc.exceptionhandling;

import java.util.Scanner;

//    There can be multiple try and catch block inside a block of code also nested try catch blocks

public class MultipleTryCatch {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        In the following code there are 2 exceptions ie Arithmetic Exception and ArrayOutOfBoundException
//        Hence we will write multiple catch blocks
//        int arr[] =new int[5];
//        arr[6]=10/0;

        int arr[] = new int[5];
        try {
            arr[6] = 10 / 0;
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
//        / by zero
//        As first the 10/0 is computed hence we get the Arithmetic Exception
//        as the program stops after finding this Exception

    }
}

