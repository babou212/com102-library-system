package com.company.util;

import com.company.domain.User;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

/**
 * Java class to read USER.csv using openCSV library
 * Author Dylan Cree
 */

public class UserReader implements ICsvReader {

    public static List<User> csvConverter() throws FileNotFoundException {
        String filePath = "src/main/resources/USERS.csv";

        return new CsvToBeanBuilder<User>(new FileReader(filePath))
                .withType(User.class).build().parse();

    }
}
