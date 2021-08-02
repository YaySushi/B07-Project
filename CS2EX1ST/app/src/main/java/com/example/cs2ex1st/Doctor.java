package com.example.cs2ex1st;

import java.util.*;

public class Doctor extends User {
    ArrayList<Appointment> pastAppointments;
    ArrayList<Appointment> futureAppointments;
    ArrayList<Patient> previousPatients;

    String specialization;

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

    public ArrayList<Appointment> getFutureAppointments() {
        return futureAppointments;
    }

    public void setFutureAppointments(ArrayList<Appointment> futureAppointments) {
        this.futureAppointments = futureAppointments;
    }

    public ArrayList<Appointment> getPastAppointments() {
        return pastAppointments;
    }

    public void setPastAppointments(ArrayList<Appointment> pastAppointments) {
        this.pastAppointments = pastAppointments;
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