package com.example.fmradio.StationManager;

import javafx.event.ActionEvent;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

public class StationManagerFxmlController {

    @FXML
    public void initialize() {
    }

    @FXML
    public void teamMeetingOA(ActionEvent actionEvent) {
        loadScene("TeamMeetingFxml.fxml", actionEvent);
    }

    @FXML
    public void approveFinalPlaylistOA(ActionEvent actionEvent) {
        loadScene("FinalPlaylistFxml.fxml", actionEvent);
    }

    @FXML
    public void teamPerformanceOA(ActionEvent actionEvent) {
        loadScene("TeamPerformanceFxml.fxml", actionEvent);
    }

    @FXML
    public void weeklyProgramOA(ActionEvent actionEvent) {
        loadScene("WeeklyProgramFxml.fxml", actionEvent);
    }

    @FXML
    public void assignRjAndProducerOA(ActionEvent actionEvent) {
        loadScene("AssignFxml.fxml", actionEvent);
    }

    @FXML
    public void socialMediaEngagementOA(ActionEvent actionEvent) {
        loadScene("SocialMediaFxml.fxml", actionEvent);
    }

    @FXML
    public void emergencyShowCancellationOA(ActionEvent actionEvent) {
        loadScene("EmergencyShowCancelFxml.fxml", actionEvent);
    }

    @FXML
    public void singoutOA(ActionEvent actionEvent) {

    }

    @FXML
    public void advertiserSlotOA(ActionEvent actionEvent) {
        loadScene("ReviewAdvertiserFxml.fxml", actionEvent);
    }

    private void loadScene(String fxmlFile, ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
