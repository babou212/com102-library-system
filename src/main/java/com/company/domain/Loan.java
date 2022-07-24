package com.company.domain;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Data
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
}
