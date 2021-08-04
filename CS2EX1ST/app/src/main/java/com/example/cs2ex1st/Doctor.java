package com.example.cs2ex1st;

import java.util.*;

public class Doctor extends User {
    private ArrayList<Patient> previousPatients;

    private String specialization;

    public Doctor() {}
    public Doctor(String first,
                  String last,
                  String email,
                  String gender,
                  String specialization,
                  String password) {
          super(first, last, email, gender, password);
          this.specialization = specialization;
    }

    public ArrayList<Patient> getPreviousPatients() {
        return previousPatients;
    }

    public void setPreviousPatients(ArrayList<Patient> previousPatients) {
        this.previousPatients = previousPatients;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}