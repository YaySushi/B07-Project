package com.example.cs2ex1st;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LogInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
    }

    public void sendLogInInfo(View view) {
        //need 2 intents for 2 cases: failure and success
        //Intent intent = new Intent(this, ProfileDisplay.class);
        //startActivity(intent);
    }
}