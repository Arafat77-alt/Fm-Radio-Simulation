package com.example.fmradio.Advertiser;

import java.io.Serializable;

public class Bill implements Serializable {
    private String title;
    private int duration;


    private int numberOfSlots;
    private String timeCategory;
    private int totalPerAd;

    public Bill(String title, int duration, int numberOfSlots, String timeCategory, int totalPerAd) {
        this.title = title;
        this.duration = duration;
        this.numberOfSlots = numberOfSlots;
        this.timeCategory = timeCategory;
        this.totalPerAd = totalPerAd;

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

    public int getNumberOfSlots() {
        return numberOfSlots;
    }

    public void setNumberOfSlots(int numberOfSlots) {
        this.numberOfSlots = numberOfSlots;
    }

    public String getTimeCategory() {
        return timeCategory;
    }

    public void setTimeCategory(String timeCategory) {
        this.timeCategory = timeCategory;
    }

    public int getTotalPerAd() {
        return totalPerAd;
    }

    public void setTotalPerAd(int totalPerAd) {
        this.totalPerAd = totalPerAd;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "title='" + title + '\'' +
                ", duration=" + duration +
                ", numberOfSlots=" + numberOfSlots +
                ", timeCategory='" + timeCategory + '\'' +
                ", totalPerAd=" + totalPerAd +
                '}';
    }
}
