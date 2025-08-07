package com.example.fmradio.Listener;

import java.time.LocalDate;

public class Playlist {
    private String listenerID;
    private String playListName;
    private LocalDate dateOfCreate;

    public Playlist(String listenerID, String playListName, LocalDate dateOfCreate) {
        this.listenerID = listenerID;
        this.playListName = playListName;
        this.dateOfCreate = dateOfCreate;
    }

    public String getListenerID() {
        return listenerID;
    }

    public void setListenerID(String listenerID) {
        this.listenerID = listenerID;
    }

    public String getPlayListName() {
        return playListName;
    }

    public void setPlayListName(String playListName) {
        this.playListName = playListName;
    }

    public LocalDate getDateOfCreate() {
        return dateOfCreate;
    }

    public void setDateOfCreate(LocalDate dateOfCreate) {
        this.dateOfCreate = dateOfCreate;
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "listenerID='" + listenerID + '\'' +
                ", playListName='" + playListName + '\'' +
                ", dateOfCreate=" + dateOfCreate +
                '}';
    }
}
