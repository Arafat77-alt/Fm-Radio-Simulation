package com.example.fmradio.Listener;

import com.example.fmradio.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ListenerDashboardController
{
    @javafx.fxml.FXML
    private Button createPlaylistFXID;
    @javafx.fxml.FXML
    private Button reportShowDashFXID;
    @javafx.fxml.FXML
    private Button bookMarkDashFXID;
    @javafx.fxml.FXML
    private Button rateShowDashFXID;
    @javafx.fxml.FXML
    private Button pollParticipationDashFXID;
    @javafx.fxml.FXML
    private Button songRequestFXID;
    @javafx.fxml.FXML
    private Button dedicateSongFXID;
    @javafx.fxml.FXML
    private Button technicalIssueFXID;
    @javafx.fxml.FXML
    private Button backFXID;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void bookMarkButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("BookMarkShow.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage dupstage = (Stage) bookMarkDashFXID.getScene().getWindow();
            dupstage.setTitle("Book Mark Window");
            dupstage.setScene(scene);
            dupstage.show();

        } catch (Exception e) {

        }
    }

    @javafx.fxml.FXML
    public void reportButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ReportShow.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage dupstage = (Stage) reportShowDashFXID.getScene().getWindow();
            dupstage.setTitle("Report content window");
            dupstage.setScene(scene);
            dupstage.show();

        } catch (Exception e) {

        }
    }

    @javafx.fxml.FXML
    public void songRequestButton(ActionEvent actionEvent) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("SongRequest.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage dupstage = (Stage) songRequestFXID.getScene().getWindow();

            dupstage.setScene(scene);
            dupstage.show();

        } catch (Exception e) {

        }
    }

    @javafx.fxml.FXML
    public void pollParticipationButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ListenerPollParticipation.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage dupstage = (Stage) pollParticipationDashFXID.getScene().getWindow();
            dupstage.setTitle("Participate the poll");
            dupstage.setScene(scene);
            dupstage.show();

        } catch (Exception e) {

        }

    }

    @javafx.fxml.FXML
    public void rateShowButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("RateShow.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage dupstage = (Stage) rateShowDashFXID.getScene().getWindow();
            dupstage.setTitle("Rate Show view");
            dupstage.setScene(scene);
            dupstage.show();

        } catch (Exception e) {

        }
    }

    @javafx.fxml.FXML
    public void createPlaylistDashBoardButtonOnAction(ActionEvent actionEvent)  {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("CreatePlaylist.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage dupstage = (Stage) createPlaylistFXID.getScene().getWindow();
            dupstage.setTitle("createplaylist view");
            dupstage.setScene(scene);
            dupstage.show();

        } catch (Exception e) {

        }
    }

    @javafx.fxml.FXML
    public void dedicateSongOnButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("dedicateSong.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage dupstage = (Stage) dedicateSongFXID.getScene().getWindow();

            dupstage.setScene(scene);
            dupstage.show();

        } catch (Exception e) {

        }
    }

    @javafx.fxml.FXML
    public void technicalIssueReportButtonDash(ActionEvent actionEvent) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ReportTechnicalIssue.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage dupstage = (Stage) technicalIssueFXID.getScene().getWindow();

            dupstage.setScene(scene);
            dupstage.show();

        } catch (Exception e) {

        }
    }

    @javafx.fxml.FXML
    public void backButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("LogIn.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage dupstage = (Stage) backFXID.getScene().getWindow();

            dupstage.setScene(scene);
            dupstage.show();

        } catch (Exception e) {

        }
    }
}