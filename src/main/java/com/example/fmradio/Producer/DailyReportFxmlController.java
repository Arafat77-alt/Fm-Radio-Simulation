package com.example.fmradio.Producer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DailyReportFxmlController
{
    @javafx.fxml.FXML
    private Label statusLabel;
    @javafx.fxml.FXML
    private TextArea summaryTextArea;
    private final String reportFile = "dailyReport.bin";

    @javafx.fxml.FXML
    public void initialize() {

    }

    @javafx.fxml.FXML
    public void uploadReportOA(ActionEvent actionEvent) {
        String summary = summaryTextArea.getText();
        if (summary.isEmpty()) {
            statusLabel.setText("Please write the show summary before uploading.");
            statusLabel.setStyle("-fx-text-fill: red;");
        } else {
            saveReportToFile(summary);
            statusLabel.setText("Report uploaded successfully!");
            statusLabel.setStyle("-fx-text-fill: green;");
        }
    }
    private void saveReportToFile(String summary) {
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(reportFile))) {
            out.writeUTF(summary);
        } catch (IOException e) {
            e.printStackTrace();
            statusLabel.setText("Error saving the report.");
            statusLabel.setStyle("-fx-text-fill: red;");
        }
    }

    @javafx.fxml.FXML
    public void attachPlaylistOA(ActionEvent actionEvent) {
        statusLabel.setText("Playlist attached.");
        statusLabel.setStyle("-fx-text-fill: blue;");
    }

    @javafx.fxml.FXML
    public void attachAdsOA(ActionEvent actionEvent) {
        statusLabel.setText("Ads attached.");
        statusLabel.setStyle("-fx-text-fill: blue;");
    }


    @javafx.fxml.FXML
    public void notifyManagerOA(ActionEvent actionEvent) {
        statusLabel.setText("Station Manager notified.");
        statusLabel.setStyle("-fx-text-fill: green;");

    }
    @FXML
    public void mainMenuOA(ActionEvent actionEvent) {
        loadProducerScene(actionEvent);
    }
    private void loadProducerScene(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ProducerFxml.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}