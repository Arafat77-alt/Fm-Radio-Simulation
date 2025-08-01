module com.example.fmradio {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.fmradio to javafx.fxml;
    opens com.example.fmradio.Advertiser to javafx.fxml, java.base;
    opens com.example.fmradio.Listener to javafx.fxml, java.base;
    exports com.example.fmradio;
    exports com.example.fmradio.Advertiser;
}