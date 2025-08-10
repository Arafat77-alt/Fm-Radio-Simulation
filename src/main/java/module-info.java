module com.example.fmradio {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires jdk.compiler;


    opens com.example.fmradio to javafx.fxml;
    opens com.example.fmradio.Advertiser to javafx.fxml, java.base;
    opens com.example.fmradio.Listener to javafx.fxml, java.base;
    exports com.example.fmradio;
    exports com.example.fmradio.Advertiser;
    exports com.example.fmradio.StationManager;
    opens com.example.fmradio.StationManager to javafx.fxml,java.base;
    opens com.example.fmradio.Producer to javafx.fxml, javafx.base;
    exports com.example.fmradio.Listener;
}