package com.example.motorway;

import android.location.Location;

public class HelpMessage extends Message{
    String registrationNumber;
    String UId;
    Location loc;

    @Override
    public String getText() {
        return registrationNumber;
    }

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

    public Location getLoc() {
        return loc;
    }

    public void setLoc(Location loc) {
        this.loc = loc;
    }

    public HelpMessage(String registrationNumber, String UId, Location loc) {
        this.registrationNumber = registrationNumber;
        this.UId = UId;
        this.loc = loc;
        this.type = "Help";
    }
}
