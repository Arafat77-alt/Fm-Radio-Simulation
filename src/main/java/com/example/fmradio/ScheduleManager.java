package com.example.fmradio;

import javafx.scene.control.Alert;

import java.time.LocalDate;

public class ScheduleManager {
    private String showName;
    private String timeSlot;
    private String rjName;
    private String producerName;
    private LocalDate showDate;
    private String status ;



    public ScheduleManager(String showName, String timeSlot, String rjName, String producerName, LocalDate showDate) {
        this.showName = showName;
        this.timeSlot = timeSlot;
        this.rjName = rjName;
        this.producerName = producerName;
        this.showDate = showDate;
        this.status = "Pending";
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    public String getRjName() {
        return rjName;
    }

    public void setRjName(String rjName) {
        this.rjName = rjName;
    }

    public LocalDate getShowDate() {
        return showDate;
    }

    public void setShowDate(LocalDate showDate) {
        this.showDate = showDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ScheduleManager{" +
                "showName='" + showName + '\'' +
                ", timeSlot='" + timeSlot + '\'' +
                ", rjName='" + rjName + '\'' +
                ", producerName='" + producerName + '\'' +
                ", showDate=" + showDate +
                ", status='" + status + '\'' +
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
