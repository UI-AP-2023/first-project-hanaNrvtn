package com.example.firstproj02;

import com.example.firstproj02.model.accounts.Customer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ProfileController implements Initializable {
    @FXML
    private Label titleLabel;

    @FXML
    private Label firstNameLabel;

    @FXML
    private Label lastNameLabel;

    @FXML
    private Label emailLabel;

    @FXML
    private Label phoneNumberLabel;

    @FXML
    private Label userNameLabel;

    @FXML
    private Label passwordLabel;

    Customer customer;

    void show(){
        if(customer.getFirstName()==null || customer.getLastName()==null) firstNameLabel.setText("Full Name: ");
        else firstNameLabel.setText("Full Name : " + customer.getFirstName() + customer.getLastName());
        lastNameLabel.setText("Credit : " + customer.getCredit());
        emailLabel.setText("Email : " + customer.getEmail());
        phoneNumberLabel.setText("Phone Number : " + customer.getPhoneNumber());
        userNameLabel.setText("User Name : " + customer.getUserName());
        passwordLabel.setText("Password : " + customer.getPassword());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //showInfo();
    }
}
