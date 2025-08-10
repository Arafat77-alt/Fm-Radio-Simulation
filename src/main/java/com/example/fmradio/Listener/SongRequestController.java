package com.example.fmradio.Listener;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class SongRequestController
{
    @javafx.fxml.FXML
    private TextField songTtitleTextfield;
    @javafx.fxml.FXML
    private TableColumn artistNameColumn;
    @javafx.fxml.FXML
    private TextField artistNameTextField;
    @javafx.fxml.FXML
    private TextArea shoutOutMessageTextArea;
    @javafx.fxml.FXML
    private TableView songRequestTableView;
    @javafx.fxml.FXML
    private TableColumn dateColumn;
    @javafx.fxml.FXML
    private TableColumn songTitleColumn;
    @javafx.fxml.FXML
    private DatePicker requestdateDatePicker;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void submitSongRequestButtonOnAction(ActionEvent actionEvent) {
    }
}