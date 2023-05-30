package com.example.firstproj02;

import javafx.application.Application;
import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeApplication extends Application {
    FXMLLoader fxmlLoader;
    Parent parent;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        fxmlLoader = new FXMLLoader(HomeApplication.class.getResource("home-view.fxml"));
        Scene scene = new Scene(parent=fxmlLoader.load());
        HomeController homeController=fxmlLoader.getController();
        homeController.parent=parent;
        stage.setTitle("Home");
        stage.setScene(scene);
        stage.show();
    }
}
