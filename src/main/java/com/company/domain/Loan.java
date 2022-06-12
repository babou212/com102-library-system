package com.company.domain;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;

import java.io.Serializable;
import java.time.LocalDate;

public final class Loan implements Serializable {

    @CsvBindByName(column = "Barcode")
    private String barcode;

    @CsvBindByName(column = "User_id")
    private String userId;

    @CsvBindByName(column = "Issue_Date")
    @CsvDate("dd/MM/yyyy")
    private LocalDate issueDate;

    @CsvBindByName(column = "Due_Date")
    @CsvDate("dd/MM/yyyy")
    private LocalDate dueDate;

    @CsvBindByName(column = "numRenews")
    private int numRenews;

    public Loan() {
    }

    public Loan(String barcode, String userId, LocalDate issueDate, LocalDate dueDate, int numRenews) {
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
                ", issueDate='" + issueDate.getDayOfMonth() + "/" + issueDate.getMonth().getValue()
                + "/" + issueDate.getYear() + '\'' +
                ", dueDate='" + dueDate.getDayOfMonth() + "/" + dueDate.getMonth().getValue() + "/"
                + dueDate.getYear() +  '\'' +
                ", numRenews=" + numRenews +
                '}';
    }

    public String getBarcode() {
        return barcode;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public int getNumRenews() {
        return numRenews;
    }

    public void setNumRenews(int numRenews) {
        this.numRenews = numRenews;
    }

    public String getUserId() {
        return userId;
    }
}
