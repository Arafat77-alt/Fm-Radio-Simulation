package com.example.fmradio;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class TeamMeetingFxmlController
{
    @javafx.fxml.FXML
    private TableView<user> userCalenderTV;
    @javafx.fxml.FXML
    private TableColumn<user , String> availabilityCol;
    @javafx.fxml.FXML
    private DatePicker meetingDateDP;
    @javafx.fxml.FXML
    private TextField meetingTimeTextField;
    @javafx.fxml.FXML
    private TableColumn<user,String> userNameCol;
    @javafx.fxml.FXML
    private Label messageLabel;
    @javafx.fxml.FXML
    private TextArea agendaTextArea;

    private final ObservableList<Staff> staffList = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {

        staffList.addAll(
                new Staff("Arafat", "RJ", true, "Always punctual"),
                new Staff("Nusrat", "Producer", false, "Busy on weekends"),
                new Staff("Zayan", "RJ", true, "Available evenings"),
                new Staff("Samira", "Producer", true, "Good availability")
        );
        userNameCol.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getName()));
        availabilityCol.setCellValueFactory(cellData -> {
           String availability = cellData.getValue().isAvailable() ? "Available" : "Busy";
            return new javafx.beans.property.SimpleStringProperty(availability);
        });

        userCalenderTV.setItems(staffList);
   }


    @javafx.fxml.FXML
    public void sendInviteOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void confirmOA(ActionEvent actionEvent) {
    }
}