package com.example.fmradio.Listener;

import java.time.LocalDate;

public class Song {
    private String songId;
    private String title;
    private String artist;
    private String genre;
    private int duration;
    private LocalDate releaseDate;

    public Song(String songId, String title, String artist, String genre, int duration, LocalDate releaseDate) {
        this.songId = songId;
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.duration = duration;
        this.releaseDate = releaseDate;
    }

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }


}
