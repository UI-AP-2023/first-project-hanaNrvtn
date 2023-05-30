package com.example.firstproj02;

import com.example.firstproj02.controller.CustomerController;
import com.example.firstproj02.model.accounts.Customer;
import com.example.firstproj02.model.processes.DiscountCode;
import com.example.firstproj02.model.processes.DiscountType;
import com.example.firstproj02.model.processes.Invoice;
import com.example.firstproj02.model.products.FlashMemory;
import com.example.firstproj02.model.products.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CouponsController implements Initializable {
    Customer customer;

    @FXML
    private TableColumn<DiscountCode, String> IDcolumn;

    @FXML
    private TableView<DiscountCode> discountsTabelView;

    @FXML
    private TableColumn<DiscountCode, Integer> percentageColumn;

    void show(){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
