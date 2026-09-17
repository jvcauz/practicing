package com.auth;

public class User {

    public String name;
    public String password;

    public String firstName;
    public String lastName;
    private String fullName;

    public String getFullName(){
        return firstName + " " + lastName;
    }
}
