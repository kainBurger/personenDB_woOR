package com.example.persdb;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import model.PersonException;

public class Person {
    private SimpleIntegerProperty id = new SimpleIntegerProperty();
    private SimpleStringProperty name = new SimpleStringProperty();
    private SimpleStringProperty wohnort = new SimpleStringProperty();

    public Person(int id, String name, String wohnort) throws PersonException {
        setId(id);
        setName(name);
        setWohnort(wohnort);
    }

    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) throws PersonException {
        if(id < 0)
            throw new PersonException("ID muss größer 0 sein!");
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) throws PersonException {
        if(name.length() < 3)
            throw new PersonException("Name muss zumindest 3 Stellen haben!");
        this.name.set(name);
    }

    public String getWohnort() {
        return wohnort.get();
    }

    public SimpleStringProperty wohnortProperty() {
        return wohnort;
    }

    public void setWohnort(String wohnort) throws PersonException {
        if(wohnort.length() < 2)
            throw new PersonException("Wohnort muss zumindest 2 Stellen haben!");
        this.wohnort.set(wohnort);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", wohnort='" + wohnort + '\'' +
                '}';
    }
}
