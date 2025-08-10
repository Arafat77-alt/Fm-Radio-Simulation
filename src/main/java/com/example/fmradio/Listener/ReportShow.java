package com.example.fmradio.Listener;

import java.time.LocalDate;

public class ReportShow {

    private String showTitle;
    private String reason;
    private String comment;
    private LocalDate reportDate;


    public ReportShow(String showTitle, String reason, String comment, LocalDate reportDate) {

        this.showTitle = showTitle;
        this.reason = reason;
        this.comment = comment;
        this.reportDate = reportDate;
    }



    public String getShowTitle() {
        return showTitle;
    }

    public void setShowTitle(String showTitle) {
        this.showTitle = showTitle;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDate getReportDate() {
        return reportDate;
    }

    public void setReportDate(LocalDate reportDate) {
        this.reportDate = reportDate;
    }

    @Override
    public String toString() {
        return "ReportShow{" +
                "listenerId='"  +
                ", showTitle='" + showTitle + '\'' +
                ", reason='" + reason + '\'' +
                ", comment='" + comment + '\'' +
                ", reportDate=" + reportDate +
                '}';
    }
}
