package com.example.fmradio.Producer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;

public class UploadScriptFxmlController
{
    @javafx.fxml.FXML
    private TextArea showScriptTextArea;
    @javafx.fxml.FXML
    private Label statusLabel;

    private final ObservableList<Script> scripts = FXCollections.observableArrayList();
    private final String dataFileName = "scripts.bin";
    @javafx.fxml.FXML
    private TextField showNameTextField;


    @javafx.fxml.FXML
    public void initialize() {
        loadScriptsFromFile();
        if (!scripts.isEmpty()) {
            Script lastScript = scripts.get(scripts.size() - 1);
            showNameTextField.setText(lastScript.getShowName());
            showScriptTextArea.setText(lastScript.getScriptText());
        }
        loadScriptsFromFile();

    }
    private void loadScriptsFromFile() {
        File file = new File(dataFileName);
        if (file.exists()) {
            try (DataInputStream in = new DataInputStream(new FileInputStream(file))) {
                int size = in.readInt();
                for (int i = 0; i < size; i++) {
                    String showName = in.readUTF();
                    String scriptText = in.readUTF();
                    scripts.add(new Script(showName, scriptText));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            addSampleScripts();
        }
    }
    private void addSampleScripts() {
        scripts.add(new Script("Morning Show", "This is the script for the morning show."));
        scripts.add(new Script("Evening Show", "This is the script for the evening show."));
        scripts.add(new Script("Music Hour", "This is the script for the music hour."));
        saveScriptsToFile();  // Save sample scripts to the file
    }
    private void saveScriptsToFile() {
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(dataFileName))) {
            out.writeInt(scripts.size());
            for (Script script : scripts) {
                out.writeUTF(script.getShowName());
                out.writeUTF(script.getScriptText());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void notifyRjManagerOA(ActionEvent actionEvent) {
        String message = "Notified RJ and Station Manager about the uploaded script.";
        statusLabel.setText(message);
    }

    @javafx.fxml.FXML
    public void archiveOA(ActionEvent actionEvent) {
        String showName = showNameTextField.getText();
        String scriptText = showScriptTextArea.getText();

        if (showName.isEmpty() || scriptText.isEmpty()) {
            statusLabel.setText("Please fill in both show name and script.");
            return;
        }

        Script newScript = new Script(showName, scriptText);
        scripts.add(newScript);
        saveScriptsToFile();

        statusLabel.setText("Script archived for: " + showName);
    }

    @javafx.fxml.FXML
    public void uploadScriptOA(ActionEvent actionEvent) {
        String showName = showNameTextField.getText();
        String scriptText = showScriptTextArea.getText();

        if (showName.isEmpty() || scriptText.isEmpty()) {
            statusLabel.setText("Please fill in both show name and script.");
            return;
        }

        Script uploadedScript = new Script(showName, scriptText);
        scripts.add(uploadedScript);
        saveScriptsToFile();

        statusLabel.setText("Script uploaded for: " + showName);
        showNameTextField.clear();
        showNameTextField.clear();

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