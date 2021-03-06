package com.example.class3todolistguijavafx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javafx.scene.control.ListView;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
public class ToDoListController {


    @FXML
    private Button clearWholeListButton;

    @FXML
    private TextField newTaskField;

    @FXML
    private Button removeTaskButton;

    @FXML
    private ListView<String> taskList;


    ObservableList<String> todoObservableList = FXCollections.observableArrayList("Task 1", "Task 2", "Task 3", "Task 4", "Task 5");
    ObservableList<String> removedObservableList = FXCollections.observableArrayList();


    boolean listCleared = false;

    @FXML
    public void initialize() {
        // this code runs when the controller is loaded
        taskList.setItems(todoObservableList);


    }


    @FXML
    void addTaskBtnClicked(ActionEvent event) {
        addTask();
    }

    private void addTask() {
        String newTask = newTaskField.getText();

        if (!newTask.equals("")) {
            todoObservableList.add(newTask);
        }
        newTaskField.clear();
    }

    @FXML
    void removeTask(ActionEvent event) {




            MultipleSelectionModel<String> selectedModel = taskList.getSelectionModel();
            String selectedTask = selectedModel.getSelectedItem();

            if(selectedTask == null) {
                System.out.println("No more task to remove 1");
//                return ;
            } else {
                System.out.println(selectedTask);
                removedObservableList.add(selectedTask);

                todoObservableList.remove(selectedTask);
                System.out.println(removedObservableList);
            }


    }

    @FXML
    void clearWholeList(ActionEvent event) {

        System.out.println(todoObservableList + " before remove\n");


        for (int i = 0; i < todoObservableList.size(); i++) {
            removedObservableList.add(todoObservableList.get(i));
        }

        todoObservableList.clear();
        System.out.println(todoObservableList + " after remove");
        System.out.println(removedObservableList);

        listCleared = true;
    }

    @FXML
    void undoList(ActionEvent event) {
//
//        undo all list at one once
//        for (int i ; i < removedObservableList.size(); i++) {
//            todoObservableList.add(removedObservableList.get(i));
//        }


        if(listCleared){
            for (int i = 0 ; i < removedObservableList.size(); i++) {
                todoObservableList.add(removedObservableList.get(i));
            }
            removedObservableList.clear();
            listCleared = false;
        } else {
            try {
                int index = removedObservableList.size() -1 ;
                todoObservableList.add(removedObservableList.get(index));
                removedObservableList.remove(index);
            } catch (Exception e){
                System.out.println("No more list to undo.");
            }
        }

    }
}