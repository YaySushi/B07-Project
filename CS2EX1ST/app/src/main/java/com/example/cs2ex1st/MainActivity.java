package com.example.cs2ex1st;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.cs2ex1st.LogInActivity;
import com.example.cs2ex1st.R;
import com.example.cs2ex1st.SignUpActivity;
import com.google.firebase.database.*;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Doctor d = new Doctor("Muffy",
        //        "Crosswire",
        //        "muffy@gmail.com",
        //        "Female",
        //        "Pediatrics",
        //        "iammuffy");
        //DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        //ref.child("Doctor").child("muffy@gmail*com").setValue(d);
////
        ////add their keys as well.
        //ref = FirebaseDatabase.getInstance().getReference();
        //ref.child("ID").child("muffy@gmail*com").setValue(d.getPassword() + ", Doctor");
//
        //ArrayList<String> prevDoctors  = new ArrayList<String>();
        //Patient p = new Patient("Ali",
        //        "Orozgani",
        //        "ali@gmail.com",
        //        "Male",
        //        "09/08/2002",
        //         prevDoctors,
        //        "iamali");
//
        //ref = FirebaseDatabase.getInstance().getReference();
        //ref.child("Patient").child("ali@gmail*com").setValue(p);
////
        ////add their keys as well.
        //ref = FirebaseDatabase.getInstance().getReference();
        //ref.child("ID").child("ali@gmail*com").setValue(p.getPassword() + ", Patient");


        //Set up the lists created from the database
        FirebaseWrapper.setUpHashMaps();
    }

    public void sendSignUpMessage(View view) {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }

    public void sendLogInMessage(View view) {
        Intent intent = new Intent(this, LogInActivity.class);
        startActivity(intent);
    }

}