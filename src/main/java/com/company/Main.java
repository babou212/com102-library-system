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

    private void start() throws FileNotFoundException {
        boolean quit = false;
        int menu;
        UserReader.userConverter(); // Calling the classes and methods to populate object attributes with data at start
        List<Item> item = ItemReader.itemConverter();
        List<Loan> loan = LoanReader.loanConverter();
        List<User> user = UserReader.userConverter();
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
                    item.forEach(System.out::println);
                    break;
                case 2:
                    loan.forEach(System.out::println);
                    break;
                case 3:
                    user.forEach(System.out::println);
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

    private static void printInstructions(){
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
