package com.example.firstproj02.view;

import com.example.firstproj02.controller.AdminController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminPanelController implements Initializable {
    AdminController adminController;
    Parent parent;

    @FXML
    private AnchorPane customerPanelAnchorPane;

    @FXML
    private Button discountsButton;

    @FXML
    private Button editInfoButton;

    @FXML
    private Button logOutButton;

    @FXML
    private Button productsButton;

    @FXML
    private Button profileButton;

    @FXML
    private Button requestsButton;

    @FXML
    private Button usersButton;

    @FXML
    void discountsButton(ActionEvent event) throws IOException {
        new DiscountApplication(parent, customerPanelAnchorPane).start((Stage) ((Node)event.getSource()).getScene().getWindow());
    }

    @FXML
    void editInfoButton(ActionEvent event) {

    }

    @FXML
    void logOutButton(ActionEvent event) throws IOException {
        new HomeApplication().start((Stage) ((Node) event.getSource()).getScene().getWindow());
    }

    @FXML
    void productsButton(ActionEvent event) throws IOException {
        new ProductTasksApplication(parent, customerPanelAnchorPane).start((Stage) ((Node)event.getSource()).getScene().getWindow());
    }

    @FXML
    void profileButton(ActionEvent event) throws IOException {
        new ProfileApplication(parent, customerPanelAnchorPane).start((Stage) ((Node) event.getSource()).getScene().getWindow());
    }

    @FXML
    void requestsButton(ActionEvent event) throws IOException {
        new RequestsApplication(parent, customerPanelAnchorPane).start((Stage) ((Node)event.getSource()).getScene().getWindow());
    }

    @FXML
    void usersButton(ActionEvent event) throws IOException {
        new UsersApplication(parent, customerPanelAnchorPane).start((Stage) ((Node)event.getSource()).getScene().getWindow());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        adminController=AdminController.getInstance();
    }
}
