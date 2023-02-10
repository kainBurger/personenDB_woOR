package com.example.persdb;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.PersonException;
import persistence.Persistence;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Controller {

    public TextField tfID;
    public TextField tfName;
    public TextField tfWohnort;
    public Button btOk;

    private Person model;
    private static Stage stage;

    public static void show() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage = new Stage();
        stage.setTitle("Neue Person hinzufügen");
        stage.setScene(scene);
        stage.show();
    }


    public void btOkClicked(ActionEvent actionEvent) throws IOException, SQLException {
        try {
            if(tfID.getText().length() == 0 || Integer.parseInt(tfID.getText()) < 0)
                throw new PersonException("ID muss größer 0 sein!");
            model = new Person(Integer.parseInt(tfID.getText()), tfName.getText(), tfWohnort.getText());
            Persistence.getInstance().insertPerson(model);
            stage.close();
        }catch(PersonException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).showAndWait();
        }
    }
}