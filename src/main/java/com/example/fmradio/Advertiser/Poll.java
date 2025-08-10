package com.example.fmradio.Advertiser;

import java.time.LocalDate;
import java.util.ArrayList;

public class Poll {
    private String pollId;
    private String pollsubject;

    private String question;
    private String optionOne;
    private String optionTwo;
    private String optionThree;
    private LocalDate dateOfPollCreate;
    private int optionNO;




    public Poll(String pollId, String pollsubject, String question, String optionOne, String optionTwo, String optionThree, LocalDate dateOfPollCreate, int optionNO) {
        this.pollId = pollId;
        this.pollsubject = pollsubject;

        this.question = question;
        this.optionOne = optionOne;
        this.optionTwo = optionTwo;
        this.optionThree = optionThree;
        this.dateOfPollCreate = dateOfPollCreate;
        this.optionNO = optionNO;
    }

    public int getOptionNO() {
        return optionNO;
    }

    public void setOptionNO(int optionNO) {
        this.optionNO = optionNO;
    }

    public String getPollId() {
        return pollId;
    }

    public void setPollId(String pollId) {
        this.pollId = pollId;
    }

    public String getPollsubject() {
        return pollsubject;
    }

    public void setPollsubject(String pollsubject) {
        this.pollsubject = pollsubject;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOptionOne() {
        return optionOne;
    }

    public void setOptionOne(String optionOne) {
        this.optionOne = optionOne;
    }

    public String getOptionTwo() {
        return optionTwo;
    }

    public void setOptionTwo(String optionTwo) {
        this.optionTwo = optionTwo;
    }

    public String getOptionThree() {
        return optionThree;
    }

    public void setOptionThree(String optionThree) {
        this.optionThree = optionThree;
    }

    public LocalDate getDateOfPollCreate() {
        return dateOfPollCreate;
    }

    public void setDateOfPollCreate(LocalDate dateOfPollCreate) {
        this.dateOfPollCreate = dateOfPollCreate;
    }


    @Override
    public String toString() {
        return "Poll{" +
                "pollId='" + pollId + '\'' +
                ", pollsubject='" + pollsubject + '\'' +
                ", question='" + question + '\'' +
                ", optionOne='" + optionOne + '\'' +
                ", optionTwo='" + optionTwo + '\'' +
                ", optionThree='" + optionThree + '\'' +
                ", dateOfPollCreate=" + dateOfPollCreate +
                ", optionNO=" + optionNO +
                '}';
    }
}
