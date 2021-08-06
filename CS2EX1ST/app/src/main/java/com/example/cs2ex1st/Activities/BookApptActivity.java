package com.example.cs2ex1st.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.example.cs2ex1st.Appointment;
import com.example.cs2ex1st.Doctor;
import com.example.cs2ex1st.FirebaseWrapper;
import com.example.cs2ex1st.R;

import java.util.ArrayList;

public class BookApptActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appt);

        RecyclerView rvBookingAppt = (RecyclerView) findViewById(R.id.booking_list);
        Spinner genderFilter = (Spinner) findViewById(R.id.gender_filter);
        genderFilter.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView,
                                       View selectedItemView,
                                       int position,
                                       long id) {
                //Log.i("info", ((TextView)selectedItemView).getText().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });
        // TESTING data

        ArrayList<Appointment> appointments = new ArrayList<>();
        int i = 0;
        for(Doctor doctor: FirebaseWrapper.getInstance().getDoctorList()){
            appointments.add(new Appointment(false, doctor, i % 24,1,1,1));
            i+=1;
        }
        Doctor doc1 = new Doctor("first", "last", "a@b.c", "Female", "spec", "pass");
        Appointment app1 = new Appointment(false, doc1, 1,1,1,1);
        appointments.add(app1);
        Appointment app2 = new Appointment(false, doc1, 2,2,2,2);
        appointments.add(app2);
        // Create adapter and pass in appointment data
        BookingRecyclerAdapter adapter = new BookingRecyclerAdapter(this, appointments);

        // Attach adapter to RecyclerView
        rvBookingAppt.setAdapter(adapter);

        // Set Layout manager
        rvBookingAppt.setLayoutManager(new LinearLayoutManager(this));

    }

}