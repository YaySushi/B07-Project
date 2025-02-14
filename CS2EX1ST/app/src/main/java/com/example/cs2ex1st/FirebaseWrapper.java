package com.example.cs2ex1st;

import android.content.Intent;
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

    private static HashMap<String,Doctor> doctors = new HashMap<String,Doctor>();
    private static  HashMap<String,Patient> patients = new HashMap<String,Patient>();
    private static HashMap<String,String> emails = new HashMap<String,String>();
    /*
    This function should only be called once at the start of the app
     */
    public static void setUpHashMaps(){
        doctors = new HashMap<String,Doctor>();
        patients = new HashMap<String,Patient>();
        emails = new HashMap<String,String>();
        fillMapAtPath(doctors, DOCTOR_KEY, Doctor.class);
        fillMapAtPath(patients, PATIENT_KEY, Patient.class);
        fillMapAtPath(emails, ID_KEY, String.class);

    }

    private static <T> void fillMapAtPath(HashMap<String,T> list, String path, Class<T> typeClass){
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(path);
        // called once when the listener is added
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot child: dataSnapshot.getChildren()){
                    T t = child.getValue(typeClass);
                    list.put(child.getKey(),t);
                }
                printHashMap(list);
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
            Log.i("Firebase", key + ": " + value);
        }
    }
    public static void updateDatabase(){
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();

        for(Doctor d: getDoctorList()){
            ref.child(DOCTOR_KEY).child(d.getEmail()).setValue(d);
        }
        for(Patient p: getPatientList()){
            ref.child(PATIENT_KEY).child(p.getEmail()).setValue(p);
        }
        for(String id: getIdList()){
            ref.child(ID_KEY).child(id).setValue(getEmails().get(id));
        }
    }
    public static void addPatientToDatabase(Patient addMe){
        String key = addMe.email.replace(".","*");
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(PATIENT_KEY);
        ref.child(key).setValue(addMe);

        //add their keys as well.
        ref = FirebaseDatabase.getInstance().getReference(ID_KEY);
        ref.child(key).setValue(addMe.getPassword() + ", Patient");
    }
    public static void addDoctorToDatabase(Doctor addMe){
        String key = addMe.email.replace(".","*");
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(DOCTOR_KEY);
        ref.child(key).setValue(addMe);

        //add their keys as well.
        ref = FirebaseDatabase.getInstance().getReference(ID_KEY);
        ref.child(key).setValue(addMe.getPassword() + ", Doctor");
    }
    public static void updateDatabaseDoctor(Doctor doctor){
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(DOCTOR_KEY);
        ref.child(doctor.getEmail()).setValue(doctor);
    }
    public static void updateDatabasePatient(Patient patient){
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(PATIENT_KEY);
        ref.child(patient.getEmail()).setValue(patient);
    }
    public static void deleteDoctorFromDatabase(Doctor doctor){
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        ref.child(DOCTOR_KEY).child(doctor.email).removeValue();
        ref.child(ID_KEY).child(doctor.email).removeValue();
    }
    public static ArrayList<Doctor> getDoctorList(){
        return new ArrayList<Doctor>(doctors.values());
    }
    public static ArrayList<Patient> getPatientList(){
        return new ArrayList<Patient>(patients.values());
    }
    public static ArrayList<String> getIdList(){
        return new ArrayList<String>(emails.keySet());
    }
    public static ArrayList<String> getPassList(){ return new ArrayList<String>(emails.values()); }
    public static HashMap<String, Doctor> getDoctors() {
        return doctors;
    }

    public static HashMap<String, Patient> getPatients() {
        return patients;
    }

    public static HashMap<String, String> getEmails() {
        return emails;
    }

    public static Doctor getDoctorWithKey(String key) {
        return FirebaseWrapper.getDoctors().get(key);
    }

    public static Patient getPatientWithKey(String key) {
        return FirebaseWrapper.getPatients().get(key);
    }
}
