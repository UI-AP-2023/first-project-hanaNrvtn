package com.example.firstproj02;

import com.example.firstproj02.controller.ProductController;
import com.example.firstproj02.model.accounts.Customer;
import com.example.firstproj02.model.exceptions.NoEnoughSupplyException;
import com.example.firstproj02.model.products.Product;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ProductPanelController implements Initializable {
    @FXML
    private ListView<Product> productListView;
    @FXML
    private Label productInfoLabel;
    @FXML
    private Button addToCartButton;
    @FXML
    private Button leaveCommentButton;
    @FXML
    private TextField numberTextField;
    @FXML
    private TextField commentTextField;
    ArrayList<Product> products;
    ArrayList<Product> tempCart;
    private Product currentProduct;
    ProductController productController;
    Customer customer;

    void show(){
        productListView.getItems().addAll(products);
        productListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Product>() {
            @Override
            public void changed(ObservableValue<? extends Product> observableValue, Product product, Product t1) {
                currentProduct=productListView.getSelectionModel().getSelectedItem();
                productInfoLabel.setText(currentProduct.getID());
            }
        });
    }

    @FXML
    void addToCartButton(ActionEvent event) {
        try {
            if(customer!=null) productController.addToShoppingCart(customer.getCart(), currentProduct, Integer.parseInt(numberTextField.getText()));  // input mismatch
            else productController.addToShoppingCart(tempCart, currentProduct, Integer.parseInt(numberTextField.getText()));
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Confirmation!");
            alert.setHeaderText("Thanks!");
            alert.setContentText("Product added successfully.");
            alert.showAndWait();
        } catch (NoEnoughSupplyException e) {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setHeaderText("No enough supply of this product");
            alert.setContentText("Only " + currentProduct.getNumberOfProduct() + " number of this product remains.");
            alert.showAndWait();
        } catch (NumberFormatException e){
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning!");
            alert.setHeaderText("Invalid input format");
            alert.setContentText("Only numeric input is valid.");
            alert.showAndWait();
        }
    }

    @FXML
    void leaveCommentButton(ActionEvent event) {
        if(customer==null) {
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning!");
            alert.setHeaderText("Anonymous user");
            alert.setContentText("Need to be logged in to leave comment.");
            alert.showAndWait();
        } else {
            try {
                if(commentTextField.getText().equals("")){
                    Alert alert=new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning!");
                    alert.setHeaderText("No Comment Yet");
                    alert.setContentText("Please fill comment field first.");
                    alert.showAndWait();
                }
                productController.commentToProduct(customer, currentProduct, commentTextField.getText());
                Alert alert=new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information!");
                alert.setHeaderText("Thanks!");
                alert.setContentText("Comment request sent successfully.");
                alert.showAndWait();
            }catch(NullPointerException e){  // current product is null
                Alert alert=new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning!");
                alert.setHeaderText("No Product Selected");
                alert.setContentText("Please select a product firs.");
                alert.showAndWait();
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        productController=ProductController.getInstance();
    }
}
