package com.example.cs2ex1st;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PatientListAdapter extends RecyclerView.Adapter<PatientListAdapter.ViewHolder> {
    private ArrayList<Patient> patientList;

    public PatientListAdapter (ArrayList<Patient> patients) {
        this.patientList = patients;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView patientNameTextView;
        private TextView patientGender;
        private TextView patientDOB;
        private TextView listDoctors;

        public ViewHolder(View view) {
            super(view);

            patientNameTextView = (TextView)view.findViewById(R.id.patient_info1);
            patientGender = (TextView)view.findViewById(R.id.patient_info2);
            patientDOB = (TextView)view.findViewById(R.id.patient_info3);
            listDoctors = (TextView)view.findViewById(R.id.list_doctors);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.item_patient_list, viewGroup, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    // Put content into views
    @Override
    public void onBindViewHolder(PatientListAdapter.ViewHolder viewHolder, int position) {
        // Get Appointment at position
        Patient cur = patientList.get(position);
        // Set the views based on cur data
        viewHolder.patientNameTextView.setText("Patient: " + cur.toString());
        viewHolder.patientGender.setText("Gender: " + cur.getGender());
        viewHolder.patientDOB.setText("Date of Birth: " + cur.getDOB());
        viewHolder.listDoctors.setText("List of Doctors Visited: " + cur.getPreviousDoctors());
    }

    @Override
    public int getItemCount() {
        return patientList.size();
    }
}