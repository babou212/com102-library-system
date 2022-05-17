package com.company.service;

import com.company.domain.Item;
import com.company.domain.Loan;
import com.company.domain.User;
import com.company.util.CsvReader;
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
import java.util.List;
import java.util.stream.Collectors;

/**
 // * Java Loan service class
 // * Author Dylan Cree B00826872
 */

public class LoanService extends CsvReader{
    private final List<Item> items = CsvReader.csvConverter("src/main/resources/ITEMS.csv", Item.class);
    private final List<Loan> loans = CsvReader.csvConverter("src/main/resources/LOANS.csv", Loan.class);
    private final List<User> users = CsvReader.csvConverter("src/main/resources/USERS.csv", User.class);

    public LoanService() throws FileNotFoundException {
        super();
        // FileNotFoundException Exception for constructor
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void printLoans() {
        loans.forEach(System.out::println);
    }

    public void printItems() {
        items.forEach(System.out::println);
    }

    public void issueLoan(String userId, String barcode) {
        if (users.stream().anyMatch(user -> user.getUserId().equals(userId))
                && items.stream().anyMatch(item -> item.getBarcode().equals(barcode))) {
            LocalDate issueDate = LocalDate.now();
            LocalDate currentDate = LocalDate.now();
            int numRenews = 0;
            List<Item> results = items.stream().filter(item -> item.getBarcode()
                    .equals(barcode)).collect(Collectors.toList());

            if(results.get(0).getType().equals("Book")) {
                LocalDate dueDate = currentDate.plus(4, ChronoUnit.WEEKS);
                Loan loan = new Loan(barcode, userId, issueDate, dueDate, numRenews);
                loans.add(loan);
                System.out.println("New book loan created");
                loans.forEach(System.out::println);
            } else if (results.get(0).getType().equals("Multimedia")){
                LocalDate dueDate = currentDate.plus(1, ChronoUnit.WEEKS);
                Loan loan = new Loan(barcode, userId, issueDate, dueDate, numRenews);
                loans.add(loan);
                System.out.println("New multimedia loan created");
                loans.forEach(System.out::println);
            }
        } else {
            System.out.println("userId or barcode invalid");
        }
    }

    public void returnItem(String barcode) {
        LocalDate currentDate = LocalDate.now();

        if (loans.stream().anyMatch(loans -> loans.getBarcode().equals(barcode))) {
            List<Loan> results = loans.stream().filter(item -> item.getBarcode()
                    .equals(barcode)).collect(Collectors.toList());

            if (results.get(0).getDueDate().isAfter(currentDate) || results.get(0).getDueDate().equals(currentDate)) {
                loans.removeIf(loans -> loans.getBarcode().equals(barcode));
                System.out.println("Item has been returned");
                loans.forEach(System.out::println);

            } else if (results.get(0).getDueDate().isBefore(currentDate)) {
                System.out.println("Date outside of return window");
            }
        } else {
            System.out.println("Barcode " + barcode + " was invalid or not currently on loan");
        }
    }

    public void writeLoan() throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        String filePath = "src/main/resources/LOANS.csv";

            Writer writer = new FileWriter(filePath);
            StatefulBeanToCsv<Loan> beanToCsv = new StatefulBeanToCsvBuilder<Loan>(writer).build();
            beanToCsv.write(loans);
            writer.close();   
    } 

    public void renewLoan(String barcode) {
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
                } else if (results.get(0).getType().equals("Multimedia") && loan.getBarcode().equals(barcode) &&
                        loan.getNumRenews() < 2) {
                    LocalDate dueDate = currentDate.plus(1, ChronoUnit.WEEKS);
                    loan.setDueDate(dueDate);
                    loan.setNumRenews(loan.getNumRenews() + 1);
                    System.out.println("Multimedia loan renewed");
                } else if (loan.getBarcode().equals(barcode)&& quitElseIf[0] == 0){
                    System.out.println("Loan cannot be renewed");
                    quitElseIf[0]++;
                }
            });
        } else {
            System.out.println("Barcode Invalid or item not currently on loan");
        }
    }
}
