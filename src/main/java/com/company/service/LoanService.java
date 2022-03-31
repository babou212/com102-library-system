package com.company.service;

import com.company.util.ItemReader;
import com.company.util.LoanReader;
import com.company.util.UserReader;
import com.company.domain.Item;
import com.company.domain.Loan;
import com.company.domain.User;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

/**
 // * Java class to provide the logic for manipulating program data
 // * Author Dylan Cree
 */

public class LoanService {
    private final Scanner scanner = new Scanner(System.in);
    private final List<Item> items = ItemReader.itemConverter();
    private final List<Loan> loans = LoanReader.loanConverter();
    private final List<User> users = UserReader.userConverter();

    public LoanService() throws FileNotFoundException {
    }

    public void printLoans() {
        loans.forEach(System.out::println); // Printing stream to print all list objects on new line
    }

    public void printItems() {
        items.forEach(System.out::println);
    }

    public void printUsers() {
        users.forEach(System.out::println);
    }

    public void issueLoan() {
        System.out.println("Please enter userId");
        String userId = scanner.nextLine();
        System.out.println("Please enter item barcode");
        String barcode = scanner.nextLine();

        if (users.stream().anyMatch(user -> user.getUserId().equals(userId))
                && items.stream().anyMatch(item -> item.getBarcode().equals(barcode))) {
            LocalDate issueDate = LocalDate.now();
            LocalDate currentDate = LocalDate.now();
            int numRenews = 0;

            if (items.stream().anyMatch(item -> item.getType().equals("Book"))) {
                LocalDate dueDate = currentDate.plus(2, ChronoUnit.WEEKS);
                Loan loan = new Loan(barcode, userId, issueDate, dueDate, numRenews);
                loans.add(loan);
                loans.forEach(System.out::println);
            } else {
                LocalDate dueDate = currentDate.plus(1, ChronoUnit.WEEKS);
                Loan loan = new Loan(barcode, userId, issueDate, dueDate, numRenews);
                loans.add(loan);
                loans.forEach(System.out::println);
            }
        } else {
            System.out.println("userId or barcode invalid");
        }
    }

    public void returnItem() {
        System.out.println("Please enter barcode for the item you wish to remove");
        String barcode = scanner.nextLine();

        LocalDate currentDate = LocalDate.now();

        if (loans.stream().anyMatch(loans -> loans.getBarcode().equals(barcode))&&
                (loans.stream().anyMatch(loans -> loans.getDueDate().isEqual(currentDate))||
                        loans.stream().anyMatch(loans -> loans.getDueDate().isAfter(currentDate)))) {

            loans.removeIf(loans -> loans.getBarcode().equals(barcode));
            loans.forEach(System.out::println);
            System.out.println("Item has been returned");

            } else if (loans.stream().anyMatch(loans -> loans.getBarcode().equals(barcode))
            && loans.stream().anyMatch(loans -> loans.getDueDate().isBefore(currentDate))){
                System.out.println("Date outside of return range");
            }else {
                System.out.println("Barcode " + barcode + "is invalid or the item is not on loan");
            }
    }

    public void writeLoan() throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        String filePath = "src/main/resources/LOANS.csv";

        Writer writer = new FileWriter(filePath);
        StatefulBeanToCsv<Loan> beanToCsv = new StatefulBeanToCsvBuilder<Loan>(writer).build();
        beanToCsv.write(loans);
        writer.close();
    }

    public void renewLoan() {
        System.out.println("Please enter barcode for loan renewal");
        String barcode = scanner.nextLine();

        if (loans.stream().anyMatch(loans -> loans.getBarcode().equals(barcode))) {
            LocalDate currentDate = LocalDate.now();
            List<Item> results = items.stream().filter(item -> item.getBarcode()
                    .equals(barcode)).collect(Collectors.toList());

            final int[] quitElseIf = {0};
            loans.forEach(loan -> {
                if (results.get(0).getType().equals("Book") && loan.getBarcode().equals(barcode)
                        && loan.getNumRenews() < 3) {
                    LocalDate dueDate = currentDate.plus(2, ChronoUnit.WEEKS);
                    loan.setDueDate(dueDate);
                    loan.setNumRenews(loan.getNumRenews() + 1);
                    System.out.println("Book loan renewed");
                } else if (results.get(0).getType().equals("Multimedia") && loan.getBarcode().equals(barcode)&&
                        loan.getNumRenews() < 2) {
                    LocalDate dueDate = currentDate.plus(1, ChronoUnit.WEEKS);
                    loan.setDueDate(dueDate);
                    System.out.println("Multimedia loan renewed");
                } else if (loan.getBarcode().equals(barcode)&& quitElseIf[0] == 0){
                    System.out.println("Loan has reached max renews");
                    quitElseIf[0]++;
                }
            });
        } else {
            System.out.println("Barcode Invalid or item not currently on loan");
        }
    }
}
