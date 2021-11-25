package main;

import entity.Security;
import dao.SecurityDAO;
import entity.Manager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
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
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;
import java.util.function.Predicate;

public class Scene2Controller implements Initializable {
    public Button logoutButton;
    public Button saveButton;
    public TextField searchBar;

    Manager manager = new Manager();
    SecurityDAO myDao = new SecurityDAO();

    ObservableList<Security> list = FXCollections.observableArrayList(manager.securityList);
    FilteredList<Security> filteredData = new FilteredList<>(FXCollections.observableList(list));
    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TableColumn<Security, Double> salary;
    @FXML
    private TableColumn<Security, String> securityGender;
    @FXML
    private TableColumn<Security, String> securityID;
    @FXML
    private TableColumn<Security, String> securityName;
    @FXML
    private TableView<Security> securityTable;


    public Scene2Controller() throws IOException {}

    public void logout(javafx.event.ActionEvent ev) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
        root = loader.load();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Save");
        alert.setContentText("Do you want to save before logout?");
        if (alert.showAndWait().get() == ButtonType.OK) {
            myDao.saveListSecurityAsChar(manager.securityList);
            myDao.saveListSecurityAsByte(manager.securityList);
        }

        alert.setTitle("Logout");
        alert.setContentText("Do you want to logout?");
        if (alert.showAndWait().get() == ButtonType.OK) {
            stage = (Stage) ((Node) ev.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    public void openAddSecurity() throws IOException {
        Scene4Controller scene4Controller = new Scene4Controller();
        scene4Controller.addSecurity();
    }

    public void viewSchedule(javafx.event.ActionEvent ev) throws IOException {
        Scene3Controller scene3Controller = new Scene3Controller();
        scene3Controller.viewSchedule();
    }

    public void calSalary() {
        manager.calculateSalary();
        securityTable.refresh();
    }

    public void save(javafx.event.ActionEvent ev) throws IOException {
//        myDao.saveListSecurityAsChar(manager.securityList);
//        myDao.saveListSecurityAsByte(manager.securityList);
//        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle("Save");
//        alert.setContentText("Successful");
//        try {
//            if (alert.showAndWait().get() == ButtonType.OK) {
//                alert.close();
//            }
//        } catch (NoSuchElementException ignored){}
        this.manager.securityList = myDao.readListSecurityAsByte();
        ObservableList<Security> list = FXCollections.observableArrayList(manager.securityList);
        securityTable.setItems(list);
        securityTable.refresh();
    }

    //Search Alg
    private Predicate<Security> createPredicate(String searchText){
        return security -> {
            if (searchText == null || searchText.isEmpty()) return true;
            return search(security, searchText);
        };
    }
    private boolean search(Security security, String searchText){
        return (security.getSecurityID().toLowerCase().contains(searchText.toLowerCase())) ||
                (security.getFullName().toLowerCase().contains(searchText.toLowerCase())) ||
                (security.getGender().equalsIgnoreCase(searchText)) ||
                (Long.valueOf((long)security.getSalary()).toString().equals(searchText.toLowerCase()));
    }
    public void doSearch(javafx.event.ActionEvent ev) throws IOException{
        securityTable.setItems(filteredData);
        searchBar.textProperty().addListener((observable, oldValue, newValue) ->
                filteredData.setPredicate(createPredicate(newValue)));

    }
    //end of Search Alg


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        securityID.setCellValueFactory(new PropertyValueFactory<Security, String>("securityID"));
        securityName.setCellValueFactory(new PropertyValueFactory<Security, String>("fullName"));
        securityGender.setCellValueFactory(new PropertyValueFactory<Security, String>("gender"));
        salary.setCellValueFactory(new PropertyValueFactory<Security, Double>("salary"));
        securityTable.setItems(list);
    }


}

