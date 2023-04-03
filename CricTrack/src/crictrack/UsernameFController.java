/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crictrack;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class UsernameFController implements Initializable {

    @FXML
    private TextField username;
    @FXML
    private Label warning;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void submit(ActionEvent event) throws SQLException, IOException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crictrack", "root", "");
        Statement stat = con.createStatement();
        String query = "SELECT `User Name` FROM `userinfo` WHERE `User Name`='";
        query += username.getText();
        query += "'";
        ResultSet rs = stat.executeQuery(query);
        if(rs.next() == false) warning.setText("Wrong Username");
        else{
            stat.close();
            con.close();
            
            CricTrack.usernAme = username.getText();
            
            Parent window1;
            window1 = FXMLLoader.load(getClass().getResource("forgot.fxml"));

            Stage mainStage;
            mainStage = CricTrack.parentWindow;
            mainStage.getScene().setRoot(window1);
        }
    }

    @FXML
    private void cancel(ActionEvent event) throws IOException {
        Parent window1;
        window1 = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

        Stage mainStage;
        mainStage = CricTrack.parentWindow;
        mainStage.getScene().setRoot(window1);
    }
    
}
