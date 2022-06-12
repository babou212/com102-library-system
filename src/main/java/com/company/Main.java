package com.company;

import com.company.service.ProgramService;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, CsvRequiredFieldEmptyException,
            CsvDataTypeMismatchException {
        ProgramService programService = new ProgramService();
        programService.programStart();
    }
}
