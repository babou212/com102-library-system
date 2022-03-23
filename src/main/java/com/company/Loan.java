package com.company;

import com.opencsv.bean.CsvBindByName;

public class Loan {
    @CsvBindByName(column = "Barcode")
    private String barcode;

    @CsvBindByName(column = "User_id")
    private String userId;

    @CsvBindByName(column = "Issue_Date")
    private String issueDate;

    @CsvBindByName(column = "numRenews")
    private int numRenews;

    @Override
    public String toString() {
        return "Loan{" +
                "barcode='" + barcode + '\'' +
                ", userId='" + userId + '\'' +
                ", issueDate='" + issueDate + '\'' +
                ", numRenews=" + numRenews +
                '}';
    }
}
