package Employee;

import Employee.ModelTable1;
import connectivity.ConnectionClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class employee implements Initializable {
    @FXML private TextField emp_search;
    @FXML private TableView<ModelTable1> table;
    @FXML private TableColumn<ModelTable1, String> tableid;
    @FXML private TableColumn<ModelTable1, String> tablename;
    @FXML private TableColumn<ModelTable1, String> tabledob;
    @FXML private TableColumn<ModelTable1, String> tableemail;
    @FXML private TableColumn<ModelTable1, String> tabletp;
    @FXML private TableColumn<ModelTable1, String> tableres;

    ObservableList<ModelTable1> oblist = FXCollections.observableArrayList();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();

        try {
            ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM employee");
            while (rs.next()) {
                oblist.add(new ModelTable1(rs.getString("employeeID"), rs.getString("employeeName"), rs.getString("employeeDOB"), rs.getString("employeeEmail"), rs.getString("employeeTelephoneNumber"), rs.getString("employeeResidentialAddress")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        tableid.setCellValueFactory(new PropertyValueFactory<>("id"));
        tablename.setCellValueFactory(new PropertyValueFactory<>("name"));
        tabledob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        tableemail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tabletp.setCellValueFactory(new PropertyValueFactory<>("tel"));
        tableres.setCellValueFactory(new PropertyValueFactory<>("res"));

        table.setItems(oblist);
    }
    public void alertMsg(String Message){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText(Message);
        alert.showAndWait();
    }
    public void infoMsg(String Message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(Message);
        alert.showAndWait();
    }
    public void loadWindow(String location, String title) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource(location));
        Scene scene= new Scene(root);
        Stage stage= new Stage(StageStyle.DECORATED);
        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();
    }



    public void add_employee(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../Employee/AddEmployee.fxml"));
        Scene scene = new Scene(root,637,828);
        scene.getStylesheets().add(getClass().getResource("employee.css").toExternalForm());
        primaryStage.setTitle("Innovative - e | Add Employee ");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void delete_employee(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../Employee/DeleteEmployee.fxml"));
        Scene scene = new Scene(root,600,400);
        scene.getStylesheets().add(getClass().getResource("employee.css").toExternalForm());
        primaryStage.setTitle("Innovative - e | Delete Employee ");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public void update_employee(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../Employee/UpdateEmployee.fxml"));
        Scene scene = new Scene(root,1123,810);
        scene.getStylesheets().add(getClass().getResource("employee.css").toExternalForm());
        primaryStage.setTitle("Innovative - e | Update Employee ");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public void mainpage(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../Owner/main.fxml"));
        Scene scene = new Scene(root,601,682);
        scene.getStylesheets().add(getClass().getResource("../Login/login.css").toExternalForm());
        primaryStage.setTitle("Innovative - e | Innovative - e ");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public void refresh(ActionEvent event) {
        oblist.clear();
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();

        try {
            ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM employee");
            while (rs.next()) {
                oblist.add(new ModelTable1(rs.getString("employeeID"), rs.getString("employeeName"), rs.getString("employeeDOB"), rs.getString("employeeEmail"), rs.getString("employeeTelephoneNumber"), rs.getString("employeeResidentialAddress")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        tableid.setCellValueFactory(new PropertyValueFactory<>("id"));
        tablename.setCellValueFactory(new PropertyValueFactory<>("name"));
        tabledob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        tableemail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tabletp.setCellValueFactory(new PropertyValueFactory<>("tel"));
        tableres.setCellValueFactory(new PropertyValueFactory<>("res"));

        table.setItems(oblist);

    }
    public void searchEmployee(ActionEvent event){
        oblist.clear();
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();

        try {
            ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM employee WHERE employeeID = " + emp_search.getText());
            while (rs.next()) {
                oblist.add(new ModelTable1(rs.getString("employeeID"), rs.getString("employeeName"), rs.getString("employeeDOB"), rs.getString("employeeEmail"), rs.getString("employeeTelephoneNumber"), rs.getString("employeeResidentialAddress")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        tableid.setCellValueFactory(new PropertyValueFactory<>("id"));
        tablename.setCellValueFactory(new PropertyValueFactory<>("name"));
        tabledob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        tableemail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tabletp.setCellValueFactory(new PropertyValueFactory<>("tel"));
        tableres.setCellValueFactory(new PropertyValueFactory<>("res"));

        table.setItems(oblist);
    }





}
