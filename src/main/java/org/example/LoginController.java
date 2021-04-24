package org.example;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.IOException;

public class LoginController {

    @FXML
   private Button loginButton;

    public void fortrydButtonOnAction(ActionEvent event) {
        Stage stage =(Stage) loginButton.getScene().getWindow();
        stage.close();
    }
            TextField login;
    public void login(ActionEvent actionEvent) throws IOException {
        try {

            if (login.getText().contains("gmail")) {
                Main.setRoot("Patient");

                //JavaFxApp.setRoot("personale");
                //find ud af: java check if string is integer
            }
            if (login.getText().contains("Personale")) {

                Main.openstage(); //lav en ny scene/side
                //find ud af: java check if string is integer
            }
        } finally {

        }
    }

    public void lavBrugerForms(){
            //try {
                /*Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
                primaryStage.setTitle("Hello World");
                primaryStage.setScene(new Scene(root, 300, 275));
                primaryStage.show();*/

    }

    @FXML
    public void loginButtonOnAction(ActionEvent actionEvent) {
        try {
            //if (login.getText().contains("gmail")) {
                Main.setRoot("Personale.fxml");//}
                //Main.setRoot("Patient.fxml");

                //else  {Main.setRoot("Patient");}
            Main.openstage();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*@FXML
    public void loginButtonOnAction(ActionEvent actionEvent) {
        try {
            Main.setRoot("Personale");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}

