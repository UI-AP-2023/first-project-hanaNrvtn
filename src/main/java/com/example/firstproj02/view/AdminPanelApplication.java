package com.example.firstproj02.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminPanelApplication extends Application {
    FXMLLoader fxmlLoader;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        fxmlLoader = new FXMLLoader(LoginApplication.class.getResource("/com/example/firstproj02/fxmls/admin-panel-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setTitle("Admin Panel");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
