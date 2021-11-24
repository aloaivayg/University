package main;

import entity.Manager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;


public class Main extends Application {
    public static void main(String[] args) throws IOException {
        launch(args);
    }

    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        Scene scene = new Scene(root);

        //title & icon
        stage.setTitle("Campus Security");
        Image icon = new Image("logo.png");
        stage.getIcons().add(icon);

        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);

        stage.setOnCloseRequest(windowEvent -> {
            windowEvent.consume();
            try {
                close(stage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void close(Stage stage) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setContentText("Do you want to exit?");
        if (alert.showAndWait().get() == ButtonType.OK) {
            stage.close();
        }
    }
}
