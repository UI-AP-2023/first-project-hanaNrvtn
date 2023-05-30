package com.example.firstproj02;

import com.example.firstproj02.model.accounts.Customer;
import com.example.firstproj02.model.products.Product;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class CartApplication extends Application {

    ArrayList<Product> tempCart;
    Parent parent;
    Pane pane;
    Customer customer;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CartApplication.class.getResource("cart-view.fxml"));
        parent=fxmlLoader.load();
        pane.getChildren().clear();
        pane.getChildren().add(parent);
        CartController cartController=fxmlLoader.getController();
        cartController.tempCart=tempCart;
        cartController.customer=customer;
        cartController.parent=parent;
        cartController.pane=pane;
        cartController.show();
        primaryStage.setTitle("Shopping Cart");
    }

    CartApplication(Customer customer, Parent parent, Pane pane){
        this.customer=customer;
        this.parent=parent;
        this.pane=pane;
    }

    CartApplication(ArrayList<Product> tempCart, Parent parent, Pane pane) throws IOException {
        this.tempCart=tempCart;
        this.parent=parent;
        this.pane=pane;
    }
}
