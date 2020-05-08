package Login;

import com.sun.javafx.collections.ObservableListWrapper;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../Login/login.fxml"));
        Scene scene = new Scene(root,600,400);
        scene.getStylesheets().add(getClass().getResource("login.css").toExternalForm());
        primaryStage.setTitle("Innovative - e | Login ");
        primaryStage.setScene(scene);
        primaryStage.show();



    }
    public void OnClickLogin(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("signin.fxml"));
        Scene scene = new Scene(root,600,581);
        scene.getStylesheets().add(getClass().getResource("login.css").toExternalForm());
        primaryStage.setTitle("Innovative - e | Sign IN");
        primaryStage.setScene(scene);
        primaryStage.show();

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


    public static void main(String[] args) {
        launch(args);
    }
}
