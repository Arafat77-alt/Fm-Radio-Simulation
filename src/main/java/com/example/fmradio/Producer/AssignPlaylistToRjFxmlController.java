package com.example.fmradio.Producer;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

import java.io.*;

public class AssignPlaylistToRjFxmlController {

    @FXML
    private ComboBox<String> selectRjComboBox;

    @FXML
    private ComboBox<String> selectShowCombobox;

    @FXML
    private ListView<String> playlistListView;

    @FXML
    private Label messageLabel;

    private final ObservableList<String> playlists = FXCollections.observableArrayList();
    private final String dataFileName = "assignedPlaylists.bin";

    @FXML
    public void initialize() {
        selectRjComboBox.setItems(FXCollections.observableArrayList("RJ1", "RJ2", "RJ3"));
        selectShowCombobox.setItems(FXCollections.observableArrayList("Show1", "Show2", "Show3"));
        playlistListView.setItems(playlists);
        loadPlaylistsFromFile();
    }

    @FXML
    public void assignPlaylistOA(ActionEvent actionEvent) {
        String selectedRj = selectRjComboBox.getSelectionModel().getSelectedItem();
        String selectedShow = selectShowCombobox.getSelectionModel().getSelectedItem();
        String selectedPlaylist = playlistListView.getSelectionModel().getSelectedItem();

        if (selectedRj != null && selectedShow != null && selectedPlaylist != null) {
            String assignment = "Assigned " + selectedPlaylist + " to " + selectedRj + " for " + selectedShow;
            messageLabel.setText(assignment);
            playlists.add(assignment);
            savePlaylistsToFile();
        } else {
            messageLabel.setText("Please select all fields.");
        }
    }



    private void loadPlaylistsFromFile() {
        File file = new File(dataFileName);
        if (file.exists()) {
            try (DataInputStream in = new DataInputStream(new FileInputStream(file))) {
                int size = in.readInt();
                for (int i = 0; i < size; i++) {
                    playlists.add(in.readUTF());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            addSamplePlaylists();
        }
    }

    private void addSamplePlaylists() {
        playlists.add("Playlist 1");
        playlists.add("Playlist 2");
        playlists.add("Playlist 3");
    }

    private void savePlaylistsToFile() {
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(dataFileName))) {
            out.writeInt(playlists.size());
            for (String playlist : playlists) {
                out.writeUTF(playlist);
            }
        } catch (IOException e) {
            e.printStackTrace();
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