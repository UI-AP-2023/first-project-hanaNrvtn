package com.example.firstproj02;

import com.example.firstproj02.model.accounts.Customer;
import com.example.firstproj02.model.products.Product;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ProductPanelApplication extends Application {

    Parent parent;
    Pane pane;
    ArrayList<Product> products;
    ArrayList<Product> tempCart;
    Customer customer;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("product-panel-view.fxml"));
        parent=fxmlLoader.load();
        pane.getChildren().clear();
        pane.getChildren().add(parent);
        ProductPanelController productPanelController=fxmlLoader.getController();
        productPanelController.products=products;
        productPanelController.tempCart=tempCart;
        productPanelController.customer=customer;
        productPanelController.show();
        primaryStage.setTitle("Product Panel");
        /*
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("product-panel-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        ProductPanelController productPanelController=fxmlLoader.getController();
        productPanelController.products=products;
        productPanelController.tempCart=tempCart;
        productPanelController.customer=customer;

        productPanelController.show();

        primaryStage.setTitle("Product Panel");
        primaryStage.setScene(scene);
        primaryStage.show();
         */
    }

    ProductPanelApplication(ArrayList<Product> products, Customer customer, Parent parent, Pane pane){
        this.products=products;
        this.customer=customer;
        this.parent=parent;
        this.pane=pane;
    }

    ProductPanelApplication(ArrayList<Product> products, ArrayList<Product> tempCart, Parent parent, Pane pane){
        this.products=products;
        this.tempCart=tempCart;
        this.parent=parent;
        this.pane=pane;
    }
}
