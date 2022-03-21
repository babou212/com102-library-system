package com.company;

import java.util.Scanner;

public class Main {
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        Main main = new Main();
        main.start();
    }

    public void start(){
        boolean quit = false;
        int menu;
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

                    break;
                case 2:
                    LoanReader.readLoansCSV();
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
        System.out.println("\t 0 - To print menu options.");
        System.out.println("\t 1 - To print the list of Items.");
        System.out.println("\t 2 - To view current active loans");
        System.out.println("\t 3 - To modify an item in the list.");
        System.out.println("\t 4 - To remove an item from the list.");
        System.out.println("\t 5 - To search for an item in the list.");
        System.out.println("\t 6 - TO quit the application.");
    }
}
