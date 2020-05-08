package Owner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class owner {
    @FXML private Button customer;
    @FXML private Button employee;
    @FXML private Button contract;
    @FXML private Button role;

    public void OnClickCustomer (ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../Customer/customer.fxml"));
        Scene scene = new Scene(root,1188,851);
        scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
        primaryStage.setTitle("Innovative - e | Customer ");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void OnClickEmployee (ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../Employee/employee.fxml"));
        Scene scene = new Scene(root,1188,851);
        scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
        primaryStage.setTitle("Innovative - e | Employee ");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void OnClickContract (ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("..//Contract/contract.fxml"));
        Scene scene = new Scene(root,1188,851);
        scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
        primaryStage.setTitle("Innovative - e | Contract ");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void OnClickRole (ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../Role/role.fxml"));
        Scene scene = new Scene(root,1188,851);
        scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
        primaryStage.setTitle("Innovative - e | Role ");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
