package com.example.fmradio.Producer;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;

public class CoordinateWithAdvertiserFxmlController {

    @FXML
    private TableView<AdSubmission> adSubmissionTableView;

    @FXML
    private TableColumn<AdSubmission, String> statusCol;

    @FXML
    private TableColumn<AdSubmission, String> advertiserNameCol;

    @FXML
    private TableColumn<AdSubmission, String> adTitleCol;

    @FXML
    private ComboBox<String> availableSlotComboBox;

    @FXML
    private TableColumn<AdSubmission, String> durationCol;

    @FXML
    private TableColumn<AdSubmission, String> submissionDateCol;

    @FXML
    private TextArea messageToAdvertiserTextArea;

    private final ObservableList<AdSubmission> adSubmissions = FXCollections.observableArrayList();
    private final String dataFileName = "adSubmissionData.bin";

    @FXML
    public void initialize() {
        availableSlotComboBox.setItems(FXCollections.observableArrayList("Slot 1", "Slot 2", "Slot 3"));
        loadAdSubmissionsFromFile();
        adSubmissionTableView.setItems(adSubmissions);

        adTitleCol.setCellValueFactory(new PropertyValueFactory<>("adTitle"));
        advertiserNameCol.setCellValueFactory(new PropertyValueFactory<>("advertiserName"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
        durationCol.setCellValueFactory(new PropertyValueFactory<>("duration"));
        submissionDateCol.setCellValueFactory(new PropertyValueFactory<>("submissionDate"));

        loadAdSubmissionsFromFile();
        adSubmissionTableView.setItems(adSubmissions);
    }

    @FXML
    public void notifyStationManagerOA(ActionEvent actionEvent) {
        String message = "Notified Station Manager about the new ad submission.";
        messageToAdvertiserTextArea.setText(message);
    }

    @FXML
    public void messageToAdvertiserTextArea(Event event) {
        String selectedAd = adSubmissionTableView.getSelectionModel().getSelectedItem() != null ? adSubmissionTableView.getSelectionModel().getSelectedItem().getAdTitle() : "No ad selected";
        messageToAdvertiserTextArea.setText("Message for Advertiser regarding ad: " + selectedAd);
    }

    @FXML
    public void sendMessageToAdvertiserOA(ActionEvent actionEvent) {
        String message = messageToAdvertiserTextArea.getText();
        if (!message.isEmpty()) {
            System.out.println("Message sent to Advertiser: " + message);
        }
    }

    @FXML
    public void finalizePlanOA(ActionEvent actionEvent) {
        String selectedSlot = availableSlotComboBox.getSelectionModel().getSelectedItem();
        if (selectedSlot != null) {
            String planDetails = "Finalized ad plan for " + selectedSlot + " slot.";
            messageToAdvertiserTextArea.setText(planDetails);
            saveAdPlanToFile(planDetails); // This will now save to a different file
        }
    }

    @FXML
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
    private void saveAdPlanToFile(String planDetails) {
            String planFileName = "adPlanDetails.txt";
            try (DataOutputStream out = new DataOutputStream(new FileOutputStream(planFileName))) {
                out.writeUTF(planDetails);
            } catch (IOException e) {
                e.printStackTrace();
            }

    }
    private void saveAdSubmissionsToFile() {
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(dataFileName))) {
            for (AdSubmission ad : adSubmissions) {
                out.writeUTF(ad.getAdTitle());
                out.writeUTF(ad.getAdvertiserName());
                out.writeUTF(ad.getStatus());
                out.writeUTF(ad.getDuration());
                out.writeUTF(ad.getSubmissionDate());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void loadAdSubmissionsFromFile() {
        File file = new File(dataFileName);
        if (file.exists() && file.length() > 0) { // Check if the file exists AND has content
            try (DataInputStream in = new DataInputStream(new FileInputStream(file))) {
                while (in.available() > 0) {
                    String adTitle = in.readUTF();
                    String advertiserName = in.readUTF();
                    String status = in.readUTF();
                    String duration = in.readUTF();
                    String submissionDate = in.readUTF();
                    adSubmissions.add(new AdSubmission(adTitle, advertiserName, status, duration, submissionDate));
                }
            } catch (IOException e) {
                e.printStackTrace();
                // If there's an error reading, clear the list and add sample data
                adSubmissions.clear();
                addSampleData();
                saveAdSubmissionsToFile(); // Save the new, valid data
            }
        } else {
            addSampleData();
            saveAdSubmissionsToFile(); // Save the initial sample data so the file is created correctly
        }
    }

    private void addSampleData() {
        adSubmissions.add(new AdSubmission("Ad 1", "Advertiser 1", "Pending", "30s", "2025-08-10"));
        adSubmissions.add(new AdSubmission("Ad 2", "Advertiser 2", "Approved", "60s", "2025-08-11"));
        adSubmissions.add(new AdSubmission("Ad 3", "Advertiser 3", "Rejected", "45s", "2025-08-12"));
    }
}
