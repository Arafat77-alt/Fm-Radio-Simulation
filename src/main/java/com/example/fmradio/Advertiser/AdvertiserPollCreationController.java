package com.example.fmradio.Advertiser;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

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
    private TextField pollIDTextField;
    @javafx.fxml.FXML
    private TextField pollSubjectTextField;
    @javafx.fxml.FXML
    private TableColumn optionNoCol;

    @javafx.fxml.FXML
    public void initialize() {


        optionNoCol.setCellValueFactory(new  PropertyValueFactory<>("optionNO"));
        subjectColumn.setCellValueFactory(new PropertyValueFactory<>("pollsubject"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("dateOfPollCreate"));
    }

    ArrayList<Poll> pollList = new ArrayList<>();

    @javafx.fxml.FXML
    public void validatePollButtonOnAction(ActionEvent actionEvent) {
        String pollId;
        String pollsubject;
        pollId = pollIDTextField.getText();
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



        if (pollId.isBlank() || pollsubject.isBlank() || question.isBlank() || dateOfPollCreate == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Please write down all the requirements before poll creation");
            alert.show();
            return;
        };

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
        showSuccessFailLabel.setText("Your poll is valid");

    }


    @javafx.fxml.FXML
    public void createPollButtonOnAction(ActionEvent actionEvent) {
        String pollId;
        String pollsubject;
        pollId = pollIDTextField.getText();
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

        ArrayList<Poll> pollCreationArrayList =  new ArrayList<>(); //Poll.pollList;
        Poll newcreatedpoll = new Poll(pollId,pollsubject,question,optionOne, optionTwo, optionThree, dateOfPollCreate, count);
        pollCreationArrayList.add(newcreatedpoll);

        createPollTableView.getItems().addAll(pollCreationArrayList);
    }
}