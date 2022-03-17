package com.company;

import com.opencsv.exceptions.CsvValidationException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    private final Scanner scanner = new Scanner(System.in);
    private final Loans loan = new Loans();
    private final Users user = new Users();
    private final Items item = new Items();
    private final LoanReader loanReader = new LoanReader();

    public Main() throws IOException, CsvValidationException {
    }

    public static void main(String[] args) throws IOException, CsvValidationException {
        Main main = new Main();
        main.start();
    }

    private void start(){
        boolean quit = false;
        int choice;
        printInstructions();

        while (!quit){
                System.out.println("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine();

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
