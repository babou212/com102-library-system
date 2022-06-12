package com.company.util;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class CsvReader {

    protected CsvReader() {
    }

    protected static <T> List<T> csvConverter(String filePath, Class<T> clazz) throws FileNotFoundException {

        return new CsvToBeanBuilder<T>(new FileReader(filePath))
                .withType(clazz)
                .build()
                .parse();
    }
}
