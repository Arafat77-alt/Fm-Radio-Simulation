package com.example.fmradio.StationManager;

import javafx.beans.property.StringProperty;

public class Song {
    private String songName;
    private String album;
    private String artist;
    private String duration;
    private boolean isDuplicate;

    public Song(String songName, String album, String artist, String duration, boolean isDuplicate) {
        this.songName = songName;
        this.album = album;
        this.artist = artist;
        this.duration = duration;
        this.isDuplicate = false;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public boolean isDuplicate() {
        return isDuplicate;
    }

    public void setDuplicate(boolean duplicate) {
        isDuplicate = duplicate;
    }

    @Override
    public String toString() {
        return "Song{" +
                "songName='" + songName + '\'' +
                ", album='" + album + '\'' +
                ", artist='" + artist + '\'' +
                ", duration='" + duration + '\'' +
                ", isDuplicate=" + isDuplicate +
                '}';
    }
}
