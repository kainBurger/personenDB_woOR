package com.example.persdb;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Person;

import java.io.IOException;
import java.util.List;

public class Controller {

    public TextField tfID;
    public TextField tfName;
    public TextField tfWohnort;
    public Button btOk;

    private Person model;

    public static void show() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        Stage stage = new Stage();
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }


    public void btOkClicked(ActionEvent actionEvent) throws IOException {
        model = new Person(Integer.parseInt(tfID.getText()), tfName.getText(), tfWohnort.getText());
    }
}