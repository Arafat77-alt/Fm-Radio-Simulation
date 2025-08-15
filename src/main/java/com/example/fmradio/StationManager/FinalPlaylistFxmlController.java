package com.example.fmradio.StationManager;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class FinalPlaylistFxmlController
{
    @javafx.fxml.FXML
    private TableColumn<Song,String> songNameCol;
    @javafx.fxml.FXML
    private TableColumn<Song,String > albumCol;
    @javafx.fxml.FXML
    private TableColumn<Song,String> duplicateCol;
    @javafx.fxml.FXML
    private TableColumn<Song,String> artistCol;
    @javafx.fxml.FXML
    private TableColumn<Song,String> durationCol;
    @javafx.fxml.FXML
    private Label statusLabel;

    @javafx.fxml.FXML
    private TableView<Song> dailyPlaylistTableView;

    private ObservableList<Song> playlist;

    @javafx.fxml.FXML
    public void initialize() {
        playlist = FXCollections.observableArrayList();

        songNameCol.setCellValueFactory(new PropertyValueFactory<>("songName"));
        albumCol.setCellValueFactory(new PropertyValueFactory<>("album"));
        artistCol.setCellValueFactory(new PropertyValueFactory<>("artist"));
        durationCol.setCellValueFactory(new PropertyValueFactory<>("duration"));
        duplicateCol.setCellValueFactory(song -> {
            return song.getValue().isDuplicate() ? new SimpleStringProperty("Duplicate") : new SimpleStringProperty("Unique");
        });

        dailyPlaylistTableView.setItems(playlist);

    }


    @javafx.fxml.FXML
    public void receivePlaylistOA(ActionEvent actionEvent) {
        playlist.add(new Song("Song 1", "Album 1", "Artist 1", "3:20", false));  // Not a duplicate
        playlist.add(new Song("Song 2", "Album 2", "Artist 2", "3:15", false));  // Not a duplicate
        playlist.add(new Song("Song 3", "Album 3", "Artist 1", "4:00", true));   // Marked as duplicate

        dailyPlaylistTableView.refresh();
        statusLabel.setText("Playlist received successfully!");
    }

    @javafx.fxml.FXML
    public void checkDuplicateOA(ActionEvent actionEvent) {
        boolean hasDuplicates = false;

        for (Song song : playlist) {
            for (Song otherSong : playlist) {
                if (!song.equals(otherSong) && song.getSongName().equals(otherSong.getSongName())) {
                    song.setDuplicate(true);
                    hasDuplicates = true;
                }
            }
        }


        if (hasDuplicates) {
            statusLabel.setText("Some songs in the playlist are duplicates.");
        } else {
            statusLabel.setText("The playlist has no duplicates.");
        }

        dailyPlaylistTableView.refresh();

    }





    @javafx.fxml.FXML
    public void notifyProducerAndRjOA(ActionEvent actionEvent) {
        statusLabel.setText("Producer and RJ have been notified about the approved playlist.");
    }



    @javafx.fxml.FXML
    public void approvePlaylistOA(ActionEvent actionEvent) {
        statusLabel.setText("The playlist has been approved for broadcast.");
    }
    @FXML
    public void mainMenuOA(ActionEvent actionEvent) {
        loadStationManagerScene(actionEvent);
    }

    private void loadStationManagerScene(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("StationManagerFxml.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}