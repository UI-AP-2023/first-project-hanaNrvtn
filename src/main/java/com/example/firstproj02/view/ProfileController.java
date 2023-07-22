package com.example.firstproj02.view;

import com.example.firstproj02.model.accounts.Admin;
import com.example.firstproj02.model.accounts.Customer;
import com.example.firstproj02.model.accounts.User;
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
        if(customer!=null){
            if(customer.getFirstName()==null || customer.getLastName()==null) firstNameLabel.setText("Full Name: ");
            else firstNameLabel.setText("Full Name : " + customer.getFirstName() +"  " + customer.getLastName());
            lastNameLabel.setText("Credit : " + customer.getCredit());
        } else {
            firstNameLabel.setText("First Name : " + Admin.getAdmin().getFirstName());
            lastNameLabel.setText("Last Name : " + Admin.getAdmin().getLastName());
        }
        User user;
        if(customer!=null) user=customer;
        else user=Admin.getAdmin();
        emailLabel.setText("Email : " + user.getEmail());
        phoneNumberLabel.setText("Phone Number : " + user.getPhoneNumber());
        userNameLabel.setText("User Name : " + user.getUserName());
        passwordLabel.setText("Password : " + user.getPassword());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
