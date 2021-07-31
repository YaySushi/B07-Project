package com.example.cs2ex1st;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class DoctorSignUp extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_sign_up);
        Spinner spinner = (Spinner) findViewById(R.id.doctorGenderSpinner);
        ArrayAdapter<CharSequence> genderAdapter = ArrayAdapter.createFromResource(this, R.array.gender, android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(genderAdapter);
        spinner.setOnItemSelectedListener(this);
    }

    public void submitDoctorData(View view) {
        // need 2 cases: failure and success
        // ***INCOMPLETE***
        Intent intent = new Intent(this, SignUpSuccess.class);
        startActivity(intent);
    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        gender = (String)parent.getItemAtPosition(pos);
    }

    public void onNothingSelected(AdapterView<?> parent) {
        gender = "Male";
    }
}