package com.example.fmradio.StationManager;



import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class StationManagerFxmlController {

    private Stage stage;

    @javafx.fxml.FXML
    private Label messageLabel;  // This will link to your FXML Label

    @javafx.fxml.FXML
    public void initialize() {
        // Initialization logic if needed
    }

    @javafx.fxml.FXML
    public void approveFinalPlaylistOA(ActionEvent actionEvent) {
        loadScene("FinalPlaylistFxml.fxml");
    }

    @Deprecated
    public void reviewSocialMediaOA(ActionEvent actionEvent) {
        loadScene("SocialMediaFxml.fxml");
    }

    @javafx.fxml.FXML
    public void teamPerformanceOA(ActionEvent actionEvent) {
        loadScene("TeamPerformanceFxml.fxml");
    }

    @javafx.fxml.FXML
    public void weeklyProgramOA(ActionEvent actionEvent) {
        loadScene("WeeklyProgramFxml.fxml");
    }

    @javafx.fxml.FXML
    public void assignRjAndProducerOA(ActionEvent actionEvent) {
        loadScene("AssignFxml.fxml");
    }

    @javafx.fxml.FXML
    public void emergencyShowCancellationOA(ActionEvent actionEvent) {
        loadScene("EmergencyCancelFxml.fxml");
    }

    @javafx.fxml.FXML
    public void singoutOA(ActionEvent actionEvent) {
        // Handle sign out or logout logic
    }

    @Deprecated
    public void reviewAdvertiserSlotOA(ActionEvent actionEvent) {
        loadScene("ReviewAdvertiserFxml.fxml");
    }

    @javafx.fxml.FXML
    public void teamMeetingOA(ActionEvent actionEvent) {
        loadScene("TeamMeetingFxml.fxml");
    }

    private void loadScene(String fxmlFileName) {
        try {
            // Ensure the FXML file path is correct
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/fmradio/StationManager/" + fxmlFileName));

            if (fxmlLoader.getLocation() == null) {
                throw new IOException("FXML file not found: " + fxmlFileName);
            }

            // Load the FXML file
            StackPane root = fxmlLoader.load();
            Scene scene = new Scene(root);
            stage = (Stage) root.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            showAlert("Error", "Failed to load scene: " + fxmlFileName + "\n" + e.getMessage());
            e.printStackTrace();  // Print the stack trace for debugging
        }
    }

    // Method to show alerts
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();

        // Assuming messageLabel is initialized properly and linked to FXML
        messageLabel.setText(message);
    }

    // This method is called when you want to go back to the main menu
    public void backToMainMenu() {
        loadScene("StationManagerMainMenu.fxml");  // Make sure this FXML exists
    }

    @javafx.fxml.FXML
    public void socialMediaOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void advertiserSlotOA(ActionEvent actionEvent) {
    }
}
