package com.example.cs2ex1st;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        User d1;
        String email = "asdfasdf@gmail.com";
        d1 = new Doctor("asdf", "asdf", email, "asdfasdf?", "asdfasdf", "passsssssss");

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        ref.child("sushi writing this").child("sushi's child").setValue(d1);
        Log.i("TESTINGGGGG", "HI HELLO THERE"); //check in logcat.
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