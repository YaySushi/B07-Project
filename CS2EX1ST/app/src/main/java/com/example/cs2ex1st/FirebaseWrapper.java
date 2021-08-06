package com.example.cs2ex1st;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
/*
Converts Database json objects into Java HashMaps
 */
public class FirebaseWrapper {
    public static final String DOCTOR_KEY = "Doctor";
    public static final String PATIENT_KEY = "Patient";
    public static final String ID_KEY = "ID";

    private static FirebaseWrapper instance;
    private HashMap<String,Doctor> doctors = new HashMap<String,Doctor>();
    private HashMap<String,Patient> patients = new HashMap<String,Patient>();
    private HashMap<String,String> emails = new HashMap<String,String>();
    private FirebaseWrapper(){
        fillMapAtPath(doctors, DOCTOR_KEY, Doctor.class);
        fillMapAtPath(patients, PATIENT_KEY, Patient.class);
        fillMapAtPath(emails, ID_KEY, String.class);

    }

    public static FirebaseWrapper getInstance() {
        if(instance == null){
            instance = new FirebaseWrapper();
        }
        return instance;
    }

    private <T> void fillMapAtPath(HashMap<String,T> list, String path, Class<T> typeClass){
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(path);
        // called once when the listener is added
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                list.clear();
                for(DataSnapshot child: dataSnapshot.getChildren()){
                    T t = child.getValue(typeClass);
                    list.put(dataSnapshot.getKey(),t);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });
    }
    public static <T extends Object> void printHashMap(HashMap<String,T> map){
        for (String key: map.keySet()) {
            String value = map.get(key).toString();
            System.out.println(key + " " + value);
        }
    }
    public static void addPatientToDatabase(Patient addMe){
        // TODO
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Patient");
        ref.child(addMe.email.replace(".","*")).setValue(addMe);
    }
    public ArrayList<Doctor> getDoctorList(){
        return new ArrayList<Doctor>(doctors.values());
    }
    public ArrayList<Patient> getPatientList(){
        return new ArrayList<Patient>(patients.values());
    }
    public ArrayList<String> getIdList(){
        return new ArrayList<String>(emails.keySet());
    }

    public HashMap<String, Doctor> getDoctors() {
        return doctors;
    }

    public HashMap<String, Patient> getPatients() {
        return patients;
    }

    public HashMap<String, String> getEmails() {
        return emails;
    }
}
