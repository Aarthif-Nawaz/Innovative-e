package Login;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class login {
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
    @FXML private TextField user;
    @FXML private TextField pass;
    @FXML private Button sign;


    public void Button(ActionEvent event) throws IOException {
        String username  = user.getText();
        String password = pass.getText();

        if (username.equals("Aarthif")&& password.equals("1234")){
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../Owner/main.fxml"));
            Scene scene = new Scene(root,631,682);
            scene.getStylesheets().add(getClass().getResource("login.css").toExternalForm());
            primaryStage.setTitle("Innovative - e ");
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        else{
            alertMsg("You Have Provide Invalid Details when Logging in\n Please fill in the Correct Details");
        }
    }



}
