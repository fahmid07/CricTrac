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
import static java.sql.JDBCType.NULL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
/**
 *
 * @author Asus
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Button button;
    @FXML
    private AnchorPane logInPane;
    @FXML
    private TextField usernameBox;
    @FXML
    private PasswordField passwordBox;
    @FXML
    private Label wrongAlert;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        wrongAlert.setText("Enter Username & Password");
        usernameBox.setText("");
        passwordBox.setText("");
    }    

    @FXML
    private void signInButtonAction(ActionEvent event) throws IOException, SQLException {
        /*Parent window1;
        window1 = FXMLLoader.load(getClass().getResource("menu.fxml"));

        Stage mainStage;
        mainStage = CricTrack.parentWindow;
        mainStage.getScene().setRoot(window1);*/
        //logInPane.getChildren().setAll(FXMLLoader.load("menu.fxml"));
        
        String userName = usernameBox.getText();
        String password = passwordBox.getText();
        if(userName.equals("") || password.equals("")) wrongAlert.setText("Wrong Username or Password");
        else{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crictrack", "root", "");
            Statement stat = con.createStatement();
            String query = "SELECT `User Name`,`Password` FROM `userinfo` WHERE `User Name`='";
            query += userName;
            query += "'";
            ResultSet rs = stat.executeQuery(query);
            if(rs.next() == false) wrongAlert.setText("Wrong Username or Password");
            else{
                String un = rs.getString("User Name");
                String pass = rs.getString("Password");

                if(un.equals(userName) && pass.equals(password)){
                    stat.close();
                    con.close();
                    CricTrack.usernAme = userName;

                    Parent window1;
                    window1 = FXMLLoader.load(getClass().getResource("menu.fxml"));

                    Stage mainStage;
                    mainStage = CricTrack.parentWindow;
                    mainStage.getScene().setRoot(window1);
//                    Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
//                    logInPane.getChildren().setAll(root);
                }
                else wrongAlert.setText("Wrong Username or Password");
            }
        }
        //Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
        //logInPane.getChildren().setAll(root);
    }
    
    @FXML
    private void signUpAction(ActionEvent event) throws IOException {
        Parent window1;
        window1 = FXMLLoader.load(getClass().getResource("signUp.fxml"));

        Stage mainStage;
        mainStage = CricTrack.parentWindow;
        mainStage.getScene().setRoot(window1);
    }

    @FXML
    private void forgot(ActionEvent event) throws IOException {
        Parent window1;
        window1 = FXMLLoader.load(getClass().getResource("usernameF.fxml"));

        Stage mainStage;
        mainStage = CricTrack.parentWindow;
        mainStage.getScene().setRoot(window1);
    }
    
}
