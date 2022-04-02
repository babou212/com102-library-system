package com.company.service;

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
    void returnItemShouldRemoveLoanIfDueIsAfterOrEqualCurrentDate() {
        String barcode = "169865085";
        String userId = "B00359213";
        loanService.issueLoan(userId, barcode);
        loanService.returnItem(barcode);
        List<Loan> result = loanService.getLoans().stream().filter(loan -> loan.getBarcode().equals(barcode)&&
                loan.getUserId().equals(userId)).collect(Collectors.toList());

        assertEquals(0, result.size());
    }

    @Test
    void returnItemShouldNotRemoveLoanIfDueIsBeforeCurrentDate() {
        String barcode = "340096334";

        loanService.returnItem(barcode);
        List<Loan> result = loanService.getLoans().stream().filter(loan -> loan.getBarcode().equals(barcode))
                .collect(Collectors.toList());

        assertEquals(1, result.size());
    }

    @Test
    void renewLoanShouldRenewTypeBookBy2Weeks() {
        // Given
        String barcode = "340096334";

        //When
        loanService.renewLoan(barcode);
        List<Loan> result = loanService.getLoans().stream().filter(loan -> loan.getBarcode().equals(barcode))
                .collect(Collectors.toList());
        Loan resultObj = result.get(0);

        //Then
        assertEquals(1, resultObj.getNumRenews());
        assert(resultObj.getDueDate().isAfter(LocalDate.now().plus(13, ChronoUnit.DAYS)));
    }

    @Test
    void renewLoanShouldRenewTypeMultimediaBy1Week() {
        String barcode = "433849131";

        loanService.renewLoan(barcode);
        List<Loan> result = loanService.getLoans().stream().filter(loan -> loan.getBarcode().equals(barcode))
                .collect(Collectors.toList());
        Loan resultObj = result.get(0);

        assertEquals(1, resultObj.getNumRenews());
        assert(resultObj.getDueDate().isAfter(LocalDate.now().plus(6, ChronoUnit.DAYS)));
    }
}
