package com.example.cs2ex1st;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class PatientFutureAppt extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_future_appt);
        RecyclerView patient_future= (RecyclerView)findViewById(R.id.recyclePatientFuture);
        setTitle("Upcoming Appointments");
        // Update user's appointment lists
        LoggedInUser.getUser().update();

        // Create adapter and pass in appointment data
        Patient s= (Patient)LoggedInUser.getUser();
        ArrayList<Appointment> appointments = new ArrayList<>(s.getReserved_appointments());

        TextView docName = findViewById(R.id.next_appt_docname);
        TextView date = findViewById(R.id.next_appt_date);
        if(appointments.size() > 0){
            Collections.sort(appointments);
            Appointment next = appointments.get(0);

            docName.setText(next.DoctorGet().getFirstName() + " " + next.DoctorGet().getLastName());
            date.setText(next.getDate());
            appointments.remove(next);
        }
        else{
            docName.setText("N/A");
            date.setText("N/A");
        }


        ApptAdapter adapter = new ApptAdapter(appointments);
        // Attach adapter to RecyclerView
        patient_future.setAdapter(adapter);
        // Set Layout manager
        patient_future.setLayoutManager(new LinearLayoutManager(this));
    }
}