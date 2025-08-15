package com.example.fmradio.Producer;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;

public class AssignPlaylistFxmlController {

    @FXML
    private TableView<SongSubmission> songTableTableView;

    @FXML
    private TableColumn<SongSubmission, String> songTitleCol;
    @FXML
    private TableColumn<SongSubmission, String> durationCol;
    @FXML
    private TableColumn<SongSubmission, String> statusCol;

    @FXML
    private Label messageLabel;

    private final ObservableList<SongSubmission> submissions = FXCollections.observableArrayList();

    private final String dataFileName = "songs.bin";

    @FXML
    public void initialize() {
        songTitleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        durationCol.setCellValueFactory(new PropertyValueFactory<>("duration"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
        songTableTableView.setItems(submissions);
        loadSongsFromFile();
    }

    private void addSampleSongs() {
        submissions.add(new SongSubmission("Song 1", "03:24", "PENDING"));
        submissions.add(new SongSubmission("Song 2", "02:45", "PENDING"));
    }

    private void saveSongsToFile() {
        DataStorage.saveData(new ArrayList<>(submissions), dataFileName);
    }

    private void loadSongsFromFile() {
        File file = new File(dataFileName);
        if (file.exists()) {
            var loadedSongs = DataStorage.loadData(dataFileName);
            if (loadedSongs != null) {
                submissions.setAll(loadedSongs);
            }
        } else {
            addSampleSongs();
        }
    }

    @FXML
    public void approveOA(ActionEvent actionEvent) {
        SongSubmission selectedSong = songTableTableView.getSelectionModel().getSelectedItem();
        if (selectedSong != null) {
            selectedSong.setStatus("APPROVED");
            messageLabel.setText("Song approved: " + selectedSong.getTitle());
            messageLabel.setStyle("-fx-text-fill: green;");
            songTableTableView.refresh();
            saveSongsToFile();
        } else {
            messageLabel.setText("No song selected.");
            messageLabel.setStyle("-fx-text-fill: red;");
        }
    }

    @FXML
    public void rejectOA(ActionEvent actionEvent) {
        SongSubmission selectedSong = songTableTableView.getSelectionModel().getSelectedItem();
        if (selectedSong != null) {
            selectedSong.setStatus("REJECTED");
            messageLabel.setText("Song rejected: " + selectedSong.getTitle());
            messageLabel.setStyle("-fx-text-fill: red;");
            songTableTableView.refresh();
            saveSongsToFile();
        } else {
            messageLabel.setText("No song selected.");
            messageLabel.setStyle("-fx-text-fill: red;");
        }
    }

    @FXML
    public void notifyMusicManagerOA(ActionEvent actionEvent) {
        SongSubmission selectedSong = songTableTableView.getSelectionModel().getSelectedItem();
        if (selectedSong != null) {
            messageLabel.setText("Notified Music Manager about: " + selectedSong.getTitle());
            messageLabel.setStyle("-fx-text-fill: blue;");
        } else {
            messageLabel.setText("No song selected.");
            messageLabel.setStyle("-fx-text-fill: red;");
        }
    }
    @FXML
    public void checkDuplicateOA(ActionEvent actionEvent) {
        SongSubmission selectedSong = songTableTableView.getSelectionModel().getSelectedItem();
        if (selectedSong != null) {
            boolean isDuplicate = submissions.stream()
                    .filter(song -> !song.equals(selectedSong))
                    .anyMatch(song -> song.getTitle().equalsIgnoreCase(selectedSong.getTitle()));

            if (isDuplicate) {
                messageLabel.setText("Duplicate song found: " + selectedSong.getTitle());
                messageLabel.setStyle("-fx-text-fill: orange;");
            } else {
                messageLabel.setText("No duplicate found for: " + selectedSong.getTitle());
                messageLabel.setStyle("-fx-text-fill: green;");
            }
        } else {
            messageLabel.setText("No song selected.");
            messageLabel.setStyle("-fx-text-fill: red;");
        }
    }


    @FXML
    public void mainMenuOA(ActionEvent actionEvent) {
        loadProducerScene(actionEvent);
    }
    private void loadProducerScene(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ProducerFxml.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

