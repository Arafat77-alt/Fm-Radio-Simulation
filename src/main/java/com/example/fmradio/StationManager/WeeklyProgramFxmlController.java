package com.example.fmradio.StationManager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class WeeklyProgramFxmlController {
    @javafx.fxml.FXML
    private TableColumn<ScheduleManager, String> producerNameCol;
    @javafx.fxml.FXML
    private Label outputLabel;
    @javafx.fxml.FXML
    private TableView<ScheduleManager> scheduleTableView;
    @javafx.fxml.FXML
    private TableColumn<ScheduleManager, String> showTimeCol;
    @javafx.fxml.FXML
    private TextField showTimeTF;
    @javafx.fxml.FXML
    private TextField producerNameTF;
    @javafx.fxml.FXML
    private TextField rjNameTF;
    @javafx.fxml.FXML
    private TableColumn<ScheduleManager, LocalDate> showDateCol;
    @javafx.fxml.FXML
    private TableColumn<ScheduleManager, String> rjNameCol;
    @javafx.fxml.FXML
    private TextField showNameTF;
    @javafx.fxml.FXML
    private TableColumn<ScheduleManager, String> showNameCol;
    @javafx.fxml.FXML
    private DatePicker showDateDP;

    @javafx.fxml.FXML
    private Label conflictLabel;
    @javafx.fxml.FXML
    private Label messageLabel;
    @javafx.fxml.FXML
    private TableColumn<ScheduleManager,String> statusCol;


    @javafx.fxml.FXML
    public void initialize() {
        showTimeCol.setCellValueFactory(new PropertyValueFactory<>("timeSlot"));
        showDateCol.setCellValueFactory(new PropertyValueFactory<>("showDate"));
        rjNameCol.setCellValueFactory(new PropertyValueFactory<>("rjName"));
        producerNameCol.setCellValueFactory(new PropertyValueFactory<>("producerName"));
        showNameCol.setCellValueFactory(new PropertyValueFactory<>("showName"));
        statusCol.setCellValueFactory(new  PropertyValueFactory<>("status"));

        scheduleTableView.setItems(SharedData.stationData.getScheduleList());
        scheduleTableView.refresh();

    }

    @javafx.fxml.FXML
    public void addToTableOA(ActionEvent actionEvent) {

            String name = showNameTF.getText();
            String time = showTimeTF.getText();
            String rj = rjNameTF.getText();
            String producer = producerNameTF.getText();
            LocalDate date = showDateDP.getValue();

            if (name.isEmpty() || time.isEmpty() || rj.isEmpty() || producer.isEmpty()) {
                messageLabel.setText("Please Enter Required Information");
                return;
            }


            SharedData.stationData.getScheduleList().add(new ScheduleManager(name, time, rj, producer, date));


            BinaryFileUtil.saveStationData(SharedData.stationData, "C:/intasgo.com/data/station_data.bin");

            clearFields();
            messageLabel.setText("Added to schedule!");
    }
    @javafx.fxml.FXML
    public void receiveProposalOA(ActionEvent actionEvent) {
        long pendingCount = SharedData.stationData.getScheduleList().stream()
                .filter(s -> "Pending".equalsIgnoreCase(s.getStatus()))
                .count();
        outputLabel.setText("You have " + pendingCount + " pending show proposals.");
    }


    @javafx.fxml.FXML
    public void checkConflictOA(ActionEvent actionEvent) {
        ScheduleManager selected = scheduleTableView.getSelectionModel().getSelectedItem();
        if (selected == null) {
            outputLabel.setText("Please select a show to approve.");
            return;
        }
        selected.setStatus("Approved");
        scheduleTableView.refresh();


        BinaryFileUtil.saveStationData(SharedData.stationData, "C:/intasgo.com/data/station_data.bin");
        outputLabel.setText("'" + selected.getShowName() + "' approved for broadcast.");
    }

    @javafx.fxml.FXML
    public void approveScheduleOA(ActionEvent actionEvent) {
        ScheduleManager selected = scheduleTableView.getSelectionModel().getSelectedItem();
        if (selected == null) {
            outputLabel.setText("Please select a show to approve.");
            return;
        }
        selected.setStatus("Approved");
        scheduleTableView.refresh();

        // Save updated schedule list to the file
        BinaryFileUtil.saveStationData(SharedData.stationData, "C:/intasgo.com/data/station_data.bin");
        outputLabel.setText("'" + selected.getShowName() + "' approved for broadcast.");
    }

    private void clearFields() {
        showTimeTF.clear();
        rjNameTF.clear();
        producerNameTF.clear();
        showDateDP.setValue(null);
    }

    @javafx.fxml.FXML
    public void mainMenuOA(ActionEvent actionEvent) {
    }
}


