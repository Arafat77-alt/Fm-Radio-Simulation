package com.example.fmradio.Listener;

import com.example.fmradio.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.ArrayList;

public class RateShowContoller
{

    @javafx.fxml.FXML
    private TextField showTitleTextfield;
    @javafx.fxml.FXML
    private TextArea commentTextArea;
    @javafx.fxml.FXML
    private ComboBox<String> ratingComboBox;
    @javafx.fxml.FXML
    private Button ratingHistoryInAnotherWindowFXID;

    @javafx.fxml.FXML
    public void initialize() {
        ratingComboBox.getItems().addAll("*", "**", "***", "****", "*****");
    }

    ArrayList<RateShow> rateShows = new ArrayList<>();

    @javafx.fxml.FXML
    public void submitRatingButtonOnAction(ActionEvent actionEvent) {
        String showTitle;
        String rating;
        String comment;
        LocalDate dateOfRating;

        showTitle = showTitleTextfield.getText();
        rating = ratingComboBox.getValue();
        comment = commentTextArea.getText();
        dateOfRating = LocalDate.now();

        RateShow rate = new RateShow(showTitle, rating, comment, dateOfRating);
        rateShows.add(rate);
    }

    @javafx.fxml.FXML
    public void ratingHistoryAnotherWindowButton(ActionEvent actionEvent) {
        try {
            FXMLLoader myfxmlLoader = new FXMLLoader(HelloApplication.class.getResource("SeeYourRatingHistory.fxml"));
            Scene scene = new Scene(myfxmlLoader.load());
            Stage dupstage = (Stage) ratingHistoryInAnotherWindowFXID.getScene().getWindow();
            dupstage.setTitle("History view");
            SeeYourRatingHistoryController newController = myfxmlLoader.getController();
            newController.getHistory(rateShows);
            dupstage.setScene(scene);
            dupstage.show();

        } catch (Exception e) {

        }

    }
}