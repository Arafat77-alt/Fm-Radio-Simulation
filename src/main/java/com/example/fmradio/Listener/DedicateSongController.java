package com.example.fmradio.Listener;

import com.example.fmradio.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

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
    private Button backFXID;

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