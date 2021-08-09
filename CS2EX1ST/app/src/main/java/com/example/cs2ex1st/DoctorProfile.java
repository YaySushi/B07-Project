package com.example.cs2ex1st;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DoctorProfile extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_profile);
        setTitle("Profile");
        //LoggedInUser is assumed to be initialized from loggin in.
        FirebaseWrapper.printHashMap(FirebaseWrapper.getDoctors());
        Doctor d = (Doctor)LoggedInUser.getUser();
        ((TextView)findViewById(R.id.textView25)).setText(d.toString());
        ((TextView)findViewById(R.id.textView26)).setText(d.getSpecialization());
        ((TextView)findViewById(R.id.textView31)).setText(d.getEmail());
        ((TextView)findViewById(R.id.textView29)).setText(d.getGender());
    }

    public void goToDoctorAvailableAppointments(View view) {
        Intent intent = new Intent(this, DoctorAvailableAppt.class);
        startActivity(intent);
    }

    public void goToDoctorFutureAppointments(View view) {
        Intent intent = new Intent(this, DoctorFutureAppt.class);
        startActivity(intent);
    }

    public void goToDoctorPastAppointments(View view) {
        Intent intent = new Intent(this, DoctorPastAppt.class);
        startActivity(intent);
    }

    public void goToListOfPatients(View view) {
        Intent intent = new Intent(this, DisplayPatientsList.class);
        startActivity(intent);
    }

    public void deleteProfile(View view) {

        // TODO delete profile

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}