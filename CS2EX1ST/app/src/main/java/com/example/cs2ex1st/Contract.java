package com.example.cs2ex1st;

import android.view.View;

public interface Contract {
    public interface View {
        public void displayMessage(String message);
        public String getEmail();
        public String getPassword();
        public void startDoctorProfile();
        public void startPatientProfile();
        public void signUpInstead(android.view.View view);
    }

    public interface Presenter {
        public void validateUser();
    }

    public interface Model {
        public boolean checkEmail(String email);
        public boolean checkPassword(String email, String password);
        public boolean isDoctor(String email);
    }
}
