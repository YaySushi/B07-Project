package com.example.cs2ex1st;

import java.util.*;

public class Doctor extends DummyUser {
    ArrayList<DummyAppointment> pastAppointments;
    ArrayList<DummyAppointment> futureAppointments;
    ArrayList<DummyPatient> previousPatients;

    String specialization;

    public Doctor() {}
    public Doctor(String first, String last, String gender, String email, String specialization) {
          super(first, last, gender, email);
          this.specialization = specialization;
    }

    public ArrayList<DummyAppointment> getFutureAppointments() {
        return futureAppointments;
    }

    public ArrayList<DummyAppointment> getPastAppointments() {
        return futureAppointments;
    }
}