module com.example.examenjava {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.examenjava to javafx.fxml;
    exports com.example.examenjava;
}