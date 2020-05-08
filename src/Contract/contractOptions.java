package Contract;

import connectivity.ConnectionClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;

public class contractOptions {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;



    @FXML private TextField coid1;
    @FXML private TextField coid;
    @FXML private TextField coname;
    @FXML private TextField codes;
    @FXML private DatePicker cdate;
    @FXML private TextField cojob;
    @FXML private TextField cojob1;
    @FXML private TextField proj_id;

    @FXML private TextField contractID;
    @FXML private Label load;

    final ObservableList options = FXCollections.observableArrayList();


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

    public void addContract(ActionEvent event)  {


        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();

        String sql = "INSERT INTO contract (`contractID`, `contractName`,`contractDescription`,`creationDate`,`jobType`,`customerID`,`projectLeader`) VALUES ('"
                + coid.getText() + "', '" + coname.getText() + "', '"+ codes.getText() + "', '"+ cdate.getValue()+ "', '"+ cojob.getText() +"','"+ cojob1.getText()+"', '"+ proj_id.getText() + "');";

        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ps.executeUpdate(sql);
        } catch (SQLException e) {
            alertMsg("Foreign Key Constraint Enter Correct ID's For Customer & Employee");
            e.printStackTrace();
        }
        infoMsg("Successfully Added Contract");

    }

    public void mainpage1(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../Contract/contract.fxml"));
        Scene scene = new Scene(root,1188,851);
        scene.getStylesheets().add(getClass().getResource("../Owner/main.css").toExternalForm());
        primaryStage.setTitle("Innovative - e | Innovative - e ");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void deleteContract(ActionEvent event){
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();

        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql = "DELETE FROM contract WHERE contractID = "+contractID.getText();
        try {
            statement.executeUpdate(sql);
            infoMsg("Successfully Deleted Contract");
        } catch (SQLException e) {
            alertMsg("Contract ID not in Database | Please Input The correct ID");
            e.printStackTrace();
        }
    }
    public void updateSearch(ActionEvent event){
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
        ResultSet rs = null;
        try {
            rs = connection.createStatement().executeQuery("SELECT * FROM contract WHERE contractID = "+coid1.getText());
        } catch (SQLException e) {
            alertMsg("ID not in Database");
            e.printStackTrace();
        }

        String ID = "contractID";
        String name = "contractName";
        String des = "contractDescription";
        String date = "creationDate";
        String jobType = "jobType";
        String cusID = "customerID";
        String proj = "projectLeader";


        try{
            if (rs.next()){
                coid.setText(rs.getString(ID));
                coname.setText(rs.getString(name));
                codes.setText(rs.getString(des));
                cdate.setValue(LocalDate.parse(rs.getString("creationDate")));
                cojob.setText(rs.getString(jobType));
                cojob1.setText(rs.getString(cusID));
                proj_id.setText(rs.getString(proj));


            }else{
                alertMsg("Inavalid ID Given");
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

    }
    public void updateContract(ActionEvent event)  {
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();

        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql = "UPDATE `contract` SET `contractID`="+"'"+coid.getText()+"'"+",`contractName`="+"'"+coname.getText()+"'"+",`contractDescription`="+"'"+codes.getText()+"'"+",`creationDate`="+"'"+cdate.getValue()+"'"+",`jobType`="+"'"+cojob.getText()+"'"+",`customerID`="+"'"+cojob1.getText()+"'"+",`projectLeader`="+"'"+proj_id.getText()+"'"+"WHERE contractID = "+coid1.getText();
        try {
            statement.executeUpdate(sql);
            infoMsg("Successfully Updated Contract");
        } catch (SQLException e) {
            alertMsg("Foreign Key Constraints");
            e.printStackTrace();
        }
    }


}
