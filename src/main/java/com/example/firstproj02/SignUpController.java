package com.example.firstproj02;

import com.example.firstproj02.controller.CustomerController;
import com.example.firstproj02.model.exceptions.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {
    CustomerController customerController;

    @FXML
    private TextField emailTextField;
    @FXML
    private TextField phoneNumberTextField;
    @FXML
    private TextField userNameTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private Label signUpPageLabel;
    @FXML
    private Button submitButton;
    @FXML
    private Button backButton;
    @FXML
    void emailTextField(ActionEvent event) {

    }                                       // throws or try catch
                                            // declare variables to keep email ,...
    @FXML
    void submitButton(ActionEvent event) throws IOException {   // check one by one prefferently by validation
        try {
            customerController.checkEmailRegex(emailTextField.getText());
            customerController.checkEmailAvailability(emailTextField.getText());
            customerController.checkPhoneNumberRegex(phoneNumberTextField.getText());
            customerController.checkPhoneNumberAvailability(phoneNumberTextField.getText());  //
            customerController.checkUserNameAvailability(userNameTextField.getText());
            customerController.checkPasswordRegex(passwordTextField.getText());

            customerController.signup(emailTextField.getText(), phoneNumberTextField.getText(), userNameTextField.getText(), passwordTextField.getText());

            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information!");
            alert.setHeaderText("Sign Up Request");
            alert.setContentText("request sent successfully");
            Optional<ButtonType> result=alert.showAndWait();
            if(result.isPresent() && result.get()==ButtonType.OK)
                new LoginApplication().start((Stage) ((Node)event.getSource()).getScene().getWindow());
        } catch (InvalidEmailException | UnavailableEmailException | InvalidPhoneNumberException | UnavailableUserNameException | InvalidPasswordException e) {
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning!");
            if(e instanceof InvalidInputException){
                alert.setHeaderText("Invalid Input!");
                if(e instanceof InvalidEmailException)
                    alert.setContentText("Invalid email format");
                if(e instanceof InvalidPhoneNumberException)
                    alert.setContentText("Invalid phone number format");
                if(e instanceof InvalidPasswordException)
                    alert.setContentText("Invalid password format");
            } else{
                alert.setHeaderText("Unavailable Input!");
                if(e instanceof UnavailableEmailException)
                    alert.setContentText("This user name has already used.\nTry another one.");
                if(e instanceof UnavailablePhoneNumberException)
                    alert.setContentText("This user name has already used.\nTry another one.");
                if(e instanceof UnavailableUserNameException)
                    alert.setContentText("This user name has already used.\nTry another one.");
            }
            alert.showAndWait();
        }
    }

    @FXML
    void backButton(ActionEvent event) throws IOException {
        new HomeApplication().start((Stage) ((Node)event.getSource()).getScene().getWindow());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        customerController=new CustomerController();
    }
}
