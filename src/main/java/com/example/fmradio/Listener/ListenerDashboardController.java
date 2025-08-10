package com.example.fmradio.Listener;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ListenerDashboardController
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void bookMarkButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void songHistoryButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void reportButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void songRequestButton(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("SongRequest.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("New scene");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void pollParticipationButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void rateShowButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void createPlaylistDashBoardButtonOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("CreatePlaylist.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("New scene");
        stage.setScene(scene);
        stage.show();
    }
}