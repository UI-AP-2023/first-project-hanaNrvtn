package com.example.firstproj02;

import com.example.firstproj02.model.accounts.Customer;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class PaymentApplication extends Application {

    Parent parent;
    Pane pane;
    Customer customer;
    //FXMLLoader fxmlLoader;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("payment-view.fxml"));
        parent=fxmlLoader.load();
        pane.getChildren().clear();
        pane.getChildren().add(parent);
        PaymentController paymentController=fxmlLoader.getController();
        paymentController.setCustomer(customer);
        //paymentController.show();
        primaryStage.setTitle("Payment");
        /*
        FXMLLoader fxmlLoader = new FXMLLoader(HomeApplication.class.getResource("payment-view.fxml"));
        fxml=fxmlLoader.load();
        PaymentController paymentController=fxmlLoader.getController();
        paymentController.setCustomer(customer);
        //PaymentController paymentController=fxmlLoader.getController();
        //paymentController.setCustomer(customer);
        baseAnchorPane.getChildren().clear();
        baseAnchorPane.getChildren().add(fxml);
        Scene scene = new Scene(fxml);
        primaryStage.setTitle("Home");
        primaryStage.setScene(scene);
        primaryStage.show();
         */
    }

    PaymentApplication(Customer customer, Parent parent, Pane pane){
        this.customer=customer;
        this.parent=parent;
        this.pane=pane;
    }
}
