package com.example.fmradio.Advertiser;

import com.example.fmradio.HelloApplication;
import com.example.fmradio.Utility.AppendableObjectOutputStream;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;


public class ScheduleAdvertisementController
{

    @javafx.fxml.FXML
    private ComboBox<String> targetAudienceComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> categoryComboBox;
    @javafx.fxml.FXML
    private TableView<Advertisement> sceduleAdTableview;
    @javafx.fxml.FXML
    private TextField durationMinutesTextField;
    @javafx.fxml.FXML
    private TextField adTittleTextField;
    @javafx.fxml.FXML
    private ComboBox<String> timingSlotComboBox;
    @javafx.fxml.FXML
    private DatePicker airingDateDatePicker;
    @javafx.fxml.FXML
    private TableColumn<Advertisement, LocalDate> airingDateColoumn;
    @javafx.fxml.FXML
    private TableColumn<Advertisement, String> targetAudienceColoumn;
    @javafx.fxml.FXML
    private TableColumn<Advertisement, String> categoryColoumn;
    @javafx.fxml.FXML
    private TableColumn<Advertisement, String> adTitleColoumn;
    @javafx.fxml.FXML
    private TableColumn<Advertisement, String> timeSlotColoumn;
    @javafx.fxml.FXML
    private TableColumn<Advertisement, Integer> durationMinutesColoumn;
    @javafx.fxml.FXML
    private Label datecheckLabel;
    @FXML
    private Button backFXID;

    @javafx.fxml.FXML
    public void initialize() {

        categoryComboBox.getItems().addAll("Retail", "Event", "Service");
        targetAudienceComboBox.getItems().addAll("Teens", "Adults", "All");
        timingSlotComboBox.getItems().addAll("Moring", "Evening", "Night");

        adTitleColoumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        airingDateColoumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        categoryColoumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        durationMinutesColoumn.setCellValueFactory(new PropertyValueFactory<>("duration"));
        targetAudienceColoumn.setCellValueFactory(new PropertyValueFactory<>("targetAudience"));
        timeSlotColoumn.setCellValueFactory(new PropertyValueFactory<>("timeSlot"));
    }


    @FXML
    public void submitRequestButtonOnAction(ActionEvent actionEvent) {
        String title;
        int duration;
        String category;
        LocalDate date;
        String timeSlot;
        String targetAudience;

        title = adTittleTextField.getText();
        duration = Integer.parseInt(durationMinutesTextField.getText());
        category = categoryComboBox.getValue();
        date = airingDateDatePicker.getValue();
        timeSlot = timingSlotComboBox.getValue();
        targetAudience = targetAudienceComboBox.getValue();

        LocalDate a = LocalDate.now();

        if (date.equals(a) || date.isBefore(a) ){
            datecheckLabel.setText("Set a Future Date");
            return;
        }

        Advertisement ads = new Advertisement(title, duration, category, date, timeSlot, targetAudience);
        sceduleAdTableview.getItems().addAll(ads);
        datecheckLabel.setText("Successful");
        saveAds(ads);

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

    @FXML
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