package com.example.cs2ex1st;
import java.io.Serializable;
import java.util.*;
public class Patient extends User implements Serializable {
    //assuming appointment consists of doctor field and time field
    private String DOB;
    private ArrayList<String> previousDoctors = new ArrayList<String>();
    public Patient(){}
    public Patient(String firstname,
                   String lastname,
                   String email,
                   String gender,
                   String DOB,
                   ArrayList<String> prevDoctors,
                   String password)
    {
        super(firstname,lastname,email, gender, password);
        this.DOB = DOB;
        this.previousDoctors = prevDoctors;
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
        boolean can_reserve=true;
//        for(Appointment a:prior_appointments)
//        {
//            if(a.DoctorGet()==app.DoctorGet())
//            {
//                can_reserve=true;
//                break;
//            }
//        }
        if(can_reserve && !app.isBooked())
        {
            app.setBooked(true);
            app.PatientSet(this);
            //app.DoctorGet().addAppointment(app.DoctorGet().getReserved_appointments(),app);
            ArrayList<Patient> patients = app.DoctorGet().getFuturePatients();
            patients.add(this);
            app.DoctorGet().setFuturePatients(patients);
            this.addAppointment(reserved_appointments,app);
            FirebaseWrapper.addDoctorToDatabase(app.DoctorGet());
            FirebaseWrapper.addPatientToDatabase(app.PatientGet());
            return true;
        }
         */
        return false;
    }

    public ArrayList<String> getPreviousDoctors() {
        return this.previousDoctors;
    }

    public String getDOB() { return DOB; }

    public void setDOB(String DOB) { this.DOB = DOB; }
}
