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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class SettingsController implements Initializable {

    @FXML
    private TextField email;
    @FXML
    private TextField phone;
    @FXML
    private TextField name;
    @FXML
    private Label nameW;
    @FXML
    private Label emailW;

    ArrayList<String> emails = new ArrayList<>();
    ArrayList<String> phones = new ArrayList<>();
    @FXML
    private Label phoneW;
    @FXML
    private Label finalAlert;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            try {
                // TODO
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crictrack", "root", "");
                Statement stat = con.createStatement();
                String query = "SELECT `Email`,`Phone` FROM `userinfo` WHERE `User Name`!='" + CricTrack.usernAme + "'";
                ResultSet rs = stat.executeQuery(query);
                
                
                while(rs.next()){
                    emails.add(rs.getString("Email"));
                    phones.add(rs.getString("Phone"));
                }
                
                stat.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(SettingsController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/crictrack", "root", "");
            Statement statt = conn.createStatement();
            
            String query1 = "SELECT `Name`,`Email`,`Phone` FROM `userinfo` WHERE `User Name`='" + CricTrack.usernAme + "'";
            ResultSet rs1 = statt.executeQuery(query1);
            
            rs1.next();
            
            name.setText(rs1.getString("Name"));
            email.setText(rs1.getString("Email"));
            phone.setText(rs1.getString("Phone"));
            
            statt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SettingsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void update(ActionEvent event) throws SQLException {
        //UPDATE `userinfo` SET `Name`='',`Email`='',`Phone`=''
        //UPDATE `userinfo` SET `Name`='',`Email`='',`Phone`='' WHERE `User Name`='fahmid'
        int flag1 = 1, flag4 = 1, flag5 = 1;
        
        String str = email.getText();
        for(String st:emails){
            if(st.equals(str) || str.length() > 45){
                flag1 = 0;
                break;
            }
        }
        
        
        
        str = phone.getText();
        for(String st:phones){
            if(st.equals(str) || st.length()>11){
                flag4 = 0;
                break;
            }
        }
        
        str = name.getText();
        if(str.length() > 95) flag5 = 0;
        
        
        if(!name.getText().equals("") && !email.getText().equals("") && !phone.getText().equals("")){
            int flag = flag1* flag4 * flag5;
            if(flag == 1){
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crictrack", "root", "");
                    Statement stat = con.createStatement();
                    
                    String query = "UPDATE `userinfo` SET `Name`='" + name.getText() + "',`Email`='" + email.getText() + "',`Phone`='" + phone.getText() + "' WHERE `User Name`='" + CricTrack.usernAme + "'";
                    stat.executeUpdate(query);
                    
                    stat.close();
                    con.close();
            }
        }
        else finalAlert.setText("No field can not be empty");
    }

    @FXML
    private void back(ActionEvent event) throws IOException {
        Parent window1;
        window1 = FXMLLoader.load(getClass().getResource("menu.fxml"));

        Stage mainStage;
        mainStage = CricTrack.parentWindow;
        mainStage.getScene().setRoot(window1);
    }

    @FXML
    private void emailR(KeyEvent event) {
        String str = email.getText();
        for(String st:emails){
            if(st.equals(str)){
                emailW.setText("Email already used");
                break;
            }
            else if(str.length() > 45) emailW.setText("Email length can not be more than 45");
            else emailW.setText("");
        }
    }

    @FXML
    private void phoneR(KeyEvent event) {
        String str = phone.getText();
        for(String st:phones){
            if(st.equals(str)){
                phoneW.setText("Phone already used");
                break;
            }
            else if(str.length()!=11) phoneW.setText("Number must contain 11 digit");
            else phoneW.setText("");
        }
    }

    @FXML
    private void nameR(KeyEvent event) {
        String str = name.getText();
        
        if(str.length() > 95) nameW.setText("Name length can not be more than 95");
        else nameW.setText("");
    }
    
}
