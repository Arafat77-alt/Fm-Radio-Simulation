package com.example.fmradio.Advertiser;

import java.time.LocalDate;

public class Advertisement {
    private String adId;
    private String advertiserId;
    private String title;
    private int duration;
    private String category;
    private LocalDate date;
    private String timeSlot;

    public Advertisement(String adId, String advertiserId, String title, int duration, String category, LocalDate date, String timeSlot) {
        this.adId = adId;
        this.advertiserId = advertiserId;
        this.title = title;
        this.duration = duration;
        this.category = category;
        this.date = date;
        this.timeSlot = timeSlot;
    }

    public String getAdId() {
        return adId;
    }

    public void setAdId(String adId) {
        this.adId = adId;
    }

    public String getAdvertiserId() {
        return advertiserId;
    }

    public void setAdvertiserId(String advertiserId) {
        this.advertiserId = advertiserId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }
}
