package com.example.cs2ex1st;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BookingRecyclerAdapter
        extends RecyclerView.Adapter<BookingRecyclerAdapter.ViewHolder> {
    // List of appointments
    private ArrayList<Appointment> appointments;
    private Context context;
    // Custom ViewHolder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nameField, timeField, genderField, specField, dateField;
        private ConstraintLayout mainLayout;
        public ViewHolder(View view) {
            super(view);

            nameField = (TextView)view.findViewById(R.id.booking_docname_field);
            timeField = (TextView)view.findViewById(R.id.booking_time_field);
            genderField = (TextView)view.findViewById(R.id.booking_gender_field);
            specField = (TextView)view.findViewById(R.id.booking_spec_field);
            dateField = (TextView)view.findViewById(R.id.booking_date_field);
            mainLayout = (ConstraintLayout) view.findViewById(R.id.main_layout);
        }
    }

    // Constructor
    public BookingRecyclerAdapter(Context context, ArrayList<Appointment> appointments) {
        this.context = context;
        this.appointments = appointments;
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
        Appointment cur = appointments.get(position);

        // Set the views based on cur data
        viewHolder.nameField.setText(cur.getDoctor().getFirstName() + " " + cur.getDoctor().getLastName());
        viewHolder.genderField.setText(cur.getDoctor().getGender());
        viewHolder.specField.setText(cur.getDoctor().getSpecialization());
        viewHolder.timeField.setText(cur.getHour() + ":00 - " + (cur.getHour()+1) + ":00");
        viewHolder.dateField.setText(cur.getDay() + "/" + cur.getMonth() + "/" + cur.getYear());

        viewHolder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Log.i("info", ""+cur.getDoctor().getFirstName());
                    Intent intent = new Intent(context, BookingConfirmActivity.class);
                    intent.putExtra("appointment", cur);
                    context.startActivity(intent);
            }
        });
    }

    // Return item count
    @Override
    public int getItemCount() {
        return appointments.size();
    }
}

