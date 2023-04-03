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
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class SignUpController implements Initializable {

    @FXML
    private Button createbt;

    /**
     * Initializes the controller class.
     */
    ArrayList<String> users = new ArrayList<>();
    ArrayList<String> emails = new ArrayList<>();
    ArrayList<String> phones = new ArrayList<>();
    @FXML
    private TextField name;
    @FXML
    private TextField email;
    @FXML
    private TextField user;
    @FXML
    private TextField pass;
    @FXML
    private TextField phone;
    @FXML
    private Label userNameAlert;
    @FXML
    private Label emailAlert;
    @FXML
    private Label phoneAlert;
    @FXML
    private Label passAlert;
    @FXML
    private Label nameAlert;
    @FXML
    private Label finalAlert;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crictrack", "root", "");
            Statement stat = con.createStatement();
            String query = "SELECT `User Name`,`Email`,`Phone` FROM `userinfo`";
            ResultSet rs = stat.executeQuery(query);
            
            while(rs.next()){
                users.add(rs.getString("User Name"));
                emails.add(rs.getString("Email"));
                phones.add(rs.getString("Phone"));
            }
            
            stat.close();
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void createACbt(ActionEvent event) throws IOException {
        int flag1 = 1, flag2 = 1, flag3 = 1, flag4 = 1, flag5 = 1;
        
        String str = email.getText();
        for(String st:emails){
            if(st.equals(str) || str.length() > 45){
                flag1 = 0;
                break;
            }
        }
        
        str = user.getText();
        for(String st:users){
            if(st.equals(str) || str.length() > 12){
                flag2 = 0;
                break;
            }
        }
        
        str = pass.getText();
        if(str.length() > 15) flag3 = 0;
        
        str = phone.getText();
        for(String st:phones){
            if(st.equals(str) || st.length()>11){
                flag4 = 0;
                break;
            }
        }
        
        str = name.getText();
        if(str.length() > 95) flag5 = 0;
        
        
        if(!name.getText().equals("") && !email.getText().equals("") && !pass.getText().equals("") && !phone.getText().equals("") && !user.getText().equals("")){
            int flag = flag1 * flag2 * flag3 * flag4 * flag5;
            if(flag == 1){
                try {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crictrack", "root", "");
                    Statement stat = con.createStatement();
                    String query = "INSERT INTO `userinfo`(`Name`, `Email`, `User Name`, `Password`, `Phone`) VALUES ('" + name.getText() + "','" + email.getText() + "','" + user.getText() + "','" + pass.getText() + "','" + phone.getText() + "')";
                    stat.executeUpdate(query);
                    
                    String que = "CREATE TABLE " + user.getText() + " ( teamName varchar(100), captain varchar(100), player1 varchar(100), player2 varchar(100), player3 varchar(100), player4 varchar(100), player5 varchar(100), player6 varchar(100), player7 varchar(100), player8 varchar(100), player9 varchar(100), player10 varchar(100), player11 varchar(100), player12 varchar(100), matchWon int, matchLost int, teamFull varchar(1000));";
                    stat.executeUpdate(que);
                    
                    que = "CREATE TABLE " + user.getText() + "matches" + " ( teams varchar(1000), team1 varchar(1000), team2 varchar(1000), result varchar(1000) );";
                    stat.executeUpdate(que);
                    
                    stat.close();
                    con.close();
                    
                    
                    
                    Parent window1;
                    window1 = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

                    Stage mainStage;
                    mainStage = CricTrack.parentWindow;
                    mainStage.getScene().setRoot(window1);
                    
                } catch (SQLException ex) {
                    Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else finalAlert.setText("No field can not be empty");
        
    }

    @FXML
    private void emailType(KeyEvent event) {
        String str = email.getText();
        for(String st:emails){
            if(st.equals(str)){
                emailAlert.setText("Email already used");
                break;
            }
            else if(str.length() > 45) emailAlert.setText("Email length can not be more than 45");
            else emailAlert.setText("");
        }
    }

    @FXML
    private void userType(KeyEvent event) {
        String str = user.getText();
        for(String st:users){
            if(st.equals(str)){
                userNameAlert.setText("User already exists");
                break;
            }
            else if(str.length() > 12) userNameAlert.setText("username length can not be more than 12");
            else userNameAlert.setText("");
        }
    }

    @FXML
    private void passType(KeyEvent event) {
        String str = pass.getText();
        
        if(str.length() > 15) passAlert.setText("Password size can not be more than 15");
        else passAlert.setText("");
    }

    @FXML
    private void phonetype(KeyEvent event) {
        String str = phone.getText();
        for(String st:phones){
            if(st.equals(str)){
                phoneAlert.setText("Phone already used");
                break;
            }
            else if(str.length()!=11) phoneAlert.setText("Number must contain 11 digit");
            else phoneAlert.setText("");
        }
    }

    @FXML
    private void nameType(KeyEvent event) {
        String str = name.getText();
        
        if(str.length() > 95) nameAlert.setText("Name length can not be more than 95");
        else nameAlert.setText("");
    }

    @FXML
    private void cancelbt(ActionEvent event) throws IOException {
        Parent window1;
        window1 = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

        Stage mainStage;
        mainStage = CricTrack.parentWindow;
        mainStage.getScene().setRoot(window1);
        
    }
    
}
