package com.pranav.jdbc.exceptionhandling;

import java.util.Scanner;

public class NestedTryCatch {
    static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int arr[]=new int[5];

        try{
            System.out.println("I am in the first try block!!!");
            try{
                arr[6]=10;
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }catch(Exception e){
            System.out.println("Lol");
        }
//        I am in the first try block!!!
//        Index 6 out of bounds for length 5
    }
}
