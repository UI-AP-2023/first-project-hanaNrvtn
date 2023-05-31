package com.example.firstproj02;

import com.example.firstproj02.controller.CustomerController;
import com.example.firstproj02.model.accounts.Admin;
import com.example.firstproj02.model.accounts.Customer;
import com.example.firstproj02.model.exceptions.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;

import java.lang.annotation.AnnotationTypeMismatchException;
import java.net.URL;
import java.util.ResourceBundle;

public class PaymentController implements Initializable {             // check all graphical elements in a scene to have ID and be in controller
    @FXML
    private Label paymentPageLabel;

    @FXML
    private TextField additionalTextField;

    @FXML
    private Label additionalCreditStatusLabel;

    @FXML
    private TextField cardNumberTextField;

    @FXML
    private Label cardNumberStatusLabel;

    @FXML
    private TextField CVV2TxtField;

    @FXML
    private Label CVV2StatusLabel;

    @FXML
    private TextField cardPasswordTextField;

    @FXML
    private Label passwordStatusLabel;

    @FXML
    private Button finishButton;

    private Customer customer;
    private CustomerController customerController;
    boolean  cardNumberIsValid, CVV2IsValid, passwordIsValid;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @FXML
    void finishButton(ActionEvent event) {
        if((!additionalTextField.getText().equals("")) && (!cardNumberTextField.getText().equals("")) && (!CVV2TxtField.getText().equals("")) && (!cardPasswordTextField.getText().equals(""))){
            customerController.creatIncreaseCreditRequest(customer, Double.parseDouble(additionalTextField.getText()), cardNumberTextField.getText(), CVV2TxtField.getText(), cardPasswordTextField.getText());
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information!");
            alert.setHeaderText("Credit Increase Request");
            alert.setContentText("Your Credit increase request sent successfully.");
            alert.showAndWait();
        }else {
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning!");
            alert.setHeaderText("Blank Field");
            alert.setContentText("Please fill all fields first.");
            alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        customerController=CustomerController.getInstance();

        cardNumberTextField.textProperty().addListener((p, o, n)-> {   // send them to methods
            try {
                customerController.checkCreditCardRegex(cardNumberTextField.getText());
                cardNumberIsValid=true;
                cardNumberStatusLabel.setText("valid credit card number");
            } catch (InvalidCreditCardNumberException e) {
                cardNumberIsValid=false;
                cardNumberStatusLabel.setText("invalid credit card number");
            }
        });

        CVV2TxtField.textProperty().addListener((p, o, n)-> {   // send them to methods
            try {
                customerController.checkCVV2Regex(CVV2TxtField.getText());
                CVV2IsValid=true;
                CVV2StatusLabel.setText("valid CVV2");
            } catch (InvalidCVV2Exception e) {
                CVV2IsValid=false;
                CVV2StatusLabel.setText("invalid CVV2");
            }
        });

        cardPasswordTextField.textProperty().addListener((p, o, n)-> {   // send them to methods
            try {
                customerController.checkCardPasswordRegex(cardPasswordTextField.getText());
                passwordIsValid=true;
                passwordStatusLabel.setText("valid password");
            } catch (InvalidCardPasswordException e) {
                passwordIsValid=false;
                passwordStatusLabel.setText("invalid password");
            }
        });
    }
}
