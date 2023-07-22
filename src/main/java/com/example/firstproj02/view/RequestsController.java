package com.example.firstproj02.view;

import com.example.firstproj02.controller.AdminController;
import com.example.firstproj02.model.accounts.Admin;
import com.example.firstproj02.model.processes.IncreaseCreditRequest;
import com.example.firstproj02.model.processes.Invoice;
import com.example.firstproj02.model.processes.RegistrationRequest;
import com.example.firstproj02.model.processes.Request;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class RequestsController implements Initializable {

    Request currentRequest;
    AdminController adminController;
    @FXML
    private Button acceptButton;

    @FXML
    private Button rejectButton;

    @FXML
    private Label requestDetailsLabel;

    @FXML
    void acceptButton(ActionEvent event) {
        if(currentRequest instanceof RegistrationRequest)
            adminController.acceptRegistrationRequest(currentRequest);
        else if(currentRequest instanceof IncreaseCreditRequest)
            adminController.acceptIncreaseCreditRequest(currentRequest);
        else adminController.acceptCommentCheckRequest(currentRequest);

        requestsListView.getItems().remove(requestsListView.getSelectionModel().getSelectedItem());
    }

    @FXML
    void rejectButton(ActionEvent event) {
        if(currentRequest instanceof RegistrationRequest)
            adminController.rejectRegistrationRequest(currentRequest);
        else if(currentRequest instanceof IncreaseCreditRequest)
            adminController.rejectIncreaseCreditRequest(currentRequest);
        else adminController.rejectCommentCheckRequest(currentRequest);
        requestsListView.getItems().remove(requestsListView.getSelectionModel().getSelectedItem());
    }


    @FXML
    private ListView<Request> requestsListView;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        adminController=AdminController.getInstance();
        requestsListView.getItems().addAll(Admin.getAdmin().getRequests());

        requestsListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Request>() {
            @Override
            public void changed(ObservableValue<? extends Request> observableValue, Request product, Request t1) {
                currentRequest=requestsListView.getSelectionModel().getSelectedItem();
                requestDetailsLabel.setText(currentRequest.toString1());
            }
        });
    }
}
