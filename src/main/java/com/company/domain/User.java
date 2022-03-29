package com.company.domain;

import com.opencsv.bean.CsvBindByName;

import java.io.Serializable;

/**
 // * Java beans data class for serialization and deserialization
 // * Author Dylan Cree
 */

public class User implements Serializable { // Serializable interface for java beans class

    @CsvBindByName(column = "User_id") // @CsvBindByName openCSV command
    private String userId;
    
    @CsvBindByName(column = "first_name")
    private String firstName;
    
    @CsvBindByName(column = "last_name")
    private String lastName;
    
    @CsvBindByName(column = "email")
    private String email;

    public User() {  // No args constructor for java beans class
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

    public String getUserId() {
        return userId;
    }
}
