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
        if(prevDoctors.size() == 0){
            throw new InputMismatchException("Please choose at least 1 previously seen doctor");
        }
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
    public void remove_references_to_doc(Doctor doc)
    {
        ArrayList<Appointment> past_to_remove=new ArrayList<Appointment>();
        ArrayList<Appointment> future_to_remove=new ArrayList<Appointment>();
        ArrayList<String> past_doctors_to_remove = new ArrayList<String>();
        for(String docKey : this.previousDoctors) {
            if(docKey.equals(doc.getEmail().replace('.', '*'))) {
                past_doctors_to_remove.add(docKey);
            }
        }
        for(String docKey : past_doctors_to_remove) this.previousDoctors.remove(docKey);

        for(Appointment p:prior_appointments)
        {
            if(p.DoctorGet()==doc)
            {
                past_to_remove.add(p);
            }
        }
        for(Appointment p:reserved_appointments)
        {
            if(p.DoctorGet()==doc)
            {
                future_to_remove.add(p);
            }
        }
        for(Appointment p:past_to_remove)
        {
            prior_appointments.remove(p);
        }
        for(Appointment p:future_to_remove)
        {
            reserved_appointments.remove(p);
        }

    }
    public boolean book_appointment(Appointment app)
    {
        boolean can_reserve= previousDoctors.contains(app.DoctorGet().getEmail());
        if(can_reserve && !app.isBooked())
        {
            app.setBooked(true);
            app.PatientSet(this);
            //app.DoctorGet().addAppointment(app.DoctorGet().getReserved_appointments(),app);
            //ArrayList<Patient> patients = app.DoctorGet().getFuturePatients();
            //patients.add(this);
            //app.DoctorGet().setFuturePatients(patients);
            this.addAppointment(reserved_appointments,app);
            Doctor d = app.DoctorGet();
            Patient p = app.PatientGet();
            FirebaseWrapper.updateDatabaseDoctor(d);
            FirebaseWrapper.updateDatabasePatient(p);
            //FirebaseWrapper.updateDatabase();
            return true;
        }

        return false;
    }

    public ArrayList<String> getPreviousDoctors() {
        return this.previousDoctors;
    }
    public void addToPreviousDoctors(String doctorKey) {
        if(!this.previousDoctors.contains(doctorKey)) this.previousDoctors.add(doctorKey);
    }

    public String getDOB() { return DOB; }

    public void setDOB(String DOB) { this.DOB = DOB; }
}
