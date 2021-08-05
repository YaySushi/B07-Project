package com.example.cs2ex1st;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LogInActivity extends AppCompatActivity {
    private TextView logInErrorText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        logInErrorText = (TextView) findViewById(R.id.errorText1);
        logInErrorText.setText("");
    }

    public void sendLogInInfo(View view) {
        EditText editText = (EditText) findViewById(R.id.emailaddress);
        String email = editText.getText().toString();
        email = email.replace('.', '*');
        editText = (EditText) findViewById(R.id.password);
        String password = editText.getText().toString();

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("ID/" + email);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    String[] info = ((String)dataSnapshot.getValue()).split(", ");
                    if (info[0].equals(password)) {
                        if (info[1].equals("Doctor")) {
                            Intent intent = new Intent(LogInActivity.this, activity_doctor_profile.class);
                            startActivity(intent);
                        } else {
                            Intent intent = new Intent(LogInActivity.this, activity_patient_profile.class);
                            startActivity(intent);
                        }
                    } else {
                        logInErrorText.setText("Password is incorrect.");
                        return;
                    }
                } else {
                    logInErrorText.setText("Email address is incorrect.");
                    return;
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.toException());
            }
        });
    }
}