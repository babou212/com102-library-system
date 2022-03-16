package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Items {
    private final Scanner scanner = new Scanner(new File
            ("/home/dylanc/IdeaProjects/library_System/src/ITEMS.csv"));

    public Items() throws FileNotFoundException {
    }
}
