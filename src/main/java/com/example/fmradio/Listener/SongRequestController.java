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
    private Button backFXID;


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

        songTitle = songTtitleTextfield.getText();
        artistName = artistNameTextField.getText();
        shoutout  = shoutOutMessageTextArea.getText();
        requestdate = requestdateDatePicker.getValue();

        SongRequest songRequest = new SongRequest(songTitle, artistName, shoutout, requestdate );
        songRequestList.add(songRequest);
        songRequestTableView.getItems().add(songRequest);
    }

    @javafx.fxml.FXML
    public void backButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ListenerDashboard.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage dupstage = (Stage) backFXID.getScene().getWindow();
            dupstage.setScene(scene);
            dupstage.setTitle("Listener DashBoard");
            dupstage.show();

        } catch (Exception e) {

        }
    }
}