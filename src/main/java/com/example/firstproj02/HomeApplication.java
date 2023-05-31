package com.example.firstproj02;

import com.example.firstproj02.model.accounts.Customer;
import javafx.application.Application;
import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeApplication extends Application {
    FXMLLoader fxmlLoader;
    Customer customer;
    Parent parent;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        fxmlLoader = new FXMLLoader(HomeApplication.class.getResource("home-view.fxml"));
        //parent=fxmlLoader.load();
        Scene scene = new Scene(parent=fxmlLoader.load());
        HomeController homeController=fxmlLoader.getController();
        homeController.customer=customer;
        homeController.parent=parent;
        stage.setTitle("Home");
        stage.setScene(scene);
        stage.show();
    }
}
