package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.IOException;

public class LoginController {

    @FXML
    Button loginButton;

    @FXML
    TextField BrugernavnTextField;
    Main main = new Main();

    public void fortrydButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) loginButton.getScene().getWindow();
        stage.close();
        main.closestage();// her får vi siden logget ved at man klikker på fortryd

    }

    public void loginButtonOnAction(ActionEvent actionEvent) throws IOException {


        try {
            System.out.println(BrugernavnTextField.getText());
            if (BrugernavnTextField.getText().contains("gmail")) ;
            { //her skal brugernavnet indeholde ordet "gmail" for at man kan logget ind son sundhedsprsonale
                Main.setRoot("PersonaleN.fxml");
                Main.openstage();
            } else if (BrugernavnTextField.getText().contains("")) { // her der kan man taste hvad man vil for at komme ind på patient siden, vores intension er dog at patient skal bruge sit CPR for at logge ind
                Main.setRoot("Patient.fxml");
                Main.openstage();
            } else {
                System.out.println("Forkert login, prøv igen"); // hvis der ikke bliver tastet et godkendt kodeord vil den i terminalen skrive deet forkert, samt hvd der er indtastes
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


