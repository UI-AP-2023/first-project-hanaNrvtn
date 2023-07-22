package com.example.firstproj02.view;

import com.example.firstproj02.model.accounts.Customer;
import com.example.firstproj02.model.processes.DiscountCode;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class CouponsController implements Initializable {
    Customer customer;

    @FXML
    private ListView<DiscountCode> discountsListView;

    void show() {
        discountsListView.getItems().addAll(customer.getDiscountCodes());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
