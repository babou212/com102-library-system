package com.company;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

/**
// * Java class to read LOANS.csv using openCSV library
// * Author Dylan Cree
 */

    public class LoanReader {
    public static List<Loan> loanConverter() throws FileNotFoundException {
        String filePath = "/home/dylanc/IdeaProjects/library_System/src/main/java/LOANS.csv";

        List<Loan> beans = new CsvToBeanBuilder<Loan>(new FileReader(filePath))
                .withType(Loan.class)
                .build()
                .parse();

        //beans.forEach(System.out::println);  // debug statement to check output was correct
        return beans;
    }
}
