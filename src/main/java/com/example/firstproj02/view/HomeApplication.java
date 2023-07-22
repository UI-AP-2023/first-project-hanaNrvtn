package com.example.firstproj02.view;

import com.example.firstproj02.model.accounts.Customer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HomeApplication extends Application {
    FXMLLoader fxmlLoader;
    Customer customer;
    Parent parent;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        fxmlLoader = new FXMLLoader(HomeApplication.class.getResource("/com/example/firstproj02/fxmls/home-view.fxml"));
        Scene scene = new Scene(parent=fxmlLoader.load());
        HomeController homeController=fxmlLoader.getController();
        homeController.customer=customer;
        homeController.parent=parent;
        stage.setTitle("Home");
        stage.setScene(scene);
        stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/example/firstproj02/images/app-icons/app-light.PNG"))));
        stage.show();
    }
}
