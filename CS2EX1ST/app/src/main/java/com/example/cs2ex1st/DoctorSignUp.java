package com.example.cs2ex1st;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.InputMismatchException;

public class DoctorSignUp extends AppCompatActivity {
    private Spinner spinner1;
    private Spinner spinner2;
    private TextView errorText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_sign_up);
        setTitle("Doctor Sign up");
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

        errorText = (TextView) findViewById(R.id.doctorSignUpErrorText);
        errorText.setText("");
    }

    public void doctorLogInInstead(View view) {
        Intent intent = new Intent(this, LogInActivity.class);
        startActivity(intent);
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

        User d1;
        try {
            d1 = new Doctor(firstName, lastName, email, spinner1.getSelectedItem().toString(), spinner2.getSelectedItem().toString(), password);
        } catch (InputMismatchException ex) {
            errorText.setText(ex.getMessage());
            return;
        }
        DatabaseReference ref2 = FirebaseDatabase.getInstance().getReference();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("ID/" + d1.getEmail());
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    errorText.setText("Email already exists.");
                } else {
                    ref2.child("Doctor").child(d1.getEmail()).setValue(d1);
                    ref2.child("ID").child(d1.getEmail()).setValue(d1.getPassword() + ", Doctor");
                    Intent intent = new Intent(DoctorSignUp.this, SignUpSuccess.class);
                    startActivity(intent);
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.toException());
            }
        });
    }
}