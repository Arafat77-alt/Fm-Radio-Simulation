package com.example.fmradio.Listener;

import com.example.fmradio.Utility.AppendableObjectOutputStream;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

public class ReportTechnicalIssueController
{
    @javafx.fxml.FXML
    private ComboBox<String> issueTypeComboBox;
    @javafx.fxml.FXML
    private DatePicker issueDateDatePicker;
    @javafx.fxml.FXML
    private Label feedBackLabel;
    @javafx.fxml.FXML
    private TextArea decriptionIssueTextArea;
    @javafx.fxml.FXML
    private TableView<ReportTechnicalIssue> issuetableView;
    @javafx.fxml.FXML
    private TableColumn<ReportTechnicalIssue, String> descriptionColoumn;
    @javafx.fxml.FXML
    private TableColumn<ReportTechnicalIssue, String> issueTypeColoumn;
    @javafx.fxml.FXML
    private TableColumn<ReportTechnicalIssue, LocalDate> issueDateColoumn;

    @javafx.fxml.FXML
    public void initialize() {
        issueTypeComboBox.getItems().addAll("No Audio", "Buffering", "Weak Signal", "Station Unavailable");
        issueTypeColoumn.setCellValueFactory(new PropertyValueFactory<>("issueType"));
        descriptionColoumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        issueDateColoumn.setCellValueFactory(new PropertyValueFactory<>("issueDate"));
    }

    ArrayList<ReportTechnicalIssue> reportList = new ArrayList<>();

    @javafx.fxml.FXML
    public void submitIssueButtonOnAction(ActionEvent actionEvent) {
        String issueType;
        String description;
        LocalDate issueDate;

        issueType = issueTypeComboBox.getValue();
        description = decriptionIssueTextArea.getText();
        issueDate = issueDateDatePicker.getValue();

        LocalDate today = LocalDate.now();

        if (issueType == null || description.isBlank() || issueDate == null){
            feedBackLabel.setText("Please fill up all the requirements");
            return;
        }
        if (issueDate.isAfter(today) ) {
            feedBackLabel.setText("Can not be a future date");
            return;
        }
        feedBackLabel.setText("Thank You for your feedback");
        ReportTechnicalIssue issue = new ReportTechnicalIssue(issueType, description, issueDate );
        reportList.add(issue);
        issuetableView.getItems().addAll(reportList);
        safeTechIssues(issue);

    }


    private void safeTechIssues(Object report){
        ObjectOutputStream oos = null;

        try{
            File file = new File("ListenerTechIssues.bin");

            if (file.exists()){
                FileOutputStream fos = new FileOutputStream(file, true);
                oos = new AppendableObjectOutputStream(fos);
            }else {
                FileOutputStream fos = new FileOutputStream(file);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(report);
            oos.close();

        }catch (Exception e){

        }


    }
}