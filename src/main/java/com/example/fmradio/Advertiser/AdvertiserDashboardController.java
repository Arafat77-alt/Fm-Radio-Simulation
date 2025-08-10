package com.example.fmradio.Advertiser;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AdvertiserDashboardController
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void uploadAdvertisementOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void billSummaryOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void createPollAdvertiserButtonOnaction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("AdvertiserPollCreation.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("New scene");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void platylistSponsorOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void genetrateListenerReportOnAction(ActionEvent actionEvent) {
    }
}