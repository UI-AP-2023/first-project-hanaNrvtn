package com.example.firstproj02.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DiscountController implements Initializable {
    @FXML
    private Button customerDiscountButton;

    @FXML
    private Button productDiscountButton;

    Parent parent;
    Pane pane;

    @FXML
    void customerDiscountButton(ActionEvent event) throws IOException {
        new CustomerDiscountApplication(parent, pane).start((Stage) ((Node)event.getSource()).getScene().getWindow());
    }

    @FXML
    void productDiscountButton(ActionEvent event) {

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
