package com.example.fmradio;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class LogInController
{
    @javafx.fxml.FXML
    private Button listenerButtonFXML;
    @javafx.fxml.FXML
    private Button advertiserFXID;

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

}
