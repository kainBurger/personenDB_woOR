package com.example.persdb;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        ListController.show(stage);
    }

    public static void main(String[] args) {
        launch();
    }


}