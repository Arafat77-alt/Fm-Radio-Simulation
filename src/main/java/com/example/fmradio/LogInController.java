package com.example.fmradio;

import com.example.fmradio.Producer.ProducerFxmlController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class LogInController
{
    @javafx.fxml.FXML
    private Button listenerButtonFXML;
    @javafx.fxml.FXML
    private Button advertiserFXID;
    @FXML
    private Button producerBtn;
    @FXML
    private Button stationManagerBtn;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void listenerButtonLogInOnAction(ActionEvent actionEvent) {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ListenerDashboard.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage dupstage = (Stage) listenerButtonFXML.getScene().getWindow();
            dupstage.setTitle(" Listener DashBoard view");
            dupstage.setScene(scene);
            dupstage.show();
        } catch (Exception e){

        }
    }

    @javafx.fxml.FXML
    public void AdvertiserButtonLogInOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("AdvertiserDashboard.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage dupstage = (Stage) advertiserFXID.getScene().getWindow();
            dupstage.setTitle(" Advertiser DashBoard view");
            dupstage.setScene(scene);
            dupstage.show();
        } catch (Exception e){

        }
    }





    @FXML
    public void producerOA(ActionEvent  event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/fmradio/Producer/ProducerFxml.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void stationManagerOA(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/fmradio/StationManager/StationManagerFxml.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
