package model;

public class Person {
    private int id;
    private String name;
    private String wohnort;

    public Person(int id, String name, String wohnort) {
        this.id = id;
        this.name = name;
        this.wohnort = wohnort;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWohnort() {
        return wohnort;
    }

    public void setWohnort(String wohnort) {
        this.wohnort = wohnort;
    }
}
