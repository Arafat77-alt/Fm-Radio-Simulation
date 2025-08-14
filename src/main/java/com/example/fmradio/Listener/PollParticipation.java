package com.example.fmradio.Listener;

import java.io.Serializable;
import java.time.LocalDateTime;

public class PollParticipation implements Serializable {
    private String pollTitle;
    private String selectedOption;


    public PollParticipation( String pollTitle, String selectedOption) {

        this.pollTitle = pollTitle;
        this.selectedOption = selectedOption;

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



    @Override
    public String toString() {
        return "PollParticipation{" +
                ", pollTitle='" + pollTitle + '\'' +
                ", selectedOption='" + selectedOption + '\'' +
                '}';
    }

}
