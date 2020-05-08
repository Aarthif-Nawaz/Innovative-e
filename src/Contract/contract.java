package Contract;


import com.sun.javafx.collections.ObservableListWrapper;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class contract implements Initializable {

    @FXML private TextField con_search;
    @FXML private TableView<ModelTable> table;
    @FXML private TableColumn<ModelTable, String> tableid;
    @FXML private TableColumn<ModelTable, String> tablename;
    @FXML private TableColumn<ModelTable, String> tabledob;
    @FXML private TableColumn<ModelTable, String> tableemail;
    @FXML private TableColumn<ModelTable, String> tabletp;
    @FXML private TableColumn<ModelTable, String> tableres;
    @FXML private TableColumn<ModelTable, String> tableproj;

    ObservableList<ModelTable> oblist = FXCollections.observableArrayList();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
        try {
            ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM contract");
            while (rs.next()) {
                oblist.add(new ModelTable(rs.getString("contractID"), rs.getString("contractName"), rs.getString("contractDescription"), rs.getString("creationDate"), rs.getString("jobType"), rs.getString("customerID"), rs.getString("projectLeader")));
            }
            tableid.setCellValueFactory(new PropertyValueFactory<>("id"));
            tablename.setCellValueFactory(new PropertyValueFactory<>("name"));
            tabledob.setCellValueFactory(new PropertyValueFactory<>("dob"));
            tableemail.setCellValueFactory(new PropertyValueFactory<>("email"));
            tabletp.setCellValueFactory(new PropertyValueFactory<>("tel"));
            tableres.setCellValueFactory(new PropertyValueFactory<>("res"));
            tableproj.setCellValueFactory(new PropertyValueFactory<>("proj"));

            table.setItems(oblist);
        } catch (SQLException e) {
            e.printStackTrace();
        }

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
    public void add_contract(ActionEvent event) throws IOException{
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../Contract/AddContract.fxml"));
        Scene scene = new Scene(root,600,597);
        scene.getStylesheets().add(getClass().getResource("contract.css").toExternalForm());
        primaryStage.setTitle("Innovative - e | Add Contract ");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public void delete_contract(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../Contract/DeleteContract.fxml"));
        Scene scene = new Scene(root,600,400);
        scene.getStylesheets().add(getClass().getResource("contract.css").toExternalForm());
        primaryStage.setTitle("Innovative - e | Delete Contract ");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public void update_contract(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../Contract/UpdateContract.fxml"));
        Scene scene = new Scene(root,1093,811);
        scene.getStylesheets().add(getClass().getResource("contract.css").toExternalForm());
        primaryStage.setTitle("Innovative - e | Update Contract ");
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
            ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM contract");
            while (rs.next()) {
                oblist.add(new ModelTable(rs.getString("contractID"), rs.getString("contractName"), rs.getString("contractDescription"), rs.getString("creationDate"), rs.getString("jobType"), rs.getString("customerID"), rs.getString("projectLeader")));
            }
            tableid.setCellValueFactory(new PropertyValueFactory<>("id"));
            tablename.setCellValueFactory(new PropertyValueFactory<>("name"));
            tabledob.setCellValueFactory(new PropertyValueFactory<>("dob"));
            tableemail.setCellValueFactory(new PropertyValueFactory<>("email"));
            tabletp.setCellValueFactory(new PropertyValueFactory<>("tel"));
            tableres.setCellValueFactory(new PropertyValueFactory<>("res"));
            tableproj.setCellValueFactory(new PropertyValueFactory<>("proj"));

            table.setItems(oblist);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void searchContract(ActionEvent event) throws SQLException {
        oblist.clear();
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();

        ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM contract WHERE contractID = " + con_search.getText());
        while (rs.next()){
            oblist.add(new ModelTable(rs.getString("contractID"), rs.getString("contractName"), rs.getString("contractDescription"),rs.getString("creationDate"),rs.getString("jobType"),rs.getString("customerID"),rs.getString("projectLeader")));

        }
        tableid.setCellValueFactory(new PropertyValueFactory<>("id"));
        tablename.setCellValueFactory(new PropertyValueFactory<>("name"));
        tabledob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        tableemail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tabletp.setCellValueFactory(new PropertyValueFactory<>("tel"));
        tableres.setCellValueFactory(new PropertyValueFactory<>("res"));
        tableproj.setCellValueFactory(new PropertyValueFactory<>("proj"));

        table.setItems(oblist);

    }


}
