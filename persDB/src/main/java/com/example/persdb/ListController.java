package com.example.persdb;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import persistence.Persistence;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class ListController {

    public Button btRefresh;
    public Button btInsert;
    public TableView<Person> tvItems;

    //private Connection c = DriverManager.getConnection("jdbc:derby://localhost:1527/B_Uebung", "B_Uebung", "B_Uebung");

    public static void show(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("listView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Personen anzeigen");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void initialize() throws SQLException {
        TableColumn<Person, Integer> columnId = new TableColumn<>("ID");
        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Person, String> columnName = new TableColumn<>("Name");
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Person, String> columnWohnort = new TableColumn<>("Wohnort");
        columnWohnort.setCellValueFactory(new PropertyValueFactory<>("wohnort"));

        tvItems.getColumns().addAll(columnId, columnName, columnWohnort);
        //tvItems.getItems().add(new Person(1, "Florian Kainberger", "Fornach"));
        fillList();

    }

    private void fillList() throws SQLException {
        tvItems.setItems(FXCollections.observableList(Persistence.getInstance().getPeople()));
    }

    public void btRefreshClicked(ActionEvent actionEvent) throws SQLException {
        fillList();
    }

    public void btInsertClicked(ActionEvent actionEvent) throws IOException {
        Controller.show();
    }
}
