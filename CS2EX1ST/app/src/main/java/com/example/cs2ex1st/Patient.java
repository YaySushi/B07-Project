package com.example.cs2ex1st;
import java.io.Serializable;
import java.util.*;
public class Patient extends User implements Serializable {
    //assuming appointment consists of doctor field and time field
    private String DOB;
    public Patient(){}
    public Patient(String firstname,
                   String lastname,
                   String email,
                   String gender,
                   String DOB,
                   String password)
    {
        super(firstname,lastname,email, gender, password);
        this.DOB = DOB;
    }
    public Patient(String firstname,
                   String lastname,
                   String email,
                   String gender,
                   String DOB,
                   String password,
                   ArrayList<Appointment> past_appointments)
    {
        super(firstname,lastname,email, gender, password);
        this.DOB = DOB;
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
            app.setPatient(this);
            app.getDoctor().addAppointment(app.getDoctor().getReserved_appointments(),app);
            this.addAppointment(reserved_appointments,app);
            return true;
        }
        return false;
    }


    public String getDOB() { return DOB; }

    public void setDOB(String DOB) { this.DOB = DOB; }
}
