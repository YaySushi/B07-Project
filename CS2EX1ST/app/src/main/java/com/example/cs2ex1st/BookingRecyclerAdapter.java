package com.example.cs2ex1st;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BookingRecyclerAdapter
        extends RecyclerView.Adapter<BookingRecyclerAdapter.ViewHolder> {
    // List of appointments
    private ArrayList<Doctor> doctors;
    private Context context;
    private Appointment selectedAppointment;
    // Custom ViewHolder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nameField, genderField, specField;
        private ConstraintLayout mainLayout;
        public ViewHolder(View view) {
            super(view);

            nameField = (TextView)view.findViewById(R.id.booking_docname_field);
            //timeField = (TextView)view.findViewById(R.id.booking_time_field);
            genderField = (TextView)view.findViewById(R.id.booking_gender_field);
            specField = (TextView)view.findViewById(R.id.booking_spec_field);
            //dateField = (TextView)view.findViewById(R.id.booking_date_field);
            mainLayout = (ConstraintLayout) view.findViewById(R.id.main_layout);
        }
    }

    // Constructor
    public BookingRecyclerAdapter(Context context, ArrayList<Doctor> doctors) {
        this.context = context;
        this.doctors = doctors;
    }

    // Adapter methods that need to be overridden
    // Creates new views
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.item_book_appt, viewGroup, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    // Put content into views
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        // Get Appointment at position
        Doctor cur = doctors.get(position);

        // Set the views based on cur data
        viewHolder.nameField.setText(cur.getFirstName() + " " + cur.getLastName());
        viewHolder.genderField.setText(cur.getGender());
        viewHolder.specField.setText(cur.getSpecialization());
        //viewHolder.timeField.setText(cur.getHour() + ":00 - " + (cur.getHour()+1) + ":00");
        //viewHolder.dateField.setText(cur.getDay() + "/" + cur.getMonth() + "/" + cur.getYear());

        viewHolder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Doctor: " + cur.getFirstName() + " " + cur.getLastName() + " available times");
                builder.setCancelable(true);
                selectedAppointment = cur.getUnbookedAppointments().get(0);
                builder.setSingleChoiceItems(getAvailableTimes(cur), 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        selectedAppointment = cur.getUnbookedAppointments().get(which);
                    }
                });
                builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Patient user = (Patient)LoggedInUser.getUser();

                        if(user.book_appointment(selectedAppointment)){
                            Toast.makeText(context, "Appointment Sucessfully Booked", Toast.LENGTH_SHORT).show();
                            user.addToPreviousDoctors(cur.getEmail().replace('.', '*'));
                            FirebaseWrapper.updateDatabase();
                        }
                        else{
                            Toast.makeText(context, "Failed to book an appointment", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //close and do nothing
                    }
                });
                builder.create().show();
            }
            private String[] getAvailableTimes(Doctor doctor){
                ArrayList<String> times = new ArrayList<>();
                for(Appointment a: doctor.reserved_appointments){
                    if(!a.isBooked()){
                        times.add(a.getDate());
                    }
                }
                String[] s = new String[times.size()];
                times.toArray(s);
                return s;
            }
        });
    }

    // Return item count
    @Override
    public int getItemCount() {
        return doctors.size();
    }
}

