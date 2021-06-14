package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Patient {

    @FXML
    Button dataForklaring;

    Main main = new Main();
    ActionEvent actionEvent;





    public void close() {

        main.closestage();// her får vi siden logget ved at man klikker på logud
    }

    public void Info(ActionEvent actionEvent) throws IOException {
        this.actionEvent = actionEvent;
        String data = dataForklaring.getText();
        Main.setRoot("Dataforklaring.fxml");
        Main.openstage();
    }
}
