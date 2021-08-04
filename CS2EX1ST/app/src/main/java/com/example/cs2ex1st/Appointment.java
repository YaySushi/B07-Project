package com.example.cs2ex1st;

import java.util.Calendar;

public class Appointment {
    private int hour, day, month, year;
    private boolean isBooked;
    private Doctor doctor;
    public Appointment(boolean isBooked, Doctor doctor, int hour, int day, int month, int year) {
        this.isBooked = isBooked;
        this.hour = hour;
        this.day = day;
        this.month = month;
        this.year = year;
        this.doctor = doctor;
    }
    public Appointment(boolean isBooked, int hour, int day, int month, int year) {
        this.isBooked = isBooked;
        this.hour = hour;
        this.day = day;
        this.month = month;
        this.year = year;
    }
    public void setTime(int hour, int day, int month, int year){
        this.hour = hour;
        this.day = day;
        this.month = month;
        this.year = year;
    }
    public long getMillis(){
        Calendar c = Calendar.getInstance();
        c.set(year, month-1, day, hour, 0);
        return c.getTimeInMillis();
    }
    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }


    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        this.isBooked = booked;
    }
}
