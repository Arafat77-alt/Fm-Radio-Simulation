package com.example.fmradio.Producer;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;

public class PreShowCheckFxmlController
{
    @javafx.fxml.FXML
    private TextField testTimeTextField;
    @javafx.fxml.FXML
    private CheckBox micCheckBox;
    @javafx.fxml.FXML
    private CheckBox audioCheckBox;
    @javafx.fxml.FXML
    private DatePicker testDateDatePicker;

    private final String dataFileName = "preShowTests.bin";
    @javafx.fxml.FXML
    private Label showResultLabel;

    @javafx.fxml.FXML
    public void initialize() {

    }

    @javafx.fxml.FXML
    public void dryRunOA(ActionEvent actionEvent) {
        String testTime = testTimeTextField.getText();
        boolean micTested = micCheckBox.isSelected();
        boolean audioTested = audioCheckBox.isSelected();
        String testDate = testDateDatePicker.getValue() != null ? testDateDatePicker.getValue().toString() : "";

        if (testTime.isEmpty() || testDate.isEmpty()) {
            showResultLabel.setText("Please fill all fields.");
            showResultLabel.setStyle("-fx-text-fill: red;");
        } else if (micTested && audioTested) {
            showResultLabel.setText("Dry run successful! All tests passed.");
            showResultLabel.setStyle("-fx-text-fill: green;");
            saveTestData(testTime, micTested, audioTested, testDate);
        } else {
            showResultLabel.setText("Tests failed. Please check microphone and audio levels.");
            showResultLabel.setStyle("-fx-text-fill: red;");
        }
    }
    private void saveTestData(String testTime, boolean micTested, boolean audioTested, String testDate) {
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(dataFileName))) {
            out.writeUTF(testTime);
            out.writeBoolean(micTested);
            out.writeBoolean(audioTested);
            out.writeUTF(testDate);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadTestData() {
        File file = new File(dataFileName);
        if (file.exists()) {
            try (DataInputStream in = new DataInputStream(new FileInputStream(file))) {
                String testTime = in.readUTF();
                boolean micTested = in.readBoolean();
                boolean audioTested = in.readBoolean();
                String testDate = in.readUTF();

                showResultLabel.setText("Last Test - Time: " + testTime + ", Date: " + testDate +
                        ", Mic Tested: " + (micTested ? "Yes" : "No") +
                        ", Audio Tested: " + (audioTested ? "Yes" : "No"));
                showResultLabel.setStyle("-fx-text-fill: blue;");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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


}