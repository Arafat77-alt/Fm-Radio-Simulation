package com.example.fmradio.Advertiser;

import com.example.fmradio.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.ArrayList;

public class BillHistoryPageController
{
    @javafx.fxml.FXML
    private TableView<Bill> billHistoryTableView;
    @javafx.fxml.FXML
    private TableColumn<Bill, Integer> billColoumn;
    @javafx.fxml.FXML
    private TableColumn<Bill, String> adTitleColoumn;
    @javafx.fxml.FXML
    private Button backButtonFXID;

    @javafx.fxml.FXML
    public void initialize() {
        adTitleColoumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        billColoumn.setCellValueFactory(new PropertyValueFactory<>("totalPerAd"));
    }

    public void showBill(ArrayList<Bill> newArrayList){
        billHistoryTableView.getItems().addAll(newArrayList);

    }

    @javafx.fxml.FXML
    public void backButtonOnAction(ActionEvent actionEvent) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("BillOfAdvertisement.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage dupstage = (Stage) backButtonFXID.getScene().getWindow();
            dupstage.setTitle("Bill making");
            dupstage.setScene(scene);
            dupstage.show();

        } catch (Exception e) {

        }
    }
}