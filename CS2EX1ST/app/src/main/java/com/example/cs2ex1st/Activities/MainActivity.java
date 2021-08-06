package com.example.cs2ex1st.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.cs2ex1st.FirebaseWrapper;
import com.example.cs2ex1st.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set up the lists created from the database
        FirebaseWrapper.getInstance();
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