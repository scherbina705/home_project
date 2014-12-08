package com.mycompany.app;

import java.util.Scanner;

public class CalculatorConsoleApp {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        String operation;
        Double a,b,result;
        Scanner sc = new Scanner(System.in);
        do {
            //Print greetings;
            System.out.println("\nHello, this is demo version of calculator!");

            //Print operations;
            System.out.println("Available operations are: ");
            for(String availableOperation:calc.getOperations()){
                System.out.println("\"" + availableOperation + "\" ");
            }

            //Read operation
            System.out.println("Type your operation:");
            operation=sc.nextLine();
            if ("exit".equals(operation)) break;

            //Read values, perform operation, write it
            System.out.println("Enter 1st value");
            a=sc.nextDouble();
            System.out.println("Enter 2nd value");
            b=sc.nextDouble();
            try{
                result=calc.perform(operation,a,b);
                System.out.println(a+operation+b+"="+result);
            }catch (UnknownOperationException e){
                System.err.println(e.getMessage());
            }
        }while(true);
    }
}
