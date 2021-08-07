package com.example.cs2ex1st;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class PatientFutureAppt extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_future_appt);
        RecyclerView patient_future= (RecyclerView)findViewById(R.id.recyclerPatientPast);
        // Create adapter and pass in appointment data
        //savedInstanceState.getPatient().update();
        Intent intent= getIntent();
        Patient s= (Patient)intent.getSerializableExtra(PatientProfile.EXTRA_MESSAGE);
        ApptAdapter adapter = new ApptAdapter(s.getReserved_appointments());
        // Attach adapter to RecyclerView
        patient_future.setAdapter(adapter);

        // Set Layout manager
        patient_future.setLayoutManager(new LinearLayoutManager(this));

    }
}