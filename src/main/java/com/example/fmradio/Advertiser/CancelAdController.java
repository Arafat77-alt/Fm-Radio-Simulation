package com.example.fmradio.Advertiser;

import com.example.fmradio.HelloApplication;
import com.example.fmradio.Utility.AppendableObjectOutputStream;
import javafx.event.ActionEvent;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javax.imageio.IIOException;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;


public class CancelAdController {
    @javafx.fxml.FXML
    private TableView<Advertisement> sceduleAdTableview;
    @javafx.fxml.FXML
    private TableColumn<Advertisement, LocalDate> airingDateColoumn;
    @javafx.fxml.FXML
    private TableColumn<Advertisement, String> targetAudienceColoumn;
    @javafx.fxml.FXML
    private TableColumn<Advertisement, String> categoryColoumn;
    @javafx.fxml.FXML
    private TableColumn<Advertisement, String> timeSlotColoumn;
    @javafx.fxml.FXML
    private ComboBox<String> adTtileComboBox;
    @javafx.fxml.FXML
    private TableColumn<Advertisement, Integer> durationMinutesColoumn;
    @javafx.fxml.FXML
    private TableColumn<Advertisement, String> adTitleColoumn;
    @javafx.fxml.FXML
    private Button backFXID;


    @javafx.fxml.FXML
    public void initialize() {
        adTitleColoumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        airingDateColoumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        categoryColoumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        durationMinutesColoumn.setCellValueFactory(new PropertyValueFactory<>("duration"));
        targetAudienceColoumn.setCellValueFactory(new PropertyValueFactory<>("targetAudience"));
        timeSlotColoumn.setCellValueFactory(new PropertyValueFactory<>("timeSlot"));

    }

    ArrayList<Advertisement> adsArray = new ArrayList<>();


    @javafx.fxml.FXML
    public void cancelButtonOnAction(ActionEvent actionEvent) {
        String adtitle = adTtileComboBox.getValue();
        File f = new File("Advertisements.bin");
        if (f.exists()){
            f.delete();
        }
        for (Advertisement a : adsArray) {
            if (adtitle.equals(a.getTitle())) {
                sceduleAdTableview.getItems().remove(a);
                adTtileComboBox.getItems().remove(a);
                continue;
            }
            saveAds(a);
        }
    }

    @javafx.fxml.FXML
    public void loadAdButtonOnAction(ActionEvent actionEvent) {
        FileInputStream fisforobject = null;
        ObjectInputStream ois = null;
        sceduleAdTableview.getItems().clear();
        adTtileComboBox.getItems().clear();
        adsArray.clear();
        try {
            fisforobject = new FileInputStream("Advertisements.bin");
            ois = new ObjectInputStream(fisforobject);
            while (true) {
                Advertisement adsReading = (Advertisement) ois.readObject();
                adTtileComboBox.getItems().addAll(adsReading.getTitle());
                adsArray.add(adsReading);
                sceduleAdTableview.getItems().add(adsReading);
            }
        } catch (Exception e) {
            try {

                if (ois != null) {
                    ois.close();
                }
            } catch (Exception e2) {

            }

        }
    }

    public void saveAds(Object Advertisement){
        ObjectOutputStream oos = null;
        try {
            File file = new File("Advertisements.bin");
            if (file.exists()){
                FileOutputStream fos2 = new FileOutputStream(file, true);
                oos = new AppendableObjectOutputStream(fos2);
            }
            else {
                FileOutputStream fos2 = new FileOutputStream(file);
                oos = new ObjectOutputStream(fos2);
            }
            oos.writeObject(Advertisement);
            oos.close();
        }
        catch (Exception e){
        }
    }

    @javafx.fxml.FXML
    public void backButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("AdvertiserDashboard.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage dupstage = (Stage) backFXID.getScene().getWindow();
            dupstage.setScene(scene);
            dupstage.setTitle("AdvertiserDashBoard");
            dupstage.show();

        } catch (Exception e) {

        }
    }
}


