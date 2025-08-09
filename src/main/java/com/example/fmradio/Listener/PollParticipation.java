package com.example.fmradio.Listener;

import java.time.LocalDateTime;

public class PollParticipation {
    private String pollTitle;
    private String selectedOption;
    private LocalDateTime dateTime;

    public PollParticipation(String listenerId, String pollTitle, String selectedOption, LocalDateTime dateTime) {

        this.pollTitle = pollTitle;
        this.selectedOption = selectedOption;
        this.dateTime = dateTime;
    }


    public String getPollTitle() {
        return pollTitle;
    }

    public void setPollTitle(String pollTitle) {
        this.pollTitle = pollTitle;
    }

    public String getSelectedOption() {
        return selectedOption;
    }

    public void setSelectedOption(String selectedOption) {
        this.selectedOption = selectedOption;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "PollParticipation{" +
                ", pollTitle='" + pollTitle + '\'' +
                ", selectedOption='" + selectedOption + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }
}
