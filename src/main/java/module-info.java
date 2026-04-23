module com.ppva {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.ppva to javafx.fxml;
    exports com.ppva;
    exports com.ppva.controller;
    opens com.ppva.controller to javafx.fxml;
}