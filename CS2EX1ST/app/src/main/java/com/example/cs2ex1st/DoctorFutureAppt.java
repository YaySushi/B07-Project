package com.example.cs2ex1st;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class DoctorFutureAppt extends AppCompatActivity {
    private Appointment firstAppointment = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_future_appt);
        setTitle("Upcoming Appointments");
        RecyclerView rvDocFutureAppt = (RecyclerView)findViewById(R.id.recyclerFutureAppt);

        // Update user's appointment lists
        LoggedInUser.getUser().update();

        // Create ArrayList of appointments that are already booked
        ArrayList<Appointment> bookedAppts = new ArrayList<>();
        for (Appointment x : LoggedInUser.getUser().getReserved_appointments()) {
            if (x.isBooked()) bookedAppts.add(x);
        }

        // Sort the ArrayList of appointments to display in order
        Collections.sort(bookedAppts);

        // Get textboxes for the "first" appointment.
        TextView patientName = findViewById(R.id.next_appt_patname3);
        TextView date = findViewById(R.id.next_appt_date3);

        if(bookedAppts.size() > 0) {
            Appointment a = bookedAppts.get(0);
            firstAppointment = a;
            patientName.setText(a.PatientGet().getFirstName() + " " + a.PatientGet().getLastName());
            date.setText(a.getDate());
            bookedAppts.remove(a);
        }
        else {
            patientName.setText("N/A");
            date.setText("N/A");
        }

        DoctorFutureApptAdapter adapter = new DoctorFutureApptAdapter(bookedAppts);
        rvDocFutureAppt.setAdapter(adapter);
        rvDocFutureAppt.setLayoutManager(new LinearLayoutManager(this));
    }
    public void onClick(View v) {
        if(firstAppointment == null) return;

        LoggedInUser.setInspectingPatient(firstAppointment.PatientGet());
        Intent i = new Intent(this, PatientInspect.class);
        startActivity(i);
    }
}