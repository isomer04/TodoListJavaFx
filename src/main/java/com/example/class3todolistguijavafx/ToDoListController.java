package com.example.class3todolistguijavafx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ToDoListController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}