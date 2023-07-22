package com.example.firstproj02.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class DiscountApplication extends Application {

    Parent parent;
    Pane pane;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/firstproj02/fxmls/discount-view.fxml"));
        parent=fxmlLoader.load();
        pane.getChildren().clear();
        pane.getChildren().add(parent);
        DiscountController discountController=fxmlLoader.getController();
        discountController.parent=parent;
        discountController.pane=pane;
        primaryStage.setTitle("Admin Panel");
    }

    DiscountApplication(Parent parent, Pane pane){
        this.parent=parent;
        this.pane=pane;
    }
}
