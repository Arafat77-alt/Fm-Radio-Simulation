package com.example.fmradio.Advertiser;

import com.example.fmradio.Listener.CreatePlayList;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.time.LocalDate;


public class SponsorPlaylistController {
    @javafx.fxml.FXML
    private ComboBox<String> playlistLoadedNamesComboBox;
    @javafx.fxml.FXML
    private TableColumn<SponsoredPlaylist, LocalDate> sponsorDateCol;
    @javafx.fxml.FXML
    private TableColumn<SponsoredPlaylist, String> playListNamesCol;
    @javafx.fxml.FXML
    private TableView<SponsoredPlaylist> sponsorTableView;


    @javafx.fxml.FXML
    public void initialize() {
        playListNamesCol.setCellValueFactory(new PropertyValueFactory<>("playlistName"));
        sponsorDateCol.setCellValueFactory(new PropertyValueFactory<>("sponsorshipDate"));

    }


    @javafx.fxml.FXML
    public void submitToSponsorButtonOnAction(ActionEvent actionEvent) {

        String playlistName;
        LocalDate sponsorshipDate;

        playlistName = playlistLoadedNamesComboBox.getValue();
        sponsorshipDate = LocalDate.now();

        SponsoredPlaylist sponsoredPlaylist = new SponsoredPlaylist(playlistName, sponsorshipDate);
        sponsorTableView.getItems().addAll(sponsoredPlaylist);

    }

    @Deprecated
    public void playlistComboBoXOnAction(ActionEvent actionEvent) {
    }


    @javafx.fxml.FXML
    public void loadPlaylistnamesButtonOnAction(ActionEvent actionEvent) {
        FileInputStream fisforobject = null;
        ObjectInputStream ois = null;
        try {
            fisforobject = new FileInputStream("ListenerPlaylist.bin");
            ois = new ObjectInputStream(fisforobject);

            while (true) {
                CreatePlayList createPlayListReading = (CreatePlayList) ois.readObject();
                playlistLoadedNamesComboBox.getItems().addAll(createPlayListReading.getPlaylistName());
            }
        } catch (Exception e) {

        }
    }
}

