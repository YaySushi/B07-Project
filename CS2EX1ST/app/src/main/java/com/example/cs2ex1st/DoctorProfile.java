package com.example.cs2ex1st;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DoctorProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_profile);

        //LoggedInUser is assumed to be initialized from loggin in.
        Doctor d = (Doctor)LoggedInUser.getUser();
        ((TextView)findViewById(R.id.textView25)).setText(d.toString());
        ((TextView)findViewById(R.id.textView26)).setText(d.getSpecialization());
        ((TextView)findViewById(R.id.textView31)).setText(d.getEmail());
        ((TextView)findViewById(R.id.textView29)).setText(d.getGender());
    }

    public void GoToDoctorAvailableAppointments(View view) {
        Intent intent = new Intent(this, DoctorAvailableAppt.class);
        startActivity(intent);
    }

    public void GoToDoctorFutureAppointments(View view) {
        Intent intent = new Intent(this, DoctorFutureAppt.class);
        startActivity(intent);
    }

    public void GoToDoctorPastAppointments(View view) {
        Intent intent = new Intent(this, DoctorPastAppt.class);
        startActivity(intent);
    }
}