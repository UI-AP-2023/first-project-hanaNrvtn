package com.example.firstproj02.view;

import com.example.firstproj02.model.accounts.Customer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class ProfileApplication extends Application {
    //FXMLLoader fxmlLoader;
    Customer customer;
    Parent parent;
    Pane pane;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/firstproj02/fxmls/profile-view.fxml"));
        parent=fxmlLoader.load();
        pane.getChildren().clear();
        pane.getChildren().add(parent);
        ProfileController profileController=fxmlLoader.getController();
        profileController.customer=customer;
        profileController.show();
        primaryStage.setTitle("Profile Details");
    }

    ProfileApplication(Customer customer, Parent parent, Pane pane){
        this.customer=customer;
        this.parent=parent;
        this.pane=pane;
    }

    ProfileApplication(Parent parent, Pane pane){
        this.parent=parent;
        this.pane=pane;
    }
}
