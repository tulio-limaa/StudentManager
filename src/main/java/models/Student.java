package models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Student {
    private int id;
    private String name;
    private String email;
    private String major;

    public Student(int id, String name, String email, String major) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.major = major;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public IntegerProperty idProperty() {
        return new SimpleIntegerProperty(this.id);
    }

    public StringProperty nameProperty() {
        return new SimpleStringProperty(this.name);
    }

    public StringProperty emailProperty() {
        return new SimpleStringProperty(this.email);
    }

    public StringProperty majorProperty() {
        return new SimpleStringProperty(this.major);
    }
}
