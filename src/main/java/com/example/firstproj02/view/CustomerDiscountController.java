package com.example.firstproj02.view;

import com.example.firstproj02.controller.AdminController;
import com.example.firstproj02.model.accounts.Admin;
import com.example.firstproj02.model.processes.DiscountCode;
import com.example.firstproj02.model.processes.DiscountType;
import com.example.firstproj02.model.processes.Invoice;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class CustomerDiscountController implements Initializable {
    AdminController adminController;
    DiscountCode currentDiscountCode;
    Bounds bounds1, bounds2;

    @FXML
    private VBox generalInfoVBox;

    @FXML
    private TextField percentageTextField;

    @FXML
    private TextField expTextField;

    @FXML
    private TextField capacityTextField;

    @FXML
    private ChoiceBox<DiscountType> discountTypeChoiceBox;

    @FXML
    private VBox buttonVbox;

    @FXML
    private Button addButton;

    @FXML
    private Button editButton;

    @FXML
    private Button removeButton;

    @FXML
    private Button confirmDeleteButton;

    @FXML
    private Button confirmEditButton;

    @FXML
    private Button confirmAddButton;

    @FXML
    private ListView<DiscountCode> discountsListView;


    @FXML
    void addButton(ActionEvent event) {  // discount type is null
        empty();
        confirmAddButton.setVisible(true);
        confirmEditButton.setVisible(false);
        confirmDeleteButton.setVisible(false);
        addButton.setVisible(false);
        editButton.setVisible(true);
        removeButton.setVisible(true);   // change layouts/buttonVbox.getChildren().set()
        buttonVbox.getChildren().remove(editButton);
        buttonVbox.getChildren().remove(removeButton);
        buttonVbox.getChildren().add(1, editButton);
        buttonVbox.getChildren().add(2, removeButton);
    }

    @FXML
    void editButton(ActionEvent event) {
        list();
        discountsListView.setVisible(true);
        confirmAddButton.setVisible(false);
        confirmEditButton.setVisible(true);
        confirmDeleteButton.setVisible(false);
        addButton.setVisible(true);
        editButton.setVisible(false);
        removeButton.setVisible(true);
        buttonVbox.getChildren().remove(addButton);
        buttonVbox.getChildren().remove(removeButton);
        buttonVbox.getChildren().add(1, addButton);
        buttonVbox.getChildren().add(2, removeButton);
        list();
    }

    @FXML
    void removeButton(ActionEvent event) {
        list();
        discountsListView.setVisible(true);
        confirmAddButton.setVisible(false);
        confirmEditButton.setVisible(false);
        confirmDeleteButton.setVisible(true);
        addButton.setVisible(true);
        editButton.setVisible(true);
        removeButton.setVisible(false);
        buttonVbox.getChildren().remove(addButton);
        buttonVbox.getChildren().remove(editButton);
        buttonVbox.getChildren().add(1, addButton);
        buttonVbox.getChildren().add(2, editButton);
        //list();
    }


    @FXML
    void confirmAddButton(ActionEvent event) {
        DiscountType currentDiscountType=discountTypeChoiceBox.getValue();
        if(currentDiscountType.equals(DiscountType.WELCOMING))
            adminController.offerWelcomingDiscount(Double.parseDouble(percentageTextField.getText()), LocalDate.parse(expTextField.getText(), adminController.getFormatter()), Integer.parseInt(capacityTextField.getText()));
        if(currentDiscountType.equals(DiscountType.ENCOURAGING))
            adminController.offerEncouragingDiscount(Double.parseDouble(percentageTextField.getText()), LocalDate.parse(expTextField.getText(), adminController.getFormatter()), Integer.parseInt(capacityTextField.getText()));
        if(currentDiscountType.equals(DiscountType.LOYALTY))
            adminController.offerLoyaltyDiscount(Double.parseDouble(percentageTextField.getText()), LocalDate.parse(expTextField.getText(), adminController.getFormatter()), Integer.parseInt(capacityTextField.getText()));
        System.out.println(adminController.getSampleDiscountCodes());
        list();
    }

    @FXML
    void confirmEditButton(ActionEvent event) {
        adminController.editSampleDiscountCodes(currentDiscountCode, Double.parseDouble(percentageTextField.getText()), LocalDate.parse(expTextField.getText()), Integer.parseInt(capacityTextField.getText()));
        discountsListView.getSelectionModel().getSelectedItem().setPercentage(Double.parseDouble(percentageTextField.getText()));
        list();
    }

    @FXML
    void confirmDeleteButton(ActionEvent event) {
        adminController.removeSampleDiscountCode(currentDiscountCode);
        discountsListView.getItems().remove(currentDiscountCode);
        list();
    }

    void empty(){
        percentageTextField.setText("");
        expTextField.setText("");
        capacityTextField.setText("");
    }

    void fill(){
        percentageTextField.setText(String.valueOf(currentDiscountCode.getPercentage()));
        expTextField.setText(String.valueOf(currentDiscountCode.getExpiration()));
        capacityTextField.setText(String.valueOf(currentDiscountCode.getCapacity()));
        discountTypeChoiceBox.setValue(currentDiscountCode.getDiscountType());
    }

    void layouts(){
        bounds1= editButton.localToScene(editButton.getBoundsInLocal());
        bounds2=removeButton.localToScene(removeButton.getBoundsInLocal());
    }

    void list(){
        discountsListView.getItems().clear();
        discountsListView.getItems().addAll(adminController.getSampleDiscountCodes());
        discountsListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<DiscountCode>() {
            @Override
            public void changed(ObservableValue<? extends DiscountCode> observableValue, DiscountCode product, DiscountCode t1) {
                currentDiscountCode=discountsListView.getSelectionModel().getSelectedItem();
                fill();
            }
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        discountsListView.setVisible(false);
        confirmEditButton.setVisible(false);
        confirmDeleteButton.setVisible(false);
        adminController=AdminController.getInstance();
        discountTypeChoiceBox.getItems().add(DiscountType.WELCOMING);
        discountTypeChoiceBox.getItems().add(DiscountType.ENCOURAGING);
        discountTypeChoiceBox.getItems().add(DiscountType.LOYALTY);
    }
}
