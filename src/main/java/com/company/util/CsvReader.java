package com.company.util;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

/**
 * Java class to read CSV's using generics using openCSV library
 * Author Dylan Cree
 */

public class CsvReader {

    public static <T> List<T> csvConverter(String filePath, Class<T> clazz) throws FileNotFoundException {

        return new CsvToBeanBuilder<T>(new FileReader(filePath))
                .withType(clazz)
                .build()
                .parse();
    }
}
