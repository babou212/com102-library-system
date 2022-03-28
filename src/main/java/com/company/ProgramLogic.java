package com.company;

import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Scanner;

/**
 // * Java class to provide the logic for manipulating program data
 // * Author Dylan Cree
 */

public class ProgramLogic {
    private final Scanner scanner = new Scanner(System.in);
    private final List<Item> items = ItemReader.itemConverter();
    private final List<Loan> loans = LoanReader.loanConverter();
    private final List<User> users = UserReader.userConverter();

    public ProgramLogic() throws FileNotFoundException {
    }

    public void printInstructions(){  // Method to print menu options to the user
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

    public void printLoans(){
        loans.forEach(System.out::println); // Printing stream to print all list objects on new line
    }

    public void printItems(){
        items.forEach(System.out::println);
    }

    public void printUsers(){
        users.forEach(System.out::println);
    }

    public void issueLoan() {
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

    public void returnLoan(){
        System.out.println("Please enter barcode for the loan you wish to remove");
        String barcode = scanner.nextLine();

        if (loans.stream().anyMatch(loans -> loans.getBarcode().equals(barcode))){
            loans.removeIf(loans -> loans.getBarcode().equals(barcode));
            loans.forEach(System.out::println);
            System.out.println("Loan has been removed from the list");
        }else {
            System.out.println("Barcode " + barcode + " was invalid or there are no active loans please try again");
        }
    }

    public void writeLoan() throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        String filePath = "/home/dylanc/IdeaProjects/library_System/src/main/java/LOANS.csv";

        Writer writer = new FileWriter(filePath);
        StatefulBeanToCsv<Loan> beanToCsv = new StatefulBeanToCsvBuilder<Loan>(writer).build();
        beanToCsv.write(loans);
        writer.close();
    }
}
