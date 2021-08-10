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
        setTitle("Available Appointments");

        LoggedInUser.getUser().update();

        // Create ArrayList of appointments that are already booked
        ArrayList<Appointment> doc_avail_appts = new ArrayList<>();
        for (Appointment x : LoggedInUser.getUser().getReserved_appointments()) {
            if (!x.isBooked()) doc_avail_appts.add(x);
        }
        ApptAdapter adapter = new ApptAdapter(doc_avail_appts);
        rvDocAvailAppt.setAdapter(adapter);
        rvDocAvailAppt.setLayoutManager(new LinearLayoutManager(this));
    }
}