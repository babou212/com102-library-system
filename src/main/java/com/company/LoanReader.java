//package com.company;
//
//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Arrays;
//
///**
// * Java class to read LOANS.csv into array of objects
// * Author Dylan Cree
// */
//
//public class LoanReader {
//    private final ArrayList<String> loanArray = new ArrayList<>();
//
//    public void readLoansCSV(){
//        String loanPath = "/home/dylanc/IdeaProjects/library_System/src/LOANS.csv";
//        String line = null;
//
//        BufferedReader bufferedReader;
//        try {
//            bufferedReader = new BufferedReader(new FileReader(loanPath));
//            while (true) {
//                try {
//                    if ((line = bufferedReader.readLine()) == null) break;
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                assert line != null;
//                String[] values = line.split(",");
//                loanArray.add(Arrays.toString(values));
//            }
//        } catch (FileNotFoundException ex) {
//            ex.printStackTrace();
//        }
//    }
//
//    public void printLoans(){
//        for (int i=1; i<loanArray.size(); i++){
//            System.out.println(loanArray.get(i));
//        }
//    }
//}
