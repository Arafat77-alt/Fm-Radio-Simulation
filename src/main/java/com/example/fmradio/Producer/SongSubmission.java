package com.example.fmradio.Producer;

import java.io.Serializable;

public class SongSubmission implements Serializable {
    private String title;
    private String duration;
    private String status;

    public SongSubmission(String title, String duration, String status) {
        this.title = title;
        this.duration = duration;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SongSubmission{" +
                "title='" + title + '\'' +
                ", duration='" + duration + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

