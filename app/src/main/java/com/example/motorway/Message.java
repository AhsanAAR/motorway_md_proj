package com.example.motorway;

import android.location.Location;

public class Message {
    String text_;
    String title_;
    String registrationNumber;
    Location loc;
    String email;

    public Message(){

    }

    public Message(String text_) {
        this.text_ = text_;
    }

    public String getText_() {
        return text_;
    }

    public void setText_(String text_) {
        this.text_ = text_;
    }

    public String getTitle_() {
        return title_;
    }

    public void setTitle_(String title_) {
        this.title_ = title_;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Location getLoc() {
        return loc;
    }

    public void setLoc(Location loc) {
        this.loc = loc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
