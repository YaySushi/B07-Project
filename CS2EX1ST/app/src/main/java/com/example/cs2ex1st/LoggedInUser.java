package com.example.cs2ex1st;

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
        if (type.equals("Doctor")) {
            currentUser = FirebaseWrapper.getDoctors().get(email);
        } else {
            currentUser = FirebaseWrapper.getPatients().get(email);
        }
    }
}
