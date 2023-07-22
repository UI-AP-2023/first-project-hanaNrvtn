package com.example.firstproj02.view;

import com.example.firstproj02.model.accounts.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class CustomerPanelController implements Initializable {

    Parent parent;
    Customer customer;

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

    @FXML
    private Button backButton;

    @FXML
    private Button logOutButton;


    @FXML
    void invoicesButton(ActionEvent event) throws IOException {
        new InvoicesApplication(customer, parent, customerPanelAnchorPane).start((Stage) ((Node) event.getSource()).getScene().getWindow());
    }

    @FXML
    void cartButton(ActionEvent event) throws IOException {
        new CartApplication(customer, parent, customerPanelAnchorPane).start((Stage) ((Node) event.getSource()).getScene().getWindow());
    }

    @FXML
    void couponsButton(ActionEvent event) throws IOException {
        new CouponsApplication(customer, parent, customerPanelAnchorPane).start((Stage) ((Node) event.getSource()).getScene().getWindow());  //
    }

    @FXML
    void paymentButton(ActionEvent event) throws IOException {
        new PaymentApplication(customer, parent, customerPanelAnchorPane).start((Stage) ((Node) event.getSource()).getScene().getWindow());
    }

    @FXML
    void editInfoButton(ActionEvent event) throws IOException {
        new EditInfoApplication(customer, parent, customerPanelAnchorPane).start((Stage) ((Node) event.getSource()).getScene().getWindow());
    }

    @FXML
    void profileButton(ActionEvent event) throws IOException {
        new ProfileApplication(customer, parent, customerPanelAnchorPane).start((Stage) ((Node) event.getSource()).getScene().getWindow());
    }

    @FXML
    void backButton(ActionEvent event) throws IOException {
        HomeApplication homeApplication = new HomeApplication();
        homeApplication.start((Stage) ((Node) event.getSource()).getScene().getWindow());
        HomeController homeController = homeApplication.fxmlLoader.getController();
        homeController.customer = customer;
    }

    @FXML
    void logOutButton(ActionEvent event) throws IOException {
        new HomeApplication().start((Stage) ((Node) event.getSource()).getScene().getWindow());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
