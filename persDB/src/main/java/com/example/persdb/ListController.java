package com.example.persdb;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

public class ListController {

    public ListView lvItems;
    public Button btRefresh;
    public Button btInsert;

    //private Connection c = DriverManager.getConnection("jdbc:derby://localhost:1527/B_Uebung", "B_Uebung", "B_Uebung");

    public static void show(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("listView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void initialize() {

    }

    public void btRefreshClicked(ActionEvent actionEvent) {

    }

    public void btInsertClicked(ActionEvent actionEvent) {

    }
}
