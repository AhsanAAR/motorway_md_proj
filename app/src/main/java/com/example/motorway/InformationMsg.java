package com.example.motorway;

public class InformationMsg extends  Message{
    String Uid;

    public String getUid() {
        return Uid;
    }

    public void setUid(String uid) {
        Uid = uid;
    }

    public InformationMsg(String text, String uid) {
        this.text = text;
        Uid = uid;
        this.type = "Info";
    }

    public InformationMsg(){

    }
}
