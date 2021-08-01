package com.example.cs2ex1st;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void doctorSignUp(View view) {
        Intent intent = new Intent(this, DoctorSignUp.class);
        startActivity(intent);
    }

    public void patientSignUp(View view) {
        Intent intent = new Intent(this, PatientSignUp.class);
        startActivity(intent);
    }
}