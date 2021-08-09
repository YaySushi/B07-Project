package com.example.cs2ex1st;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DisplayPatientsList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_patients_list);

        RecyclerView rvDocListPatients = (RecyclerView)findViewById(R.id.recyclerPatientList);
        Doctor u = (Doctor) LoggedInUser.getUser();
        ArrayList<Patient> patientList = new ArrayList<>();
        //patientList = u.getPreviousPatients();

        //since doctor class doesn't keep track of patients, for now, we use this:
        //patientList = FirebaseWrapper.getPatientList();
        for(Appointment app:u.getReserved_appointments()){
            if(app.isBooked() && !patientList.contains(app.PatientGet()))
                patientList.add(app.PatientGet());
        }
        for(Appointment app:u.getPrior_appointments()){
            if(app.isBooked() && !patientList.contains(app.PatientGet()))
                patientList.add(app.PatientGet());
        }
        PatientListAdapter adapter = new PatientListAdapter(patientList);
        rvDocListPatients.setAdapter(adapter);
        rvDocListPatients.setLayoutManager(new LinearLayoutManager(this));
    }

    public void returnToHome(View view) {
        Intent intent = new Intent(this, DoctorProfile.class);
        startActivity(intent);
    }
}