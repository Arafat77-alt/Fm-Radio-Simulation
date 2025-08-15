package com.example.fmradio.Producer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class MonitorShowFxmlController
{
    @javafx.fxml.FXML
    private TableColumn<Show,String> typeCol;
    @javafx.fxml.FXML
    private TableColumn<Show,String> segmentNameCol;
    @javafx.fxml.FXML
    private Label confirmationLabel;
    @javafx.fxml.FXML
    private TableColumn<Show,String> startTimeCol;
    @javafx.fxml.FXML
    private ListView<Script> chatlistListView;
    @javafx.fxml.FXML
    private TableView<Show> monitorTableView;
    @javafx.fxml.FXML
    private TableColumn<Show,String> durationCol;

    private ObservableList<Show> showData = FXCollections.observableArrayList();



    @javafx.fxml.FXML
    public void initialize() {
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        segmentNameCol.setCellValueFactory(new PropertyValueFactory<>("segmentName"));
        startTimeCol.setCellValueFactory(new PropertyValueFactory<>("startTime"));
        durationCol.setCellValueFactory(new PropertyValueFactory<>("duration"));

        showData.add(new Show("Music", "Morning Jams", "09:00", "30"));
        showData.add(new Show("Talk", "News Highlights", "09:30", "15"));
        showData.add(new Show("Advertisement", "Ad Break 1", "09:45", "5"));
        showData.add(new Show("Music", "Listener's Choice", "09:50", "25"));
        monitorTableView.setItems(showData);
    }

    @javafx.fxml.FXML
    public void sendMessageOA(ActionEvent actionEvent) {
        confirmationLabel.setText("Message sent to RJ.");
    }

    @javafx.fxml.FXML
    public void openMonitorOA(ActionEvent actionEvent) {
        confirmationLabel.setText("Monitoring started for the current show.");
    }

    @javafx.fxml.FXML
    public void mainMenuOA(ActionEvent actionEvent) {
        loadProducerScene(actionEvent);
    }
    private void loadProducerScene(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ProducerFxml.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @javafx.fxml.FXML
    public void checkTimingOA(ActionEvent actionEvent) {
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        for (int i = 0; i < showData.size(); i++) {
            Show show1 = showData.get(i);
            LocalTime startTime1 = LocalTime.parse(show1.getStartTime(), timeFormatter);
            // The duration string is now a pure number, so Long.parseLong works
            long duration1Minutes = Long.parseLong(show1.getDuration());
            LocalTime endTime1 = startTime1.plus(duration1Minutes, ChronoUnit.MINUTES);

            for (int j = i + 1; j < showData.size(); j++) {
                Show show2 = showData.get(j);
                LocalTime startTime2 = LocalTime.parse(show2.getStartTime(), timeFormatter);
                long duration2Minutes = Long.parseLong(show2.getDuration());
                LocalTime endTime2 = startTime2.plus(duration2Minutes, ChronoUnit.MINUTES);

                if (startTime1.isBefore(endTime2) && startTime2.isBefore(endTime1)) {
                    confirmationLabel.setText("Time clash detected between '" + show1.getSegmentName() + "' and '" + show2.getSegmentName() + "'.");
                    return;
                }
            }
        }

        confirmationLabel.setText("Timing checked. No clashes detected. All segments are on schedule.");
    }

}