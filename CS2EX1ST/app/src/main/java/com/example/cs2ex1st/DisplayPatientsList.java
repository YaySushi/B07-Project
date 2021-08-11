package com.example.cs2ex1st;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DisplayPatientsList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_patients_list);
        setTitle("Previous Patients");

        RecyclerView rvDocListPatients = (RecyclerView)findViewById(R.id.recyclerPatientList);
        Doctor u = (Doctor) LoggedInUser.getUser();
        ArrayList<Patient> patientList = new ArrayList<>();
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
}