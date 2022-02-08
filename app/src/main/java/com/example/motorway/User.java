package com.example.motorway;

public class User {
    String name;
    String emailAddress;
    String UID;
    String phoneNumber;

    public User(String name, String emailAddress, String UID, String phoneNumber) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.UID = UID;
        this.phoneNumber = phoneNumber;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
