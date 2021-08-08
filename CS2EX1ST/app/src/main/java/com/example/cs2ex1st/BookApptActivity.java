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
    RecyclerView rvBookingAppt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appt);

        rvBookingAppt = (RecyclerView) findViewById(R.id.booking_list);
        Spinner genderFilter = (Spinner) findViewById(R.id.gender_filter);
        genderFilter.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView,
                                       View selectedItemView,
                                       int position,
                                       long id) {
                //Log.i("info", ((TextView)selectedItemView).getText().toString());
                String selectedGender = ((TextView)selectedItemView).getText().toString();
                if(selectedGender.equals(getResources().getStringArray(R.array.gender)[0]))
                {
                    resetRecyclerView();
                    return;
                }
                ArrayList<Appointment> appointments = new ArrayList<>();
                int i = 0;
                for(Doctor doctor: FirebaseWrapper.getDoctorList()){
                    if(doctor.getGender().equals(selectedGender)){
                        appointments.add(new Appointment(false, doctor,i, 1,1,1));
                        i++;
                    }
                }

                // Attach adapter to RecyclerView
                rvBookingAppt.setAdapter(new BookingRecyclerAdapter(BookApptActivity.this, appointments));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });
        Spinner specFilter = (Spinner) findViewById(R.id.specialization_filter);
        specFilter.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView,
                                       View selectedItemView,
                                       int position,
                                       long id) {
                //Log.i("info", ((TextView)selectedItemView).getText().toString());
                String selectedSpec = ((TextView)selectedItemView).getText().toString();
                if(selectedSpec.equals(getResources().getStringArray(R.array.specialization)[0])) {
                    resetRecyclerView();
                    return;
                }
                ArrayList<Appointment> appointments = new ArrayList<>();
                int i = 0;
                for(Doctor doctor: FirebaseWrapper.getDoctorList()){
                    if(doctor.getSpecialization().equals(selectedSpec)){
                        appointments.add(new Appointment(false, doctor,i, 1,1,1));
                        i++;
                    }
                }

                // Attach adapter to RecyclerView
                rvBookingAppt.setAdapter(new BookingRecyclerAdapter(BookApptActivity.this, appointments));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });

        // TESTING data
        resetRecyclerView();

        // Set Layout manager
        rvBookingAppt.setLayoutManager(new LinearLayoutManager(this));

    }
    private void resetRecyclerView(){
        ArrayList<Appointment> appointments = new ArrayList<Appointment>();
        int i = 0;
        for(Doctor doctor: FirebaseWrapper.getDoctorList()){
            appointments.add(new Appointment(false, doctor,i, 1,1,1));
            i++;
        }

        // Create adapter and pass in appointment data
        BookingRecyclerAdapter adapter = new BookingRecyclerAdapter(this, appointments);

        // Attach adapter to RecyclerView
        rvBookingAppt.setAdapter(adapter);
    }
}