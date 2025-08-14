package com.example.fmradio.Listener;

import java.time.LocalDate;

public class ReportTechnicalIssue {
    private String issueType;
    private String description;
    private LocalDate issueDate;

    public ReportTechnicalIssue(String issueType, String description, LocalDate issueDate) {
        this.issueType = issueType;
        this.description = description;
        this.issueDate = issueDate;
    }

    public String getIssueType() {
        return issueType;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    @Override
    public String toString() {
        return "ReportTechnicalIssue{" +
                "issueType='" + issueType + '\'' +
                ", description='" + description + '\'' +
                ", issueDate=" + issueDate +
                '}';
    }
}
