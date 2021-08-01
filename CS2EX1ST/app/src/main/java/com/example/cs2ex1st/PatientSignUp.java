package com.example.cs2ex1st;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class PatientSignUp extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Patient p;
    private Spinner spinner1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_sign_up);

        spinner1 = (Spinner) findViewById(R.id.doctorGenderSpinner);
        ArrayAdapter<CharSequence> genderAdapter = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item,
                getResources().getStringArray(R.array.gender));
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(genderAdapter);
    }

    public void submitPatientData(View view) {
        User p = new Patient(spinner1.getSelectedItem());
        // add try-catch blocks

        // then search database
        // need 2 cases: failure and success
        // ***INCOMPLETE***
        Intent intent = new Intent(this, SignUpSuccess.class);
        startActivity(intent);
    }

}