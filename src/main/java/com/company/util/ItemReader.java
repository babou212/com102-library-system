package com.company.util;

import com.company.domain.Item;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

/**
 * Java class to read ITEMS.csv using openCSV library
 * Author Dylan Cree
 */

public class ItemReader implements ICsvReader {

    public static List<Item> csvConverter() throws FileNotFoundException {
        String filePath = "src/main/resources/ITEMS.csv";

        return new CsvToBeanBuilder<Item>(new FileReader(filePath))
                .withType(Item.class)
                .build()
                .parse();
    }
}
