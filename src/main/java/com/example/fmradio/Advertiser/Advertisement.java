package com.example.fmradio.Advertiser;

import java.io.Serializable;
import java.time.LocalDate;

public class Advertisement implements Serializable {
    private String title;
    private int duration;
    private String category;
    private LocalDate date;
    private String timeSlot;
    private String targetAudience;

    public Advertisement( String title, int duration, String category, LocalDate date, String timeSlot, String targetAudience) {

        this.title = title;
        this.duration = duration;
        this.category = category;
        this.date = date;
        this.timeSlot = timeSlot;
        this.targetAudience = targetAudience;
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

    public String getTargetAudience() {
        return targetAudience;
    }

    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    @Override
    public String toString() {
        return "Advertisement{" +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                ", category='" + category + '\'' +
                ", date=" + date +
                ", timeSlot='" + timeSlot + '\'' +
                ", targetAudience='" + targetAudience + '\'' +
                '}';
    }
}

