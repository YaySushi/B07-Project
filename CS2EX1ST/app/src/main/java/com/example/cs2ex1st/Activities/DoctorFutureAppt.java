package com.example.cs2ex1st.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.cs2ex1st.R;

import java.util.ArrayList;

public class DoctorFutureAppt extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_future_appt);

        RecyclerView rvDocPastAppt = (RecyclerView)findViewById(R.id.recyclerFutureAppt);

        // Get Doctor's list of appointments

        // Create adapter and pass in appointment data

        // Attach adapter to RecyclerView

        // Set Layout manager

/*
        // TESTING data
        ArrayList<Appointment> appointments = new ArrayList<>();

        Doctor doc1 = new Doctor("first", "last", "a@b.c", "F", "spec", "pass");
        Appointment app1 = new Appointment(11, true);
        app1.setDoctor(doc1);

        Appointment app2 = new Appointment(12, true);
        app2.setDoctor(doc1);

        Appointment app3 = new Appointment(13, true);
        app3.setDoctor(doc1);

        Appointment app4 = new Appointment(14, true);
        app4.setDoctor(doc1);

        Appointment app5 = new Appointment(15, true);
        app5.setDoctor(doc1);

        Appointment app6 = new Appointment(16, true);
        app6.setDoctor(doc1);

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

 */

    }
}