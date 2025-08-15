package com.example.fmradio.Advertiser;

import com.example.fmradio.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class BillOfAdvertisementController
{
    @javafx.fxml.FXML
    private Label totalPerAdLabel;
    @javafx.fxml.FXML
    private ComboBox<String> timeCategoryComboBox;
    @javafx.fxml.FXML
    private TextField noOfSlotsTextField;
    @javafx.fxml.FXML
    private ComboBox<String> adTitleComboBox;
    @javafx.fxml.FXML
    private ComboBox<Integer> durationComboBox;
    @javafx.fxml.FXML
    private Button billHistoryFXID;
    @javafx.fxml.FXML
    private Button backFXID;

    @javafx.fxml.FXML
    public void initialize() {
        timeCategoryComboBox.getItems().addAll("Prime", "Regular");
    }


    ArrayList<Bill> newBillList = new ArrayList<>();

    @javafx.fxml.FXML
    public void generateBillButtonOnAction(ActionEvent actionEvent) {
        int duration;
        int numberOfSlots;
        String timeCategory;
        int totalPerAd;

        String title = adTitleComboBox.getValue();

        duration = durationComboBox.getValue();
        numberOfSlots = Integer.parseInt(noOfSlotsTextField.getText());
        timeCategory = timeCategoryComboBox.getValue();
        int rate = 0;

        if(timeCategory == null){
            totalPerAdLabel.setText("Please select the time Category");
        }
        if(timeCategory.equals("Prime")){
            rate = 10;
        }else {
            rate = 5;
        }
        totalPerAd = rate*duration*numberOfSlots;
        totalPerAdLabel.setText(Integer.toString(totalPerAd));

        Bill newBill = new Bill(title, duration,  numberOfSlots,timeCategory, totalPerAd );
        newBillList.add(newBill);


    }

    @javafx.fxml.FXML
    public void loadAdInfosForBillButtonOnAction(ActionEvent actionEvent) {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try{
            fis = new FileInputStream("Advertisements.bin");
            ois = new ObjectInputStream(fis);
            while(true){
                Advertisement ads = (Advertisement) ois.readObject();
                adTitleComboBox.getItems().addAll(ads.getTitle());
                durationComboBox.getItems().addAll(ads.getDuration());
            }
        }catch (Exception e){

        }
    }

    @javafx.fxml.FXML
    public void billHistoryButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader myfxmlLoader = new FXMLLoader(HelloApplication.class.getResource("BillHistoryPage.fxml"));
            Scene scene = new Scene(myfxmlLoader.load());
            Stage duplistage = (Stage) billHistoryFXID.getScene().getWindow();
            duplistage.setTitle("Bill History");
            BillHistoryPageController newController = myfxmlLoader.getController();
            duplistage.setScene(scene);

            newController.showBill(newBillList);
            duplistage.show();

        } catch (Exception e) {

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