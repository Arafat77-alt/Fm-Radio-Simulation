package com.example.fmradio;
import com.example.fmradio.Staff;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;



public class AssignFxmlController
{
    @javafx.fxml.FXML
    private TableColumn<ScheduleManager,String> producerNameCol;
    @javafx.fxml.FXML
    private TableView<Staff> producerTV;
    @javafx.fxml.FXML
    private TableColumn<ScheduleManager,LocalDate> ShowDateCol;
    @javafx.fxml.FXML
    private TextField assignRjTF;
    @javafx.fxml.FXML
    private TableColumn<ScheduleManager,String> showTimeCol;
    @javafx.fxml.FXML
    private TextField assignProducerTF;
    @javafx.fxml.FXML
    private TableColumn<ScheduleManager,String > rjNameCol;
    @javafx.fxml.FXML
    private Label messageLabel;
    @javafx.fxml.FXML
    private TableView<ScheduleManager> showTableView;
    @javafx.fxml.FXML
    private TableView<Staff> rjTableView;
    @javafx.fxml.FXML
    private TableColumn<ScheduleManager,String> showNameCol;
    @javafx.fxml.FXML
    private TextArea performanceReportTA;


    private final ObservableList<ScheduleManager> scheduleList = SharedData.scheduleList;
    private final ObservableList<Staff> rjList = FXCollections.observableArrayList();
    private final ObservableList<Staff> producerList = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Staff,String> producerTableViewCol;
    @FXML
    private TableColumn<Staff,String> rjTableViewCOl;

    @FXML
    public void initialize(){
        rjList.addAll(
                new Staff("Arafat", "RJ", true, "Good performance in morning shows"),
                new Staff("Ariq", "RJ", true, "Strong with audience interaction")
        );

        producerList.addAll(
                new Staff("Nusrat", "Producer", true, "Highly organized and punctual"),
                new Staff("Samira", "Producer", true, "Experience managing news segments")
        );

        showNameCol.setCellValueFactory(new PropertyValueFactory<>("showName"));
        showTimeCol.setCellValueFactory(new PropertyValueFactory<>("timeSlot"));
        ShowDateCol.setCellValueFactory(new PropertyValueFactory<>("showDate"));
        producerNameCol.setCellValueFactory(new PropertyValueFactory<>("producerName"));
        rjNameCol.setCellValueFactory(new PropertyValueFactory<>("rjName"));
        showTableView.setItems(scheduleList);

        rjTableViewCOl.setCellValueFactory(new PropertyValueFactory<>("name"));
        rjTableView.setItems(rjList);
        rjTableView.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                assignRjTF.setText(newVal.getName());
                performanceReportTA.setText("RJ Report:\n" + newVal.getPerformanceNote());
            }
        });


        producerTableViewCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        producerTV.setItems(producerList);
        producerTV.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                assignProducerTF.setText(newVal.getName());
                performanceReportTA.setText("Producer Report:\n" + newVal.getPerformanceNote());
            }
        });


    }



    @javafx.fxml.FXML
    public void notifyOA(ActionEvent actionEvent) {
        String rj = assignRjTF.getText().trim();
        String producer = assignProducerTF.getText().trim();

        if (rj.isEmpty() || producer.isEmpty()) {
            messageLabel.setText(" Cannot notify without assigning both.");
            return;
        }

        messageLabel.setText(" Notified: " + rj + " and " + producer);
    }

    @javafx.fxml.FXML
    public void assignOA(ActionEvent actionEvent) {
        ScheduleManager selectedShow = showTableView.getSelectionModel().getSelectedItem();
        String rj = assignRjTF.getText().trim();
        String producer = assignProducerTF.getText().trim();

        if (selectedShow == null || rj.isEmpty() || producer.isEmpty()) {
            messageLabel.setText("Please select a show and both users.");
            return;
        }

        selectedShow.setRjName(rj);
        selectedShow.setProducerName(producer);
        messageLabel.setText("✔ Assigned " + rj + " and " + producer + " to the show: " + selectedShow.getShowName());

        // Refresh the table view to reflect changes
        showTableView.refresh();

    }

    @javafx.fxml.FXML
    public void backToMainMenuOA(ActionEvent actionEvent) {
    }
}