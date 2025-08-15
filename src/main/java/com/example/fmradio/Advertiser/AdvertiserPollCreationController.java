package com.example.fmradio.Advertiser;

import com.example.fmradio.HelloApplication;
import com.example.fmradio.Utility.AppendableObjectOutputStream;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class AdvertiserPollCreationController
{
    @javafx.fxml.FXML
    private TextField pollQuestionTextField;
    @javafx.fxml.FXML
    private TextField optionTwoTextField;
    @javafx.fxml.FXML
    private Label showSuccessFailLabel;
    @javafx.fxml.FXML
    private TextField optionOneTextField;
    @javafx.fxml.FXML
    private TableColumn<Poll, LocalDate> dateColumn;
    @javafx.fxml.FXML
    private TextField optionThreeTextField;
    @javafx.fxml.FXML
    private TableColumn<Poll, String> subjectColumn;
    @javafx.fxml.FXML
    private TableView<Poll> createPollTableView;
    @javafx.fxml.FXML
    private TextField pollSubjectTextField;
    @javafx.fxml.FXML
    private TableColumn<Poll, Integer> optionNoCol;
    @javafx.fxml.FXML
    private TableColumn<Poll, String> optionThreeCol;
    @javafx.fxml.FXML
    private TableColumn<Poll, String> pollTtitleColoumn;
    @javafx.fxml.FXML
    private TableColumn<Poll, String> optionTwoColoumn;
    @javafx.fxml.FXML
    private TableColumn<Poll, String> questionColoumn;
    @javafx.fxml.FXML
    private TableColumn<Poll, String> optionOneColoumn;
    @javafx.fxml.FXML
    private TableView<Poll> advertiserPollTableview;
    @javafx.fxml.FXML
    private Button backFXID;

    @javafx.fxml.FXML
    public void initialize() {


        optionNoCol.setCellValueFactory(new  PropertyValueFactory<>("optionNO"));
        subjectColumn.setCellValueFactory(new PropertyValueFactory<>("pollsubject"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("dateOfPollCreate"));

        pollTtitleColoumn.setCellValueFactory(new  PropertyValueFactory<>("pollsubject"));
        optionOneColoumn.setCellValueFactory(new  PropertyValueFactory<>("optionOne"));
        optionTwoColoumn.setCellValueFactory(new PropertyValueFactory<>("optionTwo"));
        optionThreeCol.setCellValueFactory(new PropertyValueFactory<>("optionThree"));
        questionColoumn.setCellValueFactory(new PropertyValueFactory<>("question"));

    }

    @javafx.fxml.FXML
    public void validatePollButtonOnAction(ActionEvent actionEvent) {

        String pollsubject;
        pollsubject = pollSubjectTextField.getText();
        LocalDate dateOfPollCreate;
        dateOfPollCreate = LocalDate.now();

        String question;
        question = pollQuestionTextField.getText();

        String optionOne;
        String optionTwo;
        String optionThree;

        optionOne = optionOneTextField.getText();
        optionTwo = optionTwoTextField.getText();
        optionThree= optionThreeTextField.getText();


        if (optionOne.isBlank()){
            if (optionTwo.isBlank() || optionThree.isBlank()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("select minimum two options");
                alert.show();
                return;
            }
        }

        if (optionTwo.isBlank()){
            if (optionOne.isBlank() || optionThree.isBlank()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("select minimum two options");
                alert.show();
                return;
            }
        }

        if (optionThree.isBlank()){
            if (optionTwo.isBlank() || optionOne.isBlank()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("select minimum two options");
                alert.show();
                return;
            }
        }

        if (pollsubject.isBlank() || question.isBlank()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Data entries");
            alert.setContentText("Please fill up title and question");
            alert.showAndWait();

        }

        showSuccessFailLabel.setText("Your poll is valid");

    }


    @javafx.fxml.FXML
    public void createPollButtonOnAction(ActionEvent actionEvent) {
        String pollId;
        String pollsubject;
        pollsubject = pollSubjectTextField.getText();
        LocalDate dateOfPollCreate;
        dateOfPollCreate = LocalDate.now();
        String question;
        question = pollQuestionTextField.getText();

        String optionOne;
        String optionTwo;
        String optionThree;

        optionOne = optionOneTextField.getText();
        optionTwo = optionTwoTextField.getText();
        optionThree= optionThreeTextField.getText();


        int count= 0;
        if (optionOne.length() != 0){
            count++;
        }
        if (optionTwo.length() != 0){
            count++;
        }
        if (optionThree.length() != 0){
            count++;
        }

        ArrayList<Poll> pollCreationArrayList =  new ArrayList<>();
        Poll newcreatedpoll = new Poll(pollsubject,question,optionOne, optionTwo, optionThree, dateOfPollCreate, count);

        pollCreationArrayList.add(newcreatedpoll);
        createPollTableView.getItems().addAll(pollCreationArrayList);
        advertiserPollTableview.getItems().addAll(pollCreationArrayList);

        saveFile(newcreatedpoll);
    }

    private void saveFile(Object Poll){

        ObjectOutputStream oos = null;

        try {
            File file = new File("createdpolls.bin");
            if (file.exists()) {
                FileOutputStream fos = new FileOutputStream(file, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                FileOutputStream fos = new FileOutputStream(file);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(Poll);
            oos.close();
        }
        catch (Exception e){

        }

    }

    @javafx.fxml.FXML
    public void backButtonOnAction(ActionEvent actionEvent) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("AdvertiserDashboard.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage dupstage = (Stage) backFXID.getScene().getWindow();
            dupstage.setScene(scene);
            dupstage.setTitle("AdvertiserDashBoard");
            dupstage.show();

        } catch (Exception e) {

        }

    }
}