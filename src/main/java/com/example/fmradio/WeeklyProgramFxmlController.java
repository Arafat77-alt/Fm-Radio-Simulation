package com.example.fmradio;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

    private ObservableList<ScheduleManager> scheduleList = FXCollections.observableArrayList();
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

        scheduleTableView.setItems(scheduleList);


    }

    @javafx.fxml.FXML
    public void addToTableOA(ActionEvent actionEvent) {
        String name = showNameTF.getText();
        String time = showTimeTF.getText();
        String rj = rjNameTF.getText();
        String producer = producerNameTF.getText();
        LocalDate date = showDateDP.getValue();



        if (name.isEmpty() || time.isEmpty() || rj.isEmpty() || producer.isEmpty() ) {
            messageLabel.setText("PLease Enter Required Information");
            return;

        }

        System.out.println("Adding: " + name + ", " + time + ", " + rj + ", " + producer + ", " + date);

        scheduleList.add(new ScheduleManager(name, time, rj, producer, date));
        clearFields();
        messageLabel.setText("Added to schedule!");


    }

    @javafx.fxml.FXML
    public void receiveProposalOA(ActionEvent actionEvent) {
        long pendingCount = scheduleList.stream()
                .filter(entry -> entry.getStatus().equalsIgnoreCase("Pending"))
                .count();

        outputLabel.setText(" You have " + pendingCount + " pending show proposals.");

    }

    @javafx.fxml.FXML
    public void checkConflictOA(ActionEvent actionEvent) {
        for (int i = 0; i < scheduleList.size(); i++) {
            ScheduleManager entry1 = scheduleList.get(i);
            for (int j = i + 1; j < scheduleList.size(); j++) {
                ScheduleManager entry2 = scheduleList.get(j);

                if (entry1.getShowDate().equals(entry2.getShowDate()) &&
                        entry1.getTimeSlot().equalsIgnoreCase(entry2.getTimeSlot())) {

                    conflictLabel.setText(" Conflict between \"" + entry1.getShowName() +
                            "\" and \"" + entry2.getShowName() +
                            "\" on " + entry1.getShowDate() +
                            " at " + entry1.getTimeSlot());
                    return;
                }
            }
        }


        conflictLabel.setText("✅ No conflicts found.");
    }

    @javafx.fxml.FXML
    public void approveScheduleOA(ActionEvent actionEvent) {
        ScheduleManager selected = scheduleTableView.getSelectionModel().getSelectedItem();

        if (selected == null) {
            outputLabel.setText(" Please select a show to approve.");
            return;
        }

        selected.setStatus("Approved");
        scheduleTableView.refresh();  // needed to update table display
        outputLabel.setText("✅ \"" + selected.getShowName() + "\" approved for broadcast.");

    }
    private void clearFields() {
        showTimeTF.clear();
        showTimeTF.clear();
        rjNameTF.clear();
        producerNameTF.clear();
        showDateDP.setValue(null);
    }
}


