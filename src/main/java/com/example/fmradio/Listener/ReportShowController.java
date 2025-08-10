package com.example.fmradio.Listener;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;

public class ReportShowController
{
    @javafx.fxml.FXML
    private ComboBox<String> reasonForReportComboBox;
    @javafx.fxml.FXML
    private TableColumn<ReportShow, String> showTitleColumn;
    @javafx.fxml.FXML
    private TextField showTitleTextField;
    @javafx.fxml.FXML
    private TableView<ReportShow> listenerReportTableView;
    @javafx.fxml.FXML
    private TableColumn<ReportShow, String> reasonColumn1;
    @javafx.fxml.FXML
    private TextArea additionaleCommentTextArea;
    @javafx.fxml.FXML
    private TableColumn<ReportShow, LocalDate> dateColumn;
    @javafx.fxml.FXML
    private Label feebackLabel;

    @javafx.fxml.FXML
    public void initialize() {
        reasonForReportComboBox.getItems().addAll("Irrelevant Content", "Personal preference", "Needs Improvements");
        showTitleColumn.setCellValueFactory(new PropertyValueFactory<>("showTitle"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("reportDate"));
        reasonColumn1.setCellValueFactory(new PropertyValueFactory<>("reason"));
    }

    ArrayList<ReportShow>  reportShowArrayList = new ArrayList<>();

    @javafx.fxml.FXML
    public void submitReportButtonONaction(ActionEvent actionEvent) {

         reportShowArrayList.clear();
         String showTitle;
         String reason;
         String comment;
         LocalDate reportDate;

         showTitle = showTitleTextField.getText();
         reason     = reasonForReportComboBox.getValue();
         comment    = additionaleCommentTextArea.getText();
         reportDate = LocalDate.now();

        ReportShow reportShow = new ReportShow(showTitle, reason, comment, reportDate);
        reportShowArrayList.add(reportShow);
        listenerReportTableView.getItems().addAll(reportShowArrayList);

        if (comment.isBlank()){
            feebackLabel.setText("You can give more details in the addtional comment section");
        }
        else {
            feebackLabel.setText("Thank you for your kind words");
        }


    }
}