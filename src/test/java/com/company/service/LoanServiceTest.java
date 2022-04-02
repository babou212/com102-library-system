package com.company.service;

import com.company.domain.Item;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class LoanServiceTest {
    private Item item1;
    private Item item2;

    @BeforeAll
    static void setup(){
        Item item1 = new Item("169865085", "", "", "Book", "");
        Item item2 = new Item("433849131", "", "", "Multimedia", "");
        System.out.println("Test running...");
    }

    @Test
    void printLoans()  {

    }

    @Test
    void printItems() {
    }

    @Test
    void issueLoan_TypeBook() {
        String userId = "B00000464";
        String barcode = "169865085";

    }

    @Test
    void issueLoan_TypeMultimedia() {
        String userId = "B00000464";
        String barcode = "169865085";

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
