//package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

//public class UserReader {
//
//    public static void main(String[] args) {
//        String filePath = "/home/dylanc/IdeaProjects/library_System/src/USERS.csv";
//        List<Users> usersList = getUserData(filePath);
//        for (Users user: usersList){
//            System.out.println(user);
//        }
    //}
//
//    private static List<Users> getUserData(String filePath) {
//        List<Users> usersList = null;
//        Path pathFile = Paths.get(filePath);
//        try (BufferedReader br = Files.newBufferedReader(pathFile)){
//                String row = br.readLine();
//                while (row!=null){
//                    String[] attr = row.split(",");
//                    Users user = getOneUserData(attr);
//                    usersList.add(user);
//                    row = br.readLine();
//                }
//        } catch (IOException e){
//            e.printStackTrace();
//        }
//        return usersList;
//    }

//    private static Users getOneUserData(String[] attr){
//        String user_id = attr[0];
//        String first_name = attr[1];
//        String last_name = attr[2];
//        String email = attr[3];
//        Users users = new Users(user_id, first_name, last_name, email);
//        System.out.println(users);
//        return users;
//    }
//}
