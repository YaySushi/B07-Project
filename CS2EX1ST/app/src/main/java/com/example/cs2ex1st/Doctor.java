package com.example.cs2ex1st;

import java.util.*;

public class Doctor extends User {
    ArrayList<Appointment> pastAppointments;
    ArrayList<Appointment> futureAppointments;
    ArrayList<Patient> previousPatients;

    String specialization;

    public Doctor() {
    }
    public Doctor(String first,
                  String last,
                  String email,
                  String gender,
                  String specialization,
                  String password) {
          super(first, last, email, gender, password);
          this.specialization = specialization;
    }

    public ArrayList<Appointment> getFutureAppointments() {
        return futureAppointments;
    }

    public ArrayList<Appointment> getPastAppointments() {
        return futureAppointments;
    }
}