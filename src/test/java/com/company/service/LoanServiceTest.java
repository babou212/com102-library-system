package com.company.service;

import com.company.domain.Item;

import com.company.domain.Loan;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoanServiceTest {
    private final LoanService loanService = new LoanService();

    LoanServiceTest() throws FileNotFoundException {
    }

    @Test
    void issueLoanShouldProperlyMapNewLoanIfCorrectBookDataIsPassed() {
       String barcode = "169865085";
       String userId = "B00359213";
       loanService.issueLoan(userId, barcode);
       List<Loan> result = loanService.getLoans().stream().filter(loan -> loan.getBarcode().equals(barcode)&&
               loan.getUserId().equals(userId)).collect(Collectors.toList());

       assertEquals(1, result.size());
    }

    @Test
    void issueLoanShouldNotAddNewLoanIfIncorrectDataIsPassed() {
        String userId = "B00000000";
        String barcode = "000000000";

        loanService.issueLoan(userId, barcode);
        List<Loan> result = loanService.getLoans().stream().filter(loan -> loan.getBarcode().equals(barcode)&&
                loan.getUserId().equals(userId)).collect(Collectors.toList());

        assertEquals(0, result.size());
    }

    @Test
    void issueLoanShouldProperlyMapNewLoanIfCorrectMultimediaDataIsPassed(){
        String barcode = "798764462";
        String userId = "B00359213";
        loanService.issueLoan(userId, barcode);
        List<Loan> result = loanService.getLoans().stream().filter(loan -> loan.getBarcode().equals(barcode)&&
                loan.getUserId().equals(userId)).collect(Collectors.toList());

        assertEquals(1, result.size());
    }

    @Test
    void returnItem_TypeBook() {
        String barcode = "169865085";
        LocalDate currentDate = LocalDate.now();

    }

    @Test
    void returnItem_TypeMultimedia() {
        String barcode = "169865085";
        LocalDate currentDate = LocalDate.now();

    }

    @Test
    void writeLoan() {

    }

    @Test
    void renewLoan_TypeBook() {

    }

    @Test
    void renewLoan_TypeMultimedia() {

    }
}
