package com.example.cs2ex1st;

import java.util.InputMismatchException;
import java.util.regex.Pattern;

public abstract class DummyUser {
    String email;
    String firstName;
    String lastName;
    String gender;
    String password;

    public DummyUser() {}
    public DummyUser(String first, String last, String email, String gender, String password) {
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
        this.password = password;
    }
}
