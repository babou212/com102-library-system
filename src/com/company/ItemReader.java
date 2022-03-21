package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Java class to read ITEMS.csv into array of objects
 * Author Dylan Cree
 */

public class ItemReader {

    public static void readItemsCSV(){
        String loanPath = "/home/dylanc/IdeaProjects/library_System/src/ITEMS.csv";
        String line = null;

        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(loanPath));
            while (true) {
                try {
                    if ((line = bufferedReader.readLine()) == null) break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                assert line != null;
                String[] values = line.split(",");
                System.out.println(Arrays.deepToString(values));
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
