package com.example.cs2ex1st;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

//singleton class that contains a User that's currently logged in.
public class LoggedInUser {
    private static User currentUser = null;

    public static User getUser() {
        return currentUser;
    }

    public static void setUser(User user) {
        currentUser = user;
    }

    public static void setUser(String email, String type) {
        DatabaseReference ref;
        if (type.equals("Doctor")) {
            ref = FirebaseDatabase.getInstance().getReference("Doctor/" + email);
        } else {
            ref = FirebaseDatabase.getInstance().getReference("Patient/" + email);
        }
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (type.equals("Doctor")) {
                    currentUser = (Doctor) dataSnapshot.getValue();
                } else {
                    currentUser = (Patient) dataSnapshot.getValue();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.toException());
            }
        });
    }
}
