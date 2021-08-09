package com.example.cs2ex1st;

import androidx.annotation.Nullable;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class Appointment implements Comparable<Appointment>, Serializable {
    private int hour, day, month, year;
    private boolean isBooked;
    private Doctor doctor = null;
    private Patient patient = null;

    public Appointment()
    {

    }
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
    public String getDate() {
        Calendar c = Calendar.getInstance();
        c.set(year, month-1, day, hour, 0);

        Date d = c.getTime();
        String s = DateFormat.getTimeInstance(DateFormat.SHORT).format(d) + " "
                + DateFormat.getDateInstance().format(d);
        return s;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getDay() { return day; }

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

    @Override
    public int compareTo(Appointment appointment) {
        if(this.getMillis() < appointment.getMillis()) return 1;
        else if(this.getMillis() == appointment.getMillis()) return 0;
        else return -1;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(obj.getClass() != getClass()) return false;

        Appointment app2 = (Appointment)obj;
        return (
                this.hour == app2.getHour()
                        && this.day == app2.getDay()
                        && this.month == app2.getMonth()
                        && this.year == app2.getYear()
                        && this.doctor.equals(app2.getDoctor())
        );
    }
}
