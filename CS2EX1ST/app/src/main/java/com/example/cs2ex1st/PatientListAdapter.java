package com.example.cs2ex1st;

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

        public ViewHolder(View view) {
            super(view);
            patientNameTextView = (TextView)view.findViewById(R.id.patient_list_name);
            patientGender = (TextView)view.findViewById(R.id.patient_list_gender);
            patientDOB = (TextView)view.findViewById(R.id.patient_info_dob);
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
        viewHolder.patientNameTextView.setText(cur.toString());
        viewHolder.patientGender.setText(cur.getGender());
        viewHolder.patientDOB.setText(cur.getDOB());
    }

    @Override
    public int getItemCount() {
        return patientList.size();
    }
}