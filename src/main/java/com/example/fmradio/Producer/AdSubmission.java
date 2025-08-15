package com.example.fmradio.Producer;

public class AdSubmission {
    private String adTitle;
    private String advertiserName;
    private String status;
    private String duration;
    private String submissionDate;

    public AdSubmission(String adTitle, String advertiserName, String status, String duration, String submissionDate) {
        this.adTitle = adTitle;
        this.advertiserName = advertiserName;
        this.status = status;
        this.duration = duration;
        this.submissionDate = submissionDate;
    }

    public String getAdTitle() {
        return adTitle;
    }

    public void setAdTitle(String adTitle) {
        this.adTitle = adTitle;
    }

    public String getAdvertiserName() {
        return advertiserName;
    }

    public void setAdvertiserName(String advertiserName) {
        this.advertiserName = advertiserName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(String submissionDate) {
        this.submissionDate = submissionDate;
    }

    @Override
    public String toString() {
        return "AdSubmission{" +
                "adTitle='" + adTitle + '\'' +
                ", advertiserName='" + advertiserName + '\'' +
                ", status='" + status + '\'' +
                ", duration='" + duration + '\'' +
                ", submissionDate='" + submissionDate + '\'' +
                '}';
    }
}
