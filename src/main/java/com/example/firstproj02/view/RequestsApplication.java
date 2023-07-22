package com.example.firstproj02.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class RequestsApplication extends Application {

    Parent parent;
    Pane pane;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/firstproj02/fxmls/requests-view.fxml"));
        parent=fxmlLoader.load();
        pane.getChildren().clear();
        pane.getChildren().add(parent);
        primaryStage.setTitle("Admin Panel");
    }

    RequestsApplication(Parent parent, Pane pane){
        this.parent=parent;
        this.pane=pane;
    }
}
