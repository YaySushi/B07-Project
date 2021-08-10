package com.example.cs2ex1st;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DoctorListAdapter extends RecyclerView.Adapter<DoctorListAdapter.ViewHolder> {
    private ArrayList<Doctor> doctorList;

    public DoctorListAdapter(ArrayList<Doctor> doctors) {
        this.doctorList = doctors;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView doctorNameTextView;
        private TextView doctorGender;
        private TextView doctorEmail;

        public ViewHolder(View view) {
            super(view);
            doctorNameTextView = (TextView)view.findViewById(R.id.doctor_info_name);
            doctorGender = (TextView)view.findViewById(R.id.doctor_info_gender);
            doctorEmail = (TextView)view.findViewById(R.id.doctor_info_email);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.item_doctor_list, viewGroup, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    // Put content into views
    @Override
    public void onBindViewHolder(DoctorListAdapter.ViewHolder viewHolder, int position) {
        // Get Appointment at position
        Doctor cur = doctorList.get(position);
        // Set the views based on cur data
        if(cur == null) return;
        viewHolder.doctorNameTextView.setText(cur.toString());
        viewHolder.doctorGender.setText( "(" + cur.getGender() + ")" );
        viewHolder.doctorEmail.setText(cur.getEmail().replace('*', '.'));
    }

    @Override
    public int getItemCount() {
        return doctorList.size();
    }
}