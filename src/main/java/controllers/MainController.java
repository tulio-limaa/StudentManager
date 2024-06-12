package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import models.Student;

public class MainController {
    @FXML
    private TableView<Student> studentTableView;

    @FXML
    private TableColumn<Student, Integer> idColumn;

    @FXML
    private TableColumn<Student, String> nameColumn;

    @FXML
    private TableColumn<Student, String> emailColumn;

    @FXML
    private TableColumn<Student, String> majorColumn;

    @FXML
    private TextField idTextField;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField majorTextField;

    public void initialize() {
        idColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getId()).asObject());
        nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        emailColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmail()));
        majorColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMajor()));
    }

    @FXML
    private void handleAddButton() {
        // Get the input from the text fields
        int id = Integer.parseInt(idTextField.getText());
        String name = nameTextField.getText();
        String email = emailTextField.getText();
        String major = majorTextField.getText();

        // Create a new Student object
        Student newStudent = new Student(id, name, email, major);

        // Add the new student to the table
        studentTableView.getItems().add(newStudent);

        // Clear the text fields
        clearTextFields();
    }

    @FXML
    private void handleUpdateButton() {
        // Get the selected student from the table
        Student selectedStudent = studentTableView.getSelectionModel().getSelectedItem();
        if (selectedStudent != null) {
            // Update the selected student's information
            selectedStudent.setId(Integer.parseInt(idTextField.getText()));
            selectedStudent.setName(nameTextField.getText());
            selectedStudent.setEmail(emailTextField.getText());
            selectedStudent.setMajor(majorTextField.getText());

            // Refresh the table view
            studentTableView.refresh();

            // Clear the text fields
            clearTextFields();
        }
    }

    @FXML
    private void handleDeleteButton() {
        // Get the selected student from the table
        Student selectedStudent = studentTableView.getSelectionModel().getSelectedItem();
        if (selectedStudent != null) {
            // Remove the selected student from the table
            studentTableView.getItems().remove(selectedStudent);

            // Clear the text fields
            clearTextFields();
        }
    }

    private void clearTextFields() {
        idTextField.clear();
        nameTextField.clear();
        emailTextField.clear();
        majorTextField.clear();
    }
}
