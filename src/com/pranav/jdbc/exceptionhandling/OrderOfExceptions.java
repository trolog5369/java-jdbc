package com.pranav.jdbc.exceptionhandling;

//It's a good practice if write the subclass class exception first instead of superclass
//INSTEAD of Superclass first then Subclass
public class OrderOfExceptions {
    static void main(String[] args) {
//        try {
//            int x = 10 / 0;
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }catch (ArithmeticException e){
//            System.out.println(e.getMessage());
//        }
//        java: exception java.lang.ArithmeticException has already been caught

//        We write the Parent class first then the Child class which is senseless as we already have caught the exception
//        hence the error

        try {
            int x = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
//        / by zero
//        Now we have written the Child class first instead of Parent which is good practice as well as correct
    }
}
