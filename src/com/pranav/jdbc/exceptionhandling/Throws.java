package com.pranav.jdbc.exceptionhandling;

public class Throws {
//    This method can throw exception hence we use throws keyword
//    Hence the programmer/tester gets to know that this function throws exception
    public static void division(int dividend, int divisor) throws ArithmeticException{
        System.out.println("The result is: "+dividend/divisor);
    }

    static void main(String[] args) {
        division(10,0);
//        Exception as divisor is 0
    }
}
