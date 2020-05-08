package Customer;

import Contract.ModelTable;
import Customer.ModelTable1;
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

public class customer implements Initializable {
    @FXML private TextField cus_search;
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
            ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM customer");
            while (rs.next()) {
                oblist.add(new ModelTable1(rs.getString("customerID"), rs.getString("customerName"), rs.getString("customerDOB"), rs.getString("customerEmail"), rs.getString("customerTelephoneNumber"), rs.getString("customerResidentialAddress")));
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


    public void add_customer(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../Customer/AddCustomer.fxml"));
        Scene scene = new Scene(root,694,613);
        scene.getStylesheets().add(getClass().getResource("customer.css").toExternalForm());
        primaryStage.setTitle("Innovative - e | Add Customer ");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public void delete_customer(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../Customer/DeleteCustomer.fxml"));
        Scene scene = new Scene(root,600,400);
        scene.getStylesheets().add(getClass().getResource("customer.css").toExternalForm());
        primaryStage.setTitle("Innovative - e | Delete Customer ");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public void update_customer(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../Customer/UpdateCustomer.fxml"));
        Scene scene = new Scene(root,1183,857);
        scene.getStylesheets().add(getClass().getResource("customer.css").toExternalForm());
        primaryStage.setTitle("Innovative - e | Update Customer ");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public void add_contract1(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../Contract/AddContract.fxml"));
        Scene scene = new Scene(root,600,597);
        scene.getStylesheets().add(getClass().getResource("../Contract/contract.css").toExternalForm());
        primaryStage.setTitle("Innovative - e | Add Contract ");
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
    public void refresh(ActionEvent event){
        oblist.clear();
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();

        try {
            ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM customer");
            while (rs.next()) {
                oblist.add(new ModelTable1(rs.getString("customerID"), rs.getString("customerName"), rs.getString("customerDOB"), rs.getString("customerEmail"), rs.getString("customerTelephoneNumber"), rs.getString("customerResidentialAddress")));
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
    public void searchCustomer(ActionEvent event) throws SQLException {
        oblist.clear();
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();

        ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM customer WHERE customerID = " + cus_search.getText());
        while (rs.next()){
            oblist.add(new ModelTable1(rs.getString("customerID"), rs.getString("customerName"), rs.getString("customerDOB"),rs.getString("customerEmail"),rs.getString("customerTelephoneNumber"),rs.getString("customerResidentialAddress")));

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
