package com.example.fmradio.Listener;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class CreatePlaylistController
{
    @javafx.fxml.FXML
    private TextField playListNmaeTextField;
    @javafx.fxml.FXML
    private ComboBox<String> fifthSongComboBox;
    @javafx.fxml.FXML
    private DatePicker createPlayListDatePicker;
    @javafx.fxml.FXML
    private ComboBox<String> fourthSongComBox;
    @javafx.fxml.FXML
    private ComboBox<String> thirdSongComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> firstSongComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> secondSongComboBox;
    @javafx.fxml.FXML
    private TableColumn<CreatePlayList, String> playListNameCol;
    @javafx.fxml.FXML
    private TableColumn<CreatePlayList, Integer> numberSongCol;
    @javafx.fxml.FXML
    private TableView<CreatePlayList> playListTableview;
    @javafx.fxml.FXML
    private TableColumn<CreatePlayList, LocalDate> dateCreateplaylistCol;

    @javafx.fxml.FXML
    public void initialize() {

        firstSongComboBox.getItems().addAll("Bohemian Rhapsody", "Hotel California");
        secondSongComboBox.getItems().addAll("Sicko Mode", "Lose Yourself", "HUMBLE");
        thirdSongComboBox.getItems().addAll("Blinding Lights", "Levitating");
        fourthSongComBox.getItems().addAll("Take Five", "So What");
        fifthSongComboBox.getItems().addAll("The Four Seasons");

    }

    @javafx.fxml.FXML
    public void historyPLayListButton(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
//        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("PlayListCreateHistory.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("New scene");
        stage.setScene(scene);
        stage.show();

    }

    @javafx.fxml.FXML
    public void savePlayListButton(ActionEvent actionEvent) {
        String playlistName = playListNmaeTextField.getText();
        LocalDate dateOfCreate = createPlayListDatePicker.getValue();

        String firstsong = firstSongComboBox.getValue();
        String secondsong = secondSongComboBox.getValue();
        String thirdsong = thirdSongComboBox.getValue();
        String fourthsong = fourthSongComBox.getValue();
        String fifthsong = fifthSongComboBox.getValue();



        int count = 0;

        if(firstsong != null){
            count++;
        }
        if (secondsong != null) {
            count++;
        }

        if (thirdsong != null) {
            count++;
        }

        if (fourthsong != null) {
            count++;
        }

        if (fifthsong != null) {
            count++;
        }

        ArrayList<CreatePlayList> playListArrayList = Playlist.playListArrayList;
        CreatePlayList createPlayList = new CreatePlayList(playlistName, count, dateOfCreate );
        playListArrayList.add(createPlayList);
    }
}