package com.example.cs2ex1st.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cs2ex1st.Appointment;
import com.example.cs2ex1st.FirebaseWrapper;
import com.example.cs2ex1st.R;

public class BookingConfirmActivity extends AppCompatActivity {
    private TextView nameField, timeField, genderField, specField, dateField;
    private Appointment appointment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_booking_confirm);

        nameField = (TextView) findViewById(R.id.confirm_docname_field);
        timeField = (TextView) findViewById(R.id.confirm_time_field);
        genderField = (TextView) findViewById(R.id.confirm_gender_field);
        specField = (TextView) findViewById(R.id.confirm_spec_field);
        dateField = (TextView) findViewById(R.id.confirm_date_field);
        if(getIntent() != null && getIntent().getExtras() != null && getIntent().hasExtra("appointment")){
            appointment = (Appointment)getIntent().getSerializableExtra("appointment");
            Log.i("info","" + appointment.getDoctor().getGender());
            nameField.setText(appointment.getDoctor().getFirstName() + " " + appointment.getDoctor().getLastName());
            genderField.setText("Gender: " + appointment.getDoctor().getGender());
            specField.setText("Specialization: " + appointment.getDoctor().getSpecialization());
            timeField.setText("Time: " + appointment.getHour() + ":00 - " + (appointment.getHour()+1) + ":00");
            dateField.setText("Day: " + appointment.getDay() + "/" + appointment.getMonth() + "/" + appointment.getYear());
        }

        FirebaseWrapper.getInstance();
    }
    public void bookAppointment(View view){

        //LoggedInUser.getUser().addAppointment(LoggedInUser.getUser().reserved_appointments, appointment);

        Log.i("firebasehelper",""+FirebaseWrapper.getInstance().getDoctorList().size());
    }
}