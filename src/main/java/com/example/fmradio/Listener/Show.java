package com.example.fmradio.Listener;

import java.time.LocalDate;

public class Show {
    private String showId;
    private String title;
    private LocalDate airDate;
    private int duration;        // in minutes
    private String genre;

    public Show(String showId, String title, LocalDate airDate, int duration, String genre) {
        this.showId = showId;
        this.title = title;
        this.airDate = airDate;
        this.duration = duration;
        this.genre = genre;
    }

    public String getShowId() {
        return showId;
    }

    public void setShowId(String showId) {
        this.showId = showId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getAirDate() {
        return airDate;
    }

    public void setAirDate(LocalDate airDate) {
        this.airDate = airDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Show{" +
                "showId='" + showId + '\'' +
                ", title='" + title + '\'' +
                ", airDate=" + airDate +
                ", duration=" + duration +
                ", genre='" + genre + '\'' +
                '}';
    }

}
