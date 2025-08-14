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

import java.time.LocalDate;
import java.util.ArrayList;

public class ProposeColabHistoryController
{
    @javafx.fxml.FXML
    private TableView<ProposeColab> promotedShowTableview;
    @javafx.fxml.FXML
    private TableColumn<ProposeColab, LocalDate> dateCol;
    @javafx.fxml.FXML
    private TableColumn<ProposeColab, String> statusCol;
    @javafx.fxml.FXML
    private TableColumn<ProposeColab, String> showNameCol;
    @javafx.fxml.FXML
    private Button backFXID;

    @javafx.fxml.FXML
    public void initialize() {

        showNameCol.setCellValueFactory(new PropertyValueFactory<>("showName"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("proposeDate"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

    }

    @javafx.fxml.FXML
    public void backButtonOnAction(ActionEvent actionEvent) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ProposeColabShow.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage dupstage = (Stage) backFXID.getScene().getWindow();
            dupstage.setTitle("promoColab");
            dupstage.setScene(scene);
            dupstage.show();
        } catch (Exception e) {

        }

    }

    public void showPromoHistory(ArrayList<ProposeColab> newArrayList) {
        promotedShowTableview.getItems().addAll(newArrayList);

    }


}