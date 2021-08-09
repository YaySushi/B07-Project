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
    String selectedGender , selectedSpec;
    String genderDefault, specDefault;
    ArrayList<Appointment> appointments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appt);
        appointments = new ArrayList<Appointment>();


        rvBookingAppt = (RecyclerView) findViewById(R.id.booking_list);
        Spinner genderFilter = (Spinner) findViewById(R.id.gender_filter);

        genderDefault = getResources().getStringArray(R.array.gender)[0];
        selectedGender = genderDefault;
        genderFilter.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView,
                                       View selectedItemView,
                                       int position,
                                       long id) {
                //Log.i("info", ((TextView)selectedItemView).getText().toString());
                selectedGender = ((TextView)selectedItemView).getText().toString();
                if(selectedGender.equals(genderDefault))
                {
                    resetRecyclerView();
                    return;
                }
                appointments = new ArrayList<>();
                int i = 0;
                for(Doctor doctor: FirebaseWrapper.getDoctorList()){
                    if(passesFilter(doctor)){
                        appointments.add(new Appointment(false, doctor.getEmail(), i, 1,1,1));
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
        specDefault = getResources().getStringArray(R.array.specialization)[0];
        selectedSpec = specDefault;
        specFilter.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView,
                                       View selectedItemView,
                                       int position,
                                       long id) {
                //Log.i("info", ((TextView)selectedItemView).getText().toString());
                selectedSpec = ((TextView)selectedItemView).getText().toString();
                if(selectedSpec.equals(specDefault)) {
                    resetRecyclerView();
                    return;
                }
                appointments = new ArrayList<>();
                int i = 0;
                for(Doctor doctor: FirebaseWrapper.getDoctorList()){
                    if(passesFilter(doctor)){
                        appointments.add(new Appointment(false, doctor.getEmail(), i, 1,1,1));
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
        appointments = new ArrayList<>();
        int i = 0;
        for(Doctor doctor: FirebaseWrapper.getDoctorList()){
            if(passesFilter(doctor)){
                appointments.add(new Appointment(false, doctor.getEmail(), i, 1,1,1));
                i++;
            }
        }

        // Create adapter and pass in appointment data
        BookingRecyclerAdapter adapter = new BookingRecyclerAdapter(this, appointments);

        // Attach adapter to RecyclerView
        rvBookingAppt.setAdapter(adapter);
    }

    public boolean passesFilter(Doctor doctor){
        boolean passGender = selectedGender.equals(genderDefault) || doctor.getGender().equals(selectedGender);
        boolean passSpec = selectedSpec.equals(specDefault) || doctor.getSpecialization().equals(selectedSpec);
        return passGender && passSpec;
    }
}