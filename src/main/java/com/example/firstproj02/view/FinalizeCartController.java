package com.example.firstproj02.view;

import com.example.firstproj02.controller.CustomerController;
import com.example.firstproj02.model.accounts.Customer;
import com.example.firstproj02.model.exceptions.*;
import com.example.firstproj02.model.processes.DiscountCode;
import com.example.firstproj02.model.processes.Invoice;
import com.example.firstproj02.model.products.Product;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class FinalizeCartController implements Initializable {

    @FXML
    private Label invoiceLabel;
    @FXML
    private Button applyDiscountCode;
    @FXML
    private TextField discountCodeTextField;
    @FXML
    private Button confirmButton;
    @FXML
    private ListView<DiscountCode> couponsListView;
    Customer customer;
    CustomerController customerController;
    Invoice invoice;
    DiscountCode currentDiscountCode;

    void show(){
        invoiceLabel.setText(invoice.toString1());
        couponsListView.getItems().addAll(customer.getDiscountCodes());
        couponsListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<DiscountCode>() {
            @Override
            public void changed(ObservableValue<? extends DiscountCode> observableValue, DiscountCode discountCode, DiscountCode t1) {
                currentDiscountCode=couponsListView.getSelectionModel().getSelectedItem();
            }
        });
    }
    @FXML
    void applyDiscountCode(ActionEvent event) {   //
        try {
            System.out.println(invoice.toString1());
            customerController.applyDiscountCode(customer, invoice, currentDiscountCode);
            System.out.println(invoice.toString1());
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.getDialogPane().getStylesheets().add(Objects.requireNonNull(getClass().getResource("/com/example/firstproj02/styles/dialog-pane-style.css")).toExternalForm());
            ((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/example/firstproj02/images/app-icons/app-light.PNG"))));alert.setTitle("Information!");
            alert.setHeaderText("Apply Discount Code!");
            alert.setContentText("Applied successfully.");
            alert.showAndWait();
        } catch (NotFoundDiscountCodeException | ExpiredDiscountCodeException | UnavailableDiscountCodeException | NullPointerException e) {
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.getDialogPane().getStylesheets().add(Objects.requireNonNull(getClass().getResource("/com/example/firstproj02/styles/dialog-pane-style.css")).toExternalForm());
            ((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/example/firstproj02/images/app-icons/app-light.PNG"))));alert.setTitle("Warning!");
            alert.setContentText("Please try another coupon.");
            if(e instanceof NotFoundDiscountCodeException || e instanceof  NullPointerException)
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
            System.out.println(customer.getCredit());
            customerController.verifyShopping(customer, invoice);
            System.out.println(customer.getCredit());
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.getDialogPane().getStylesheets().add(Objects.requireNonNull(getClass().getResource("/com/example/firstproj02/styles/dialog-pane-style.css")).toExternalForm());
            ((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/example/firstproj02/images/app-icons/app-light.PNG"))));alert.setTitle("Information!");
            alert.setHeaderText("Thanks For Your Shop!");
            alert.setContentText("Shopping processes finished successfully.\nYour remain credit: " + customer.getCredit());
            alert.showAndWait();
        } catch (NoEnoughCreditException e) {
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.getDialogPane().getStylesheets().add(Objects.requireNonNull(getClass().getResource("/com/example/firstproj02/styles/dialog-pane-style.css")).toExternalForm());
            ((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/example/firstproj02/images/app-icons/app-light.PNG"))));alert.setTitle("Warning!");
            alert.setHeaderText("No Enough credit");
            alert.setContentText("Please upgrade your credit first.");
            alert.showAndWait();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        customerController=CustomerController.getInstance();
    }
}
