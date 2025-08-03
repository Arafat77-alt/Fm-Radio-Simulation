package com.example.fmradio.StationManager;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

public class ReviewAdvertiserFxmlController
{
    @javafx.fxml.FXML
    private TableView advertiserUsageTableView;
    @javafx.fxml.FXML
    private TableColumn advertiserNameCol;
    @javafx.fxml.FXML
    private TableColumn scheduleTimeCol;
    @javafx.fxml.FXML
    private TableColumn adTitleCol;
    @javafx.fxml.FXML
    private TableColumn numberOfPlaysCol;
    @javafx.fxml.FXML
    private TextArea contractTermsTextArea;
    @javafx.fxml.FXML
    private TableColumn durationCol;
    @javafx.fxml.FXML
    private TableColumn costPerMInCol;
    @javafx.fxml.FXML
    private TableColumn totalCostCol;
    @javafx.fxml.FXML
    private Label messageLabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void loadAdReportOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void checkConflictsOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void mainMenuOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void viewContractTermsOA(ActionEvent actionEvent) {
    }
}