package com.company;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

/**
 * Java class to read USER.csv
 * Author Dylan Cree
 */

public class UserReader {

    public static void userConverter() throws FileNotFoundException {
        String filePath = "/home/dylanc/IdeaProjects/library_System/src/main/java/USERS.csv";

        List<User> beans = new CsvToBeanBuilder<User>(new FileReader(filePath))
                .withType(User.class).build().parse();

        //beans.forEach(System.out::println);
    }
}
