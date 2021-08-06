package com.example.cs2ex1st;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.InputMismatchException;

public class PatientSignUp extends AppCompatActivity {
    private Spinner spinner;
    private TextView errorText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_sign_up);

        spinner = (Spinner) findViewById(R.id.patientGenderSpinner);
        ArrayAdapter<CharSequence> genderAdapter = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item,
                getResources().getStringArray(R.array.gender));
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(genderAdapter);
        errorText = (TextView) findViewById(R.id.patientSignInErrorText);
        errorText.setText("");
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
        //add dob to constructor
        User p1;
        try {
            p1 = new Patient(firstName, lastName, email, spinner.getSelectedItem().toString(), password, dob);
        } catch (InputMismatchException ex) {
            errorText.setText(ex.getMessage());
            return;
        }

        // search database and indicate failure if email already exists
        // else add to database
        email = email.replace(".", "*");
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        ref.child("Patients").child(email).setValue(p1);
        Intent intent = new Intent(this, SignUpSuccess.class);
        startActivity(intent);
    }

}