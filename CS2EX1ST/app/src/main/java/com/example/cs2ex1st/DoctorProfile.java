package com.example.cs2ex1st;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DoctorProfile extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_profile);
        setTitle("Profile");

        //LoggedInUser is assumed to be initialized from logging in.
        Doctor d = (Doctor)LoggedInUser.getUser();
        ((TextView)findViewById(R.id.textView25)).setText(d.toString());
        ((TextView)findViewById(R.id.textView26)).setText(d.getSpecialization());
        ((TextView)findViewById(R.id.textView31)).setText(d.getEmail().replace("*","."));
        ((TextView)findViewById(R.id.textView29)).setText(d.getGender());
    }

    public void goToDoctorAvailableAppointments(View view) {
        Intent intent = new Intent(this, DoctorAvailableAppt.class);
        startActivity(intent);
    }

    public void goToDoctorFutureAppointments(View view) {
        Intent intent = new Intent(this, DoctorFutureAppt.class);
        startActivity(intent);
    }

    public void goToDoctorPastAppointments(View view) {
        Intent intent = new Intent(this, DoctorPastAppt.class);
        startActivity(intent);
    }

    public void goToListOfPatients(View view) {
        Intent intent = new Intent(this, DisplayPatientsList.class);
        startActivity(intent);
    }

    public void deleteProfile(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirm Deletion");
        builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Doctor d = (Doctor)LoggedInUser.getUser();
                for(Patient p:FirebaseWrapper.getPatientList())
                {
                    p.remove_references_to_doc(d);
                }
                FirebaseWrapper.updateDatabase();
                FirebaseWrapper.deleteDoctorFromDatabase(d);
                LoggedInUser.setUser(null);
                LoggedInUser.setInspectingPatient(null);
                Toast.makeText(getApplicationContext(), "Account deleted successfully", Toast.LENGTH_LONG);
                Intent intent = new Intent(DoctorProfile.this, MainActivity.class);
                startActivity(intent);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Closes dialog
            }
        });
        builder.create().show();
    }

    public void doctorLogOut(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirm Log-out");
        builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                LoggedInUser.setUser(null);
                LoggedInUser.setInspectingPatient(null);
                Toast.makeText(getApplicationContext(), "Logged-out successfully", Toast.LENGTH_LONG);
                Intent intent = new Intent(DoctorProfile.this, MainActivity.class);
                startActivity(intent);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Closes dialog
            }
        });
        builder.create().show();
    }
}