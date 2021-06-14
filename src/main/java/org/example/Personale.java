package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;



public class Personale {

    @FXML
    TextField sogCpr;
    @FXML
    Button redigerData;
    @FXML
    Button logUdPatient;


    Main main = new Main();
    ActionEvent actionEvent;

    public void close() {
        main.closestage();// her får vi siden logget ved at man klikker på logud
    }


    public void slaPatientOp(ActionEvent actionEvent) throws IOException {
        this.actionEvent = actionEvent;
        String sog = sogCpr.getText();
    }

    public void editData (ActionEvent actionEvent) throws IOException {
        this.actionEvent = actionEvent;
        String edit = redigerData.getText();
    }

}


