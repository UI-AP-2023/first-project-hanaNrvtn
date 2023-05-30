package com.example.firstproj02;

import com.example.firstproj02.controller.ProductController;
import com.example.firstproj02.model.accounts.Admin;
import com.example.firstproj02.model.accounts.Customer;
import com.example.firstproj02.model.products.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    Customer customer;
    ProductController productController;
    ArrayList<Product> products;
    ArrayList<Product> tempCart;
    Parent parent;


    FlashMemory flashMemory=new FlashMemory(2.0, 90, 90, "12:12:12", "name", 90, 90);
    void method(){
        products.add(flashMemory);
    }

    @FXML
    private AnchorPane homeAnchorPane;

    @FXML
    private TextField searchTextField;

    @FXML
    private ImageView searchImageView;

    @FXML
    private Button userAccountButton;

    @FXML
    private ImageView cartImageView;

    @FXML
    private ImageView digitalCategoryImageView;

    @FXML
    private ImageView vehicleCategoryImageView;

    @FXML
    private ImageView stationaryCategoryImageView;

    @FXML
    private ImageView edibleCategoryImageView;

    @FXML
    void userAccountButton(ActionEvent event) throws IOException {
        if(customer==null){
            new LoginApplication().start((Stage) ((Node)event.getSource()).getScene().getWindow());
        }
        else{
            CustomerPanelApplication customerPanelApplication=new CustomerPanelApplication();
            customerPanelApplication.start((Stage) ((Node)event.getSource()).getScene().getWindow());
            CustomerPanelController customerPanelController=customerPanelApplication.fxmlLoader.getController();
            customerPanelController.customer=customer;
        }
    }

    @FXML
    void searchImageView(MouseEvent event) throws IOException {
        if(customer!=null) new ProductPanelApplication(productController.findMatches(searchTextField.getText()), customer, parent, homeAnchorPane).start((Stage) ((Node)event.getSource()).getScene().getWindow());
        else new ProductPanelApplication(productController.findMatches(searchTextField.getText()), tempCart, parent, homeAnchorPane).start((Stage) ((Node)event.getSource()).getScene().getWindow());
    }

    @FXML
    void digitalCategoryImageView(MouseEvent event) throws IOException {
        if(customer!=null) new ProductPanelApplication(productController.filterByGeneralCategory(Admin.getAdmin().getProducts(), ProductCategory.DIGITAL_EQUIPMENT), customer, parent, homeAnchorPane).start((Stage) ((Node)event.getSource()).getScene().getWindow());
        else new ProductPanelApplication(productController.filterByGeneralCategory(Admin.getAdmin().getProducts(), ProductCategory.DIGITAL_EQUIPMENT), tempCart, parent, homeAnchorPane).start((Stage) ((Node)event.getSource()).getScene().getWindow());
    }

    @FXML
    void vehicleCategoryImageView(MouseEvent event) throws IOException {
       if(customer!=null) new ProductPanelApplication(productController.filterByGeneralCategory(Admin.getAdmin().getProducts(), ProductCategory.VEHICLE), customer, parent, homeAnchorPane).start((Stage) ((Node)event.getSource()).getScene().getWindow());
        else new ProductPanelApplication(productController.filterByGeneralCategory(Admin.getAdmin().getProducts(), ProductCategory.VEHICLE), tempCart, parent, homeAnchorPane).start((Stage) ((Node)event.getSource()).getScene().getWindow());
    }

    @FXML
    void stationaryCategoryImageView(MouseEvent event) throws IOException {
        if(customer!=null) new ProductPanelApplication(productController.filterByGeneralCategory(Admin.getAdmin().getProducts(), ProductCategory.STATIONERY), customer, parent, homeAnchorPane).start((Stage) ((Node)event.getSource()).getScene().getWindow());
        else new ProductPanelApplication(productController.filterByGeneralCategory(Admin.getAdmin().getProducts(), ProductCategory.STATIONERY),tempCart, parent, homeAnchorPane).start((Stage) ((Node)event.getSource()).getScene().getWindow());
    }

    @FXML
    void edibleCategoryImageView(MouseEvent event) throws IOException {
       if(customer!=null) new ProductPanelApplication(productController.filterByGeneralCategory(Admin.getAdmin().getProducts(), ProductCategory.EDIBLE_PRODUCT), customer, parent, homeAnchorPane).start((Stage) ((Node)event.getSource()).getScene().getWindow());
       else new ProductPanelApplication(productController.filterByGeneralCategory(Admin.getAdmin().getProducts(), ProductCategory.EDIBLE_PRODUCT), tempCart, parent, homeAnchorPane).start((Stage) ((Node)event.getSource()).getScene().getWindow());
    }

    @FXML
    void cartImageView(MouseEvent event) throws IOException {
        new CartApplication(tempCart, parent, homeAnchorPane).start((Stage) ((Node)event.getSource()).getScene().getWindow());
    }


    @Override            // complete filters by general filters
    public void initialize(URL url, ResourceBundle resourceBundle) {
        productController=ProductController.getInstance();
        products=new ArrayList<>();
        if(customer==null) tempCart=new ArrayList<>();
        products=Admin.admin.getProducts();
    }
}
