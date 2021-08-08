package com.example.cs2ex1st;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PatientProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_profile);

        //LoggedInUser is assumed to be initialized from loggin in.
        Patient p = (Patient)LoggedInUser.getUser();
        ((TextView)findViewById(R.id.textView40)).setText(p.toString());
        ((TextView)findViewById(R.id.textView45)).setText(p.getDOB());
        ((TextView)findViewById(R.id.textView29)).setText(p.getEmail());
        ((TextView)findViewById(R.id.textView41)).setText(p.getGender());
    }

    public void GoToPatientFutureAppointments(View view) {
        Intent intent = new Intent(this, PatientFutureAppt.class);
        startActivity(intent);
    }

    public void GoToPatientPastAppointments(View view) {
        Intent intent = new Intent(this, PatientPastAppt.class);
        startActivity(intent);
    }
}