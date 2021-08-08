package com.example.cs2ex1st;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.cs2ex1st.LogInActivity;
import com.example.cs2ex1st.R;
import com.example.cs2ex1st.SignUpActivity;
import com.google.firebase.database.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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