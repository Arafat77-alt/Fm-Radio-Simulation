package com.example.fmradio.Advertiser;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;

public class GiveAwaySponsorController
{
    @javafx.fxml.FXML
    private TableColumn<GiveAway, String> prizeColoumn;
    @javafx.fxml.FXML
    private TextField prizeTextField;
    @javafx.fxml.FXML
    private TableColumn<GiveAway, String> titleColoumn;
    @javafx.fxml.FXML
    private TextArea conditionTextArea;
    @javafx.fxml.FXML
    private TableView<GiveAway> giveAwayTableView;
    @javafx.fxml.FXML
    private TextField giveAwaytitleTextField;
    @javafx.fxml.FXML
    private DatePicker datePicker;
    @javafx.fxml.FXML
    private TableColumn<GiveAway, String> conditionColoumn;
    @javafx.fxml.FXML
    private TableColumn<GiveAway, LocalDate> expiryDateDatePickerCol;

    @javafx.fxml.FXML
    public void initialize() {

        titleColoumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        prizeColoumn.setCellValueFactory(new PropertyValueFactory<>("Prize"));
        conditionColoumn.setCellValueFactory(new PropertyValueFactory<>("expirydate"));
        expiryDateDatePickerCol.setCellValueFactory(new PropertyValueFactory<>("Condition"));

    }

    ArrayList<GiveAway> giveAwayArrayList = new ArrayList<>();
    @javafx.fxml.FXML
    public void submitGiveAwayButtonOnAction(ActionEvent actionEvent) {
        String title;
        String Prize;
        String Condition;

        title = giveAwaytitleTextField.getText();
        Prize = prizeTextField.getText();
        Condition = conditionTextArea.getText();

        LocalDate expirydate;
        expirydate = datePicker.getValue();

        LocalDate a = LocalDate.now();

        if (expirydate.equals(a) || expirydate.isBefore(a) ){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Date entry wrong");
            alert.setContentText("Set future date only");
            alert.show();
            return;
        }
        GiveAway giveAway = new GiveAway(title, Prize, expirydate, Condition);
        giveAwayArrayList.add(giveAway);
        giveAwayTableView.getItems().addAll(giveAwayArrayList);
        giveAwayArrayList.clear();
    }
}