package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Java class to read LOANS.csv into array of objects
 * Author Dylan Cree
 */

public class LoanReader {
    //private List<Loans> loansArrayList =

    public LoanReader() throws IOException {
        String loanPath = "/home/dylanc/IdeaProjects/library_System/src/LOANS.csv";
        String line;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(loanPath));
        while ((line = bufferedReader.readLine()) != null){
            String[] values = line.split(",");
            System.out.println(Arrays.toString(values));
        }
    }
}
