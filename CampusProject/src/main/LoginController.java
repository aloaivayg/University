package main;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML
    public javafx.scene.control.TextField usernameTxt;
    public TextField passwordTxt;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void login(javafx.event.ActionEvent ev) throws IOException {
        String username = usernameTxt.getText();
        String password = passwordTxt.getText();

        if (username.equals("admin") && password.equals("helloBro1")) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
            root = loader.load();

            stage = (Stage) ((Node) ev.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
}
