package com.example.cs2ex1st;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DoctorAvailableAppt extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_available_appt);
        RecyclerView rvDocAvailAppt = (RecyclerView)findViewById(R.id.recyclerAvailAppnt);

        //ArrayList<Appointment> appointments = new ArrayList<>();
        //LoggedInUser.setUser(new Doctor("fren", "zarded", "fren@gmail.com", "mail", "liver", "pass"));
        //LoggedInUser.getUser().addAppointment(new Appointment(true, 11, 1, 1, 2021));
        //Doctor doc = new Doctor("fren", "zarded", "HOHO@gmail.com", "mail", "liver", "pass");
        //Patient p = new Patient("ali", "orozgani", "PATIENTHOOHOO@gmail.com", "other", "23/04/2014", "passssssss");



        //this is doctor's reserved appointments.
        //ArrayList<Appointment> doc_reserved_appts = new ArrayList<>();
        //Appointment app = new Appointment(true, doc.getEmail(), 11, 1, 1, 2021);
        //app.PatientSet(p);
        //doc_reserved_appts.add(app);

        //go through tomorrow's appointments and see which one's are available
        //ArrayList<Appointment> avail_appts = new ArrayList<>();
        //for(int i = 9; i <= 15; i++) {  //24 hours clocc
        //    app = new Appointment(true, doc.getEmail(), i, 1, 1, 2021);
        //    app.PatientSet(p);
        //    if(!doc_reserved_appts.contains(app)) avail_appts.add(app);
        //}
//
        //ApptAdapter adapter = new ApptAdapter(avail_appts);
        //rvDocAvailAppt.setAdapter(adapter);
        //rvDocAvailAppt.setLayoutManager(new LinearLayoutManager(this));
    }
}