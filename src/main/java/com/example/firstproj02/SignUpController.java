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
    void emailTextField(ActionEvent event) {

    }                                       // throws or try catch
                                            // declare variables to keep email ,...
    @FXML
    void submitButton(ActionEvent event) throws IOException {   // check one by one prefferently by validation
        try {
            customerController.checkEmailRegex(emailTextField.getText());
            customerController.checkEmailAvailability(emailTextField.getText());
            customerController.checkPhoneNumberRegex(phoneNumberTextField.getText());
            customerController.checkPhoneNumberAvailability(phoneNumberTextField.getText());
            customerController.checkUserNameAvailability(userNameTextField.getText());
            customerController.checkPasswordRegex(passwordTextField.getText());

            customerController.signup(emailTextField.getText(), phoneNumberTextField.getText(), userNameTextField.getText(), passwordTextField.getText());

            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Confirmation!");
            alert.setHeaderText("1");
            alert.setContentText("request sent successfully");
            Optional<ButtonType> result=alert.showAndWait();
            if(result.isPresent() && result.get()==ButtonType.OK)
                new LoginApplication().start((Stage) ((Node)event.getSource()).getScene().getWindow());
        } catch (InvalidInputException | UnavailableInputException e) {
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning!");
            alert.setHeaderText("1");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        customerController=new CustomerController();
    }
}
