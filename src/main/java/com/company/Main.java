package com.company;

import com.company.service.LoanService;

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

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.start();
    }

    private void start() { // Method to control the operation of the program
        boolean quit = false;
        int menu = 0;

        printInstructions(); // Method Call to print program instructions

        while (!quit) {
                System.out.println("Enter your choice: ");

                if(scanner.hasNextInt()) {
                    menu = scanner.nextInt();
                }else {
                    System.out.println("\nPlease enter a valid option");
                    scanner.next(); // Scanner next call to clear input buffer
                }

            switch (menu) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    loanService.issueLoan();
                    break;
                case 2:
                    loanService.renewLoan();
                    break;
                case 3:
                    loanService.returnItem();
                    break;
                case 4:
                    loanService.printLoans();
                    System.out.print("\n");
                    loanService.printItems();
                    break;
                case 5:
                    loanService.writeLoan();
                    quit = true;
                    System.out.println("User has terminated the program");
                    scanner.close(); // CLose scanner once program has terminated
                    break;
            }
        }
    }

    private void printInstructions() {  // Method to print menu options to the user
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print menu options");
        System.out.println("\t 1 - To Issue new loan");
        System.out.println("\t 2 - To renew loan");
        System.out.println("\t 3 - To return item");
        System.out.println("\t 4 - To view all items on loan and all items held by library");
        System.out.println("\t 5 - TO quit the application");
    }
}
