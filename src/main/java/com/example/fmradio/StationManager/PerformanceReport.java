package com.example.fmradio.StationManager;

import java.io.Serializable;

public class PerformanceReport implements Serializable {
    private static final long serialVersionUID = 1L;

    private String user;
    private String reportSummary;
    private String comment;
    private boolean reviewed;

    public PerformanceReport(String user, String reportSummary, String comment, boolean reviewed) {
        this.user = user;
        this.reportSummary = reportSummary;
        this.comment = comment;
        this.reviewed = reviewed;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getReportSummary() {
        return reportSummary;
    }

    public void setReportSummary(String reportSummary) {
        this.reportSummary = reportSummary;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isReviewed() {
        return reviewed;
    }

    public void setReviewed(boolean reviewed) {
        this.reviewed = reviewed;
    }

    @Override
    public String toString() {
        return "PerformanceReport{" +
                "user='" + user + '\'' +
                ", reportSummary='" + reportSummary + '\'' +
                ", comment='" + comment + '\'' +
                ", reviewed=" + reviewed +
                '}';
    }
}
