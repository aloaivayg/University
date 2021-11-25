package main;

import entity.Security;
import dao.SecurityDAO;
import entity.Manager;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.NoSuchElementException;

public class Scene4Controller {

    public Button confirmBtn;
    public TextField idTxt;
    public TextField nameTxt;
    public TextField genderTxt;
    public TextField baseTxt;

    Manager manager = new Manager();
    SecurityDAO myDao = new SecurityDAO();

    public Scene4Controller() throws IOException {

    }

    public void addSecurity() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("AddSecurityDialog.fxml"));
        DialogPane addSecurityDialog = fxmlLoader.load();

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setDialogPane(addSecurityDialog);
        if(dialog.showAndWait().get() == ButtonType.CLOSE) {
            dialog.close();
        }
    }

    public void doAddSecurity() throws IOException {
        String id = idTxt.getText();
        String name = nameTxt.getText();
        String gender = genderTxt.getText();
        double base = Double.parseDouble(baseTxt.getText());
        Security temp = new Security(id, name, gender, base);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        if (manager.addSecurity(temp)) {
            alert.setTitle("Add security");
            alert.setContentText("Successful");
            myDao.saveListSecurityAsChar(manager.securityList);
            myDao.saveListSecurityAsByte(manager.securityList);
//            manager.save(manager.securityList);
            try {
                if (alert.showAndWait().get() == ButtonType.OK) {
                    alert.close();
                }
            } catch (NoSuchElementException ignored){}
        } else {
            alert.setTitle("Add security");
            alert.setContentText("Unsuccessful");
            try {
                if (alert.showAndWait().get() == ButtonType.OK) {
                    alert.close();
                }
            } catch (NoSuchElementException ignored){}
        }


    }
}
