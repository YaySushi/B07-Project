package com.example.cs2ex1st;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setTitle("Sign up");
        // set up doctors for app useage
//        Doctor d = new Doctor("Bob", "Builder", "ash@gmail.com", "Male", "Anatomical Pathology", "pass");
//        FirebaseWrapper.addDoctorToDatabase(d);
//        d = new Doctor("Bugs", "Bunny", "doc@gmail.com", "Male", "Anatomical Pathology", "pass");
//        FirebaseWrapper.addDoctorToDatabase(d);
//        d = new Doctor("Doctor", "Phil", "doctor@gmail.com", "Male", "Diagnostic Radiology", "pass");
//        FirebaseWrapper.addDoctorToDatabase(d);
//        d = new Doctor("Get", "Bent", "get@gmail.com", "Female", "Clinical Immunology/Allergy", "pass");
//        FirebaseWrapper.addDoctorToDatabase(d);
//        d = new Doctor("John", "Johnson", "john@gmail.com", "Male", "Anesthesiology", "pass");
//        FirebaseWrapper.addDoctorToDatabase(d);
//        d = new Doctor("Micheal", "Mike", "mike@gmail.com", "Male", "Anatomical Pathology", "pass");
//        FirebaseWrapper.addDoctorToDatabase(d);
//        d = new Doctor("Bugs", "Bunny", "doc@gmail.com", "Male", "Dermatology", "pass");
//        FirebaseWrapper.addDoctorToDatabase(d);
//        d = new Doctor("Pascal", "Wager", "pascal@gmail.com", "Male", "General Surgery", "pass");
//        FirebaseWrapper.addDoctorToDatabase(d);
//        d = new Doctor("Pog", "Gers", "pog@gmail.com", "Female", "Cardiology", "pass");
//        FirebaseWrapper.addDoctorToDatabase(d);
//        d = new Doctor("Sergio", "Aguero", "sergio@gmail.com", "Male", "Anatomical Pathology", "pass");
//        FirebaseWrapper.addDoctorToDatabase(d);
//        d = new Doctor("Shelia", "Doves", "shelia@gmail.com", "Female", "Family Medicine", "pass");
//        FirebaseWrapper.addDoctorToDatabase(d);
    }

    public void doctorSignUp(View view) {
        Intent intent = new Intent(this, DoctorSignUp.class);
        startActivity(intent);
    }

    public void patientSignUp(View view) {
        Intent intent = new Intent(this, PatientSignUp.class);
        startActivity(intent);
    }
}