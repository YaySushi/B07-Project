package com.example.cs2ex1st;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class PatientSignUp extends AppCompatActivity {

    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_sign_up);

        spinner = (Spinner) findViewById(R.id.patientGenderSpinner);
        ArrayAdapter<CharSequence> genderAdapter = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item,
                getResources().getStringArray(R.array.gender));
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(genderAdapter);
    }

    public void submitPatientData(View view) {
       // User p = new Patient(spinner1.getSelectedItem());
        // add try-catch blocks

        // then search database in case email already exists
        // need 2 cases: failure and success
        // ***INCOMPLETE***
        Intent intent = new Intent(this, SignUpFailure.class);
        startActivity(intent);
    }

}