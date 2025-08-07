package com.example.fmradio.Advertiser;

import java.time.LocalDate;

public class SponsoredPlaylist {

    private String advertiserId;
    private String playlistName;
    private LocalDate sponsorshipDate;

    public SponsoredPlaylist(String advertiserId, String playlistName, LocalDate sponsorshipDate) {
        this.advertiserId = advertiserId;
        this.playlistName = playlistName;
        this.sponsorshipDate = sponsorshipDate;
    }

    public String getAdvertiserId() {
        return advertiserId;
    }

    public void setAdvertiserId(String advertiserId) {
        this.advertiserId = advertiserId;
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
}
