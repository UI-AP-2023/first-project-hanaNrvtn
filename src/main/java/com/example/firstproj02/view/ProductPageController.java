package com.example.firstproj02.view;

import com.example.firstproj02.controller.ProductController;
import com.example.firstproj02.model.accounts.Customer;
import com.example.firstproj02.model.exceptions.NoEnoughSupplyException;
import com.example.firstproj02.model.products.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class ProductPageController implements Initializable {
    ProductController productController;
    ArrayList<Product> tempCart;
    Customer customer;
    Product product;

    @FXML
    private Button addToCartButton;

    @FXML
    private TextField commentTextField;

    @FXML
    private Button leaveCommentButton;

    @FXML
    private TextField numberTextField;

    @FXML
    private Label productInfoLabel;

    @FXML
    private Button homeButton;

    @FXML
    void addToCartButton(ActionEvent event) {
        try {
            if(customer!=null) productController.addToShoppingCart(customer.getCart(), product, Integer.parseInt(numberTextField.getText()));  // input mismatch
            else productController.addToShoppingCart(tempCart, product, Integer.parseInt(numberTextField.getText()));
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.getDialogPane().getStylesheets().add(Objects.requireNonNull(getClass().getResource("/com/example/firstproj02/styles/dialog-pane-style.css")).toExternalForm());
            ((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/example/firstproj02/images/app-icons/app-light.PNG"))));
            alert.setTitle("Confirmation!");
            alert.setHeaderText("Thanks!");
            alert.setContentText("Product added successfully.");
            alert.showAndWait();
        } catch (NoEnoughSupplyException e) {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.getDialogPane().getStylesheets().add(Objects.requireNonNull(getClass().getResource("/com/example/firstproj02/styles/dialog-pane-style.css")).toExternalForm());
            ((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/example/firstproj02/images/app-icons/app-light.PNG"))));
            alert.setTitle("Error!");
            alert.setHeaderText("No enough supply of this product");
            alert.setContentText("Only " + product.getNumberOfProduct() + " number of this product remains.");
            alert.showAndWait();
        } catch (NumberFormatException e){
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.getDialogPane().getStylesheets().add(Objects.requireNonNull(getClass().getResource("/com/example/firstproj02/styles/dialog-pane-style.css")).toExternalForm());
            ((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/example/firstproj02/images/app-icons/app-light.PNG"))));
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
            alert.getDialogPane().getStylesheets().add(Objects.requireNonNull(getClass().getResource("/com/example/firstproj02/styles/dialog-pane-style.css")).toExternalForm());
            ((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/example/firstproj02/images/app-icons/app-light.PNG"))));
            alert.setTitle("Warning!");
            alert.setHeaderText("Anonymous user");
            alert.setContentText("Need to be logged in to leave comment.");
            alert.showAndWait();
        } else {
            try {
                if(commentTextField.getText().equals("")){
                    Alert alert=new Alert(Alert.AlertType.WARNING);
                    alert.getDialogPane().getStylesheets().add(Objects.requireNonNull(getClass().getResource("/com/example/firstproj02/styles/dialog-pane-style.css")).toExternalForm());
                    ((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/example/firstproj02/images/app-icons/app-light.PNG"))));
                    alert.setTitle("Warning!");
                    alert.setHeaderText("No Comment Yet");
                    alert.setContentText("Please fill comment field first.");
                    alert.showAndWait();
                }
                productController.commentToProduct(customer, product, commentTextField.getText());
                Alert alert=new Alert(Alert.AlertType.INFORMATION);
                alert.getDialogPane().getStylesheets().add(Objects.requireNonNull(getClass().getResource("/com/example/firstproj02/styles/dialog-pane-style.css")).toExternalForm());
                ((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/example/firstproj02/images/app-icons/app-light.PNG"))));
                alert.setTitle("Information!");
                alert.setHeaderText("Thanks!");
                alert.setContentText("Comment request sent successfully.");
                alert.showAndWait();
            }catch(NullPointerException e){  // current product is null
                Alert alert=new Alert(Alert.AlertType.WARNING);
                alert.getDialogPane().getStylesheets().add(Objects.requireNonNull(getClass().getResource("/com/example/firstproj02/styles/dialog-pane-style.css")).toExternalForm());
                ((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/example/firstproj02/images/app-icons/app-light.PNG"))));
                alert.setTitle("Warning!");
                alert.setHeaderText("No Product Selected");
                alert.setContentText("Please select a product firs.");
                alert.showAndWait();
            }
        }
    }

    @FXML
    void homeButton(ActionEvent event) throws IOException {
        new HomeApplication().start((Stage) ((Node)event.getSource()).getScene().getWindow());
    }

    void show(){
        productInfoLabel.setText(product.toString1());
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
      productController=ProductController.getInstance();
    }
}
