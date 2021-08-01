package com.example.cs2ex1st;

public class Appointment {
    int startTime;
    boolean isBooked;
    Doctor doctor;
    public Appointment(int startTime, boolean isBooked) {
        this.startTime = startTime;
        this.isBooked = isBooked;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        this.isBooked = booked;
    }
}
