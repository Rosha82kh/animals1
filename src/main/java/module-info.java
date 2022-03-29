module com.example.animals {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.datatransfer;


    opens com.example.animals to javafx.fxml;
    exports com.example.animals;
}