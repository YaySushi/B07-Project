package com.example.cs2ex1st;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ApptAdapter extends RecyclerView.Adapter<ApptAdapter.ViewHolder> {
    // List of appointments
    private ArrayList<Appointment> appointments;

    // Custom ViewHolder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView doctorNameTextView;
        private TextView apptTimeTextView;

        public ViewHolder(View view) {
            super(view);

            doctorNameTextView = (TextView)view.findViewById(R.id.doctor_name);
            apptTimeTextView = (TextView)view.findViewById(R.id.appt_time);
        }
    }

    // Constructor
    public ApptAdapter(ArrayList<Appointment> appointments) {
        this.appointments = appointments;
    }

    // Adapter methods that need to be overridden
    // Creates new views
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.item_appt, viewGroup, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    // Put content into views
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        // Get Appointment at position
        Appointment cur = appointments.get(position);

        // Set the views based on cur data
        TextView docName = viewHolder.doctorNameTextView;
        docName.setText(cur.getDoctor().getFirstName() + " " + cur.getDoctor().getLastName());

        TextView apptTime = viewHolder.apptTimeTextView;
        apptTime.setText("Time: " + cur.getMillis());
    }

    // Return item count
    @Override
    public int getItemCount() {
        return appointments.size();
    }
}
