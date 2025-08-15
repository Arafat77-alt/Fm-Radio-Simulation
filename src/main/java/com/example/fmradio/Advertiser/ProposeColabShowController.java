package com.example.fmradio.Advertiser;

import com.example.fmradio.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.ArrayList;

public class ProposeColabShowController {
    @javafx.fxml.FXML
    private DatePicker proposedateDatePicker;
    @javafx.fxml.FXML
    private TextField showNameTitle;
    @javafx.fxml.FXML
    private Label succesFailLabel;
    @javafx.fxml.FXML
    private TextArea conceptSummaryTextArea;
    @javafx.fxml.FXML
    private Button promoHistoryFXID;
    @javafx.fxml.FXML
    private Button backFXID;

    @javafx.fxml.FXML
    public void initialize() {
    }

    ArrayList<ProposeColab> arr = new ArrayList<>();

    @javafx.fxml.FXML
    public void submitButtonONAction(ActionEvent actionEvent) {
        String showName;
        LocalDate proposeDate;
        String status;
        String summary;

        showName = showNameTitle.getText();
        proposeDate = proposedateDatePicker.getValue();
        summary = conceptSummaryTextArea.getText();
        status = "Pending";

        if (showName.isBlank() || proposeDate == null || summary.isBlank()){
            succesFailLabel.setText("Please fill up the requirement");
            return;
        }
        succesFailLabel.setText("Successful");
        ProposeColab poc = new ProposeColab(showName, proposeDate, status, summary);
        arr.add(poc);

    }

    @javafx.fxml.FXML
    public void seePromoReportButtonOnAction(ActionEvent actionEvent) {

        try {
            FXMLLoader myfxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ProposeColabHistory.fxml"));
            Scene scene = new Scene(myfxmlLoader.load());
            Stage dupstage = (Stage) promoHistoryFXID.getScene().getWindow();
            dupstage.setTitle("Promoted shows");
            ProposeColabHistoryController newController = myfxmlLoader.getController();
            dupstage.setScene(scene);
            newController.showPromoHistory(arr);
            dupstage.show();

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