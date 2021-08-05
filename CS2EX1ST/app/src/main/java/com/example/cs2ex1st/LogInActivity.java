package com.example.cs2ex1st;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LogInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
    }

    public void sendLogInInfo(View view) {
        Intent intent;
        // search database and indicate failure if email does not exist or if email exists and password does not match
        intent = new Intent(this, activity_patient_profile.class);
        startActivity(intent);

        // else if patient, move to patient profile
        // if doctor, move to doctor profile
    }
}