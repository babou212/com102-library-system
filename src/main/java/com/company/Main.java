package com.company;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 // * Main Java class for controlling the program
 // * Author Dylan Cree
 */

public class Main {
    private final Scanner scanner = new Scanner(System.in);
    private final ProgramLogic programLogic = new ProgramLogic();

    public Main() throws FileNotFoundException {
    }

    public static void main(String[] args) throws FileNotFoundException {
        Main main = new Main();
        main.start();
    }

    private void start() { // Method to control the operation of the program
        boolean quit = false;
        int menu = 0;

        printInstructions();

        while (!quit){
                System.out.println("Enter your choice: ");

                if(scanner.hasNextInt()){
                    menu = scanner.nextInt();
                }else {
                    System.out.println("Please enter a valid option");
                    scanner.next(); // Scanner next call to clear input buffer
                }

            switch (menu){
                case 0:
                    printInstructions();
                    break;
                case 1:
                    programLogic.printItems();
                    break;
                case 2:
                    programLogic.printLoans();
                    break;
                case 3:
                    programLogic.printUsers();
                    break;
                case 4:
                    programLogic.issueLoan();
                    break;
                case 5:
                    System.out.println("Test---");
                    break;
                case 6:
                    programLogic.returnLoan();
                    break;
                case 7:
                    System.out.println("test=====");
                    break;
                case 8:
                    quit = true;
                    System.out.println("Program has terminated");
                    scanner.close(); // CLose scanner once program has terminated
                    break;
            }
        }
    }

    private static void printInstructions(){  // Method to print menu options to the user
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print menu options");
        System.out.println("\t 1 - To print the list of Items");
        System.out.println("\t 2 - To view current active loans");
        System.out.println("\t 3 - To see list of current users");
        System.out.println("\t 4 - To issue new loan");
        System.out.println("\t 5 - To renew a loan");
        System.out.println("\t 6 - To record a return of an item");
        System.out.println("\t 7 - To view all items on loan and all items held");
        System.out.println("\t 8 - TO quit the application");
    }
}
