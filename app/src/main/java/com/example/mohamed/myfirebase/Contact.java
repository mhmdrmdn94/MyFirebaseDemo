package com.example.mohamed.myfirebase;

/**
 * Created by mohamed on 12/05/2017.
 */

public class Contact {
    String fullName, phone;

    public Contact(){
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public Contact(String fullName, String phone) {
        this.fullName = fullName;
        this.phone = phone;
    }


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
