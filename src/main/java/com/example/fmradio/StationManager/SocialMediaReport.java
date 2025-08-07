package com.example.fmradio.StationManager;

import java.io.Serializable;

public class SocialMediaReport implements Serializable {
    private static final long serialVersionUID = 1L;

    private String showName;
    private String performanceSummary;
    private String suggestion;
    private boolean archived;

    public SocialMediaReport(String showName, String performanceSummary, String suggestion, boolean archived) {
        this.showName = showName;
        this.performanceSummary = performanceSummary;
        this.suggestion = suggestion;
        this.archived = archived;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public String getPerformanceSummary() {
        return performanceSummary;
    }

    public void setPerformanceSummary(String performanceSummary) {
        this.performanceSummary = performanceSummary;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }
    public String getReport() {
        return performanceSummary;
    }


    @Override
    public String toString() {
        return "SocialMediaReport{" +
                "showName='" + showName + '\'' +
                ", performanceSummary='" + performanceSummary + '\'' +
                ", suggestion='" + suggestion + '\'' +
                ", archived=" + archived +
                '}';
    }
}
