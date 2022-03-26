package com.company;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
        Main main = new Main();
        main.start();
    }

    private void start() throws FileNotFoundException { // Method to control the operation of the program
        boolean quit = false;
        int menu;
        List<Item> items = ItemReader.itemConverter(); // Calling the classes and methods to populate program with data
        List<Loan> loans = LoanReader.loanConverter();
        List<User> users = UserReader.userConverter();
        printInstructions();

        while (!quit){
                System.out.println("Enter your choice: ");
                menu = scanner.nextInt();
                scanner.nextLine(); // Scanner nextline call to clear input buffer

            switch (menu){
                case 0:
                    printInstructions();
                    break;
                case 1:
                    items.forEach(System.out::println);  // Printing stream to print all list objects on new line
                    break;
                case 2:
                    loans.forEach(System.out::println);
                    break;
                case 3:
                    users.forEach(System.out::println);
                    break;
                case 4:
                    System.out.println("Test--");
                    break;
                case 5:
                    System.out.println("Test---");
                    break;
                case 6:
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
        System.out.println("\t 3 - To =========================");
        System.out.println("\t 4 - To =========================");
        System.out.println("\t 5 - To =========================");
        System.out.println("\t 6 - TO quit the application");
    }
}
