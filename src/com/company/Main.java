package com.company;


import java.io.IOException;
import java.util.Scanner;

public class Main {
        public Main() throws IOException{
        }
         private final Scanner scanner = new Scanner(System.in);
         //private final Loans loan = new Loans();
         private final LoanReader loanReader = new LoanReader();

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.start();
    }

    private void start(){
        boolean quit = false;
        int choice;
        printInstructions();
        //loanReader.loanPrint();

        while (!quit){
                System.out.println("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Scanner nextline call to clear input buffer

            switch (choice){
                case 0:
                    printInstructions();
                    break;
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:
                    quit = true;
                    System.out.println("Program has terminated");
                    break;
            }
        }
    }

    private static void printInstructions(){
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To print the list of Items.");
        System.out.println("\t 2 - To add an item to the list.");
        System.out.println("\t 3 - To modify an item in the list.");
        System.out.println("\t 4 - To remove an item from the list.");
        System.out.println("\t 5 - To search for an item in the list.");
        System.out.println("\t 6 - TO quit the application.");
    }
}
