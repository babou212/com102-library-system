package com.company.service;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public final class ProgramService {
    private final Scanner scanner = new Scanner(System.in);
    private final SystemService systemService = new SystemService();

    public ProgramService() throws FileNotFoundException {
        // FileNotFoundException Exception for constructor
    }

    public void programStart() throws IOException, CsvRequiredFieldEmptyException,
            CsvDataTypeMismatchException {
        boolean isQuit = false;
        int menu = 0;

        printInstructions();

        while (!isQuit) {
            System.out.println("Enter your choice: ");

            if(scanner.hasNextInt()) {
                menu = scanner.nextInt();
            }else {
                System.out.println("\nPlease enter a valid option");
                scanner.next();
            }

            switch (menu) {
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
                    scanner.close();
                    break;
            }
        }
    }

    private void printInstructions() {
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
