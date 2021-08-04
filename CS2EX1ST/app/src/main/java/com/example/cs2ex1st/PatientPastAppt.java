package com.example.cs2ex1st;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class PatientPastAppt extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_past_appt);
        RecyclerView patient_past= (RecyclerView)findViewById(R.id.recyclerPatientPast);
        savedInstanceState.getPatient().update();
        ApptAdapter adapter = new ApptAdapter(savedInstanceState.getPatient().getPrior_appointments());
        // Attach adapter to RecyclerView
        patient_past.setAdapter(adapter);

        // Set Layout manager
        patient_past.setLayoutManager(new LinearLayoutManager(this));
    }
}