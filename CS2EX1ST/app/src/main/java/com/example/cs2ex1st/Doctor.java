package com.example.cs2ex1st;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.InputMismatchException;

public class Doctor extends User implements Serializable {
    private final int STARTING_HOUR = 9;
    private final int ENDING_HOUR = 17;
    private ArrayList<String> previousPatientsKey = new ArrayList<String>();
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
        if(specialization.equals("Choose...")){
            throw new InputMismatchException("Invalid specialization");
        }
        this.specialization = specialization;
        this.previousPatientsKey = new ArrayList<String>();
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
                    this.email,
                    hour,
                    tomorrow.get(Calendar.DATE),
                    tomorrow.get(Calendar.MONTH)+1, //Calendar counts months starting from 0
                    tomorrow.get(Calendar.YEAR));
            reserved_appointments.add(appt);
        }
    }
    public void update(){
        super.update();

        // if the current day has passed refresh the available appointments
        Calendar today = Calendar.getInstance();
        String curDay = today.get(Calendar.DATE) + "/" + today.get(Calendar.MONTH) + "/" + today.get(Calendar.YEAR);
        if(!lastDayUpdated.equals(curDay)){
            addFreeAppointments();
        }
    }

    public ArrayList<String> getPreviousPatientsKey() {
        return previousPatientsKey;
    }

    public void setPreviousPatientsKey(ArrayList<String> previousPatientsKey) {
        this.previousPatientsKey = previousPatientsKey;
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