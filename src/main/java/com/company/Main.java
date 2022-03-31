package com.company;

import com.company.service.LoanService;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 // * Main Java class for controlling the program
 // * Author Dylan Cree
 */

public class Main {
    private final Scanner scanner = new Scanner(System.in);
    private final LoanService loanService = new LoanService();

    public Main() throws FileNotFoundException {
    }

    public static void main(String[] args) throws IOException, CsvRequiredFieldEmptyException,
            CsvDataTypeMismatchException {
        Main main = new Main();
        main.start();
    }

    private void start() throws CsvRequiredFieldEmptyException, CsvDataTypeMismatchException,
            IOException { // Method to control the operation of the program
        boolean quit = false;
        int menu = 0;

        printInstructions(); // Method Call to print program instructions

        while (!quit) {
                System.out.println("Enter your choice: ");

                if(scanner.hasNextInt()) {
                    menu = scanner.nextInt();
                }else {
                    System.out.println("Please enter a valid option");
                    scanner.next(); // Scanner next call to clear input buffer
                }

            switch (menu) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    loanService.printUsers();
                    break;
                case 2:
                    loanService.issueLoan();
                    break;
                case 3:
                    loanService.renewLoan();
                    break;
                case 4:
                    loanService.returnItem();
                    break;
                case 5:
                    loanService.printLoans();
                    System.out.println();
                    loanService.printItems();
                    break;
                case 6:
                    loanService.writeLoan();
                    quit = true;
                    System.out.println("Program has terminated");
                    scanner.close(); // CLose scanner once program has terminated
                    break;
            }
        }
    }

    private void printInstructions() {  // Method to print menu options to the user
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print menu options");
        System.out.println("\t 1 - To print the list of Users");
        System.out.println("\t 2 - To Issue new loan");
        System.out.println("\t 3 - To renew loan");
        System.out.println("\t 4 - To return item");
        System.out.println("\t 5 - To view all items on loan and all items held");
        System.out.println("\t 6 - TO quit the application");
    }
}
