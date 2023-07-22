package com.example.firstproj02.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class ProductTasksController {

    Parent parent;
    Pane pane;

    @FXML
    private Button addButton;

    @FXML
    private Button editButton;

    @FXML
    private Button removeButton;

    @FXML
    private Button showAllButton;

    @FXML
    void addButton(ActionEvent event) throws IOException {
        new ProductsApplication(parent, pane).start((Stage) ((Node)event.getSource()).getScene().getWindow());
    }

    @FXML
    void editButton(ActionEvent event) {

    }

    @FXML
    void removeButton(ActionEvent event) {

    }

    @FXML
    void showAllButton(ActionEvent event) {

    }
}
