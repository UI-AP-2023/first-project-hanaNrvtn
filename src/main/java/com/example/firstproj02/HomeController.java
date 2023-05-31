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
    @FXML
    private MenuButton filter;
    //............................
    @FXML
    private Menu digitalMenu;
    @FXML
    private Menu DataStorageMenu;
    @FXML
    private Menu FlashMemoryMenu;
    @FXML
    private Menu USBVersionMenu;
    @FXML
    private Menu version1Menu;
    @FXML
    private MenuItem version1price100200Menu;
    @FXML
    private MenuItem version1price200300MenuItem;
    @FXML
    private Menu version2Menu;
    @FXML
    private Menu version3Menu;
    @FXML
    private Menu SSDMenu;
    @FXML
    private Menu readSpeedMenu;
    @FXML
    private Menu PCMenu;
    @FXML
    private Menu RamCapacityMenu;
    // ....................................
    @FXML
    private Menu VehicleMenu;
    @FXML
    private Menu carMenu;
    @FXML
    private Menu automationMenu;
    @FXML
    private Menu bicycleMenu;
    @FXML
    private Menu bickTypeMenu;
    //.....................................
    @FXML
    private Menu StationaryMenu;
    @FXML
    private Menu penMenu;
    @FXML
    private Menu penColorMenu;
    @FXML
    private Menu pencilMenu;
    @FXML
    private Menu pencilTypeMenu;
    @FXML
    private Menu noteBookMenu;
    @FXML
    private Menu sheetsMenu;
    //.......................................
    @FXML
    private Menu edibelMenu;
    //......................................
    @FXML
    private Button apply;
    @FXML
    private TextField searchTextField;
    //......................................
    @FXML
    private AnchorPane homeAnchorPane;

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
    void digitalMenu(ActionEvent event) {
        products=productController.filterByGeneralCategory(Admin.getAdmin().getProducts(), ProductCategory.DIGITAL_EQUIPMENT);
    }
    @FXML
    void DataStorageMenu(ActionEvent event) {
        products=productController.filterDataStorageEquipments(Admin.getAdmin().getProducts());
    }
    @FXML
    void FlashMemoryMenu(ActionEvent event) {
        products=productController.filterFlashMemories(Admin.getAdmin().getProducts());
    }
    @FXML
    void SSDMenu(ActionEvent event) {
        products=productController.filterSSDs(Admin.admin.getProducts());
    }
    @FXML
    void PCMenu(ActionEvent event) {
        products=productController.filterPCs(Admin.getAdmin().getProducts());
    }
    //.......................................
    @FXML
    void VehicleMenu(ActionEvent event) {
        products=productController.filterByGeneralCategory(Admin.getAdmin().getProducts(), ProductCategory.VEHICLE);
    }
    @FXML
    void bicycleMenu(ActionEvent event) {
        products=productController.filterBicycles(Admin.getAdmin().getProducts());
    }
    @FXML
    void carMenu(ActionEvent event) {
        products=productController.filterCars(Admin.getAdmin().getProducts());
    }
    //.........................................
    @FXML
    void StationaryMenu(ActionEvent event) {
        products=productController.filterByGeneralCategory(Admin.admin.getProducts(), ProductCategory.STATIONERY);
    }
    @FXML
    void penMenu(ActionEvent event) {
        products=productController.filterPens(Admin.getAdmin().getProducts());
    }
    @FXML
    void pencilMenu(ActionEvent event) {
        products=productController.filterPencils(Admin.getAdmin().getProducts());
    }
    @FXML
    void noteBookMenu(ActionEvent event) {
        products=productController.filterNoteBooks(Admin.getAdmin().getProducts());
    }
    //..........................................
    @FXML
    void edibelMenu(ActionEvent event) {
        products=productController.filterByGeneralCategory(Admin.getAdmin().getProducts(), ProductCategory.EDIBLE_PRODUCT);
    }
    //..........................................
    @FXML
    void apply(ActionEvent event) throws IOException {
        if(customer!=null) new ProductPanelApplication(products, customer, parent, homeAnchorPane).start((Stage) ((Node)event.getSource()).getScene().getWindow());
        else new ProductPanelApplication(products, tempCart, parent, homeAnchorPane).start((Stage) ((Node)event.getSource()).getScene().getWindow());
    }

    @FXML
    void version1Menu(ActionEvent event) {
        products=productController.filterUSBVersion(Admin.getAdmin().getProducts(), 1);
    }
    @FXML
    void version1price100200Menu(ActionEvent event) {
        products=productController.filterByPrice(productController.filterUSBVersion(Admin.getAdmin().getProducts(), 1), 100, 200);
    }
    @FXML
    void version1price200300MenuItem(ActionEvent event) {
        products=productController.filterByPrice(productController.filterUSBVersion(Admin.getAdmin().getProducts(), 1), 200, 100);
    }
    @FXML
    void version2Menu(ActionEvent event) {
        products=productController.filterUSBVersion(Admin.getAdmin().getProducts(), 2);
    }
    @FXML
    void version3Menu(ActionEvent event) {
        products=productController.filterUSBVersion(Admin.getAdmin().getProducts(), 3);
    }


    @FXML
    void userAccountButton(ActionEvent event) throws IOException {
        if(customer==null){
            new LoginApplication().start((Stage) ((Node)event.getSource()).getScene().getWindow());
        }
        else{
            new CustomerPanelApplication(customer).start((Stage) ((Node)event.getSource()).getScene().getWindow());
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        productController=ProductController.getInstance();
        products=new ArrayList<>();
        if(customer==null) tempCart=new ArrayList<>();
        products=Admin.admin.getProducts();
    }
}
