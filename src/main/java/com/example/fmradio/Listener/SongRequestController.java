package com.example.fmradio.Listener;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;

public class SongRequestController
{
    @javafx.fxml.FXML
    private TextField songTtitleTextfield;
    @javafx.fxml.FXML
    private TableColumn<SongRequest, String> artistNameColumn;
    @javafx.fxml.FXML
    private TextField artistNameTextField;
    @javafx.fxml.FXML
    private TextArea shoutOutMessageTextArea;
    @javafx.fxml.FXML
    private TableView<SongRequest> songRequestTableView;
    @javafx.fxml.FXML
    private TableColumn<SongRequest, LocalDate> dateColumn;
    @javafx.fxml.FXML
    private TableColumn<SongRequest, String> songTitleColumn;
    @javafx.fxml.FXML
    private DatePicker requestdateDatePicker;
    @javafx.fxml.FXML
    private TableColumn<SongRequest, String> messageColumn;


    @javafx.fxml.FXML
    public void initialize() {
        songTitleColumn.setCellValueFactory(new PropertyValueFactory<>("songTitle"));
        artistNameColumn.setCellValueFactory(new PropertyValueFactory<>("artistName"));
        messageColumn.setCellValueFactory(new PropertyValueFactory<>("shoutout"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("requestdate"));

    }

   ArrayList<SongRequest> songRequestList = new ArrayList<>();

    @javafx.fxml.FXML
    public void submitSongRequestButtonOnAction(ActionEvent actionEvent) {
        String songTitle, artistName, shoutout;
        LocalDate requestdate;
        String listenerId;

        songTitle = songTtitleTextfield.getText();
        artistName = artistNameTextField.getText();
        shoutout  = shoutOutMessageTextArea.getText();
        requestdate = requestdateDatePicker.getValue();

        SongRequest songRequest = new SongRequest(songTitle, artistName, shoutout, requestdate );
        songRequestList.add(songRequest);
        songRequestTableView.getItems().addAll(songRequest);


    }
}