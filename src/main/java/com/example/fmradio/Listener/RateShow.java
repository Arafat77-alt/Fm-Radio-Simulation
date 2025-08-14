package com.example.fmradio.Listener;

import java.time.LocalDate;

public class RateShow {

    private String showTitle;
    private String rating;
    private String comment;
    private LocalDate dateOfRating;

    public RateShow(String showTitle, String rating, String comment, LocalDate dateOfRating) {
        this.showTitle = showTitle;
        this.rating = rating;
        this.comment = comment;
        this.dateOfRating = dateOfRating;
    }

    public String getShowTitle() {
        return showTitle;
    }

    public void setShowTitle(String showTitle) {
        this.showTitle = showTitle;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDate getDateOfRating() {
        return dateOfRating;
    }

    public void setDateOfRating(LocalDate dateOfRating) {
        this.dateOfRating = dateOfRating;
    }

    @Override
    public String toString() {
        return "RateShow{" +
                "showTitle='" + showTitle + '\'' +
                ", rating='" + rating + '\'' +
                ", comment='" + comment + '\'' +
                ", dateOfRating=" + dateOfRating +
                '}';
    }
}
