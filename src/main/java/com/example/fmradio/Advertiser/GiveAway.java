package com.example.fmradio.Advertiser;

import java.time.LocalDate;

public class GiveAway {
    private String title;
    private String Prize;
    private LocalDate expirydate;
    private String Condition;


    public GiveAway(String title, String prize, LocalDate expirydate, String condition) {
        this.title = title;
        Prize = prize;
        this.expirydate = expirydate;
        Condition = condition;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrize() {
        return Prize;
    }

    public void setPrize(String prize) {
        Prize = prize;
    }

    public LocalDate getExpirydate() {
        return expirydate;
    }

    public void setExpirydate(LocalDate expirydate) {
        this.expirydate = expirydate;
    }

    public String getCondition() {
        return Condition;
    }

    public void setCondition(String condition) {
        Condition = condition;
    }

    @Override
    public String toString() {
        return "GiveAway{" +
                "title='" + title + '\'' +
                ", Prize='" + Prize + '\'' +
                ", expirydate=" + expirydate +
                ", Condition='" + Condition + '\'' +
                '}';
    }
}
