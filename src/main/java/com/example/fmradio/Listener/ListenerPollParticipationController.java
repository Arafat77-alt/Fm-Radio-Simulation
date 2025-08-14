package com.example.fmradio.Listener;

import com.example.fmradio.Advertiser.Poll;
import javafx.event.ActionEvent;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javafx.scene.control.cell.PropertyValueFactory;


import java.io.FileInputStream;
import java.io.ObjectInputStream;


public class ListenerPollParticipationController
{
    @javafx.fxml.FXML
    private TableView<PollParticipation> pollParticipationTableview;
    @javafx.fxml.FXML
    private ComboBox<String> selectOptionComboBox;
    @javafx.fxml.FXML
    private TableColumn<Poll,String> pollTtitleColoumn;
    @javafx.fxml.FXML
    private TableColumn<Poll, String> optionTwoColoumn;
    @javafx.fxml.FXML
    private TableColumn<Poll, String> questionColoumn;
    @javafx.fxml.FXML
    private TableColumn<Poll, String> optionOneColoumn;
    @javafx.fxml.FXML
    private TableView<Poll> advertiserPollTableview;
    @javafx.fxml.FXML
    private TableColumn<PollParticipation, String> pollNoColoumn;
    @javafx.fxml.FXML
    private TableColumn<Poll, String> optionThreeCol;
    @javafx.fxml.FXML
    private TableColumn<PollParticipation, String> chosenOptionNoColoumn;
    @javafx.fxml.FXML
    private ComboBox<String> pollTitleNoComboBox;
    @javafx.fxml.FXML
    private Label feedBackLabel;

    @javafx.fxml.FXML
    public void initialize() {
        pollTtitleColoumn.setCellValueFactory(new PropertyValueFactory<>("pollsubject"));
        questionColoumn.setCellValueFactory(new PropertyValueFactory<>("question"));
        optionOneColoumn.setCellValueFactory(new PropertyValueFactory<>("optionOne"));
        optionTwoColoumn.setCellValueFactory(new PropertyValueFactory<>("optionTwo"));
        optionThreeCol.setCellValueFactory(new PropertyValueFactory<>("optionThree"));

        pollNoColoumn.setCellValueFactory(new PropertyValueFactory<>("pollTitle"));
        chosenOptionNoColoumn.setCellValueFactory(new PropertyValueFactory<>("optionNO"));


        chosenOptionNoColoumn.setCellValueFactory(new PropertyValueFactory<>("selectedOption"));
        selectOptionComboBox.getItems().addAll("1", "2", "3");
    }


    @javafx.fxml.FXML
    public void submitPollAnswerButtonOnAction(ActionEvent actionEvent) {
        String pollsubject;
        String optionNO;

        pollsubject = pollTitleNoComboBox.getValue();
        optionNO   = selectOptionComboBox.getValue();

        if (optionNO == null ){
            feedBackLabel.setText("Please choose an option");
            return;
        }


        PollParticipation newPollParticipation = new PollParticipation(pollsubject, optionNO);
        pollParticipationTableview.getItems().addAll(newPollParticipation);

    }

    @javafx.fxml.FXML
    public void loadPollsButtonOnAction(ActionEvent actionEvent) {
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        advertiserPollTableview.getItems().clear();;
        try {
            fis = new FileInputStream("createdpolls.bin");
            ois = new ObjectInputStream(fis);

            while (true) {
                Poll loadedPolls = (Poll) ois.readObject();
                pollTitleNoComboBox.getItems().addAll(loadedPolls.getPollsubject());
                advertiserPollTableview.getItems().add(loadedPolls);
            }

        } catch (Exception e ) {

        }
    }
}
