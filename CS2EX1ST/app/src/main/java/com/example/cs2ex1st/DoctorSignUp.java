package com.example.cs2ex1st;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class DoctorSignUp extends AppCompatActivity {
    private Spinner spinner1;
    private Spinner spinner2;
    private TextView errorText;
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

        errorText = (TextView) findViewById(R.id.doctorSignInErrorText);
        errorText.setText("");
    }

    public void submitDoctorData(View view) {
        EditText editText = (EditText) findViewById(R.id.doctorfirstname);
        String firstName = editText.getText().toString();
        editText = (EditText) findViewById(R.id.doctorlastname);
        String lastName = editText.getText().toString();
        editText = (EditText) findViewById(R.id.doctoremail);
        String email = editText.getText().toString();
        editText = (EditText) findViewById(R.id.doctorpassword);
        String password = editText.getText().toString();

        try {
            User d = new Doctor(firstName, lastName, email, spinner1.getSelectedItem().toString(), spinner2.getSelectedItem().toString(), password);
        } catch (Exception ex) {
            errorText.setText(ex.getMessage());
            return;
        }

        // search database and indicate failure if email already exists
        // else add to database

        // finally
        Intent intent = new Intent(this, SignUpSuccess.class);
        startActivity(intent);
    }
}