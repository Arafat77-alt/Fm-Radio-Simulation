package com.example.fmradio.Listener;

import java.time.LocalDateTime;

public class SongRequest {
    private String listenerId;
    private String songTitle;
    private String artistName;
    private String shoutout;
    private LocalDateTime dateTime;

    public SongRequest(String listenerId, String songTitle, String artistName, String shoutout, LocalDateTime dateTime) {
        this.listenerId = listenerId;
        this.songTitle = songTitle;
        this.artistName = artistName;
        this.shoutout = shoutout;
        this.dateTime = dateTime;
    }

    public String getListenerId() {
        return listenerId;
    }

    public void setListenerId(String listenerId) {
        this.listenerId = listenerId;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }

    public String getArtist() {
        return artistName;
    }

    public void setArtist(String artistName) {
        this.artistName = artistName;
    }

    public String getShoutout() {
        return shoutout;
    }

    public void setShoutout(String shoutout) {
        this.shoutout = shoutout;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }


    private boolean validateSongRequest(String songTitle, String artistName, String shoutout) {
            if (songTitle == null || songTitle.isEmpty()) {
                return false;
            }
            if (artistName == null || artistName.isEmpty()) {
                return false;
            }
            if (shoutout != null && shoutout.length() > 300) {
                return false;
            }
            return true;
        }
    };

