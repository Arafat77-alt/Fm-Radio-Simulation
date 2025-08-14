package com.example.fmradio.Listener;

import com.example.fmradio.HelloApplication;
import com.example.fmradio.Utility.AppendableObjectOutputStream;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
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
    private TableView<CreatePlayList> playListTableview;
    @javafx.fxml.FXML
    private TableColumn<CreatePlayList, String> playListNameCol;
    @javafx.fxml.FXML
    private TableColumn<CreatePlayList, LocalDate> dateCreateplaylistCol;
    @javafx.fxml.FXML
    private TableColumn<CreatePlayList, Integer> numberSongCol;

    @javafx.fxml.FXML
    public void initialize() {

        firstSongComboBox.getItems().addAll("Bohemian Rhapsody", "Hotel California");
        secondSongComboBox.getItems().addAll("Sicko Mode", "Lose Yourself", "HUMBLE");
        thirdSongComboBox.getItems().addAll("Blinding Lights", "Levitating");
        fourthSongComBox.getItems().addAll("Take Five", "So What");
        fifthSongComboBox.getItems().addAll("The Four Seasons");

        playListNameCol.setCellValueFactory(new PropertyValueFactory<>("playlistName"));
        numberSongCol.setCellValueFactory(new PropertyValueFactory<>("noOfSongs"));
        dateCreateplaylistCol.setCellValueFactory(new PropertyValueFactory<>("dateofcreateplayList"));

    }

    ArrayList<CreatePlayList> createPlayListArrayList = new ArrayList<>();


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

        CreatePlayList createPlayList = new CreatePlayList(playlistName, count, dateOfCreate );
        createPlayListArrayList.add(createPlayList);
        playListTableview.getItems().addAll(createPlayList);

        savePlaylists(createPlayList);

    }

    private void savePlaylists(Object CreatePlayList ){

        ObjectOutputStream oos = null;

        try {
            File file = new File("ListenerPlaylist.bin");
            if (file.exists()) {
                FileOutputStream fos2 = new FileOutputStream(file, true);
                oos = new AppendableObjectOutputStream(fos2);
            } else {
                FileOutputStream fos2 = new FileOutputStream(file);
                oos = new ObjectOutputStream(fos2);
            }
            oos.writeObject(CreatePlayList);
            oos.close();
        }
        catch (Exception e){

        }

    }



}
