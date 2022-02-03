package com.example.class3todolistguijavafx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ToDoListController {


    @FXML
    private Button clearWholeListButton;

    @FXML
    private TextField newTaskField;

    @FXML
    private Button removeTaskButton;

    @FXML
    private ListView<String> taskList;
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }


    ObservableList<String> todoObservableList = FXCollections.observableArrayList("Task1", "Task2", "Task3");


    @FXML
    public void initialize(){
        // this code runs when the controller is loaded
        taskList.setItems(todoObservableList);



    }



    @FXML
    void addTaskBtnClicked(ActionEvent event) {
        addTask();
    }

    private void addTask(){
        String newTask = newTaskField.getText();

        if(!newTask.equals("")){
            todoObservableList.add(newTask);
        }
    }

    @FXML
    void removeTask(ActionEvent event) {
        MultipleSelectionModel<String> selectedModel = taskList.getSelectionModel();
        String selectedTask = selectedModel.getSelectedItem();

        System.out.println(selectedTask);

        todoObservableList.remove(selectedTask);
    }

    @FXML
    void clearWholeList(ActionEvent event) {
        todoObservableList.clear();
    }
}