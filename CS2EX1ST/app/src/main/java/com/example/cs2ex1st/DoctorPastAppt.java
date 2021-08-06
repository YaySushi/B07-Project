package com.example.cs2ex1st;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.cs2ex1st.R;
import java.util.ArrayList;

public class DoctorPastAppt extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_past_appt);

        RecyclerView rvDocPastAppt = (RecyclerView)findViewById(R.id.recyclerAvailAppnt);

        // Get Doctor's list of appointments

        // Create adapter and pass in appointment data

        // Attach adapter to RecyclerView

        // Set Layout manager



        // TESTING data
        ArrayList<Appointment> appointments = new ArrayList<>();

        Doctor doc1 = new Doctor("first", "last", "a@b.c", "F", "spec", "pass");
        Patient pat1 = new Patient("patientFirst", "patientLast", "1@2.3", "F", "12/12/12", "wowow");

        Appointment app1 = new Appointment(true, 10, 1, 1, 2020);
        app1.setDoctor(doc1);
        app1.setPatient(pat1);

        Appointment app2 = new Appointment(true, 11, 1, 1, 2020);
        app2.setDoctor(doc1);
        app2.setPatient(pat1);

        Appointment app3 = new Appointment(true, 12, 1, 1, 2020);
        app3.setDoctor(doc1);
        app3.setPatient(pat1);

        Appointment app4 = new Appointment(true, 13, 1, 1, 2020);
        app4.setDoctor(doc1);
        app4.setPatient(pat1);

        Appointment app5 = new Appointment(true, 14, 1, 1, 2020);
        app5.setDoctor(doc1);
        app5.setPatient(pat1);

        Appointment app6 = new Appointment(true, 15, 1, 1, 2020);
        app6.setDoctor(doc1);
        app6.setPatient(pat1);

        appointments.add(app1);
        appointments.add(app2);
        appointments.add(app3);
        appointments.add(app4);
        appointments.add(app5);
        appointments.add(app6);

        // Create adapter and pass in appointment data
        ApptAdapter adapter = new ApptAdapter(appointments);

        // Attach adapter to RecyclerView
        rvDocPastAppt.setAdapter(adapter);

        // Set Layout manager
        rvDocPastAppt.setLayoutManager(new LinearLayoutManager(this));


    }
}