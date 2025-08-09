package com.example.fmradio.Listener;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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
}