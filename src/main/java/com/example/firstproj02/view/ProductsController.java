package com.example.firstproj02.view;

import com.example.firstproj02.controller.AdminController;
import com.example.firstproj02.model.exceptions.InvalidCardPasswordException;
import com.example.firstproj02.model.products.FlashMemory;
import com.example.firstproj02.model.products.PC;
import com.example.firstproj02.model.products.ProductCategory;
import com.example.firstproj02.model.products.Stationary;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ProductsController implements Initializable {

    ProductCategory currentProductCategory;
    AdminController adminController;
    RadioButton currentRadioButton;

    @FXML
    private TextField CPUModelTextFiled;

    @FXML
    private VBox PCInfoVBox;

    @FXML
    private RadioButton PCRadioButton;

    @FXML
    private HBox PCVBox;

    @FXML
    private HBox PCVBox1;

    @FXML
    private TextField RAMCapacityTextField;

    @FXML
    private TextField SSDCapacityTextField;

    @FXML
    private VBox SSDInfoVBox;

    @FXML
    private Pane SpecificInfoPane;

    @FXML
    private VBox StationaryAndVehivleInfoVBox;

    @FXML
    private TextField SupplyTextField;

    @FXML
    private TextField USBVersionTextField;

    @FXML
    private Button addButton;

    @FXML
    private TextField automaticTextFiled;

    @FXML
    private VBox bikeInfoVBox;

    @FXML
    private RadioButton bikeRadioButton;

    @FXML
    private TextField bikeTypeTextField;

    @FXML
    private TextField capacityTextField;

    @FXML
    private VBox carInfoVBox;

    @FXML
    private RadioButton carRadioButton;

    @FXML
    private Pane categoryInfoPane;

    @FXML
    private TextField cmanufacturingCountryTextField;

    @FXML
    private Button confirmButton;

    @FXML
    private VBox digitalInfoVBox;

    @FXML
    private VBox edibleInfoVBox;

    @FXML
    private Button editButton;

    @FXML
    private TextField expDateTextField;

    @FXML
    private TextField flashMemoryCapacityTextField;

    @FXML
    private VBox flashMemoryInfoVBox;

    @FXML
    private RadioButton flashMemoryRadioButton;

    @FXML
    private VBox generalInfoVBox;

    @FXML
    private TextField motorCapacityTextField;

    @FXML
    private TextField nameTextField;

    @FXML
    private VBox noteBookInfoVBox;

    @FXML
    private RadioButton noteBookRadioButton;

    @FXML
    private TextField paperTypeTextField;

    @FXML
    private TextField pecColorTextField;

    @FXML
    private VBox penInfoVBox;

    @FXML
    private RadioButton penRadioButton;

    @FXML
    private VBox pencilInfoVBox;

    @FXML
    private RadioButton pencilRadioButton;

    @FXML
    private TextField pencilTypeTextFiled;

    @FXML
    private TextField priceTextField;

    @FXML
    private TextField prodDateTextField;

    @FXML
    private ToggleGroup product;

    @FXML
    private AnchorPane productsAnchorPane;

    @FXML
    private TextField readSpeedTextField;

    @FXML
    private Button removeButton;

    @FXML
    private TextField sheetsTextFiled;

    @FXML
    private Button showAllButton;

    @FXML
    private TextField weightTextField;

    @FXML
    private TextField writeSpeedTextField1;

    @FXML
    private RadioButton SSDRadioButton;

    @FXML
    private TextField dimensionTextField;

    @FXML
    void addButton(ActionEvent event) {

    }

    @FXML
    void editButton(ActionEvent event) {

    }

    @FXML
    void removeButton(ActionEvent event) {

    }

    @FXML
    void showAllButton(ActionEvent event) {

    }

    @FXML
    void flashMemoryRadioButton(MouseEvent event) {
        hide();
        clear();
        currentRadioButton=flashMemoryRadioButton;
        digitalInfoVBox.setVisible(true);
        flashMemoryInfoVBox.setVisible(true);
    }

    @FXML
    void PCRadioButton(MouseEvent event) {
        hide();
        clear();
        currentRadioButton= PCRadioButton;
        digitalInfoVBox.setVisible(true);
        PCInfoVBox.setVisible(true);
    }

    @FXML
    void SSDRadioButton(MouseEvent event) {
        hide();
        clear();
        currentRadioButton=SSDRadioButton;
        digitalInfoVBox.setVisible(true);
        SSDInfoVBox.setVisible(true);        //
    }

    @FXML
    void bikeRadioButton(MouseEvent event) {
        hide();
        clear();
        currentRadioButton=bikeRadioButton;
        StationaryAndVehivleInfoVBox.setVisible(true);
        bikeInfoVBox.setVisible(true);
    }

    @FXML
    void carRadioButton(MouseEvent event) {
        hide();
        clear();
        currentRadioButton=carRadioButton;
        StationaryAndVehivleInfoVBox.setVisible(true);
        carInfoVBox.setVisible(true);
    }

    @FXML
    void noteBookRadioButton(MouseEvent event) {
        hide();
        clear();
        currentRadioButton=noteBookRadioButton;
        StationaryAndVehivleInfoVBox.setVisible(true);
        noteBookInfoVBox.setVisible(true);
    }

    @FXML
    void penRadioButton(MouseEvent event) {
        hide();
        clear();
        currentRadioButton=penRadioButton;
        StationaryAndVehivleInfoVBox.setVisible(true);
        penInfoVBox.setVisible(true);
    }

    @FXML
    void pencilRadioButton(MouseEvent event) {
        hide();
        clear();
        currentRadioButton=pencilRadioButton;
        StationaryAndVehivleInfoVBox.setVisible(true);
        pencilInfoVBox.setVisible(true);
    }

    @FXML
    void confirmAddButton(ActionEvent event) {
        if(currentRadioButton.equals(flashMemoryRadioButton)) {
            adminController.addFlashMemory(Double.parseDouble(USBVersionTextField.getText()), Integer.parseInt(flashMemoryCapacityTextField.getText()), Double.parseDouble(weightTextField.getText()), dimensionTextField.getText(), nameTextField.getText(), Integer.parseInt(priceTextField.getText()), Integer.parseInt(SupplyTextField.getText()));
        } else if(currentRadioButton.equals(SSDRadioButton)){
            adminController.addSSD(Integer.parseInt(writeSpeedTextField1.getText()), Integer.parseInt(readSpeedTextField.getText()), Integer.parseInt(capacityTextField.getText()), Double.parseDouble(weightTextField.getText()), dimensionTextField.getText(), nameTextField.getText(), Integer.parseInt(priceTextField.getText()), Integer.parseInt(SupplyTextField.getText()));
        } else if(currentRadioButton.equals(PCRadioButton)){
            adminController.addPC(CPUModelTextFiled.getText(), Integer.parseInt(RAMCapacityTextField.getText()), Double.parseDouble(weightTextField.getText()), dimensionTextField.getText(), nameTextField.getText(), Integer.parseInt(priceTextField.getText()), Integer.parseInt(SupplyTextField.getText()));
        } else if(currentRadioButton.equals(bikeRadioButton)){
            adminController.addBicycle(bikeTypeTextField.getText(), cmanufacturingCountryTextField.getText(), nameTextField.getText(), Integer.parseInt(priceTextField.getText()), Integer.parseInt(SupplyTextField.getText()));
        } else if(currentRadioButton.equals(carRadioButton)){
            adminController.addCar(Integer.parseInt(motorCapacityTextField.getText()), Boolean.parseBoolean(automaticTextFiled.getText()), cmanufacturingCountryTextField.getText(), nameTextField.getText(), Integer.parseInt(priceTextField.getText()), Integer.parseInt(SupplyTextField.getText()));
        } else if(currentRadioButton.equals(noteBookRadioButton)){
            adminController.addNoteBook(Integer.parseInt(sheetsTextFiled.getText()), paperTypeTextField.getText(), cmanufacturingCountryTextField.getText(), nameTextField.getText(), Integer.parseInt(priceTextField.getText()), Integer.parseInt(SupplyTextField.getText()));
        } else if(currentRadioButton.equals(penRadioButton)){
            adminController.addPen(pecColorTextField.getText(), cmanufacturingCountryTextField.getText(),nameTextField.getText(), Integer.parseInt(priceTextField.getText()), Integer.parseInt(SupplyTextField.getText()));
        } else if(currentRadioButton.equals(pencilRadioButton)){
            adminController.addPencil(pencilTypeTextFiled.getText(), cmanufacturingCountryTextField.getText(), nameTextField.getText(), Integer.parseInt(priceTextField.getText()), Integer.parseInt(SupplyTextField.getText()));
        } else {
            adminController.addEdibleProduct(prodDateTextField.getText(), expDateTextField.getText(), nameTextField.getText(), Integer.parseInt(priceTextField.getText()), Integer.parseInt(SupplyTextField.getText()));
        }
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.getDialogPane().getStylesheets().add(Objects.requireNonNull(getClass().getResource("/com/example/firstproj02/styles/dialog-pane-style.css")).toExternalForm());
        ((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/example/firstproj02/images/app-icons/app-light.PNG"))));
        alert.setTitle("Information!");
        alert.setHeaderText("Task is done!");
        alert.setContentText("Product added successfully!");
        alert.showAndWait();
    }

    void clear(){
        nameTextField.setText("");
        priceTextField.setText("");
        SupplyTextField.setText("");
        capacityTextField.setText("");
        weightTextField.setText("");
        dimensionTextField.setText("");
        prodDateTextField.setText("");
        expDateTextField.setText("");
        cmanufacturingCountryTextField.setText("");
        USBVersionTextField.setText("");
        readSpeedTextField.setText("");
        writeSpeedTextField1.setText("");
        CPUModelTextFiled.setText("");
        RAMCapacityTextField.setText("");
        bikeTypeTextField.setText("");
        motorCapacityTextField.setText("");
        automaticTextFiled.setText("");
        sheetsTextFiled.setText("");
        paperTypeTextField.setText("");
        pecColorTextField.setText("");
        pencilTypeTextFiled.setText("");
    }

    void hide(){
        digitalInfoVBox.setVisible(false);
        edibleInfoVBox.setVisible(false);
        StationaryAndVehivleInfoVBox.setVisible(false);
        flashMemoryInfoVBox.setVisible(false);
        SSDInfoVBox.setVisible(false);
        PCInfoVBox.setVisible(false);
        bikeInfoVBox.setVisible(false);
        carInfoVBox.setVisible(false);
        noteBookInfoVBox.setVisible(false);
        penInfoVBox.setVisible(false);
        pencilInfoVBox.setVisible(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        hide();
        adminController=AdminController.getInstance();
    }
}
