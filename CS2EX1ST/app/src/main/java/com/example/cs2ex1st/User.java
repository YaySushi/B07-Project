package com.example.cs2ex1st;

import java.util.InputMismatchException;
import java.util.regex.Pattern;

public abstract class User {
    String email;
    String firstName;
    String lastName;
    String gender;

    public User(String first, String last, String email, String gender) {
        if (first == "" || last == "" || first == null || last == null) {
            throw new InputMismatchException("Invalid name.");
        }

        if (Pattern.matches("[a-zA-Z0-9]@[a-zA-Z0-9]+.[a-zA-Z0-9]+|[a-zA-Z0-9]+[a-zA-Z0-9\\.]*[a-zA-Z0-9]+@[a-zA-Z0-9]+.[a-zA-Z0-9]+", email)) {
            throw new InputMismatchException("Invalid email.");
        }

        this.email = email;
        firstName = first;
        lastName = last;
        this.gender = gender;
    }
}
