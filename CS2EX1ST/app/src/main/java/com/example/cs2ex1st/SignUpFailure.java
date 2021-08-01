package com.example.cs2ex1st;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SignUpFailure extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_failure);

        TextView textView = findViewById(R.id.errorMessage);
        textView.setText(getIntent().getStringExtra("ERROR_MESSAGE"));
    }

    public void trySignUpAgain(View view) {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }

    public void logInInstead(View view) {
        Intent intent = new Intent(this, LogInActivity.class);
        startActivity(intent);
    }
}