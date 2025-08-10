package com.example.fmradio.StationManager;

import javafx.scene.control.Alert;

public class AdvertiserAdUsage {
    private String advertiserName;
    private String scheduleTime;
    private String adTitle;
    private String numberOfPlays;
    private String duration;
    private double costPerMin;
    private double totalCost;

    public AdvertiserAdUsage(String advertiserName, String scheduleTime, String adTitle, String numberOfPlays, String duration, double costPerMin, double totalCost) {
        this.advertiserName = advertiserName;
        this.scheduleTime = scheduleTime;
        this.adTitle = adTitle;
        this.numberOfPlays = numberOfPlays;
        this.duration = duration;
        this.costPerMin = costPerMin;
        this.totalCost = totalCost;
    }

    public String getAdvertiserName() {
        return advertiserName;
    }

    public void setAdvertiserName(String advertiserName) {
        this.advertiserName = advertiserName;
    }

    public String getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(String scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    public String getAdTitle() {
        return adTitle;
    }

    public void setAdTitle(String adTitle) {
        this.adTitle = adTitle;
    }

    public String getNumberOfPlays() {
        return numberOfPlays;
    }

    public void setNumberOfPlays(String numberOfPlays) {
        this.numberOfPlays = numberOfPlays;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public double getCostPerMin() {
        return costPerMin;
    }

    public void setCostPerMin(double costPerMin) {
        this.costPerMin = costPerMin;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return "AdvertiserAdUsage{" +
                "advertiserName='" + advertiserName + '\'' +
                ", scheduleTime='" + scheduleTime + '\'' +
                ", adTitle='" + adTitle + '\'' +
                ", numberOfPlays='" + numberOfPlays + '\'' +
                ", duration='" + duration + '\'' +
                ", costPerMin=" + costPerMin +
                ", totalCost=" + totalCost +
                '}';
    }
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
