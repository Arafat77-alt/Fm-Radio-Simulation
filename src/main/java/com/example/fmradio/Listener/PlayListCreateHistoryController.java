package com.example.fmradio.Listener;

import com.example.fmradio.HelloApplication;
import com.example.fmradio.Listener.CreatePlayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    private Button backtoCreatePlaylistFXID;

    @javafx.fxml.FXML
    public void initialize() {

        playListNameCol.setCellValueFactory(new PropertyValueFactory<>("playlistName"));
        numberSongCol.setCellValueFactory(new PropertyValueFactory<>("noOfSongs"));
        dateCreateplaylistCol.setCellValueFactory(new PropertyValueFactory<>("dateofcreateplayList"));

    }

    @javafx.fxml.FXML
    public void backButtonforCreatePLaylistPageOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader myfxmlLoader = new FXMLLoader(HelloApplication.class.getResource("CreatePlaylist.fxml"));
            Scene scene = new Scene(myfxmlLoader.load());

            Stage dupstage = (Stage) backtoCreatePlaylistFXID.getScene().getWindow();
            dupstage.setTitle("PDF view");
            dupstage.setScene(scene);
            dupstage.show();

        } catch (Exception e) {

        }


    }

    public void gethistory(ArrayList<CreatePlayList> G){
        playListTableview.getItems().addAll(G);

    }
}