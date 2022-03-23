package com.company;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;

public class Main {
    private final Scanner scanner = new Scanner(System.in);
    private final User user = new User();

    public static void main(String[] args) throws FileNotFoundException {
        String filePath = "/home/dylanc/IdeaProjects/library_System/src/main/java/USERS.csv";

        List<User> beans = new CsvToBeanBuilder<User>(new FileReader(filePath))
                .withType(User.class).build().parse();

        beans.forEach(System.out::println);

        Main main = new Main();
        main.start(beans);
    }

    private void start(List<User> beans ) {
        boolean quit = false;
        int menu;
        printInstructions();

        while (!quit){
                System.out.println("Enter your choice: ");
                menu = scanner.nextInt();
                scanner.nextLine(); // Scanner nextline call to clear input buffer

            switch (menu){
                case 0:
                    printInstructions();
                    break;
                case 1:
                    beans.forEach(System.out::println);
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    System.out.println("Test1");
                    break;
                case 5:
                    System.out.println("Test2");
                    break;
                case 6:
                    quit = true;
                    System.out.println("Program has terminated");
                    scanner.close(); // CLose scanner once program has terminated
                    break;
            }
        }
    }

    private static void printInstructions(){
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print menu options.");
        System.out.println("\t 1 - To print the list of Items.");
        System.out.println("\t 2 - To view current active loans.");
        System.out.println("\t 3 - To view list of users.");
        System.out.println("\t 4 - To remove an item from the list.");
        System.out.println("\t 5 - To search for an item in the list.");
        System.out.println("\t 6 - TO quit the application.");
    }
}
