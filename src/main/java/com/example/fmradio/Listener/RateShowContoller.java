package com.example.fmradio.Listener;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class RateShowContoller
{
    @javafx.fxml.FXML
    private TableColumn ratingColumn;
    @javafx.fxml.FXML
    private DatePicker RatingDatePicker;
    @javafx.fxml.FXML
    private TableColumn showTitleColumn;
    @javafx.fxml.FXML
    private TextField showTitleTextfield;
    @javafx.fxml.FXML
    private TextArea commentTextArea;
    @javafx.fxml.FXML
    private TableColumn commentColumn;
    @javafx.fxml.FXML
    private TableColumn dateColumn;
    @javafx.fxml.FXML
    private ComboBox ratingComboBox;
    @javafx.fxml.FXML
    private TableView ratingTableView;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void submitRatingButtonOnAction(ActionEvent actionEvent) {
    }
}