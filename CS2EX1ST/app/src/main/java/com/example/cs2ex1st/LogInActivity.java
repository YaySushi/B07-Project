package com.example.cs2ex1st;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LogInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
    }

    public void sendLogInInfo(View view) {
        EditText editText = (EditText) findViewById(R.id.emailaddress);
        String email = editText.getText().toString();
        email = email.replace('.', '*');
        editText = (EditText) findViewById(R.id.password);
        String password = editText.getText().toString();
        String finalEmail = email;

        boolean patientAcc = false;
        boolean doctorAcc = false;
        DatabaseReference ref1 = FirebaseDatabase.getInstance().getReference("Doctor");
        ref1.addValueEventListener(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        System.out.println("The read failed: " + databaseError.toException());
                    }
                });

        if (doctorAcc) {
            Intent intent = new Intent(this, activity_doctor_profile.class);
            startActivity(intent);
        } else if (patientAcc) {
            Intent intent = new Intent(this, activity_patient_profile.class);
            startActivity(intent);
        } else {
            Intent intent = new Intent(this, LoginFailure.class);
            startActivity(intent);
        }
    }
}