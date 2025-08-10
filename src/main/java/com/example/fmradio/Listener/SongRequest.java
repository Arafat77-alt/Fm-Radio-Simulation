package com.example.fmradio.Listener;

import java.time.LocalDate;


public class SongRequest {
    private String songTitle;
    private String artistName;
    private String shoutout;
    private LocalDate requestdate;


    public SongRequest(String songTitle, String artistName, String shoutout, LocalDate requestdate) {
        this.songTitle = songTitle;
        this.artistName = artistName;
        this.shoutout = shoutout;
        this.requestdate = requestdate;
    }


    public String getSongTitle() {
        return songTitle;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getShoutout() {
        return shoutout;
    }

    public void setShoutout(String shoutout) {
        this.shoutout = shoutout;
    }

    public LocalDate getRequestdate() {
        return requestdate;
    }

    public void setRequestdate(LocalDate requestdate) {
        this.requestdate = requestdate;
    }

    @Override
    public String toString() {
        return "SongRequest{" +
                ", songTitle='" + songTitle + '\'' +
                ", artistName='" + artistName + '\'' +
                ", shoutout='" + shoutout + '\'' +
                ", requestdate=" + requestdate +
                '}';
    }




};

