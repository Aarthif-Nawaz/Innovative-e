package Customer;

import connectivity.ConnectionClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;

public class customerOptions {
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
    @FXML private TextField search;
    @FXML
    private TextField cid;
    @FXML private TextField cname;
    @FXML private DatePicker cdob;
    @FXML private TextField cemail;
    @FXML private TextField ctel;
    @FXML private TextField cres;

    @FXML private TextField customerID;

    public void mainpage1(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../Customer/customer.fxml"));
        Scene scene = new Scene(root,1188,851);
        scene.getStylesheets().add(getClass().getResource("../Owner/main.css").toExternalForm());
        primaryStage.setTitle("Innovative - e | Innovative - e ");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public void addCustomer(ActionEvent event)  {
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();

        String sql = "INSERT INTO customer (`customerID`, `customerName`,`customerDOB`,`customerEmail`,`customerTelephoneNumber`,`customerResidentialAddress`) VALUES ('"
                + cid.getText() + "', '" + cname.getText() + "', '"+ cdob.getValue()  + "', '"+ cemail.getText() + "', '"+ ctel.getText() + "', '"
                + cres.getText() + "');";

        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ps.executeUpdate(sql);
        } catch (SQLException e) {
            alertMsg("Wrong Values for datatypes Inserted");

        }
        infoMsg("Successfully Added customer");
    }
    public void deleteCustomer(ActionEvent event){
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();

        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql = "DELETE FROM customer WHERE customerID = "+customerID.getText();
        try {
            statement.executeUpdate(sql);
            infoMsg("Successfully Deleted Customer");
        } catch (SQLException e) {
            alertMsg("Customer ID not in Database | Please Input The correct ID");

        }
    }
    public void searchCustomer(ActionEvent event)  {
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
        ResultSet rs = null;
        try {
            rs = connection.createStatement().executeQuery("SELECT * FROM customer WHERE customerID = "+search.getText());
        } catch (SQLException e) {
            alertMsg("ID Not in Database");

        }

        String ID = "customerID";
        String name = "customerName";
        String dob = "customerDOB";
        String email = "customerEmail";
        String tel = "customerTelephoneNumber";
        String res = "customerResidentialAddress";



        try{
            if (rs.next()){
                cid.setText(rs.getString(ID));
                cname.setText(rs.getString(name));
                cdob.setValue(LocalDate.parse(rs.getString("customerDOB")));
                cemail.setText(rs.getString(email));
                ctel.setText(rs.getString(tel));
                cres.setText(rs.getString(res));


            }else{
                alertMsg("Inavalid ID Given");
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void updateCustomer(ActionEvent event){
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();

        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql = "UPDATE `customer` SET `customerID`="+"'"+cid.getText()+"'"+",`customerName`="+"'"+cname.getText()+"'"+",`customerDOB`="+"'"+cdob.getValue()+"'"+",`customerEmail`="+"'"+cemail.getText()+"'"+",`customerTelephoneNumber`="+"'"+ctel.getText()+"'"+",`customerResidentialAddress`="+"'"+cres.getText()+"'"+"WHERE customerID = "+search.getText();
        try {
            statement.executeUpdate(sql);
            infoMsg("Sucessfully Updated Customer");
        } catch (SQLException e) {
            alertMsg("Foreign Key Constraints");

        }
    }


}
