package com.example.cs2ex1st;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DoctorSignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_sign_up);
    }

    public void submitDoctorData(View view) {
        // need 2 cases: failure and success
        // ***INCOMPLETE***
        Intent intent = new Intent(this, SignUpSuccess.class);
        startActivity(intent);
    }
}