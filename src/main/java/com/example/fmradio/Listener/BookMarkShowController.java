package com.example.fmradio.Listener;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;

public class BookMarkShowController
{
    @javafx.fxml.FXML
    private TableColumn<BookMarkFavourite, String> showGenreColumn;
    @javafx.fxml.FXML
    private ComboBox<String> bookMarkCategoryComboBox;
    @javafx.fxml.FXML
    private TableColumn<BookMarkFavourite, String> showTitleColumn;
    @javafx.fxml.FXML
    private TableColumn<BookMarkFavourite, String> bookMarkCategoryColumn;
    @javafx.fxml.FXML
    private TableView<BookMarkFavourite> bookMarkTableView;
    @javafx.fxml.FXML
    private TableColumn<BookMarkShowController, LocalDate> dateOfBookMarkColumn;
    @javafx.fxml.FXML
    private DatePicker bookMarkDateDatePicker;
    @javafx.fxml.FXML
    private ComboBox<String> showGenreComboBox;
    @javafx.fxml.FXML
    private TextField showTtileTextField;
    @javafx.fxml.FXML
    private Label checkDuplicateLabel;

    @javafx.fxml.FXML
    public void initialize() {

        showGenreComboBox.getItems().addAll("Music", "Talk & Commentary", "Educational / Informational", "Storytelling & Drama" );
        bookMarkCategoryComboBox.getItems().addAll("Morning Boost", "Holiday Specials ");
        showTitleColumn.setCellValueFactory(new PropertyValueFactory<>("showTitle"));
        showGenreColumn.setCellValueFactory(new PropertyValueFactory<>("genre"));
        bookMarkCategoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        dateOfBookMarkColumn.setCellValueFactory(new PropertyValueFactory<>("date"));


    }

    ArrayList<BookMarkFavourite> bookmarks = new ArrayList<>();

    @javafx.fxml.FXML
    public void saveBookMarkButtonOnAction(ActionEvent actionEvent) {
        String showTitle;
        String genre;
        LocalDate date;
        String category;

        showTitle = showTtileTextField.getText();
        genre = showGenreComboBox.getValue();
        date = bookMarkDateDatePicker.getValue();
        category = bookMarkCategoryComboBox.getValue();

        for (BookMarkFavourite b : bookmarks){
            if(showTitle.equals (b.getShowTitle())){
                checkDuplicateLabel.setText("Already added");
                return;
            }
        };

        BookMarkFavourite bookMarkFavourite = new BookMarkFavourite(showTitle,
                genre, date, category );
        bookmarks.clear();
        bookmarks.add(bookMarkFavourite);
        bookMarkTableView.getItems().addAll(bookmarks);
        checkDuplicateLabel.setText("Show added to your Favorites");




    }
}