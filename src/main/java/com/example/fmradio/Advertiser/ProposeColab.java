package com.example.fmradio.Advertiser;

import java.time.LocalDate;

public class ProposeColab {
    private String showName;
    private LocalDate proposeDate;
    private String status;
    private String summary;

    public ProposeColab(String showName, LocalDate proposeDate, String status, String summary) {
        this.showName = showName;
        this.proposeDate = proposeDate;
        this.status = status;
        this.summary = summary;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public LocalDate getProposeDate() {
        return proposeDate;
    }

    public void setProposeDate(LocalDate proposeDate) {
        this.proposeDate = proposeDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public String toString() {
        return "ProposeColab{" +
                "showName='" + showName + '\'' +
                ", proposeDate=" + proposeDate +
                ", status='" + status + '\'' +
                ", summary='" + summary + '\'' +
                '}';
    }

}