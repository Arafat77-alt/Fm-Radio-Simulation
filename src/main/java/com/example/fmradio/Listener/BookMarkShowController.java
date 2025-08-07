package com.example.fmradio.Listener;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class BookMarkShowController
{
    @javafx.fxml.FXML
    private ComboBox showGenreTextField;
    @javafx.fxml.FXML
    private TableColumn showGenreColumn;
    @javafx.fxml.FXML
    private ComboBox bookMarkCategoryComboBox;
    @javafx.fxml.FXML
    private TableColumn showTitleColumn;
    @javafx.fxml.FXML
    private TableColumn bookMarkCategoryColumn;
    @javafx.fxml.FXML
    private ComboBox showTitleTextField;
    @javafx.fxml.FXML
    private TableView bookMarkTableView;
    @javafx.fxml.FXML
    private TableColumn dateOfBookMarkColumn;
    @javafx.fxml.FXML
    private DatePicker bookMarkDateDatePicker;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void saveBookMarkButtonOnAction(ActionEvent actionEvent) {
    }
}