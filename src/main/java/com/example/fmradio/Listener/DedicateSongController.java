package com.example.fmradio.Listener;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class DedicateSongController
{
    @javafx.fxml.FXML
    private TextField recipientNameTextField;
    @javafx.fxml.FXML
    private TableView<DedicateSong> dedicateSongTableview;
    @javafx.fxml.FXML
    private TextField songTtitleTextField;
    @javafx.fxml.FXML
    private TextArea optionaleMessageTextArea;
    @javafx.fxml.FXML
    private TableColumn<DedicateSong, String> recipientNameCol;
    @javafx.fxml.FXML
    private TableColumn<DedicateSong, String> songTitleCol;
    @javafx.fxml.FXML
    private TableColumn<DedicateSong, String> optionalMessageCol;
    @javafx.fxml.FXML
    private Label successLabel;

    @javafx.fxml.FXML
    public void initialize() {

        recipientNameCol.setCellValueFactory(new PropertyValueFactory<>("recipientName"));
        songTitleCol.setCellValueFactory(new PropertyValueFactory<>("songName"));
        optionalMessageCol.setCellValueFactory(new PropertyValueFactory<>("textArea"));

    }

ArrayList<DedicateSong> dedicateSongArrayList = new ArrayList<>();
    @javafx.fxml.FXML
    public void submitdedicatedSongButtonOnAction(ActionEvent actionEvent) {
        String recipientName;
        String songName;
        String textArea;

        recipientName = recipientNameTextField.getText();
        songName = songTtitleTextField.getText();
        textArea = optionaleMessageTextArea.getText();

        if (recipientName.isBlank() || songName.isBlank()){
            successLabel.setText("PLease fill up the name and song section");
            return;
        }
        successLabel.setText("Succefull");
        DedicateSong dedicateSong = new DedicateSong(recipientName, songName, textArea);
        dedicateSongArrayList.add(dedicateSong);
        dedicateSongTableview.getItems().addAll(dedicateSong);


    }
}