package com.example.fmradio.Advertiser;

public class Poll {
    private String pollId;
    private String advertiserId;
    private String Subject;

    public Poll(String pollId, String advertiserId, String subject) {
        this.pollId = pollId;
        this.advertiserId = advertiserId;
        Subject = subject;
    }

    public String getPollId() {
        return pollId;
    }

    public void setPollId(String pollId) {
        this.pollId = pollId;
    }

    public String getAdvertiserId() {
        return advertiserId;
    }

    public void setAdvertiserId(String advertiserId) {
        this.advertiserId = advertiserId;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    @Override
    public String toString() {
        return "Poll{" +
                "pollId='" + pollId + '\'' +
                ", advertiserId='" + advertiserId + '\'' +
                ", Subject='" + Subject + '\'' +
                '}';
    }
}
