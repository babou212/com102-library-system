package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Java class to read USERS.csv into array of objects
 * Author Dylan Cree
 */

public class UserReader {
    private final ArrayList<String> userArray = new ArrayList<>();

    public void readUserCSV(){
        String loanPath = "/home/dylanc/IdeaProjects/library_System/src/USERS.csv";
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
                userArray.add(Arrays.toString(values));
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void printUsers(){
        for (int i=1; i<userArray.size(); i++){
            System.out.println(userArray.get(i));
        }
    }
}
