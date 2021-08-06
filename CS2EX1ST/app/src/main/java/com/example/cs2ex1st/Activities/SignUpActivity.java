package com.example.cs2ex1st.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.cs2ex1st.Activities.DoctorSignUp;
import com.example.cs2ex1st.Activities.PatientSignUp;
import com.example.cs2ex1st.FirebaseWrapper;
import com.example.cs2ex1st.R;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        FirebaseWrapper.printHashMap(FirebaseWrapper.getInstance().getDoctors());
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