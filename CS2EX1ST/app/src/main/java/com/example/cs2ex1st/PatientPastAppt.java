package com.example.cs2ex1st;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class PatientPastAppt extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_past_appt);
        RecyclerView patient_past= (RecyclerView)findViewById(R.id.recyclerPatientPast);
        // Create adapter and pass in appointment data
        Patient s= (Patient)LoggedInUser.getUser();
        ApptAdapter adapter = new ApptAdapter(s.getPrior_appointments());
        // Attach adapter to RecyclerView
        patient_past.setAdapter(adapter);
        // Set Layout manager
        patient_past.setLayoutManager(new LinearLayoutManager(this));
    }
}