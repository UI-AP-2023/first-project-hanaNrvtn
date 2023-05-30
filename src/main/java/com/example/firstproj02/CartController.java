package com.example.firstproj02;

import com.example.firstproj02.controller.CustomerController;
import com.example.firstproj02.model.accounts.Customer;
import com.example.firstproj02.model.exceptions.NoEnoughSupplyException;
import com.example.firstproj02.model.processes.Invoice;
import com.example.firstproj02.model.products.Product;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CartController implements Initializable {
    @FXML
    private ListView<Product> cartListView;
    @FXML
    private Label cartProductsLabel;
    @FXML
    private Button finalizeCartButton;

    @FXML
    private Button removeProductButton;
    ArrayList<Product> tempCart;
    Product currentProduct;
    CustomerController customerController;
    Parent parent;
    Pane pane;
    Customer customer;

    void show(){
        if(customer!=null) cartListView.getItems().addAll(customer.getCart());
        else cartListView.getItems().addAll(tempCart);
        cartListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Product>() {
            @Override
            public void changed(ObservableValue<? extends Product> observableValue, Product product, Product t1) {
                currentProduct=cartListView.getSelectionModel().getSelectedItem();
                cartProductsLabel.setText(currentProduct.toString());
            }
        });

    }

    @FXML
    void finalizeCartButton(ActionEvent event) throws IOException {
        try {
            Invoice invoice=customerController.invoiceShoppingCart0(customer);
            new FinalizeCartApplication(customer, parent, pane).start((Stage) ((Node)event.getSource()).getScene().getWindow());
        } catch (NoEnoughSupplyException e) {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setHeaderText("No enough supply of this product");
            alert.setContentText("Only " + currentProduct.getNumberOfProduct() + " number of this product remains.");
            alert.showAndWait();
        } catch (NullPointerException e){
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning!");
            alert.setHeaderText("Anonmous user"); //
            alert.setContentText("Need to be logged in to leave comment.");
            alert.showAndWait();
        }
    }

    @FXML
    void removeProductButton(ActionEvent event) {
        customerController.removeProductFromShoppingCart(customer.getCart(), currentProduct);
        cartListView.getItems().remove(currentProduct);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        customerController=CustomerController.getInstance();
    }
}
