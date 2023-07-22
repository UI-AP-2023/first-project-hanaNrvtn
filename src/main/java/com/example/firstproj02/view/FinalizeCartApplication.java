package com.example.firstproj02.view;

import com.example.firstproj02.model.accounts.Customer;
import com.example.firstproj02.model.processes.Invoice;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class FinalizeCartApplication extends Application {

    Invoice invoice;
    Customer customer;
    Parent parent;
    Pane pane;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FinalizeCartApplication.class.getResource("/com/example/firstproj02/fxmls/finalize-cart-view.fxml"));
        parent=fxmlLoader.load();
        pane.getChildren().clear();
        pane.getChildren().add(parent);
        FinalizeCartController finalizeCartController=fxmlLoader.getController();
        finalizeCartController.customer=customer;
        finalizeCartController.invoice=invoice;
        finalizeCartController.show();
        primaryStage.setTitle("Finalize Shopping Cart");
    }

    FinalizeCartApplication(Customer customer, Invoice invoice, Parent parent, Pane pane){
        this.customer=customer;
        this.invoice=invoice;
        this.parent=parent;
        this.pane=pane;
    }
}
