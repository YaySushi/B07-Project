package com.example.cs2ex1st;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class BookApptActivity extends AppCompatActivity {
    RecyclerView rvBookingAppt;
    String selectedGender , selectedSpec;
    String genderDefault, specDefault;
    private ArrayList<Doctor> displayDoctors;
    private ArrayList<Doctor> allAvailableDoctors = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appt);

        setTitle("Select a Doctor to see times");
        Patient p = (Patient) LoggedInUser.getUser();
        for(String email: p.getPreviousDoctors()){
            if(FirebaseWrapper.getIdList().contains(email)){
                allAvailableDoctors.add(FirebaseWrapper.getDoctorWithKey(email));
            }
        }
        displayDoctors = new ArrayList<Doctor>();

        //update all doctors appointments
        for(Doctor doctor: FirebaseWrapper.getDoctorList()){
            doctor.update();
        }

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
                resetRecyclerView();
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
                resetRecyclerView();
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
        displayDoctors = new ArrayList<>();
        for(Doctor doctor: allAvailableDoctors){
            if(passesFilter(doctor)){
                displayDoctors.add(doctor);
            }
        }

        // Create adapter and pass in appointment data
        BookingRecyclerAdapter adapter = new BookingRecyclerAdapter(this, displayDoctors);

        // Attach adapter to RecyclerView
        rvBookingAppt.setAdapter(adapter);
    }

    public boolean passesFilter(Doctor doctor){
        boolean passGender = selectedGender.equals(genderDefault) || doctor.getGender().equals(selectedGender);
        boolean passSpec = selectedSpec.equals(specDefault) || doctor.getSpecialization().equals(selectedSpec);
        return passGender && passSpec;
    }
}