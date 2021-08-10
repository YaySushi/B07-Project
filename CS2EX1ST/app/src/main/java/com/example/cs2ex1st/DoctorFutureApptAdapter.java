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

public class DoctorFutureApptAdapter extends RecyclerView.Adapter<DoctorFutureApptAdapter.ViewHolder> {
    // List of appointments
    private ArrayList<Appointment> appointments;

    public DoctorFutureApptAdapter(ArrayList<Appointment> appointments) {
        this.appointments = appointments;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView doctorNameTextView;
        private TextView patientNameTextView;
        private TextView apptTimeTextView;
        private ConstraintLayout mainLayout;

        public ViewHolder(View view) {
            super(view);
            doctorNameTextView = (TextView)view.findViewById(R.id.doctor_name);
            patientNameTextView = (TextView)view.findViewById(R.id.patient_name);
            apptTimeTextView = (TextView)view.findViewById(R.id.appt_time);
            mainLayout = (ConstraintLayout) view.findViewById(R.id.constraint_layout);
        }
    }

    @Override
    public DoctorFutureApptAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.item_appt, viewGroup, false);

        DoctorFutureApptAdapter.ViewHolder viewHolder = new DoctorFutureApptAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        // Get Appointment at position
        Appointment cur = appointments.get(position);

        // Set the views based on cur data
        try {
            TextView docName = viewHolder.doctorNameTextView;
            docName.setText(cur.DoctorGet().toString());
        } catch (Exception e) {
            TextView docName = viewHolder.doctorNameTextView;
            docName.setText("N/A");
        }

        try {
            TextView patientName = viewHolder.patientNameTextView;
            patientName.setText(cur.PatientGet().toString());
        } catch (Exception e) {
            TextView patientName = viewHolder.patientNameTextView;
            patientName.setText("N/A");
        }

        try {
            TextView apptTime = viewHolder.apptTimeTextView;
            apptTime.setText(cur.getDate());
        } catch (Exception e) {
            TextView apptTime = viewHolder.apptTimeTextView;
            apptTime.setText("N/A");
        }

        viewHolder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                LoggedInUser.setInspectingPatient(cur.PatientGet());
                Intent intent = new Intent(context, PatientInspect.class);
                context.startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return appointments.size();
    }
}
