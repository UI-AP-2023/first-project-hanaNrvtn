package com.example.firstproj02.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class ProductTasksApplication extends Application {

    Parent parent;
    Pane pane;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/firstproj02/fxmls/product-tasks-view.fxml"));
        parent=fxmlLoader.load();
        pane.getChildren().clear();
        pane.getChildren().add(parent);
        ProductTasksController productTasksController=fxmlLoader.getController();
        productTasksController.parent=parent;
        productTasksController.pane=pane;
        primaryStage.setTitle("Admin Panel");
    }

    ProductTasksApplication(Parent parent, Pane pane){
        this.parent=parent;
        this.pane=pane;
    }
}
