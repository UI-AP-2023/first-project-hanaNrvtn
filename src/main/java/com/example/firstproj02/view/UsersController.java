package com.example.firstproj02.view;

import com.example.firstproj02.controller.CustomerController;
import com.example.firstproj02.model.accounts.Admin;
import com.example.firstproj02.model.accounts.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class UsersController implements Initializable {
    CustomerController customerController;

    @FXML
    private TableColumn<User, String> passwordColumn;

    @FXML
    private TableColumn<User, String> creditColumn;  //

    @FXML
    private TableColumn<User, String> emailColumn;

    @FXML
    private TableColumn<User, String> phoneNumberColumn;

    @FXML
    private TableColumn<User, String> userNameColumn;

    @FXML
    private TableView<User> usersTableView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        customerController=CustomerController.getInstance();
        userNameColumn.setCellValueFactory(new PropertyValueFactory<User, String>("userName"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<User, String>("email"));
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<User, String>("phoneNumber"));
        passwordColumn.setCellValueFactory(new PropertyValueFactory<User, String>("password"));

        usersTableView.getItems().add(Admin.getAdmin());
        usersTableView.getItems().addAll(customerController.getCustomers());
    }
}
