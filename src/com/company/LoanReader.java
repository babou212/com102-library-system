package com.company;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoanReader {
    private final List<List<String>> loansArray = new ArrayList<>();
    public LoanReader() throws CsvValidationException, IOException {
        try (CSVReader csvReader = new CSVReader(
                new FileReader("/home/dylanc/IdeaProjects/library_System/src/LOANS.csv"))) {
            String[] val = null;

            while((val = csvReader.readNext()) != null) {
                loansArray.add(Arrays.asList(val));
            }
        }
    }
    public void loanPrint(){
        System.out.println(loansArray);
    }
}
