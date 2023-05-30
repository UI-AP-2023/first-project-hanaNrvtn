package com.example.firstproj02;

import com.example.firstproj02.model.accounts.Admin;
import com.example.firstproj02.model.accounts.Customer;
import com.example.firstproj02.model.processes.DiscountCode;
import com.example.firstproj02.model.processes.DiscountType;
import com.example.firstproj02.model.processes.Invoice;
import com.example.firstproj02.model.products.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;


public class CustomerPanelController implements Initializable {
    @FXML
    private AnchorPane customerPanelAnchorPane;

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

    Parent parent;
    Customer customer;

    @FXML
    void invoicesButton(ActionEvent event) throws IOException {
        new InvoicesApplication(customer, parent, customerPanelAnchorPane).start((Stage) ((Node)event.getSource()).getScene().getWindow());
    }

    @FXML
    void cartButton(ActionEvent event) throws IOException {
        customer.getCart().addAll(Admin.getAdmin().getProducts());
        new CartApplication(customer, parent, customerPanelAnchorPane).start((Stage) ((Node)event.getSource()).getScene().getWindow());
    }

    @FXML
    void couponsButton(ActionEvent event) throws IOException {
        new CouponsApplication(customer, parent, customerPanelAnchorPane).start((Stage) ((Node)event.getSource()).getScene().getWindow());  //
    }

    @FXML
    void paymentButton(ActionEvent event) throws IOException {
        new PaymentApplication(customer, parent, customerPanelAnchorPane).start((Stage) ((Node)event.getSource()).getScene().getWindow());
    }

    @FXML
    void editInfoButton(ActionEvent event) throws IOException {
        new EditInfoApplication(customer, parent, customerPanelAnchorPane).start((Stage) ((Node)event.getSource()).getScene().getWindow());
    }

    @FXML
    void profileButton(ActionEvent event) throws IOException {
        new ProfileApplication(customer, parent, customerPanelAnchorPane).start((Stage) ((Node)event.getSource()).getScene().getWindow());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
