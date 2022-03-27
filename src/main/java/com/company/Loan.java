package com.company;

import com.opencsv.bean.CsvBindByName;

import java.io.Serializable;

/**
 // * Java beans data class for serialization and deserialization
 // * Author Dylan Cree
 */

public class Loan implements Serializable { // Serializable interface for java beans class

    @CsvBindByName(column = "Barcode")  // @CsvBindByName openCSV command
    private String barcode;

    @CsvBindByName(column = "User_id")
    private String userId;

    @CsvBindByName(column = "Issue_Date")
    private String issueDate;

    @CsvBindByName(column = "Due_Date")
    private String dueDate;

    @CsvBindByName(column = "numRenews")
    private int numRenews;

    public Loan() {  // No args constructor for java beans class
    }

    public Loan(String barcode, String userId, String issueDate, String dueDate, int numRenews) {
        this.barcode = barcode;
        this.userId = userId;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.numRenews = numRenews;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "barcode='" + barcode + '\'' +
                ", userId='" + userId + '\'' +
                ", issueDate='" + issueDate + '\'' +
                ", dueDate='" + dueDate + '\'' +
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

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public int getNumRenews() {
        return numRenews;
    }

    public void setNumRenews(int numRenews) {
        this.numRenews = numRenews;
    }
}
