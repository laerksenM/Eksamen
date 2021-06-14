package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main extends Application {
    static Scene scene;
    static Stage stage;


    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = new Stage();

        Parent root =  FXMLLoader.load(getClass().getResource("login.fxml"));// open.stage metode.
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
        System.out.println("lortet virker ");

    }

    //open.stage og close.stage metode.
    static void setRoot(String fxml) throws IOException {
        scene = new Scene(loadFXML(fxml));
        scene.setRoot(loadFXML(fxml));
    }

    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml));
        return fxmlLoader.load();
    }
    public static void main(String[] args) {
        launch(args);
    }


    public static void openstage() throws IOException {
    // openstage metode som åbner en ny stage
        stage.setScene(scene);
        stage.show();
    }
    public void closestage() {
        stage.close();
        //close.hide
        // close stage metode som lukker scene

    }
    public void Patienter() throws SQLException {

        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/BrugereDB?serverTimezone=UTC","root","Haj1234!");// vi har sat timezone på da dette opstof som en fejl med mysql
        System.out.println("Nu er der forbindelse");
    }
}







