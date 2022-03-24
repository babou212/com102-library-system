package com.company;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

/**
 * Java class to read ITEMS.csv
 * Author Dylan Cree
 */

public class ItemReader {
    public static List<Item> itemConverter() throws FileNotFoundException {
        String filePath = "/home/dylanc/IdeaProjects/library_System/src/main/java/ITEMS.csv";

        List<Item> beans = new CsvToBeanBuilder<Item>(new FileReader(filePath))
                .withType(Item.class).build().parse();

        //beans.forEach(System.out::println);
        return beans;
    }
}
