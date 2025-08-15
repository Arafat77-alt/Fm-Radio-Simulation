package com.example.fmradio.Producer;

public class Show {
    private String type;
    private String segmentName;
    private String startTime;
    private String duration;

    public Show(String type, String segmentName, String startTime, String duration) {
        this.type = type;
        this.segmentName = segmentName;
        this.startTime = startTime;
        this.duration = duration;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSegmentName() {
        return segmentName;
    }

    public void setSegmentName(String segmentName) {
        this.segmentName = segmentName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Show{" +
                "type='" + type + '\'' +
                ", segmentName='" + segmentName + '\'' +
                ", startTime='" + startTime + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }
}
