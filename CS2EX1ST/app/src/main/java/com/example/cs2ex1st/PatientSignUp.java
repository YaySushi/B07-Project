package com.example.cs2ex1st;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.InputMismatchException;

public class PatientSignUp extends AppCompatActivity {
    private Spinner spinner;
    private TextView errorText, previousDoctorsText;
    private ArrayList<String> prevDoctors = new ArrayList<>();
    boolean[] selectedItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_sign_up);
        setTitle("Sign up (Patient)");
        spinner = (Spinner) findViewById(R.id.patientGenderSpinner);
        ArrayAdapter<CharSequence> genderAdapter = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item,
                getResources().getStringArray(R.array.gender));
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(genderAdapter);
        errorText = (TextView) findViewById(R.id.patientSignInErrorText);
        previousDoctorsText = (TextView) findViewById(R.id.prevDoctorsList);
        ArrayList<Doctor> allDoctors = FirebaseWrapper.getDoctorList();
        String[] displayItems = getDoctorNames(allDoctors);
        selectedItems = new boolean[displayItems.length];
        previousDoctorsText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder= new AlertDialog.Builder(PatientSignUp.this);
                builder.setTitle("Select Doctors");

                builder.setMultiChoiceItems(displayItems, selectedItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        if(isChecked){
                            prevDoctors.add(allDoctors.get(which).getEmail());
                        }
                        else{
                            prevDoctors.remove(allDoctors.get(which).getEmail());
                        }
                    }
                });
                builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String display = "";
                        for(String email: prevDoctors){
                            display += FirebaseWrapper.getDoctorWithKey(email).getFirstName() + ", ";
                        }
                        if(display.length() > 2) display = display.substring(0, display.length()-2);
                        previousDoctorsText.setText(display);
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Do nothing
                        prevDoctors.clear();
                        for(int i = 0; i < selectedItems.length; i++){
                            selectedItems[i] = false;
                        }
                        previousDoctorsText.setText("");
                    }
                });
                builder.create().show();
            }

        });
        errorText.setText("");
    }
    public void patientLogInInstead(View view) {
        Intent intent = new Intent(this, LogInActivity.class);
        startActivity(intent);
    }
    private String[] getDoctorNames(ArrayList<Doctor> allDoctors){
        ArrayList<String> doctors = new ArrayList<>();
        for(Doctor d: allDoctors){
            doctors.add(
                    d.getFirstName() + " " + d.getLastName() +", " + d.getGender() + ", " + "\n" +
                            d.getSpecialization() + "\n");
        }
        String[] s = new String[doctors.size()];
        doctors.toArray(s);
        return s;
    }
    public void submitPatientData(View view) {
        EditText editText = (EditText) findViewById(R.id.patientfirstname);
        String firstName = editText.getText().toString();
        editText = (EditText) findViewById(R.id.patientlastname);
        String lastName = editText.getText().toString();
        editText = (EditText) findViewById(R.id.patientemail);
        String email = editText.getText().toString();
        DatePicker dp = (DatePicker) findViewById(R.id.patientdob);
        String dob = myFormatDate(dp.getDayOfMonth(), dp.getMonth() + 1, dp.getYear());

        editText = (EditText) findViewById(R.id.patientPassword);
        String password = editText.getText().toString();


        User p1;
        try {

            p1 = new Patient(
                    firstName,
                    lastName,
                    email,
                    spinner.getSelectedItem().toString(),
                    dob,
                    prevDoctors,
                    password);
        } catch (InputMismatchException ex) {
            errorText.setText(ex.getMessage());
            return;
        }
        DatabaseReference ref2 = FirebaseDatabase.getInstance().getReference();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("ID/" + p1.getEmail());
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    errorText.setText("Email already exists.");
                } else {
                    ref2.child("Patient").child(p1.getEmail()).setValue(p1);
                    ref2.child("ID").child(p1.getEmail()).setValue(p1.getPassword() + ", Patient");

                    errorText.setText("");
                    Intent intent = new Intent(PatientSignUp.this, SignUpSuccess.class);
                    startActivity(intent);
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.toException());
            }
        });
    }
    public String myFormatDate(int day, int month, int year) {
        String out = "";
        if(day < 10) out += "0";
        out += day + "/";
        if(month < 10) out += "0";
        out += month + "/" + year;

        return out;
    }
}