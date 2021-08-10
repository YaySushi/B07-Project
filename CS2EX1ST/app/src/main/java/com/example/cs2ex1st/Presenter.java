package com.example.cs2ex1st;

public class Presenter {
    private Model model;
    private LogInActivity view;

    public Presenter(Model model, LogInActivity view) {
        this.model = model;
        this.view = view;
    }

    public void validateUser() {
        String email = view.getEmail().replace('.', '*');
        String password = view.getPassword();

        if (email.equals("")) {
            view.displayMessage("Email address cannot be empty.");
        }

        if (model.checkEmail(email)) {
            if (model.checkPassword(email, password)) {
                if (model.isDoctor(email)) {
                    LoggedInUser.setUser(email, "Doctor");
                    view.displayMessage("");
                    view.startDoctorProfile();
                } else {
                    LoggedInUser.setUser(email, "Patient");
                    view.displayMessage("");
                    view.startPatientProfile();
                }
            } else {
                view.displayMessage("Password is incorrect.");
            }
        } else {
            view.displayMessage("Email address is incorrect.");
        }

    }
}
