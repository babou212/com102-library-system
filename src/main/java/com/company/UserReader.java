package com.company;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

/**
 * Java class to read USER.csv using openCSV library
 * Author Dylan Cree
 */

public class UserReader {

    public static List<User> userConverter() throws FileNotFoundException {
        String filePath = "/home/dylanc/IdeaProjects/library_System/src/main/java/USERS.csv";

        List<User> users = new CsvToBeanBuilder<User>(new FileReader(filePath))
                .withType(User.class).build().parse();

        //beans.forEach(System.out::println);  // debug statement to check output was correct
        return users;
    }
}
