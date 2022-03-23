package com.company;

import com.opencsv.bean.CsvBindByName;

public class User {

    @CsvBindByName(column = "User_id")
    private String userId;
    
    @CsvBindByName(column = "first_name")
    private String firstName;
    
    @CsvBindByName(column = "last_name")
    private String lastName;
    
    @CsvBindByName(column = "email")
    private String email;

    public User() {

    }

    @Override
    public String toString() {
        return "User{" +
                "user_id='" + userId + '\'' +
                ", first_name='" + firstName + '\'' +
                ", last_name='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

//    public Users(String user_id, String first_name, String last_name, String email) {
//        super();
//        this.user_id = user_id;
//        this.first_name = first_name;
//        this.last_name = last_name;
//        this.email = email;
//    }

    public String printUser(){
        return "User ID [UserId= " + userId + " " + "First Name= " + firstName + " " + "Last Name= " + lastName + " "
        + "Email="  + email + " " + "]";
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
