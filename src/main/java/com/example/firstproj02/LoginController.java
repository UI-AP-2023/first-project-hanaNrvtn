package com.example.firstproj02;

import com.example.firstproj02.controller.AdminController;
import com.example.firstproj02.controller.CustomerController;
import com.example.firstproj02.model.accounts.Customer;
import com.example.firstproj02.view.AdminPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    AdminController adminController;
    CustomerController customerController;
    String userName;
    String password;

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
    void loginButton(ActionEvent event) throws IOException {

        if(adminController.login(userNameTextField.getText(), passwordTextField.getText())){   // error occured
            AdminPanel adminPanel=new AdminPanel();
            adminPanel.matchCommand();
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        adminController=AdminController.getInstance();
        customerController=CustomerController.getInstance();
    }
}
