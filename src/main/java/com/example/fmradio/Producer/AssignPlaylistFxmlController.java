package com.example.fmradio.Producer;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class AssignPlaylistFxmlController
{
    @javafx.fxml.FXML
    private TableView songTableTableView;
    @javafx.fxml.FXML
    private TableColumn durationCol;
    @javafx.fxml.FXML
    private Label messageLabel;
    @javafx.fxml.FXML
    private TableColumn songTitleCol;
    @javafx.fxml.FXML
    private TableColumn statusCol;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void notifyMusicManagerOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void approveOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void checkCopyrightOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void rejectOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void mainMenuOA(ActionEvent actionEvent) {
    }
}