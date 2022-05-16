package com.company;

import com.company.service.SystemService;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 // * Main Java class for controlling the program
 // * Author Dylan Cree B00826872
 */

public class Main {
    private final Scanner scanner = new Scanner(System.in);
    private final SystemService systemService = new SystemService();

    public Main() throws FileNotFoundException {
        // FileNotFoundException Exception for class
    }

    public static void main(String[] args) throws IOException, CsvRequiredFieldEmptyException,
            CsvDataTypeMismatchException {
        Main main = new Main();
        main.programStart();
    }
                                                                                          
    private void programStart() throws IOException, CsvRequiredFieldEmptyException,  // Method to control the operation of the program
            CsvDataTypeMismatchException{ 
        boolean isQuit = false;
        int menu = 0;

        printInstructions(); // Method Call to print program instructions

        while (!isQuit) {
                System.out.println("Enter your choice: ");

                if(scanner.hasNextInt()) {   // Validation to ensure user cannot crash the program by passing incorrect data type
                    menu = scanner.nextInt();
                }else {
                    System.out.println("\nPlease enter a valid option");
                    scanner.next(); // Scanner next call to clear input buffer
                }

            switch (menu) {  // Switch statement to control program 
                case 0:
                    printInstructions();
                    break;
                case 1:
                    systemService.issueLoan();
                    break;
                case 2:
                    systemService.renewLoan();
                    break;
                case 3:
                    systemService.returnItem();
                    break;
                case 4:
                    systemService.printLoans();
                    break;
                case 5:
                    systemService.printItems();
                    break;
                case 6:
                    systemService.writeLoan();
                    isQuit = true;
                    System.out.println("User has terminated the program");
                    scanner.close(); // CLose scanner once program has terminated
                    break;
                default:
                    System.out.println("Program Error has occurred :(, please try again");
            }
        }
    }

    private void printInstructions() {  // Method to print menu options to the user
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print menu options");
        System.out.println("\t 1 - To Issue new loan");
        System.out.println("\t 2 - To renew loan");
        System.out.println("\t 3 - To return item");
        System.out.println("\t 4 - To view all items on loan");
        System.out.println("\t 5 - TO view all items held by library");
        System.out.println("\t 6 - TO quit the application");
    }
}
