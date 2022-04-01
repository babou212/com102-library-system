package com.company.util;

import com.company.domain.Loan;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

/**
// * Java class to read LOANS.csv using openCSV library
// * Author Dylan Cree
 */

public class LoanReader implements ICsvReader{

    public static List<Loan> csvConverter() throws FileNotFoundException {
        String filePath = "src/main/resources/LOANS.csv";

        return new CsvToBeanBuilder<Loan>(new FileReader(filePath))
                .withType(Loan.class)
                .build()
                .parse();
    }
}
