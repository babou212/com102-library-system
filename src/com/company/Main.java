package com.company;

import java.io.FileNotFoundException;

public class Main {
    private final Loans loan = new Loans();
    private final Users user = new Users();
    private final Items item = new Items();

    public Main() throws FileNotFoundException {
    }

    public static void main(String[] args) throws FileNotFoundException {
        Main main = new Main();
        main.start();
    }

    private void start(){

    }
}