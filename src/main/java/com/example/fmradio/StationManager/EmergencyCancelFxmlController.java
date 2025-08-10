package com.example.fmradio.StationManager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class EmergencyCancelFxmlController
{
    @javafx.fxml.FXML
    private TextArea reciveAlertTextArea;
    @javafx.fxml.FXML
    private TableView<ScheduleManager> onGoingShowTable;
    @javafx.fxml.FXML
    private TableView<ScheduleManager> availableTableView;
    @javafx.fxml.FXML
    private TableColumn<ScheduleManager,String> showTimeCol;
    @javafx.fxml.FXML
    private TableColumn<ScheduleManager,String> availableRjCol;
    @javafx.fxml.FXML
    private TableColumn<ScheduleManager,String> timeSlotCol;
    @javafx.fxml.FXML
    private TableColumn<ScheduleManager,String> availableProducerCol;
    @javafx.fxml.FXML
    private TableColumn<ScheduleManager,String> showNameCOl;
    @javafx.fxml.FXML
    private TableColumn<ScheduleManager,String> rjCol;
    @javafx.fxml.FXML
    private TableColumn<ScheduleManager,String> producerCol;

    private final ObservableList<ScheduleManager> scheduleList = SharedData.stationData.getScheduleList();
    private final ObservableList<ScheduleManager> backupList = FXCollections.observableArrayList();
    @javafx.fxml.FXML
    private Label confirmationLabel;


    @javafx.fxml.FXML
    public void initialize() {
        showNameCOl.setCellValueFactory(new PropertyValueFactory<>("showName"));
        showTimeCol.setCellValueFactory(new PropertyValueFactory<>("timeSlot"));
        rjCol.setCellValueFactory(new PropertyValueFactory<>("rjName"));
        producerCol.setCellValueFactory(new PropertyValueFactory<>("producerName"));


        availableTableView.setItems(SharedData.stationData.getAvailableBackupShows());

        availableRjCol.setCellValueFactory(new PropertyValueFactory<>("rjName"));
        availableProducerCol.setCellValueFactory(new PropertyValueFactory<>("producerName"));
        timeSlotCol.setCellValueFactory(new PropertyValueFactory<>("timeSlot"));

        onGoingShowTable.setItems(SharedData.stationData.getScheduleList());


    }

    @javafx.fxml.FXML
    public void addNewShowOA(ActionEvent actionEvent) {
        ScheduleManager selectedBackup = availableTableView.getSelectionModel().getSelectedItem();

        if (selectedBackup == null) {
            confirmationLabel.setText("⚠ Please select an available backup show.");
            return;
        }

        // Optionally give it a unique name
        String newShowName = selectedBackup.getShowName() + " [Emergency Slot]";
        ScheduleManager newShow = new ScheduleManager(
                newShowName,
                selectedBackup.getTimeSlot(),
                selectedBackup.getRjName(),
                selectedBackup.getProducerName(),
                selectedBackup.getShowDate()
        );

        SharedData.stationData.getScheduleList().add(newShow);
        SharedData.stationData.getAvailableBackupShows().remove(selectedBackup);

        confirmationLabel.setText("'" + newShow.getShowName() + "' added to schedule.");

        onGoingShowTable.refresh();
        availableTableView.refresh();
    }



    @javafx.fxml.FXML
    public void notifyUsersOA(ActionEvent actionEvent){
        confirmationLabel.setText(" Users notified of new show assignment and update.");
    }


    @javafx.fxml.FXML
    public void cancelShowOA(ActionEvent actionEvent) {
        ScheduleManager selected = onGoingShowTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            confirmationLabel.setText(" Please select a show to cancel.");
            return;
        }

        scheduleList.remove(selected);  // Remove from live list
        confirmationLabel.setText(" Show '" + selected.getShowName() + "' has been cancelled.");
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @javafx.fxml.FXML
    public void receiveAlertOA(ActionEvent actionEvent) {
        String alertMsg = " Technician reports audio issue in 'Morning Buzz'";
        reciveAlertTextArea.setText(alertMsg);
        confirmationLabel.setText("Alert received. Please take action.");
    }

    @javafx.fxml.FXML
    public void mainMenuOA(ActionEvent actionEvent) {
    }
}