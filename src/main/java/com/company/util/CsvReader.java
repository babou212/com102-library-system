package com.company.util;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

/**
 * Java class to read CSV's using java generics/ openCSV library
 * Author Dylan Cree B00826872
 */

public class CsvReader {  // Generics used to reduce code reuse

    protected static <T> List<T> csvConverter(String filePath, Class<T> clazz) throws FileNotFoundException {

        return new CsvToBeanBuilder<T>(new FileReader(filePath))
                .withType(clazz)
                .build()
                .parse();
    }
}
