package Employee;

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

public class employeeOptions {
    public void alertMsg(String Message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText(Message);
        alert.showAndWait();
    }

    public void infoMsg(String Message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(Message);
        alert.showAndWait();
    }

    public void loadWindow(String location, String title) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(location));
        Scene scene = new Scene(root);
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();
    }

    @FXML
    private TextField id;
    @FXML
    private TextField ename;
    @FXML
    private DatePicker edob;
    @FXML
    private TextField eemail;
    @FXML
    private TextField etel;
    @FXML
    private TextField eres;

    @FXML
    private TextField employeeID;
    @FXML private TextField search;


    public void mainpage1(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../Employee/employee.fxml"));
        Scene scene = new Scene(root, 1188, 851);
        scene.getStylesheets().add(getClass().getResource("../Owner/main.css").toExternalForm());
        primaryStage.setTitle("Innovative - e | Employee ");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void addEmployee(ActionEvent event)  {
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();


        String sql = "INSERT INTO employee (`EmployeeID`, `EmployeeName`,`employeeDOB`,`employeeEmail`,`employeeTelephoneNumber`,`employeeResidentialAddress`) VALUES ('"
                + id.getText() + "', '" + ename.getText() + "', '" + edob.getValue() + "', '" + eemail.getText() + "', '" + etel.getText() + "', '"
                + eres.getText() + "');";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ps.executeUpdate(sql);
        } catch (SQLException e) {
            alertMsg("Cant Insert Values due to wrong datatype value ");

        }
        infoMsg("Successfully Added Employee");

    }

    public void deleteEmployee(ActionEvent event) {
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();

        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql = "DELETE FROM employee WHERE employeeID = "+employeeID.getText();
        try {
            statement.executeUpdate(sql);
            infoMsg("Successfully Deleted Employee");
        } catch (SQLException e) {
            alertMsg("Employee ID not in Database | Please Input The correct ID");

        }
    }
    public void searchEmployee(ActionEvent event)  {
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
        ResultSet rs = null;
        try {
            rs = connection.createStatement().executeQuery("SELECT * FROM employee WHERE employeeID = "+search.getText());
        } catch (SQLException e) {
            alertMsg("ID Not in Database");

        }

        String ID = "employeeID";
        String name = "employeeName";
        String dob = "employeeDOB";
        String email = "employeeEmail";
        String tel = "employeeTelephoneNumber";
        String res = "employeeResidentialAddress";



        try{
            if (rs.next()){
                id.setText(rs.getString(ID));
                ename.setText(rs.getString(name));
                edob.setValue(LocalDate.parse(rs.getString("employeeDOB")));
                eemail.setText(rs.getString(email));
                etel.setText(rs.getString(tel));
                eres.setText(rs.getString(res));


            }else{
                alertMsg("Inavalid ID Given");
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void updateEmployee(ActionEvent event){
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();

        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql = "UPDATE `employee` SET `employeeID`="+"'"+id.getText()+"'"+",`employeeName`="+"'"+ename.getText()+"'"+",`employeeDOB`="+"'"+edob.getValue()+"'"+",`employeeEmail`="+"'"+eemail.getText()+"'"+",`employeeTelephoneNumber`="+"'"+etel.getText()+"'"+",`employeeResidentialAddress`="+"'"+eres.getText()+"'"+"WHERE employeeID = "+search.getText();
        try {
            statement.executeUpdate(sql);
            infoMsg("Successfully Updated Employee");
        } catch (SQLException e) {
            alertMsg("Foreign Key Constraints");
            e.printStackTrace();
        }
    }
}
