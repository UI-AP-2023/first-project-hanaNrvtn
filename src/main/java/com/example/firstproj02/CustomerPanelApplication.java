package com.example.firstproj02;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CustomerPanelApplication extends Application {
    FXMLLoader fxmlLoader;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        fxmlLoader = new FXMLLoader(LoginApplication.class.getResource("customerPanel.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setTitle("Customer Panel");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
