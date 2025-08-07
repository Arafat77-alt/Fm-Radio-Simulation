package com.example.fmradio.Listener;

import java.time.LocalDate;

public class BookMarkFavourite {
    private String listenerId;
    private String showId;
    private String showTitle;
    private String genre;
    private LocalDate date;
    private String category;

    public BookMarkFavourite(String listenerId, String showId, String showTitle, String genre, LocalDate date, String category) {
        this.listenerId = listenerId;
        this.showId = showId;
        this.showTitle = showTitle;
        this.genre = genre;
        this.date = date;
        this.category = category;
    }

    public String getListenerId() {
        return listenerId;
    }

    public void setListenerId(String listenerId) {
        this.listenerId = listenerId;
    }

    public String getShowId() {
        return showId;
    }

    public void setShowId(String showId) {
        this.showId = showId;
    }

    public String getShowTitle() {
        return showTitle;
    }

    public void setShowTitle(String showTitle) {
        this.showTitle = showTitle;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "BookMarkFavourite{" +
                "listenerId='" + listenerId + '\'' +
                ", showId='" + showId + '\'' +
                ", showTitle='" + showTitle + '\'' +
                ", genre='" + genre + '\'' +
                ", date=" + date +
                ", category='" + category + '\'' +
                '}';
    }
}
