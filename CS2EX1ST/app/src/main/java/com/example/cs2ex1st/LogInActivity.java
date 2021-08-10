package com.example.cs2ex1st;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LogInActivity extends AppCompatActivity {
    private TextView logInErrorText;
    private Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        setTitle("Login");
        logInErrorText = (TextView) findViewById(R.id.errorText1);
        logInErrorText.setText("");

        presenter = new Presenter(new Model(), this);
    }

    public void displayMessage(String message) {
        logInErrorText.setText(message);
    }

    public String getEmail() {
        EditText editText = (EditText) findViewById(R.id.emailaddress);
        return editText.getText().toString();
    }

    public String getPassword() {
        EditText editText = (EditText) findViewById(R.id.password);
        return editText.getText().toString();
    }

    public void sendLogInInfo(View view) {
        presenter.validateUser();
    }

    public void startDoctorProfile() {
        Intent intent = new Intent(LogInActivity.this, DoctorProfile.class);
        startActivity(intent);
    }

    public void startPatientProfile() {
        Intent intent = new Intent(LogInActivity.this, PatientProfile.class);
        startActivity(intent);
    }

}