package com.example.fmradio.StationManager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;

public class SharedData {

    private static final String DATA_PATH = "data/";

    static {
        File directory = new File(DATA_PATH);
        if (!directory.exists()) {
            directory.mkdirs();
            System.out.println("✅ Directory created: " + DATA_PATH);
        }
    }


    public static StationData stationData = BinaryFileUtil.loadStationData(DATA_PATH + "station_data.bin");

    static {

        if (stationData == null) {
            ObservableList<ScheduleManager> scheduleList = FXCollections.observableArrayList();
            ObservableList<Staff> rjList = FXCollections.observableArrayList();
            ObservableList<Staff> producerList = FXCollections.observableArrayList();
            ObservableList<PerformanceReport> performanceReports = FXCollections.observableArrayList();
            ObservableList<SocialMediaReport> socialMediaReports = FXCollections.observableArrayList();
            ObservableList<ScheduleManager> availableBackupShows = FXCollections.observableArrayList();

            // Add default values to each list
            scheduleList.add(new ScheduleManager("Morning Buzz", "08:00 - 10:00", "Arafat", "Nusrat", LocalDate.now()));
            rjList.add(new Staff("Arafat", "RJ", true, "Good performance in morning shows"));
            producerList.add(new Staff("Nusrat", "Producer", true, "Highly organized and punctual"));
            performanceReports.add(new PerformanceReport("Arafat", "Punctual and engaged in morning shows", "", false));
            socialMediaReports.add(new SocialMediaReport("Morning Buzz", "Likes: 320, Shares: 50, Comments: 28", "", false));
            availableBackupShows.add(new ScheduleManager("Backup Morning Show", "10:00 - 11:00", "Lamia", "Anvir", LocalDate.now()));


            stationData = new StationData(new ArrayList<>(scheduleList), new ArrayList<>(rjList), new ArrayList<>(producerList),
                    new ArrayList<>(performanceReports), new ArrayList<>(socialMediaReports), new ArrayList<>(availableBackupShows));


            BinaryFileUtil.saveStationData(stationData, DATA_PATH + "station_data.bin");
        }
    }
}

