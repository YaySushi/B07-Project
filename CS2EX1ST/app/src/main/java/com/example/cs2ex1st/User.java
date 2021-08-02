package com.example.cs2ex1st;

import java.util.InputMismatchException;
import java.util.regex.Pattern;

public abstract class User {
    String email;
    String firstName;
    String lastName;
    String gender;
    String password;
    public User(){}
    public User(String first,
                String last,
                String email,
                String gender,
                String password) throws InputMismatchException {
        if (first.equals("") || last.equals("") || first.equals(null) || last.equals(null)) {
            throw new InputMismatchException("Invalid name.");
        }

        if (Pattern.matches("[a-zA-Z0-9]@[a-zA-Z0-9]+.[a-zA-Z0-9]+|[a-zA-Z0-9]+[a-zA-Z0-9\\.]*[a-zA-Z0-9]+@[a-zA-Z0-9]+.[a-zA-Z0-9]+", email)) {
            throw new InputMismatchException("Invalid email.");
        }

        this.email = email;
        firstName = first;
        lastName = last;
        this.gender = gender;
        this.password = password;
    }
}
