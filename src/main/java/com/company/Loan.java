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

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public int getNumRenews() {
        return numRenews;
    }

    public void setNumRenews(int numRenews) {
        this.numRenews = numRenews;
    }
}
