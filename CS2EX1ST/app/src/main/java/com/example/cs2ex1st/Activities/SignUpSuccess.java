package com.example.cs2ex1st.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.cs2ex1st.Activities.LogInActivity;
import com.example.cs2ex1st.FirebaseWrapper;
import com.example.cs2ex1st.R;

public class SignUpSuccess extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_success);

        FirebaseWrapper.printHashMap(FirebaseWrapper.getInstance().getDoctors());
    }

    public void goToLogIn(View view) {
        Intent intent = new Intent(this, LogInActivity.class);
        startActivity(intent);
    }
}