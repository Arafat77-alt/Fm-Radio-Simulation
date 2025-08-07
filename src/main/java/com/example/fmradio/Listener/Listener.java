package com.example.fmradio.Listener;

public class Listener {
    private String listenerID;
    private String region;
    private String gender;

    public Listener(String listenerID, String region, String gender) {
        this.listenerID = listenerID;
        this.region = region;
        this.gender = gender;
    }

    public String getListenerID() {
        return listenerID;
    }

    public void setListenerID(String listenerID) {
        this.listenerID = listenerID;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void submitSongRequest(String songTitle, String artist, String shoutout){

    };


}
