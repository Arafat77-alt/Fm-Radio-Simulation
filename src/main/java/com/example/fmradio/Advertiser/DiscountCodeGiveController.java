package com.example.fmradio.Advertiser;

import com.example.fmradio.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.ArrayList;

public class DiscountCodeGiveController
{
    @javafx.fxml.FXML
    private TableColumn<DiscountCode, Integer> discountColoumn;
    @javafx.fxml.FXML
    private TableColumn<DiscountCode, String> codeColoumn;
    @javafx.fxml.FXML
    private DatePicker expiryDatePicker;
    @javafx.fxml.FXML
    private ComboBox<String> selectoccasionCategoryComboBox;
    @javafx.fxml.FXML
    private TextField discountCodeTextField;
    @javafx.fxml.FXML
    private TextField discountNumberTextField;
    @javafx.fxml.FXML
    private TableColumn<DiscountCode, String> occasionColoumn;
    @javafx.fxml.FXML
    private TableColumn<DiscountCode, LocalDate> expireDateColoumn;
    @javafx.fxml.FXML
    private TableView<DiscountCode> discountCodeTableView;
    @javafx.fxml.FXML
    private Label feedbackOnDiscountLabel;
    @javafx.fxml.FXML
    private Button backFXID;

    @javafx.fxml.FXML
    public void initialize() {

        occasionColoumn.setCellValueFactory(new PropertyValueFactory<>("occasion"));
        codeColoumn.setCellValueFactory(new PropertyValueFactory<>("code"));
        discountColoumn.setCellValueFactory(new PropertyValueFactory<>("discount"));
        expireDateColoumn.setCellValueFactory(new PropertyValueFactory<>("expirydate"));

        selectoccasionCategoryComboBox.getItems().addAll("Music Appreciation Month", "Holiday Season", "Influencer Collaborations");
    }

    ArrayList<DiscountCode> discountCodeArrayList = new ArrayList<>();

    @javafx.fxml.FXML
    public void submitButtonOnAction(ActionEvent actionEvent) {

         String occasion;
         int discount;
         LocalDate expirydate;
         String code;

         occasion = selectoccasionCategoryComboBox.getValue();
         discount = Integer.parseInt(discountNumberTextField.getText());
         expirydate = expiryDatePicker.getValue();
         code = discountCodeTextField.getText();

        if (occasion.isBlank() || expirydate == null ||  code.isBlank()){
            feedbackOnDiscountLabel.setText("Please enter all the details");
            return;
        }

        LocalDate a = LocalDate.now();

        if (expirydate.equals(a) || expirydate.isBefore(a) ){
            feedbackOnDiscountLabel.setText("Set a Future Date");
            return;
        }

         if (discount >= 1 && discount <= 100){
             DiscountCode discountCode = new DiscountCode(occasion, discount, expirydate, code);
             discountCodeArrayList.add(discountCode);
             discountCodeTableView.getItems().addAll(discountCodeArrayList);
             discountCodeArrayList.clear();
         }else {
             feedbackOnDiscountLabel.setText("Discount supposed to be between 1 and 100");
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