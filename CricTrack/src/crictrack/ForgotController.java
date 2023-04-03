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
public class ForgotController implements Initializable {

    @FXML
    private TextField newP;
    @FXML
    private TextField retype;
    @FXML
    private TextField email;
    @FXML
    private TextField phone;
    String em, ph;
    @FXML
    private Label newpassAlert;
    @FXML
    private Label passAlert2;
    @FXML
    private Label finalAlert;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crictrack", "root", "");
            Statement stat = con.createStatement();
            String query = "SELECT `Email`,`Phone` FROM `userinfo` WHERE `User Name`='" + CricTrack.usernAme + "'";
            ResultSet rs = stat.executeQuery(query);
            
            rs.next();
            em = rs.getString("Email");
            ph = rs.getString("Phone");
            
            stat.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ForgotController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void newPR(KeyEvent event) {
        String str = newP.getText();
        
        if(str.length() > 15) newpassAlert.setText("Password size can not be more than 15");
        else newpassAlert.setText("");
    }

    @FXML
    private void retypeR(KeyEvent event) {
        String str = retype.getText();
        
        if(!str.equals(newP.getText())) passAlert2.setText("Password didn't match");
        else passAlert2.setText("");
    }

    @FXML
    private void update(ActionEvent event) throws SQLException, IOException {
        int flag1 = 1, flag2 = 1, flag3 = 1, flag, flag4 = 1;
        
        String str = newP.getText();
        
        if(str.length() > 15){
            newpassAlert.setText("Password size can not be more than 15");
            flag1 = 0;
        }
        else newpassAlert.setText("");
        
        str = retype.getText();
        
        if(!str.equals(newP.getText())){
            passAlert2.setText("Password didn't match");
            flag2 = 0;
        }
        else passAlert2.setText("");
        
        
        if(!email.getText().equals(em)){
            flag3 = 0;
            finalAlert.setText("Email or Phone didn't match");
        }
        else finalAlert.setText("");
        
        if(!phone.getText().equals(ph)){
            flag4 = 0;
            finalAlert.setText("Email or Phone didn't match");
        }
        else finalAlert.setText("");
        
        flag = flag1*flag2*flag3*flag4;
        
        if(flag==1){
            //UPDATE `userinfo` SET `Password`='' WHERE `User Name`=''
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crictrack", "root", "");
            Statement stat = con.createStatement();
                    
            String query = "UPDATE `userinfo` SET `Password`='" + newP.getText() + "' WHERE `User Name`='" + CricTrack.usernAme + "'";
            stat.executeUpdate(query);
                    
            stat.close();
            con.close();
            
            Parent window1;
            window1 = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

            Stage mainStage;
            mainStage = CricTrack.parentWindow;
            mainStage.getScene().setRoot(window1);
        }
        else finalAlert.setText("Email or Phone didn't match");
    }

    @FXML
    private void back(ActionEvent event) throws IOException {
        Parent window1;
        window1 = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

        Stage mainStage;
        mainStage = CricTrack.parentWindow;
        mainStage.getScene().setRoot(window1);
    }
    
}
