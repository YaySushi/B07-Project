package com.example.cs2ex1st;


import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class Doctor extends User implements Serializable {
    private final int STARTING_HOUR = 9;
    private final int ENDING_HOUR = 17;
    private ArrayList<Patient> previousPatients = new ArrayList<Patient>();
    private ArrayList<Patient> futurePatients = new ArrayList<Patient>();
    private String specialization;
    private String lastDayUpdated;
    public Doctor() {}
    public Doctor(String first,
                  String last,
                  String email,
                  String gender,
                  String specialization,
                  String password) {
        super(first, last, email, gender, password);
        this.specialization = specialization;
        addFreeAppointments();
    }
    public void addFreeAppointments(){
        Calendar today = Calendar.getInstance();
        Calendar tomorrow = Calendar.getInstance();
        today.setLenient(true);
        tomorrow.setLenient(true);
        int curDay = today.get(Calendar.DATE);
        int curMonth = today.get(Calendar.MONTH);
        int curYear = today.get(Calendar.YEAR);
        lastDayUpdated = curDay + "/" + curMonth + "/" + curYear;
        for(int hour = STARTING_HOUR; hour < ENDING_HOUR; hour++){
            tomorrow.set(curYear, curMonth, curDay+1);
            Appointment appt = new Appointment(
                    false,
                    Doctor.this,
                    hour,
                    tomorrow.get(Calendar.DATE),
                    tomorrow.get(Calendar.MONTH)+1, //Calendar counts months starting from 0
                    tomorrow.get(Calendar.YEAR));
            reserved_appointments.add(appt);
        }
    }
    public void update(){
        super.update();
        Calendar today = Calendar.getInstance();
        String curDay = today.get(Calendar.DATE) + "/" + today.get(Calendar.MONTH) + "/" + today.get(Calendar.YEAR);
        if(!lastDayUpdated.equals(curDay)){
            addFreeAppointments();
        }
    }
    public void setFuturePatients(ArrayList<Patient> futurePatients) {
        this.futurePatients = futurePatients;
    }

    public ArrayList<Patient> getFuturePatients() {
        return futurePatients;
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

    public String getLastDayUpdated() {
        return lastDayUpdated;
    }

    public void setLastDayUpdated(String lastDayUpdated) {
        this.lastDayUpdated = lastDayUpdated;
    }
    public ArrayList<Appointment> getUnbookedAppointments(){
        ArrayList<Appointment> appointments = new ArrayList<>();
        for(Appointment a: reserved_appointments){
            if(!a.isBooked()){
                appointments.add(a);
            }
        }
        return appointments;
    }
}