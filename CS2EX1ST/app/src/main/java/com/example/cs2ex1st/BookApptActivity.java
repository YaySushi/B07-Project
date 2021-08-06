package com.example.cs2ex1st;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cs2ex1st.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
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

        Doctor doc1 = new Doctor("first", "last", "a@b.c", "Female", "Anesthesiology", "pass");
        Appointment app1 = new Appointment(false, 1, 1, 1,1);
        app1.setDoctor(doc1);
        doc1 = new Doctor("first", "last", "a@b.c", "Male", "Cardiology", "pass");

        Appointment app2 = new Appointment(false, 2, 1, 1,1);
        app2.setDoctor(doc1);

        Appointment app3 = new Appointment(false, 3, 1, 1,1);
        app3.setDoctor(doc1);

        Appointment app4 = new Appointment(false, 4, 1, 1,1);
        app4.setDoctor(doc1);

        Appointment app5 = new Appointment(false, 5, 1, 1,1);
        app5.setDoctor(doc1);

        Appointment app6 = new Appointment(false, 6, 1, 1,1);
        app6.setDoctor(doc1);

        appointments.add(app1);
        appointments.add(app2);
        appointments.add(app3);
        appointments.add(app4);
        appointments.add(app5);
        appointments.add(app6);

        // Create adapter and pass in appointment data
        BookingRecyclerAdapter adapter = new BookingRecyclerAdapter(this, appointments);

        // Attach adapter to RecyclerView
        rvBookingAppt.setAdapter(adapter);

        // Set Layout manager
        rvBookingAppt.setLayoutManager(new LinearLayoutManager(this));

    }

}