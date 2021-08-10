package com.example.cs2ex1st;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class PatientInspect extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_inspect);
        RecyclerView rvPrevVisDocs = (RecyclerView)findViewById(R.id.recyclerPreviouslyVisitedDoctors);
        setTitle("Patient Information");

        Patient inspectingPatient = LoggedInUser.getInspectingPatient();

        TextView tv_name = (TextView) findViewById(R.id.textView56);
        tv_name.setText(inspectingPatient.getFirstName() + " " + inspectingPatient.getLastName());

        TextView tv_email = (TextView) findViewById(R.id.textView57);
        tv_email.setText(inspectingPatient.getEmail());

        TextView tv_gender = (TextView) findViewById(R.id.textView61);
        tv_gender.setText(inspectingPatient.getGender());

        TextView tv_dob = (TextView) findViewById(R.id.textView62);
        tv_dob.setText(inspectingPatient.getDOB());

        ArrayList<Doctor> prevVisDocs = new ArrayList<Doctor>();
        for(String key : inspectingPatient.getPreviousDoctors()) {
            Doctor d = FirebaseWrapper.getDoctorWithKey(key);
            if(d != null) prevVisDocs.add(d);

        }

        DoctorListAdapter adapter = new DoctorListAdapter(prevVisDocs);
        rvPrevVisDocs.setAdapter(adapter);
        rvPrevVisDocs.setLayoutManager(new LinearLayoutManager(this));
    }
}