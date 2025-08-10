package com.example.fmradio.Listener;

import java.time.LocalDate;

public class BookMarkFavourite {
    private String showTitle;
    private String genre;
    private LocalDate date;
    private String category;

    public BookMarkFavourite( String showTitle, String genre, LocalDate date, String category) {
        this.showTitle = showTitle;
        this.genre = genre;
        this.date = date;
        this.category = category;
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
                "listenerId='" +
                ", showTitle='" + showTitle + '\'' +
                ", genre='" + genre + '\'' +
                ", date=" + date +
                ", category='" + category + '\'' +
                '}';
    }
}
