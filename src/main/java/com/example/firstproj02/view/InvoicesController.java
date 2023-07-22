package com.example.firstproj02.view;

import com.example.firstproj02.controller.CustomerController;
import com.example.firstproj02.model.accounts.Customer;
import com.example.firstproj02.model.processes.Invoice;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class InvoicesController implements Initializable {
    private Customer customer;
    CustomerController customerController;
    Invoice currentInvoice;

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @FXML
    private ListView<Invoice> invoicesListView;
    @FXML
    private Label invoiceInfoLabel;
    @FXML
    private TextField productIDTextField;
    @FXML
    private Slider scoreSlider;
    @FXML
    private Button applyScore;
    void show(){
        invoicesListView.getItems().addAll(customer.getInvoices());

        invoicesListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Invoice>() {
            @Override
            public void changed(ObservableValue<? extends Invoice> observableValue, Invoice product, Invoice t1) {
                currentInvoice=invoicesListView.getSelectionModel().getSelectedItem();
                invoiceInfoLabel.setText(currentInvoice.toString1());
            }
        });
    }
    @FXML
    void applyScore(ActionEvent event) {
        try {
            customerController.rateProduct(customer, customerController.findProductInCustomerInvoices(customer, productIDTextField.getText()), scoreSlider.getValue());
        }catch (NullPointerException e){
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.getDialogPane().getStylesheets().add(Objects.requireNonNull(getClass().getResource("/com/example/firstproj02/styles/dialog-pane-style.css")).toExternalForm());
            ((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/example/firstproj02/images/app-icons/app-light.PNG"))));alert.setTitle("Warning!");
            alert.setHeaderText("Invalid ID");
            alert.setContentText("Product with this ID not found.");
            alert.showAndWait();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        customerController=CustomerController.getInstance();
    }
}
