package com.example.motorway;

import android.location.Location;

public class ReportMessage extends Message{
    Location loc;

    public Location getLoc() {
        return loc;
    }

    public void setLoc(Location loc) {
        this.loc = loc;
    }

    public ReportMessage(String text, Location loc) {
        this.text = text;
        this.loc = loc;
    }
}
