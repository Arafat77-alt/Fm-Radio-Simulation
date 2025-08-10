package com.example.fmradio.StationManager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class TeamMeetingFxmlController
{
    @javafx.fxml.FXML
    private TableView<Staff> userCalenderTV;
    @javafx.fxml.FXML
    private TableColumn<Staff , String> availabilityCol;
    @javafx.fxml.FXML
    private DatePicker meetingDateDP;
    @javafx.fxml.FXML
    private TextField meetingTimeTextField;
    @javafx.fxml.FXML
    private TableColumn<Staff,String> userNameCol;
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
        String date = (meetingDateDP.getValue() != null) ? meetingDateDP.getValue().toString() : "";
        String time = meetingTimeTextField.getText().trim();
        String agenda = agendaTextArea.getText().trim();

        if (date.isEmpty() || time.isEmpty() || agenda.isEmpty()) {
            messageLabel.setText("⚠ Please fill in date, time, and agenda before sending invites.");
            return;
        }

        // Simulate sending invite
        StringBuilder inviteSummary = new StringBuilder(" Meeting Invite Sent:\n");
        inviteSummary.append(" Date: ").append(date).append("\n");
        inviteSummary.append(" Time: ").append(time).append("\n");
        inviteSummary.append(" Agenda: ").append(agenda).append("\n\n");

        inviteSummary.append(" Invited Team Members:\n");
        for (Staff staff : staffList) {
            if (staff.isAvailable()) {
                inviteSummary.append("• ").append(staff.getName()).append(" (").append(staff.getRole()).append(")\n");
            }
        }

        messageLabel.setText(inviteSummary.toString());
    }

    @javafx.fxml.FXML
    public void confirmOA(ActionEvent actionEvent) {
        String date = (meetingDateDP.getValue() != null) ? meetingDateDP.getValue().toString() : "";
        String time = meetingTimeTextField.getText().trim();
        String agenda = agendaTextArea.getText().trim();

        if (date.isEmpty() || time.isEmpty() || agenda.isEmpty()) {
            messageLabel.setText("⚠ Cannot confirm — missing meeting details.");
            return;
        }

        // Simulate confirmation action
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Meeting Confirmed");
        alert.setHeaderText(" Team Meeting Confirmed");
        alert.setContentText("Your meeting on " + date + " at " + time + " has been confirmed.\nAgenda: " + agenda);
        alert.showAndWait();

        messageLabel.setText(" Meeting confirmed and logged.");

        // Optional: Clear inputs
        meetingDateDP.setValue(null);
        meetingTimeTextField.clear();
        agendaTextArea.clear();
    }

    @javafx.fxml.FXML
    public void mainMenuOA(ActionEvent actionEvent) {
    }
}