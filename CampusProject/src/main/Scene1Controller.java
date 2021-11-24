package main;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.NoSuchElementException;

public class Scene1Controller {
    @FXML
    public javafx.scene.control.TextField usernameTxt;
    public TextField passwordTxt;


    private Stage stage;
    private Scene scene;
    private Parent root;


    public void login(javafx.event.ActionEvent ev) throws IOException {
        String username = usernameTxt.getText();
        String password = passwordTxt.getText();

        if (username.equals("admin") && password.equals("1")) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
            root = loader.load();
            stage = (Stage) ((Node) ev.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login");
            alert.setContentText("Invalid username or password");
            try {
                if (alert.showAndWait().get() == ButtonType.OK) {
                    alert.close();
                }
            } catch (NoSuchElementException ignored){}
        }
    }
}
