package com.example.cs2ex1st;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.regex.Pattern;
public abstract class User implements Serializable {
    String email;
    String firstName;
    String lastName;
    String gender;
    String password;
    ArrayList<Appointment> reserved_appointments = new ArrayList<Appointment>();;
    ArrayList<Appointment> prior_appointments = new ArrayList<Appointment>();;
    public User(){}
    public User(String first,
                String last,
                String email,
                String gender,
                String password) throws InputMismatchException {
        if (first.equals("") || last.equals("") || first.equals(null) || last.equals(null)) {
            throw new InputMismatchException("Invalid name.");
        }
        if (!Pattern.matches("[a-zA-Z0-9]@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+|[a-zA-Z0-9]+[a-zA-Z0-9\\.]*[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+", email)) {
            throw new InputMismatchException("Invalid email.");
        }
        if(gender.equals("Choose...")){
            throw new InputMismatchException("Please choose a gender");
        }
        if (!Pattern.matches("\\w{4,}", password)) {
            throw new InputMismatchException("Invalid password.");
        }

        email = email.replace(".", "*");
        this.email = email;
        firstName = first;
        lastName = last;
        this.gender = gender;
        this.password = password;
        reserved_appointments=new ArrayList<Appointment>();
        prior_appointments=new ArrayList<Appointment>();
    }
    public void addAppointment(ArrayList<Appointment> app_list,Appointment app)
    {
        app_list.add(app);
    }
    public void removeAppointment(ArrayList<Appointment> app_list,Appointment app)
    {
        app_list.remove(app);
    }
    public void update()
    {
        //bad to remove from a list while iterating it.
        //so we accumulate the elements to remove, then remove them afterwards.
        ArrayList<Appointment> toRemove = new ArrayList<Appointment>();
        if(reserved_appointments == null) reserved_appointments = new ArrayList<>();
        if(prior_appointments == null) prior_appointments = new ArrayList<>();
        for(Appointment p:reserved_appointments)
        {
            if(p.getMillis()<System.currentTimeMillis())
            {
                prior_appointments.add(p);
                toRemove.add(p);
            }
        }
        for(Appointment p : toRemove)
        {
//            ArrayList<Patient> patients= p.DoctorGet().getFuturePatients();
//            ArrayList<Patient> patients_past= p.DoctorGet().getPreviousPatients();
//            patients_past.remove(p.PatientGet());
//            p.DoctorGet().setPreviousPatients(patients_past);
//            if(!(p.DoctorGet().getPreviousPatients().contains(p.PatientGet())))
//            {
//                patients.add(p.PatientGet());
//                p.DoctorGet().setFuturePatients(patients);
//            }
            reserved_appointments.remove(p);
        }
    }
    // Getter and setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public ArrayList<Appointment> getReserved_appointments() {
        return reserved_appointments;
    }

    public void setReserved_appointments(ArrayList<Appointment> reserved_appointments) {
        this.reserved_appointments = reserved_appointments;
    }

    public ArrayList<Appointment> getPrior_appointments() {
        return prior_appointments;
    }

    public void setPrior_appointments(ArrayList<Appointment> prior_appointments) {
        this.prior_appointments = prior_appointments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;
        return this.email.equals(((User) o).getEmail());
    }

    @Override
    public int hashCode() {
        return this.email.hashCode();
    }

    @Override
    public String toString() { return firstName + " " + lastName; }
}
