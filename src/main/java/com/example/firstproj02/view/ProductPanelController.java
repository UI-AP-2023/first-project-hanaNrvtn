package com.example.firstproj02.view;

import com.example.firstproj02.controller.ProductController;
import com.example.firstproj02.model.accounts.Customer;
import com.example.firstproj02.model.products.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ProductPanelController implements Initializable {
    ProductController productController;
    ArrayList<Product> products;
    ArrayList<Product> onViewProducts;
    ArrayList<Product> tempCart;
    Customer customer;
    private Product currentProduct;
    private int startIndex;
    Parent parent;
    @FXML
    private AnchorPane productPanelAnchorPane;

    @FXML
    private ImageView upButton;

    @FXML
    private ImageView downButton;

    @FXML
    private Label pageNumberLabel;

    @FXML
    private Button produc0_0;

    @FXML
    private Button product0_1;

    @FXML
    private Button product0_2;

    @FXML
    private Button product1_0;

    @FXML
    private Button product1_1;

    @FXML
    private Button product1_2;

    @FXML
    private Button product2_0;

    @FXML
    private Button product2_1;

    @FXML
    private Button product2_2;

    @FXML
    void produc0_0(ActionEvent event) {

    }

    @FXML
    void product0_1(ActionEvent event) {

    }

    @FXML
    void product0_2(ActionEvent event) {

    }

    @FXML
    void product1_0(ActionEvent event) {

    }

    @FXML
    void product1_1(ActionEvent event) {

    }

    @FXML
    void product1_2(ActionEvent event) {

    }

    @FXML
    void product2_0(ActionEvent event) {

    }

    @FXML
    void product2_1(ActionEvent event) {

    }

    @FXML
    void product2_2(ActionEvent event) {

    }

    @FXML
    void upButton(MouseEvent event) {
        pageNumberLabel.setText(String.valueOf(startIndex/9+1));
        gridPane.getChildren().forEach(n->((Button)n).setText(""));
        onViewProducts=productController.divideProducts(products, 9, startIndex);
        for(int i=0; i<onViewProducts.size(); ++i){
            ((Button)gridPane.getChildren().get(i)).setText(onViewProducts.get(i).toString());
            ++startIndex;
        }
        if(startIndex==products.size()) upButton.setDisable(true);
        downButton.setDisable(false);
    }

    @FXML
    void downButton(MouseEvent event) {
        if(startIndex%9==0) startIndex=(startIndex/9-2)*9;
        else startIndex=(startIndex/9-1)*9;
        onViewProducts=productController.divideProducts(products, 9, startIndex);
        for(int i=0; i<onViewProducts.size(); ++i){
            ((Button)gridPane.getChildren().get(i)).setText(onViewProducts.get(i).toString());
            ++startIndex;
        }
        pageNumberLabel.setText(String.valueOf(startIndex/9));
        if(startIndex==9) downButton.setDisable(true);
        upButton.setDisable(false);
    }

    @FXML
    private GridPane gridPane;

    void show(){
        pageNumberLabel.setText(String.valueOf(startIndex/9+1));
        onViewProducts=productController.divideProducts(products, 9, startIndex);
        for(int i=0; i<onViewProducts.size(); ++i){
            ((Button)gridPane.getChildren().get(i)).setText(onViewProducts.get(i).toString());
            ++startIndex;
        }
        if(startIndex==products.size()) upButton.setDisable(true);
        downButton.setDisable(true);

        gridPane.getChildren().forEach(n->((Button)n).setOnAction(event -> {
            try {
                if(customer!=null) new ProductPageApplication(onViewProducts.get(gridPane.getChildren().indexOf(n)), customer, parent, productPanelAnchorPane).start((Stage) ((Node)event.getSource()).getScene().getWindow());
                else new ProductPageApplication(onViewProducts.get(gridPane.getChildren().indexOf(n)),tempCart, parent, productPanelAnchorPane).start((Stage) ((Node)event.getSource()).getScene().getWindow());
            }catch (IOException ignored){}
        }));
    }

    @FXML
    void homeImageView(MouseEvent event) throws IOException {
        new HomeApplication().start((Stage) ((Node)event.getSource()).getScene().getWindow());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        productController=ProductController.getInstance();
        onViewProducts=new ArrayList<>();
        startIndex=0;
    }
}
