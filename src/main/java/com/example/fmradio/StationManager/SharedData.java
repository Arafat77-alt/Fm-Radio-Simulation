package com.example.fmradio.StationManager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;


public class SharedData {
    public static ObservableList<ScheduleManager> scheduleList = FXCollections.observableArrayList();
    public static ObservableList<Staff> rjList = FXCollections.observableArrayList();
    public static ObservableList<Staff> producerList = FXCollections.observableArrayList();

    static {

        scheduleList.addAll(
                new ScheduleManager("Morning Buzz", "08:00 - 10:00", "", "", LocalDate.of(2025, 7, 28)),
                new ScheduleManager("Evening Vibes", "18:00 - 20:00", "", "", LocalDate.of(2025, 7, 28))
        );


        rjList.addAll(
                new Staff("Arafat", "RJ", true, "Good performance in morning shows"),
                new Staff("Zayan", "RJ", true, "Strong with audience interaction")
        );


        producerList.addAll(
                new Staff("Nusrat", "Producer", true, "Highly organized and punctual"),
                new Staff("Samira", "Producer", true, "Experienced with news segments")
        );
    }
}

