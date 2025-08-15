package com.example.fmradio.Producer;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ProducerFxmlController {

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void signoutOA(ActionEvent actionEvent) {
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

    @javafx.fxml.FXML
    public void assignPlaylistToRjOA(ActionEvent actionEvent) {
        loadScene("AssignPlaylistToRjFxml.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void preShowCheckOA(ActionEvent actionEvent) {
        loadScene("PreShowCheckFxml.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void coordinateWithAdvertiserOA(ActionEvent actionEvent) {
        loadScene("CoordinateWithAdvertiserFxml.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void listenerFeedbackOA(ActionEvent actionEvent) {
        loadScene("ListenerFeedbackFxml.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void assignPlaylistOA(ActionEvent actionEvent) {
        loadScene("AssignPlaylistFxml.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void monitorShowOA(ActionEvent actionEvent) {
        loadScene("MonitorShowFxml.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void uploadScriptOA(ActionEvent actionEvent) {
        loadScene("UploadScriptFxml.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void dailyReportOA(ActionEvent actionEvent) {
        loadScene("DailyReportFxml.fxml", actionEvent);
    }
}
