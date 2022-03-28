package com.company;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

/**
 // * Main Java class for controlling the program
 // * Author Dylan Cree
 */

public class Main {
    private final Scanner scanner = new Scanner(System.in);
    private final Service service = new Service();

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

        service.printInstructions(); // Method Call to print program instructions

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
                    service.printInstructions();
                    break;
                case 1:
                    service.printItems();
                    break;
                case 2:
                    service.printLoans();
                    break;
                case 3:
                    service.printUsers();
                    break;
                case 4:
                    service.issueLoan();
                    break;
                case 5:
                    System.out.println("Test---");
                    break;
                case 6:
                    service.returnLoan();
                    break;
                case 7:
                    System.out.println("test=====");
                    break;
                case 8:
                    service.writeLoan();
                    quit = true;
                    System.out.println("Program has terminated");
                    scanner.close(); // CLose scanner once program has terminated
                    break;
            }
        }
    }
}
