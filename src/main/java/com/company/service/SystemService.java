package com.company.service;

import java.io.FileNotFoundException;
import java.util.*;

/**
 // * Java service class
 // * Author Dylan Cree
 */

public class SystemService {
    private final Scanner scanner = new Scanner(System.in);
    private final LoanService loanService = new LoanService();

    public SystemService() throws FileNotFoundException {
    }

    public void printLoans() {
        loanService.printLoans();
    }

    public void printItems() {
        loanService.printItems();
    }

    public void issueLoan() {
        System.out.println("Please enter userId");
        String userId = scanner.nextLine();
        System.out.println("Please enter item barcode");
        String barcode = scanner.nextLine();

        loanService.issueLoan(userId, barcode);
    }

    public void returnItem() {
        System.out.println("Please enter barcode for the item you wish to remove");
        String barcode = scanner.nextLine();
        loanService.returnItem(barcode);
    }

    public void writeLoan() {
        loanService.writeLoan();
    }

    public void renewLoan() {
        System.out.println("Please enter barcode for loan renewal");
        String barcode = scanner.nextLine();
        loanService.renewLoan(barcode);
    }
}
