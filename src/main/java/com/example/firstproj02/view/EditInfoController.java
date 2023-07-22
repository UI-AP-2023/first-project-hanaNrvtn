package com.example.firstproj02.view;

import com.example.firstproj02.controller.CustomerController;
import com.example.firstproj02.model.accounts.Customer;
import com.example.firstproj02.model.exceptions.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class EditInfoController implements Initializable {  // set current info as promot text
    Customer customer;
    CustomerController customerController;

    @FXML
    private TextField firstNameTextField;

    @FXML
    private Label firstNameStatusLabel;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private Label lastNameStatusLabel;

    @FXML
    private TextField emailTextField;

    @FXML
    private Label emailStatusLabel;

    @FXML
    private TextField phoneNumberTextField;

    @FXML
    private Label phoneNumberStatusLabel;

    @FXML
    private TextField userNameTextField;

    @FXML
    private Label userNameStatusLabel;

    @FXML
    private TextField passwordTextField;

    @FXML
    private Label passwordStatusLabel;

    @FXML
    private Button submitButton;

    boolean  emailIsValid, phoneNumberIsValid, passwordIsValid;

    @FXML
    void firstNameTextField(KeyEvent event) {   // remove key events
    }

    @FXML
    void lastNameTextField(KeyEvent event) {
    }

    @FXML
    void emailTextField(KeyEvent event) {
    }

    @FXML
    void phoneNumberTextField(KeyEvent event) {

    }

    @FXML
    void userNameTextField(KeyEvent event) {
    }

    @FXML
    void passwordTextField(KeyEvent event){
   }

    @FXML
    void submitButton(ActionEvent event) {
        if((emailIsValid || emailTextField.getText().equals("")) && (phoneNumberIsValid || phoneNumberTextField.getText().equals("")) && (passwordIsValid || passwordTextField.getText().equals(""))){
            System.out.println("ready to edit");
            if(!firstNameTextField.getText().equals("")) customerController.editFirstName(customer, firstNameTextField.getText());
            if(!firstNameTextField.getText().equals("")) customerController.editLastName(customer, lastNameTextField.getText());
            if(!emailTextField.getText().equals("")) customerController.editEmail(customer, emailTextField.getText());
            if(!phoneNumberTextField.getText().equals("")) customerController.editPhoneNumber(customer, phoneNumberTextField.getText());
            if(!passwordTextField.getText().equals("")) customerController.editPassword(customer, passwordTextField.getText());
        }else{
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.getDialogPane().getStylesheets().add(Objects.requireNonNull(getClass().getResource("/com/example/firstproj02/styles/dialog-pane-style.css")).toExternalForm());
            ((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/example/firstproj02/images/app-icons/app-light.PNG"))));alert.setTitle("Warning!");
            alert.setHeaderText("Invalid Information");
            alert.setContentText("Try again! \nEnter valid information");
            alert.showAndWait();
        }
    }

    private void setPromptTests(){     // maybe setText()
        firstNameTextField.setPromptText(customer.getFirstName());
        lastNameTextField.setPromptText(customer.getLastName());
        emailTextField.setPromptText(customer.getEmail());
        phoneNumberTextField.setPromptText(customer.getPhoneNumber());
        userNameTextField.setPromptText(customer.getUserName());
        passwordTextField.setPromptText(customer.getPassword());
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        customerController=CustomerController.getInstance();
        //setPromptTests();

        emailTextField.textProperty().addListener((p, o, n)-> {   // send them to methods
            try {
                customerController.checkEmailRegex(emailTextField.getText());
                customerController.checkEmailAvailability(emailTextField.getText());
                emailIsValid=true;
                emailStatusLabel.setText("valid email");
            } catch (InvalidEmailException e) {
                emailIsValid=false;
                emailStatusLabel.setText("invalid email");
            } catch (UnavailableEmailException e) {
                emailIsValid=false;
                emailStatusLabel.setText("unavailable email");
            }
        });


        phoneNumberTextField.textProperty().addListener((p, o, n)-> {
            try {
                customerController.checkPhoneNumberRegex(phoneNumberTextField.getText());
                customerController.checkPhoneNumberAvailability(phoneNumberTextField.getText());
                phoneNumberIsValid=true;
                phoneNumberStatusLabel.setText("valid phone number");
            } catch (InvalidPhoneNumberException e) {
                phoneNumberIsValid=false;
                phoneNumberStatusLabel.setText("invalid phone number");
            } catch (UnavailablePhoneNumberException e) {
                phoneNumberIsValid=false;
                phoneNumberStatusLabel.setText("unavailable phone number");
            }
        });

        passwordTextField.textProperty().addListener((p, o, n)-> {
            try {
                customerController.checkPasswordRegex(passwordTextField.getText());
                passwordStatusLabel.setText("strong password");
                passwordIsValid=true;
            } catch (InvalidPasswordException e) {
                passwordIsValid=false;
                passwordStatusLabel.setText("not strong password");
            }
        });
    }
}
