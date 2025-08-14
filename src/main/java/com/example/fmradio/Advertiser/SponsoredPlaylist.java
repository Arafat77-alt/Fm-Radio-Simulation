package com.example.fmradio.Advertiser;

import java.io.Serializable;
import java.time.LocalDate;

public class SponsoredPlaylist implements Serializable {
    private String playlistName;
    private LocalDate sponsorshipDate;

    public SponsoredPlaylist( String playlistName, LocalDate sponsorshipDate) {
        this.playlistName = playlistName;
        this.sponsorshipDate = sponsorshipDate;
    }



    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public LocalDate getSponsorshipDate() {
        return sponsorshipDate;
    }

    public void setSponsorshipDate(LocalDate sponsorshipDate) {
        this.sponsorshipDate = sponsorshipDate;
    }

    @Override
    public String toString() {
        return "SponsoredPlaylist{" +
                ", playlistName='" + playlistName + '\'' +
                ", sponsorshipDate=" + sponsorshipDate +
                '}';
    }
}
