module com.example.fmradio {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.fmradio to javafx.fxml;
    exports com.example.fmradio;
}