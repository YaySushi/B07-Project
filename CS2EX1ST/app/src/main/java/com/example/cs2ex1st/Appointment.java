package com.example.cs2ex1st;

public class Appointment {
    private int startTime;
    private boolean isBooked;

    public Appointment(int startTime, boolean isBooked) {
        this.startTime = startTime;
        this.isBooked = isBooked;
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
