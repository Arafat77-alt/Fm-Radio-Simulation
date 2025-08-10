package com.example.fmradio.StationManager;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class SocialMediaFxmlController
{
    @javafx.fxml.FXML
    private TextField suggestionTextField;
    @javafx.fxml.FXML
    private TableView<SocialMediaReport> reportTableView;
    @javafx.fxml.FXML
    private TextArea showReportTextArea;
    @javafx.fxml.FXML
    private TableColumn<SocialMediaReport,String> archiveCol;
    @javafx.fxml.FXML
    private TableColumn<SocialMediaReport,String > showNameCol;
    @javafx.fxml.FXML
    private TableColumn<SocialMediaReport,String> suggestionCol;
    @javafx.fxml.FXML
    private TableColumn<SocialMediaReport,String> reportCol;


    @javafx.fxml.FXML
    public void initialize() {

        showNameCol.setCellValueFactory(new PropertyValueFactory<>("showName"));
        reportCol.setCellValueFactory(new PropertyValueFactory<>("report"));
        suggestionCol.setCellValueFactory(new PropertyValueFactory<>("suggestion"));
        archiveCol.setCellValueFactory(cell -> {
            boolean isArchived = cell.getValue().isArchived();
            return new ReadOnlyStringWrapper(isArchived ? "Yes" : "No");
        });

        reportTableView.setItems(SharedData.stationData.getSocialMediaReports());



    }

    @javafx.fxml.FXML
    public void comparePerformanceOA(ActionEvent actionEvent) {
        StringBuilder top = new StringBuilder(" Performance Comparison:\n\n");


        for (SocialMediaReport report : SharedData.stationData.getSocialMediaReports()) {
            top.append("Show: ").append(report.getShowName())
                    .append("\nPerformance: ").append(report.getReport())
                    .append("\nSuggestion: ").append(report.getSuggestion())
                    .append("\nArchived: ").append(report.isArchived() ? "Yes" : "No")
                    .append("\n\n");
        }

        showReportTextArea.setText(top.toString());
    }

    @javafx.fxml.FXML
    public void archiveShowOA(ActionEvent actionEvent) {
        SocialMediaReport selected = reportTableView.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showReportTextArea.setText(" Please select a report to archive.");
            return;
        }

        selected.setSuggestion(suggestionTextField.getText().trim());
        selected.setArchived(true);
        reportTableView.refresh();

        BinaryFileUtil.saveStationData(SharedData.stationData, "C:/intasgo.com/data/social_media.dat");
        suggestionTextField.clear();
        showReportTextArea.setText(selected.getShowName() + " archived with suggestion.");
    }


    @javafx.fxml.FXML
    public void openReportOA(ActionEvent actionEvent) {
        SocialMediaReport selected = reportTableView.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showReportTextArea.setText(" Please select a report.");
            return;
        }

        showReportTextArea.setText(" Show: " + selected.getShowName() +
                "\n\nReport:\n" + selected.getReport());
    }

    @javafx.fxml.FXML
    public void mainMenuOA(ActionEvent actionEvent) {
    }
}