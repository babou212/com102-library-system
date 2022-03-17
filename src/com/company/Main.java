package com.company;

import com.opencsv.exceptions.CsvValidationException;
import java.io.IOException;

public class Main {
    private final Loans loan = new Loans();
    private final Users user = new Users();
    private final Items item = new Items();
    private final LoanReader loanReader = new LoanReader();

    public Main() throws IOException, CsvValidationException {
    }

    public static void main(String[] args) throws IOException, CsvValidationException {
        Main main = new Main();
        main.start();
    }

    private void start(){
        boolean flag = true;
            while (flag){
                System.out.println("Test print");
                loanReader.loanPrint();
            }
    }
}
