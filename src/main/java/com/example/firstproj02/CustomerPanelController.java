package com.example.firstproj02;

import com.example.firstproj02.model.accounts.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;


public class CustomerPanelController implements Initializable {
    @FXML
    private AnchorPane baseAnchorPane;

    @FXML
    private Button editInfoButton;

    @FXML
    private Button showInvoicesButton;

    @FXML
    private Button cartButton;

    @FXML
    private Button paymentButton;

    @FXML
    private Button invoicesButton;

    @FXML
    private Button couponsButton;

    private Parent fxml;
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @FXML
    void invoicesButton(ActionEvent event) throws IOException {
        fxml= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("invoices-view.fxml")));
        baseAnchorPane.getChildren().clear();
        baseAnchorPane.getChildren().add(fxml);
    }

    @FXML
    void cartButton(ActionEvent event) {

    }

    @FXML
    void couponsButton(ActionEvent event) throws IOException {
        fxml= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("coupons-view.fxml")));
        baseAnchorPane.getChildren().clear();
        baseAnchorPane.getChildren().add(fxml);
    }

    @FXML
    void paymentButton(ActionEvent event) throws IOException {
        fxml= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("payment-view.fxml")));
        baseAnchorPane.getChildren().clear();
        baseAnchorPane.getChildren().add(fxml);
    }

    @FXML
    void editInfoButton(ActionEvent event) throws IOException {
        fxml= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("edit-info-view.fxml")));
        baseAnchorPane.getChildren().clear();
        baseAnchorPane.getChildren().add(fxml);
    }

    @FXML
    void profileButton(ActionEvent event) throws IOException {  // customer setter
        fxml= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("profile-view.fxml")));
        baseAnchorPane.getChildren().clear();
        baseAnchorPane.getChildren().add(fxml);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
