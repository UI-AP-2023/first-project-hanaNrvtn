package com.example.firstproj02.view;

import com.example.firstproj02.controller.AdminController;
import com.example.firstproj02.controller.CustomerController;
import com.example.firstproj02.model.accounts.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    AdminController adminController;
    CustomerController customerController;
    String userName;
    String password;
    Customer customer;

    @FXML
    private Label loginLabel;
    @FXML
    private TextField userNameTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private Button loginButton;
    @FXML
    private Button signUpButton;
    @FXML
    private Button homeBackButton;

    @FXML
    void loginButton(ActionEvent event) throws IOException {

        if(adminController.login(userNameTextField.getText(), passwordTextField.getText())){   // error occured
            AdminPanelApplication adminPanelApplication=new AdminPanelApplication();
            adminPanelApplication.start((Stage) ((Node)event.getSource()).getScene().getWindow());
        } else{
            Customer customer=customerController.login(userNameTextField.getText(), passwordTextField.getText());
            if(customer!=null){
                HomeApplication homeApplication=new HomeApplication();
                homeApplication.start((Stage) ((Node)event.getSource()).getScene().getWindow());
                HomeController homeController=homeApplication.fxmlLoader.getController();
                homeController.customer=customer;
            }
            else{
                Alert alert=new Alert(Alert.AlertType.WARNING);
                alert.getDialogPane().getStylesheets().add(Objects.requireNonNull(getClass().getResource("/com/example/firstproj02/styles/dialog-pane-style.css")).toExternalForm());
                ((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/example/firstproj02/images/app-icons/app-light.PNG"))));
                alert.setTitle("Warning!");
                alert.setHeaderText("Invalid Information");
                alert.setContentText("Try again! \nUser name or password is not correct.");
                alert.showAndWait();
            }
        }
    }

    @FXML
    void signUpButton(ActionEvent event) throws IOException {
        new SignUpApplication().start((Stage) ((Node)event.getSource()).getScene().getWindow());
    }

    @FXML
    void homeBackButton(ActionEvent event) throws IOException {
        HomeApplication homeApplication=new HomeApplication();
        homeApplication.start((Stage) ((Node)event.getSource()).getScene().getWindow());
        HomeController homeController=homeApplication.fxmlLoader.getController();
        homeController.customer=customer;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        adminController=AdminController.getInstance();
        customerController=CustomerController.getInstance();
    }
}
