package com.example.cs2ex1st;

import android.content.Intent;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class Model implements Contract.Model {

    private HashMap<String, String> id;

    public Model() {
        id = FirebaseWrapper.getEmails();
    }

    public boolean checkEmail(String email) {
        return id.containsKey(email);
    }

    public boolean checkPassword(String email, String password) {
        String[] info = id.get(email).split(", ");
        return info[0].equals(password);
    }

    public boolean isDoctor(String email) {
        String[] info = id.get(email).split(", ");
        return info[1].equals("Doctor");
    }

}
