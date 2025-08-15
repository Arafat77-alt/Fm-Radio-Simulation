package com.example.fmradio.Producer;

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

import java.io.*;

public class ListenerFeedbackFxmlController
{
    @javafx.fxml.FXML
    private TableColumn<Feedback,String> typeCol;
    @javafx.fxml.FXML
    private TableColumn<Feedback,String> commentCol;
    @javafx.fxml.FXML
    private TableColumn<Feedback,String> segmentCol;
    @javafx.fxml.FXML
    private TableView<Feedback> feedbackTableView;
    @javafx.fxml.FXML
    private Label confirmationLabel;
    @javafx.fxml.FXML
    private ComboBox<String> selectCategoryComboBox;
    @javafx.fxml.FXML
    private TextArea summaryTextArea;
    private final ObservableList<Feedback> feedbackList = FXCollections.observableArrayList();
    private final String feedbackFile = "feedbackData.bin";

    @javafx.fxml.FXML
    public void initialize() {
        selectCategoryComboBox.setItems(FXCollections.observableArrayList("Positive", "Negative", "Neutral"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        commentCol.setCellValueFactory(new PropertyValueFactory<>("comment"));
        segmentCol.setCellValueFactory(new PropertyValueFactory<>("segment"));

        loadFeedbackFromFile();
        feedbackTableView.setItems(feedbackList);
    }
    private void saveFeedbackToFile(Feedback feedback) {
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(feedbackFile, true))) {
            out.writeUTF(feedback.getType());
            out.writeUTF(feedback.getComment());
            out.writeUTF(feedback.getSegment());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void loadFeedbackFromFile() {
        File file = new File(feedbackFile);
        if (file.exists()) {
            try (DataInputStream in = new DataInputStream(new FileInputStream(file))) {
                while (in.available() > 0) {
                    String type = in.readUTF();
                    String comment = in.readUTF();
                    String segment = in.readUTF();
                    feedbackList.add(new Feedback(type, comment, segment));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void saveSummaryToFile(String summary) {
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream("summaryData.bin"))) {
            out.writeUTF(summary);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @javafx.fxml.FXML
    public void submitSummaryOA(ActionEvent actionEvent) {
        String summary = summaryTextArea.getText();
        if (summary.isEmpty()) {
            confirmationLabel.setText("Please provide a summary.");
            confirmationLabel.setStyle("-fx-text-fill: red;");
        } else {
            confirmationLabel.setText("Summary submitted successfully!");
            confirmationLabel.setStyle("-fx-text-fill: green;");
            saveSummaryToFile(summary);
        }
    }

    @javafx.fxml.FXML
    public void categorizeOA(ActionEvent actionEvent) {
        String selectedCategory = selectCategoryComboBox.getSelectionModel().getSelectedItem();
        if (selectedCategory != null) {
            String message = "Category selected: " + selectedCategory;
            confirmationLabel.setText(message);
            confirmationLabel.setStyle("-fx-text-fill: blue;");
        } else {
            confirmationLabel.setText("Please select a category.");
            confirmationLabel.setStyle("-fx-text-fill: red;");
        }
    }

    @javafx.fxml.FXML
    public void receiveCommentOA(ActionEvent actionEvent) {
        String comment = "Sample comment";
        String segment = "Show Segment";
        String feedbackType = "Positive";


        Feedback newFeedback = new Feedback(feedbackType, comment, segment);
        feedbackList.add(newFeedback);
        saveFeedbackToFile(newFeedback);

        confirmationLabel.setText("Feedback received and saved.");
        confirmationLabel.setStyle("-fx-text-fill: green;");
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
}