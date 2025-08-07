package com.example.fmradio.StationManager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.Serializable;
import java.util.ArrayList;

public class StationData implements Serializable {
    private static final long serialVersionUID = 1L;


    private ArrayList<ScheduleManager> scheduleList;
    private ArrayList<Staff> rjList;
    private ArrayList<Staff> producerList;
    private ArrayList<PerformanceReport> performanceReports;
    private ArrayList<SocialMediaReport> socialMediaReports;
    private ArrayList<ScheduleManager> availableBackupShows;

    public StationData(ArrayList<ScheduleManager> scheduleList, ArrayList<Staff> rjList, ArrayList<Staff> producerList, ArrayList<PerformanceReport> performanceReports, ArrayList<SocialMediaReport> socialMediaReports, ArrayList<ScheduleManager> availableBackupShows) {
        this.scheduleList = scheduleList;
        this.rjList = rjList;
        this.producerList = producerList;
        this.performanceReports = performanceReports;
        this.socialMediaReports = socialMediaReports;
        this.availableBackupShows = availableBackupShows;
    }

    public ObservableList<ScheduleManager> getScheduleList() {
        return FXCollections.observableArrayList(scheduleList);
    }

    public ObservableList<Staff> getRjList() {
        return FXCollections.observableArrayList(rjList);
    }

    public ObservableList<Staff> getProducerList() {
        return FXCollections.observableArrayList(producerList);
    }

    public ObservableList<PerformanceReport> getPerformanceReports() {
        return FXCollections.observableArrayList(performanceReports);
    }

    public ObservableList<SocialMediaReport> getSocialMediaReports() {
        return FXCollections.observableArrayList(socialMediaReports);
    }

    public ObservableList<ScheduleManager> getAvailableBackupShows() {
        return FXCollections.observableArrayList(availableBackupShows);
    }

    @Override
    public String toString() {
        return "StationData{" +
                "scheduleList=" + scheduleList +
                ", rjList=" + rjList +
                ", producerList=" + producerList +
                ", performanceReports=" + performanceReports +
                ", socialMediaReports=" + socialMediaReports +
                ", availableBackupShows=" + availableBackupShows +
                '}';
    }
}

