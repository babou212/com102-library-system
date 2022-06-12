package com.company.domain;

import com.opencsv.bean.CsvBindByName;

import java.io.Serializable;

public final class User implements Serializable {

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

    public String getUserId() {
        return userId;
    }
}
