package com.example.fmradio.Listener;

import javafx.scene.control.Alert;

import java.io.Serializable;
import java.time.LocalDate;

public class CreatePlayList implements Serializable {
    private String playlistName;
    private int noOfSongs;
    private LocalDate dateofcreateplayList;

    public CreatePlayList(String playlistName, int noOfSongs, LocalDate dateofcreateplayList) {
        this.playlistName = playlistName;
        this.noOfSongs = noOfSongs;
        this.dateofcreateplayList = dateofcreateplayList;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public int getNoOfSongs() {
        return noOfSongs;
    }

    public void setNoOfSongs(int noOfSongs) {
        this.noOfSongs = noOfSongs;
    }

    public LocalDate getDateofcreateplayList() {
        return dateofcreateplayList;
    }

    public void setDateofcreateplayList(LocalDate dateofcreateplayList) {
        this.dateofcreateplayList = dateofcreateplayList;
    }

    @Override
    public String toString() {
        return "CreatePlayList{" +
                "playlistName='" + playlistName + '\'' +
                ", noOfSongs=" + noOfSongs +
                ", dateofcreateplayList=" + dateofcreateplayList +
                '}';
    }


}
