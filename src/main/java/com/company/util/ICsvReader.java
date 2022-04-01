package com.company.util;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public interface ICsvReader {

    static List<ICsvReader> csvConverter() throws FileNotFoundException {
        String filePath = "";

        return new CsvToBeanBuilder<ICsvReader>(new FileReader(filePath))
                .withType(ICsvReader.class).build().parse();
    }
}
