package com.example.fmradio.Listener;

import com.example.fmradio.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.ArrayList;

public class SeeYourRatingHistoryController
{
    @javafx.fxml.FXML
    private TableColumn<RateShow, String> ratingColumn;
    @javafx.fxml.FXML
    private TableColumn<RateShow, String> showTitleColumn;
    @javafx.fxml.FXML
    private TableColumn<RateShow, String> commentColumn;
    @javafx.fxml.FXML
    private TableColumn<RateShow, LocalDate> dateColumn;
    @javafx.fxml.FXML
    private TableView<RateShow> ratingTableView;
    @javafx.fxml.FXML
    private Button backButtonFXID;

    @javafx.fxml.FXML
    public void initialize() {
        showTitleColumn.setCellValueFactory(new PropertyValueFactory<>("showTitle"));
        ratingColumn.setCellValueFactory(new PropertyValueFactory<>("rating"));
        commentColumn.setCellValueFactory(new PropertyValueFactory<>("comment"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("dateOfRating"));
    }

    public void getHistory(ArrayList<RateShow> newArrayList) {
        ratingTableView.getItems().addAll(newArrayList);
    }

    @javafx.fxml.FXML
    public void backButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("RateShow.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage dupstage = (Stage) backButtonFXID.getScene().getWindow();
            dupstage.setTitle("My rating view");

            dupstage.setScene(scene);
            dupstage.show();

        } catch (Exception e) {

        }
    }
}