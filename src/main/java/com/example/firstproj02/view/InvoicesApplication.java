package com.example.firstproj02.view;

import com.example.firstproj02.model.accounts.Customer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class InvoicesApplication extends Application {

    Customer customer;
    Parent parent;
    Pane pane;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/firstproj02/fxmls/invoices-view.fxml"));
        parent=fxmlLoader.load();
        pane.getChildren().clear();
        pane.getChildren().add(parent);
        InvoicesController invoicesController=fxmlLoader.getController();
        invoicesController.setCustomer(customer);
        invoicesController.show();
        primaryStage.setTitle("Invoices");
    }

    InvoicesApplication(Customer customer, Parent parent, Pane pane){
        this.customer=customer;
        this.parent=parent;
        this.pane=pane;
    }
}
