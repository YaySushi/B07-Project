package com.example.cs2ex1st;
import java.util.*;
public class Patient extends User{
    //assuming appointment consists of doctor field and time field
    public Patient(String firstname,
                   String lastname,
                   String email,
                   String gender,
                   String password)
    {
        super(firstname,lastname,email, gender, password);
    }
    public Patient(String firstname,
                   String lastname,
                   String email,
                   String gender,
                   String password,
                   ArrayList<Appointment> past_appointments)
    {
        super(firstname,lastname,email, gender, password);
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
            if(a.getDoctor()==app.getDoctor())
            {
                can_reserve=true;
                break;
            }
        }
        if(can_reserve && !app.isBooked())
        {
            app.setBooked(true);
            app.getDoctor().addAppointment(app.getDoctor().getReserved_appointments(),app);
            this.addAppointment(reserved_appointments,app);
            return true;
        }
        return false;
    }

}
