package com.example.cs2ex1st;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
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
        EditText editText = (EditText) findViewById(R.id.patientfirstname);
        String firstName = editText.getText().toString();
        editText = (EditText) findViewById(R.id.patientlastname);
        String lastName = editText.getText().toString();
        editText = (EditText) findViewById(R.id.patientemail);
        String email = editText.getText().toString();
        editText = (EditText) findViewById(R.id.patientdob);
        String dob = editText.getText().toString();
        editText = (EditText) findViewById(R.id.patientPassword);
        String password = editText.getText().toString();

        try {
            User p = new Patient(firstName, lastName, email, dob, spinner.getSelectedItem(), password);
            //check order of arguments later: first, last, email, dob, gender, password
        } catch (Exception ex) {
            Intent intent = new Intent(this, SignUpFailure.class);
            intent.putExtra("ERROR_MESSAGE", ex.getMessage());
            startActivity(intent);
        }

        // search database and indicate failure if email already exists
        // else add to database

        // finally
        Intent intent = new Intent(this, SignUpSuccess.class);
        startActivity(intent);
    }

}