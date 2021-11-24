package main;
import entity.Duty;
import entity.Security;
import entity.Manager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;

import java.io.IOException;

public class Scene3Controller implements Initializable{
    @FXML
    private TableView<Security> scheduleTable;
    @FXML
    private TableColumn<Security, String> securityID;
    @FXML
    private TableColumn<Security, String> securityName;
    @FXML
    private TableColumn<Security, Integer> end;
    @FXML
    private TableColumn<Duty, Integer> start;
    @FXML
    private TableColumn<Duty, Date> workDate;
    @FXML
    private TableColumn<Duty, String> workPlace;

    Manager manager = new Manager();
    ObservableList<Security> list = FXCollections.observableArrayList(manager.securityList);

    public Scene3Controller() throws IOException {
    }

    public void viewSchedule() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("ViewScheduleDialog.fxml"));
        DialogPane scheduleDialog = fxmlLoader.load();

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setDialogPane(scheduleDialog);
        if(dialog.showAndWait().get() == ButtonType.CLOSE) {
            dialog.close();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        securityID.setCellValueFactory(new PropertyValueFactory<Security, String>("securityID"));

        scheduleTable.setItems(list);
    }
}