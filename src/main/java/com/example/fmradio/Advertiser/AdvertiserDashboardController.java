package com.example.fmradio.Advertiser;

import com.example.fmradio.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class AdvertiserDashboardController
{
    @javafx.fxml.FXML
    private Button createPollFXID;
    @javafx.fxml.FXML
    private Button billSummaryFXID;
    @javafx.fxml.FXML
    private Button sponsorPLaylistFXID;
    @javafx.fxml.FXML
    private Button uploadAdvertisemenFXML;
    @javafx.fxml.FXML
    private Button proposeColabFXID;
    @javafx.fxml.FXML
    private Button asDiscountFXID;
    @javafx.fxml.FXML
    private Button giveAwayFXID;
    @javafx.fxml.FXML
    private Button cancelAdFXID;
    @javafx.fxml.FXML
    private Button backFXID;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void uploadAdvertisementOnAction(ActionEvent actionEvent) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ScheduleAdvertisement.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage dupstage = (Stage) uploadAdvertisemenFXML.getScene().getWindow();
            dupstage.setTitle(" Advertisement Scheduling");
            dupstage.setScene(scene);
            dupstage.show();
        } catch (Exception e) {
        }
    }

    @javafx.fxml.FXML
    public void billSummaryOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("BillOfAdvertisement.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage dupstage = (Stage) billSummaryFXID.getScene().getWindow();
            dupstage.setTitle(" Generate Bill");
            dupstage.setScene(scene);
            dupstage.show();

        } catch (Exception e) {

        }


    }

    @javafx.fxml.FXML
    public void createPollAdvertiserButtonOnaction(ActionEvent actionEvent)  {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("AdvertiserPollCreation.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage dupstage = (Stage) createPollFXID.getScene().getWindow();
            dupstage.setTitle("Poll Creation Page");
            dupstage.setScene(scene);
            dupstage.show();

        } catch (Exception e) {

        }
    }



    @javafx.fxml.FXML
    public void platylistSponsorOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("SponsorPlaylist.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage dupstage = (Stage) sponsorPLaylistFXID.getScene().getWindow();
            dupstage.setTitle("Poll Creation Page");
            dupstage.setScene(scene);
            dupstage.show();

        } catch (Exception e) {

        }


    }

    @javafx.fxml.FXML
    public void adDiscountButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("DiscountCodeGive.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage dupstage = (Stage) asDiscountFXID.getScene().getWindow();
            dupstage.setTitle("Discount Code");
            dupstage.setScene(scene);
            dupstage.show();

        } catch (Exception e) {

        }
    }

    @javafx.fxml.FXML
    public void giveAwayButtonONAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("GiveAwaySponsor.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage dupstage = (Stage) giveAwayFXID.getScene().getWindow();
            dupstage.setTitle("GiveAway");
            dupstage.setScene(scene);
            dupstage.show();

        } catch (Exception e) {

        }


    }

    @javafx.fxml.FXML
    public void proposeColabShowFXID(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ProposeColabShow.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage dupstage = (Stage) proposeColabFXID.getScene().getWindow();
            dupstage.setTitle("colab");
            dupstage.setScene(scene);
            dupstage.show();

        } catch (Exception e) {

        }
    }

    @javafx.fxml.FXML
    public void cancelAdButtonOnAction(ActionEvent actionEvent) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("CancelAd.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage dupstage = (Stage) cancelAdFXID.getScene().getWindow();
            dupstage.setTitle("Cancel Ads");
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