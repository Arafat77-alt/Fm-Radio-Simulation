package com.example.fmradio.StationManager;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class TeamPerformanceFxmlController
{
    @javafx.fxml.FXML
    private TableView<PerformanceReport> showReportTableView;
    @javafx.fxml.FXML
    private ComboBox<String> filterOptionComboBox;
    @javafx.fxml.FXML
    private TableColumn<PerformanceReport,String> commentCol;
    @javafx.fxml.FXML
    private TextField addCommentTextFIeld;
    @javafx.fxml.FXML
    private TableColumn<PerformanceReport,String> reportsCol;
    @javafx.fxml.FXML
    private TableColumn<PerformanceReport,String > reviewCol;
    @javafx.fxml.FXML
    private TableColumn<PerformanceReport,String> userCol;




    @javafx.fxml.FXML
    private TextArea showReportTextArea;

    @javafx.fxml.FXML
    public void initialize() {


        userCol.setCellValueFactory(new PropertyValueFactory<>("user"));
        reportsCol.setCellValueFactory(new PropertyValueFactory<>("reportSummary"));
        commentCol.setCellValueFactory(new PropertyValueFactory<>("comment"));
        reviewCol.setCellValueFactory(cell -> {
            boolean reviewed = cell.getValue().isReviewed();
            return new ReadOnlyStringWrapper(reviewed ? "Yes" : "No");
        });
        showReportTableView.setItems(SharedData.stationData.getPerformanceReports());
        filterOptionComboBox.setItems(FXCollections.observableArrayList("All", "Reviewed", "Not Reviewed"));
        filterOptionComboBox.setValue("All");



    }

    @javafx.fxml.FXML
    public void filterOA(ActionEvent actionEvent) {
        String selected = filterOptionComboBox.getValue();

        switch (selected) {
            case "Reviewed":
                showReportTableView.setItems(SharedData.stationData.getPerformanceReports().filtered(PerformanceReport::isReviewed));
                break;
            case "Not Reviewed":
                showReportTableView.setItems(SharedData.stationData.getPerformanceReports().filtered(r -> !r.isReviewed()));
                break;
            default:
                showReportTableView.setItems(SharedData.stationData.getPerformanceReports());
        }
    }

    @javafx.fxml.FXML
    public void reviewDoneOA(ActionEvent actionEvent) {
        PerformanceReport selected = showReportTableView.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showReportTextArea.setText(" Please select a report to review.");
            return;
        }

        String comment = addCommentTextFIeld.getText().trim();
        if (!comment.isEmpty()) {
            selected.setComment(comment);
        }

        selected.setReviewed(true);
        showReportTableView.refresh();

        showReportTextArea.setText(" Marked as reviewed.\nComment: " + selected.getComment());
        addCommentTextFIeld.clear();
        BinaryFileUtil.saveStationData(SharedData.stationData, "C:/intasgo.com/data/team_performance.dat");
    }

    @FXML
    public void mainMenuOA(ActionEvent actionEvent) {
        loadStationManagerScene(actionEvent);
    }

    private void loadStationManagerScene(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("StationManagerFxml.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}