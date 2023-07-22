package com.example.firstproj02.view;

import com.example.firstproj02.model.accounts.Customer;
import com.example.firstproj02.model.products.Product;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ProductPageApplication extends Application {
    Parent parent;
    Pane pane;
    ArrayList<Product> tempCart;
    Customer customer;
    Product product;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/firstproj02/fxmls/product-page-view.fxml"));
        parent=fxmlLoader.load();
        pane.getChildren().clear();
        pane.getChildren().add(parent);
        ProductPageController productPageController=fxmlLoader.getController();
        productPageController.product=product;
        productPageController.tempCart=tempCart;
        productPageController.customer=customer;
        productPageController.show();
        primaryStage.setTitle("Product Panel");
    }

    ProductPageApplication(Product product, Customer customer, Parent parent, Pane pane){
        this.product=product;
        this.customer=customer;
        this.parent=parent;
        this.pane=pane;
    }

    ProductPageApplication(Product product, ArrayList<Product> tempCart, Parent parent, Pane pane){
        this.product=product;
        this.tempCart=tempCart;
        this.parent=parent;
        this.pane=pane;
    }
}
