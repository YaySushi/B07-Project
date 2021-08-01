package com.example.cs2ex1st;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class DoctorSignUp extends AppCompatActivity {

    private Doctor d;
    private Spinner spinner1;
    private Spinner spinner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_sign_up);

        spinner1 = (Spinner) findViewById(R.id.doctorGenderSpinner);
        ArrayAdapter<CharSequence> genderAdapter = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item,
                getResources().getStringArray(R.array.gender));
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(genderAdapter);

        spinner2 = (Spinner) findViewById(R.id.doctorSpecialization);
        ArrayAdapter<CharSequence> specializationAdapter = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item,
                getResources().getStringArray(R.array.specialization));
        specializationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(specializationAdapter);
    }

    public void submitDoctorData(View view) {
        User d = new Doctor(spinner1.getSelectedItem(), spinner2.getSelectedItem());
        // need 2 cases: failure and success
        // ***INCOMPLETE***
        Intent intent = new Intent(this, SignUpSuccess.class);
        startActivity(intent);
    }
}