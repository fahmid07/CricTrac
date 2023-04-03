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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class MenuController implements Initializable {

    @FXML
    private AnchorPane menuPane;
    @FXML
    private Button menubutton;
    @FXML
    private Label welcome;
     
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            welcome.setText("Welcome, " + CricTrack.usernAme);
            
            // SELECT `teamName` FROM `rbb16`
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crictrack", "root", "");
            Statement stat = con.createStatement();
            String query = "SELECT `teamName` FROM `" + CricTrack.usernAme + "`";
            ResultSet rs = stat.executeQuery(query);
            CricTrack.teams.clear();
            while(rs.next()){
                String t = rs.getString("teamName");
                CricTrack.teams.add(t);
            }
            stat.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void matchbt(ActionEvent event) throws IOException {
        Parent window1;
        window1 = FXMLLoader.load(getClass().getResource("newMatch.fxml"));

        Stage mainStage;
        mainStage = CricTrack.parentWindow;
        mainStage.getScene().setRoot(window1);
    }

    @FXML
    private void historybt(ActionEvent event) throws IOException {
        Parent window1;
        window1 = FXMLLoader.load(getClass().getResource("matchHistory.fxml"));

        Stage mainStage;
        mainStage = CricTrack.parentWindow;
        mainStage.getScene().setRoot(window1);
    }

    @FXML
    private void teambt(ActionEvent event) throws IOException {
        Parent window1;
        window1 = FXMLLoader.load(getClass().getResource("teamsetting.fxml"));

        Stage mainStage;
        mainStage = CricTrack.parentWindow;
        mainStage.getScene().setRoot(window1);
    }

    @FXML
    private void settingbt(ActionEvent event) throws IOException {
        Parent window1;
        window1 = FXMLLoader.load(getClass().getResource("settings.fxml"));

        Stage mainStage;
        mainStage = CricTrack.parentWindow;
        mainStage.getScene().setRoot(window1);
    }

    @FXML
    private void usbt(ActionEvent event) throws IOException {
        Parent window1;
        window1 = FXMLLoader.load(getClass().getResource("About.fxml"));

        Stage mainStage;
        mainStage = CricTrack.parentWindow;
        mainStage.getScene().setRoot(window1);
    }

    @FXML
    private void logoutbt(ActionEvent event) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
//        menuPane.getChildren().setAll(root);

          Parent window1;
          window1 = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

          Stage mainStage;
          mainStage = CricTrack.parentWindow;
          mainStage.getScene().setRoot(window1);
    }
    
}
