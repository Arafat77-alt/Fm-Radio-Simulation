package com.example.fmradio;

import java.time.LocalDateTime;
import java.util.List;

public class Meeting {
        private String title;
        private LocalDateTime dateTime;
        private List<String> participants;
        private String agenda;
        private boolean confirmed;

    public Meeting(String title, LocalDateTime dateTime, List<String> participants, String agenda, boolean confirmed) {
        this.title = title;
        this.dateTime = dateTime;
        this.participants = participants;
        this.agenda = agenda;
        this.confirmed = confirmed;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public List<String> getParticipants() {
        return participants;
    }

    public void setParticipants(List<String> participants) {
        this.participants = participants;
    }

    public String getAgenda() {
        return agenda;
    }

    public void setAgenda(String agenda) {
        this.agenda = agenda;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "title='" + title + '\'' +
                ", dateTime=" + dateTime +
                ", participants=" + participants +
                ", agenda='" + agenda + '\'' +
                ", confirmed=" + confirmed +
                '}';
    }
}
