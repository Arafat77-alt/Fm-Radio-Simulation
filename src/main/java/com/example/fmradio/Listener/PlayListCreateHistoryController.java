package com.example.fmradio.Listener;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class PlayListCreateHistoryController
{
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

        playListNameCol.setCellValueFactory(new PropertyValueFactory<>("playlistName"));
        numberSongCol.setCellValueFactory(new PropertyValueFactory<>("noOfSongs"));
        dateCreateplaylistCol.setCellValueFactory(new PropertyValueFactory<>("dateofcreateplayList"));

        ArrayList<CreatePlayList> playListArrayList = Playlist.playListArrayList;
        playListTableview.getItems().addAll(playListArrayList);


    }

    @javafx.fxml.FXML
    public void backButtonforCreatePLaylistPageOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("CreatePlaylist.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("New scene");
        stage.setScene(scene);
        stage.show();
    }
}