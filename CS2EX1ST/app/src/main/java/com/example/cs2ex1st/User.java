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

        if (!Pattern.matches("[a-zA-Z0-9]@[a-zA-Z0-9]+.[a-zA-Z0-9]+|[a-zA-Z0-9]+[a-zA-Z0-9\\.]*[a-zA-Z0-9]+@[a-zA-Z0-9]+.[a-zA-Z0-9]+", email)) {
            throw new InputMismatchException("Invalid email.");
        }

        if (!Pattern.matches("\\w{4,}", password)) {
            throw new InputMismatchException("Invalid password.");
        }

        this.email = email;
        firstName = first;
        lastName = last;
        this.gender = gender;
        this.password = password;
    }

    // Getter and setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
