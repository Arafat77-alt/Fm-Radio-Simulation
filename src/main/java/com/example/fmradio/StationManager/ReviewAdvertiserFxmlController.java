package com.example.fmradio.StationManager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;

public class ReviewAdvertiserFxmlController
{
    @javafx.fxml.FXML
    private TableView<AdvertiserAdUsage> advertiserUsageTableView;
    @javafx.fxml.FXML
    private TableColumn<AdvertiserAdUsage,String> advertiserNameCol;
    @javafx.fxml.FXML
    private TableColumn<AdvertiserAdUsage,String> scheduleTimeCol;
    @javafx.fxml.FXML
    private TableColumn<AdvertiserAdUsage,String> adTitleCol;
    @javafx.fxml.FXML
    private TableColumn<AdvertiserAdUsage,String> numberOfPlaysCol;
    @javafx.fxml.FXML
    private TextArea contractTermsTextArea;
    @javafx.fxml.FXML
    private TableColumn<AdvertiserAdUsage,String> durationCol;
    @javafx.fxml.FXML
    private TableColumn<AdvertiserAdUsage,String> totalCostCol;
    @javafx.fxml.FXML
    private Label messageLabel;
    private ObservableList<AdvertiserAdUsage> adUsageList;
    @javafx.fxml.FXML
    private TableColumn<AdvertiserAdUsage,String> costPerMinCol;

    @javafx.fxml.FXML
    public void initialize() {
        adUsageList = FXCollections.observableArrayList();
        advertiserNameCol.setCellValueFactory(new PropertyValueFactory<>("advertiserName"));
        scheduleTimeCol.setCellValueFactory(new PropertyValueFactory<>("scheduleTime"));
        adTitleCol.setCellValueFactory(new PropertyValueFactory<>("adTitle"));
        numberOfPlaysCol.setCellValueFactory(new PropertyValueFactory<>("numberOfPlays"));
        durationCol.setCellValueFactory(new PropertyValueFactory<>("duration"));
        costPerMinCol.setCellValueFactory(new PropertyValueFactory<>("costPerMin"));
        totalCostCol.setCellValueFactory(new PropertyValueFactory<>("totalCost"));

        advertiserUsageTableView.setItems(adUsageList);
    }


    @javafx.fxml.FXML
    public void loadAdReportOA(ActionEvent actionEvent) {
        try {

            adUsageList.add(new AdvertiserAdUsage("Advertiser 1", "10:00 AM - 11:00 AM", "Ad Title 1", "10", "30 mins", 50.0, 500.0));
            adUsageList.add(new AdvertiserAdUsage("Advertiser 2", "11:00 AM - 12:00 PM", "Ad Title 2", "15", "30 mins", 60.0, 900.0));

            advertiserUsageTableView.refresh();
            messageLabel.setText("Ad usage report loaded.");

        } catch (Exception e) {
            e.printStackTrace();
            messageLabel.setText("Failed to load ad report: " + e.getMessage());
        }

    }

    @javafx.fxml.FXML
    public void checkConflictsOA(ActionEvent actionEvent) {
        boolean conflictFound = false;

        for (int i = 0; i < adUsageList.size(); i++) {
            AdvertiserAdUsage ad1 = adUsageList.get(i);
            for (int j = i + 1; j < adUsageList.size(); j++) {
                AdvertiserAdUsage ad2 = adUsageList.get(j);


                if (ad1.getScheduleTime().equals(ad2.getScheduleTime())) {
                    conflictFound = true;
                }
            }
        }
        if (conflictFound) {
            messageLabel.setText("Conflicts detected in ad schedule.");
        } else {
            messageLabel.setText("No conflicts found in ad schedule.");
        }
    }

    @javafx.fxml.FXML
    public void mainMenuOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void viewContractTermsOA(ActionEvent actionEvent) {
        contractTermsTextArea.setText("Contract terms: ...");
    }
}