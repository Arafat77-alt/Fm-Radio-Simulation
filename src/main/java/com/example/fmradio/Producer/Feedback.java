package com.example.fmradio.Producer;

public class Feedback {
    private String type;
    private String comment;
    private String segment;

    public Feedback(String type, String comment, String segment) {
        this.type = type;
        this.comment = comment;
        this.segment = segment;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getSegment() {
        return segment;
    }

    public void setSegment(String segment) {
        this.segment = segment;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "type='" + type + '\'' +
                ", comment='" + comment + '\'' +
                ", segment='" + segment + '\'' +
                '}';
    }
}
