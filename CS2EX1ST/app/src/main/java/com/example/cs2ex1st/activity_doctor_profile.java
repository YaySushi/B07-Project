package com.example.cs2ex1st;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class activity_doctor_profile extends AppCompatActivity {

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
}