package com.example.motorway;

import android.location.Location;

public class HelpMessage extends Message{
    String registrationNumber;
    String UId;
    double latitude;
    double longitude;

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getUId() {
        return UId;
    }

    public void setUId(String UId) {
        this.UId = UId;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public HelpMessage(String text, String registrationNumber, String UId,
                       double latitude, double longitude) {
        this.text = text;
        this.registrationNumber = registrationNumber;
        this.UId = UId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.type = "Help";
    }

    public HelpMessage() {

    }
}
