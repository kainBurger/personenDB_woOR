module com.example.persdb {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.persdb to javafx.fxml;
    exports com.example.persdb;
}