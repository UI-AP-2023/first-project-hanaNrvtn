package com.example.firstproj02;

import com.example.firstproj02.controller.CustomerController;
import com.example.firstproj02.model.accounts.Customer;
import com.example.firstproj02.model.exceptions.*;
import com.example.firstproj02.model.processes.DiscountCode;
import com.example.firstproj02.model.processes.Invoice;
import com.example.firstproj02.model.products.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class FinalizeCartController implements Initializable {

    @FXML
    private ChoiceBox<DiscountCode> discountChoiceBox;
    @FXML
    private Label invoiceLabel;
    @FXML
    private Button applyDiscountCode;
    @FXML
    private ComboBox<DiscountCode> discountCodeComoBox;
    @FXML
    private Button confirmButton;
    Customer customer;
    CustomerController customerController;
    Invoice invoice;

    void show(){
        invoiceLabel.setText(invoice.toString1());
        discountCodeComoBox.getItems().addAll(customer.getDiscountCodes());
    }
    @FXML
    void applyDiscountCode(ActionEvent event) {   //
        try {
            customerController.applyDiscountCode(customer, invoice, discountCodeComoBox.getSelectionModel().getSelectedItem());
        } catch (NotFoundDiscountCodeException | ExpiredDiscountCodeException | UnavailableDiscountCodeException e) {
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning!");
            alert.setContentText("Please try another coupon.");
            if(e instanceof NotFoundDiscountCodeException)
                alert.setHeaderText("Coupon Code Not Found");
            else if(e instanceof ExpiredDiscountCodeException)
                alert.setHeaderText("Expired Coupon Coupon");
            else alert.setHeaderText("Expired Coupon Code");
            alert.showAndWait();
        }
    }
    @FXML
    void confirmButton(ActionEvent event) {
        try {
            customerController.verifyShopping(customer, invoice);
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information!");
            alert.setHeaderText("Thanks For Your Shop!");
            alert.setContentText("Shopping processes finished successfully.\nYour remain credit: " + customer.getCredit());
        } catch (NoEnoughCreditException e) {
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning!");
            alert.setHeaderText("No Enough credit");
            alert.setContentText("Please upgrade your credit first.");
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        customerController=CustomerController.getInstance();
    }
}
