package com.company;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    private final Scanner scanner = new Scanner(System.in);
    private final List<Item> items = ItemReader.itemConverter();
    private final List<Loan> loans = LoanReader.loanConverter();
    private final List<User> users = UserReader.userConverter();

    public Main() throws FileNotFoundException {
    }

    public static void main(String[] args) throws FileNotFoundException {
        Main main = new Main();
        main.start();
    }

    private void start() { // Method to control the operation of the program
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
                    items.forEach(System.out::println);  // Printing stream to print all list objects on new line
                    break;
                case 2:
                    loans.forEach(System.out::println);
                    break;
                case 3:
                    users.forEach(System.out::println);
                    break;
                case 4:
                    issueLoan();
                    break;
                case 5:
                    System.out.println("Test---");
                    break;
                case 6:
                    returnLoan();
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

    private void issueLoan() {
        System.out.println("Please enter userId");
        String userId = scanner.nextLine();
        System.out.println("Please enter item barcode");
        String barcode = scanner.nextLine();

        if(users.stream().anyMatch(user -> user.getUserId().equals(userId))
                && items.stream().anyMatch(item -> item.getBarcode().equals(barcode))){

            System.out.println("Enter current date in dd/mm/yr format");
            String issueDate = scanner.nextLine();
            System.out.println("Please enter due date");
            String dueDate = scanner.nextLine();
            int numRenews = 0;

            Loan loan = new Loan(barcode, userId, issueDate, dueDate, numRenews);
            loans.add(loan);
            System.out.println(loan);
            loans.forEach(System.out::println);
        }else {
            System.out.println("userId or barcode not found");
        }
    }

    private void returnLoan(){
        System.out.println("Please enter barcode for the loan you wish to remove");
        String barcode = scanner.nextLine();

        if (loans.stream().anyMatch(loans -> loans.getBarcode().equals(barcode))){
            loans.removeIf(loans -> loans.getBarcode().equals(barcode));
            loans.forEach(System.out::println);
        }
    }
}
