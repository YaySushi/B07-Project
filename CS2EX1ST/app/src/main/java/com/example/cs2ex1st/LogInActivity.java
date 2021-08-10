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
    private User u;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        setTitle("Login");
        logInErrorText = (TextView) findViewById(R.id.errorText1);
        logInErrorText.setText("");
    }

    public void signUpInstead(View view) {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }

    public void sendLogInInfo(View view) {
        EditText editText = (EditText) findViewById(R.id.emailaddress);
        String email = editText.getText().toString();
        email = email.replace('.', '*');
        editText = (EditText) findViewById(R.id.password);
        String password = editText.getText().toString();
        if (email.equals("")) {
            logInErrorText.setText("Email address cannot be empty.");
            return;
        }
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("ID/" + email);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    String[] info = ((String)dataSnapshot.getValue()).split(", ");
                    if (password.equals("")) {
                        logInErrorText.setText("Password cannot be empty.");
                        return;
                    }
                    if (info[0].equals(password)) {
                        if (info[1].equals("Doctor")) {
                            LoggedInUser.setUser((String)dataSnapshot.getKey(), "Doctor");
                            Intent intent = new Intent(LogInActivity.this, DoctorProfile.class);
                            startActivity(intent);
                        } else {
                            LoggedInUser.setUser((String)dataSnapshot.getKey(), "Patient");
                            Intent intent = new Intent(LogInActivity.this, PatientProfile.class);
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