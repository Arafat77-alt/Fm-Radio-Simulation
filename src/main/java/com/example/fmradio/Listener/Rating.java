package com.example.fmradio.Listener;

public class Rating {

    private String listenerId;
    private String showTitle;
    private int rank;
    private String comment;

    public Rating(String listenerId, String showTitle, int rank, String comment) {
        this.listenerId = listenerId;
        this.showTitle = showTitle;
        this.rank = rank;
        this.comment = comment;
    }

    public String getListenerId() {
        return listenerId;
    }

    public void setListenerId(String listenerId) {
        this.listenerId = listenerId;
    }

    public String getShowTitle() {
        return showTitle;
    }

    public void setShowTitle(String showTitle) {
        this.showTitle = showTitle;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
