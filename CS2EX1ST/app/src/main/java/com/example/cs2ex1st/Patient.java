package com.example.cs2ex1st;
import java.util.*;
public class Patient extends User{
    //assuming appointment consists of doctor field and time field
    ArrayList<Appointment> reserved_appointments;
    ArrayList<Appointment> prior_appointments;
    public Patient(String firstname, String lastname, String email, String password)
    {
        super(firstname,lastname,email,password);
    }
    public Patient(String firstname, String lastname, String email, String password,ArrayList<Appointment> past_appointments)
    {
        super(firstname,lastname,email,password);
        for(Appointment a:past_appointments)
        {
            prior_appointments.add(a);
        }
    }
    public boolean book_appointment(Appointment app)
    {
        boolean can_reserve=false;
        for(Appointment a:prior_appointments)
        {
            if(a.doctor==app.doctor)
            {
                can_reserve=true;
                break;
            }
        }
        if(can_reserve && is_vacant(app))
        {
            reserved_appointments.add(app);
            return true;
        }
        return false;
    }
}
