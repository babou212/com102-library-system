package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Users {
    private final Scanner scanner = new Scanner(new File
            ("/home/dylanc/IdeaProjects/library_System/src/USERS.csv"));

    public Users() throws FileNotFoundException {
    }
}
