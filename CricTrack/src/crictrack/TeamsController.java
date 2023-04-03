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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class TeamsController implements Initializable {

    @FXML
    private Label team1Name;
    @FXML
    private Label team2Name;
    @FXML
    private TextField t1p2;
    @FXML
    private TextField t1p3;
    @FXML
    private TextField t1p4;
    @FXML
    private TextField t1p5;
    @FXML
    private TextField t1p6;
    @FXML
    private TextField t1p7;
    @FXML
    private TextField t1p8;
    @FXML
    private TextField t1p9;
    @FXML
    private TextField t1p10;
    @FXML
    private TextField t1p11;
    @FXML
    private TextField t1p12;
    @FXML
    private TextField t1p13;
    @FXML
    private TextField t1p1;
    @FXML
    private TextField t2p2;
    @FXML
    private TextField t2p3;
    @FXML
    private TextField t2p4;
    @FXML
    private TextField t2p5;
    @FXML
    private TextField t2p6;
    @FXML
    private TextField t2p7;
    @FXML
    private TextField t2p8;
    @FXML
    private TextField t2p9;
    @FXML
    private TextField t2p10;
    @FXML
    private TextField t2p11;
    @FXML
    private TextField t2p12;
    @FXML
    private TextField t2p13;
    @FXML
    private TextField t2p1;

    public static ArrayList<String> team1 = new ArrayList<>();
    public static ArrayList<String> team2 = new ArrayList<>();
    public static ArrayList<String> team1b = new ArrayList<>();
    public static ArrayList<String> team2b = new ArrayList<>();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        team1Name.setText(NewMatchController._team1);
        team2Name.setText(NewMatchController._team2);
        
        if(NewMatchController.isImported1 == 1){
            try {
                // SELECT `captain`, `player1`, `player2`, `player3`, `player4`, `player5`, `player6`, `player7`, `player8`, `player9`, `player10`, `player11`, `player12` FROM `rbb16` WHERE `teamname` = 'kkr'
                
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crictrack", "root", "");
                Statement stat = con.createStatement();
                String query = "SELECT `captain`, `player1`, `player2`, `player3`, `player4`, `player5`, `player6`, `player7`, `player8`, `player9`, `player10`, `player11`, `player12` FROM `" + CricTrack.usernAme + "` WHERE `teamname` = '" + NewMatchController._team1 + "'";
                ResultSet rs = stat.executeQuery(query);
                rs.next();
                
                t1p1.setText(rs.getString("captain"));
                t1p2.setText(rs.getString("player1"));
                t1p3.setText(rs.getString("player2"));
                t1p4.setText(rs.getString("player3"));
                t1p5.setText(rs.getString("player4"));
                t1p6.setText(rs.getString("player5"));
                t1p7.setText(rs.getString("player6"));
                t1p8.setText(rs.getString("player7"));
                t1p9.setText(rs.getString("player8"));
                t1p10.setText(rs.getString("player9"));
                t1p11.setText(rs.getString("player10"));
                t1p12.setText(rs.getString("player11"));
                t1p13.setText(rs.getString("player12"));
                t1p1.setDisable(true);
                t1p2.setDisable(true);
                t1p3.setDisable(true);
                t1p4.setDisable(true);
                t1p5.setDisable(true);
                t1p6.setDisable(true);
                t1p7.setDisable(true);
                t1p8.setDisable(true);
                t1p9.setDisable(true);
                t1p10.setDisable(true);
                t1p11.setDisable(true);
                t1p12.setDisable(true);
                t1p13.setDisable(true);
                
                team1.add(t1p1.getText());
                team1.add(t1p2.getText());
                team1.add(t1p3.getText());
                team1.add(t1p4.getText());
                team1.add(t1p5.getText());
                team1.add(t1p6.getText());
                team1.add(t1p7.getText());
                team1.add(t1p8.getText());
                team1.add(t1p9.getText());
                team1.add(t1p10.getText());
                team1.add(t1p11.getText());
                team1.add(t1p12.getText());
                team1.add(t1p13.getText());
                
                team1b = team1;
                stat.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(TeamsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            t1p1.setText("captain");
            t1p2.setText("dummy2");
            t1p3.setText("dummy3");
            t1p4.setText("dummy4");
            t1p5.setText("dummy5");
            t1p6.setText("dummy6");
            t1p7.setText("dummy7");
            t1p8.setText("dummy8");
            t1p9.setText("dummy9");
            t1p10.setText("dummy10");
            t1p11.setText("dummy11");
            t1p12.setText("dummy12");
            t1p13.setText("dummy13");
            t1p1.setDisable(false);
            t1p2.setDisable(false);
            t1p3.setDisable(false);
            t1p4.setDisable(false);
            t1p5.setDisable(false);
            t1p6.setDisable(false);
            t1p7.setDisable(false);
            t1p8.setDisable(false);
            t1p9.setDisable(false);
            t1p10.setDisable(false);
            t1p11.setDisable(false);
            t1p12.setDisable(false);
            t1p13.setDisable(false);
        }
        
        if(NewMatchController.isImported2 == 1){
            
            try {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crictrack", "root", "");
                Statement stat = con.createStatement();
                String query = "SELECT `captain`, `player1`, `player2`, `player3`, `player4`, `player5`, `player6`, `player7`, `player8`, `player9`, `player10`, `player11`, `player12` FROM `" + CricTrack.usernAme + "` WHERE `teamname` = '" + NewMatchController._team2 + "'";
                ResultSet rs = stat.executeQuery(query);
                rs.next();
                
                t2p1.setText(rs.getString("captain"));
                t2p2.setText(rs.getString("player1"));
                t2p3.setText(rs.getString("player2"));
                t2p4.setText(rs.getString("player3"));
                t2p5.setText(rs.getString("player4"));
                t2p6.setText(rs.getString("player5"));
                t2p7.setText(rs.getString("player6"));
                t2p8.setText(rs.getString("player7"));
                t2p9.setText(rs.getString("player8"));
                t2p10.setText(rs.getString("player9"));
                t2p11.setText(rs.getString("player10"));
                t2p12.setText(rs.getString("player11"));
                t2p13.setText(rs.getString("player12"));
                t2p1.setDisable(true);
                t2p2.setDisable(true);
                t2p3.setDisable(true);
                t2p4.setDisable(true);
                t2p5.setDisable(true);
                t2p6.setDisable(true);
                t2p7.setDisable(true);
                t2p8.setDisable(true);
                t2p9.setDisable(true);
                t2p10.setDisable(true);
                t2p11.setDisable(true);
                t2p12.setDisable(true);
                t2p13.setDisable(true);
                
                team2.add(t2p1.getText());
                team2.add(t2p2.getText());
                team2.add(t2p3.getText());
                team2.add(t2p4.getText());
                team2.add(t2p5.getText());
                team2.add(t2p6.getText());
                team2.add(t2p7.getText());
                team2.add(t2p8.getText());
                team2.add(t2p9.getText());
                team2.add(t2p10.getText());
                team2.add(t2p11.getText());
                team2.add(t2p12.getText());
                team2.add(t2p13.getText());
                
                team2b = team2;
                
                stat.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(TeamsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            t2p1.setText("_captain");
            t2p2.setText("_dummy2");
            t2p3.setText("_dummy3");
            t2p4.setText("_dummy4");
            t2p5.setText("_dummy5");
            t2p6.setText("_dummy6");
            t2p7.setText("_dummy7");
            t2p8.setText("_dummy8");
            t2p9.setText("_dummy9");
            t2p10.setText("_dummy10");
            t2p11.setText("_dummy11");
            t2p12.setText("_dummy12");
            t2p13.setText("_dummy13");
            t2p1.setDisable(false);
            t2p2.setDisable(false);
            t2p3.setDisable(false);
            t2p4.setDisable(false);
            t2p5.setDisable(false);
            t2p6.setDisable(false);
            t2p7.setDisable(false);
            t2p8.setDisable(false);
            t2p9.setDisable(false);
            t2p10.setDisable(false);
            t2p11.setDisable(false);
            t2p12.setDisable(false);
            t2p13.setDisable(false);
        }
    }    

    @FXML
    private void mainMatchStart(ActionEvent event) throws SQLException, IOException {
        if(NewMatchController.isImported1 == 0){
            if(t1p1.getText().equals("")) t1p1.setText("captain");
            if(t1p2.getText().equals("")) t1p2.setText("dummy2");
            if(t1p3.getText().equals("")) t1p3.setText("dummy3");
            if(t1p4.getText().equals("")) t1p4.setText("dummy4");
            if(t1p5.getText().equals("")) t1p5.setText("dummy5");
            if(t1p6.getText().equals("")) t1p6.setText("dummy6");
            if(t1p7.getText().equals("")) t1p7.setText("dummy7");
            if(t1p8.getText().equals("")) t1p8.setText("dummy8");
            if(t1p9.getText().equals("")) t1p9.setText("dummy9");
            if(t1p10.getText().equals("")) t1p10.setText("dummy10");
            if(t1p11.getText().equals("")) t1p11.setText("dummy11");
            if(t1p12.getText().equals("")) t1p12.setText("dummy12");
            if(t1p13.getText().equals("")) t1p13.setText("dummy13");
            
                team1.add(t1p1.getText());
                team1.add(t1p2.getText());
                team1.add(t1p3.getText());
                team1.add(t1p4.getText());
                team1.add(t1p5.getText());
                team1.add(t1p6.getText());
                team1.add(t1p7.getText());
                team1.add(t1p8.getText());
                team1.add(t1p9.getText());
                team1.add(t1p10.getText());
                team1.add(t1p11.getText());
                team1.add(t1p12.getText());
                team1.add(t1p13.getText());
            
                team1b.add(t1p1.getText());
                team1b.add(t1p2.getText());
                team1b.add(t1p3.getText());
                team1b.add(t1p4.getText());
                team1b.add(t1p5.getText());
                team1b.add(t1p6.getText());
                team1b.add(t1p7.getText());
                team1b.add(t1p8.getText());
                team1b.add(t1p9.getText());
                team1b.add(t1p10.getText());
                team1b.add(t1p11.getText());
                team1b.add(t1p12.getText());
                team1b.add(t1p13.getText());
                
            String query = "INSERT INTO `" + CricTrack.usernAme +"`(`teamName`, `captain`, `player1`, `player2`, `player3`, `player4`, `player5`, `player6`, `player7`, `player8`, `player9`, `player10`, `player11`, `player12`, `matchWon`, `matchLost`) VALUES ('";
            String query1 = NewMatchController._team1 + "','" + t1p1.getText() + "' , '" + t1p2.getText() + "' , '" + t1p3.getText() + "' , '" + t1p4.getText() + "' , '" + t1p5.getText() + "' , '" + t1p6.getText() + "' , '" + t1p7.getText() + "' , '" + t1p8.getText() + "' , '";
            String query2 =  t1p9.getText() + "' , '" + t1p10.getText() + "' , '" + t1p11.getText() + "' , '" + t1p12.getText() + "' , '" + t1p13.getText() + "',0,0) ";
            query += query1;
            query += query2;
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crictrack", "root", "");
            Statement stat = con.createStatement();
            stat.executeUpdate(query);
                    
            stat.close();
            con.close();
        }
        
        if(NewMatchController.isImported2 == 0){
            if(t2p1.getText().equals("")) t2p1.setText("_captain");
            if(t2p2.getText().equals("")) t2p2.setText("_dummy2");
            if(t2p3.getText().equals("")) t2p3.setText("_dummy3");
            if(t2p4.getText().equals("")) t2p4.setText("_dummy4");
            if(t2p5.getText().equals("")) t2p5.setText("_dummy5");
            if(t2p6.getText().equals("")) t2p6.setText("_dummy6");
            if(t2p7.getText().equals("")) t2p7.setText("_dummy7");
            if(t2p8.getText().equals("")) t2p8.setText("_dummy8");
            if(t2p9.getText().equals("")) t2p9.setText("_dummy9");
            if(t2p10.getText().equals("")) t2p10.setText("_dummy10");
            if(t2p11.getText().equals("")) t2p11.setText("_dummy11");
            if(t2p12.getText().equals("")) t2p12.setText("_dummy12");
            if(t2p13.getText().equals("")) t2p13.setText("_dummy13");
            
            team2.add(t2p1.getText());
            team2.add(t2p2.getText());
            team2.add(t2p3.getText());
            team2.add(t2p4.getText());
            team2.add(t2p5.getText());
            team2.add(t2p6.getText());
            team2.add(t2p7.getText());
            team2.add(t2p8.getText());
            team2.add(t2p9.getText());
            team2.add(t2p10.getText());
            team2.add(t2p11.getText());
            team2.add(t2p12.getText());
            team2.add(t2p13.getText());
            
            team2b.add(t2p1.getText());
            team2b.add(t2p2.getText());
            team2b.add(t2p3.getText());
            team2b.add(t2p4.getText());
            team2b.add(t2p5.getText());
            team2b.add(t2p6.getText());
            team2b.add(t2p7.getText());
            team2b.add(t2p8.getText());
            team2b.add(t2p9.getText());
            team2b.add(t2p10.getText());
            team2b.add(t2p11.getText());
            team2b.add(t2p12.getText());
            team2b.add(t2p13.getText());
            
            String query = "INSERT INTO `" + CricTrack.usernAme +"`(`teamName`, `captain`, `player1`, `player2`, `player3`, `player4`, `player5`, `player6`, `player7`, `player8`, `player9`, `player10`, `player11`, `player12`, `matchWon`, `matchLost`) VALUES ('";
            String query1 = NewMatchController._team2 + "','" + t2p1.getText() + "' , '" + t2p2.getText() + "' , '" + t2p3.getText() + "' , '" + t2p4.getText() + "' , '" + t2p5.getText() + "' , '" + t2p6.getText() + "' , '" + t2p7.getText() + "' , '" + t2p8.getText() + "' , '";
            String query2 =  t2p9.getText() + "' , '" + t2p10.getText() + "' , '" + t2p11.getText() + "' , '" + t2p12.getText() + "' , '" + t2p13.getText() + "',0,0) ";
            query += query1;
            query += query2;
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crictrack", "root", "");
            Statement stat = con.createStatement();
            stat.executeUpdate(query);
                    
            stat.close();
            con.close();
        }
        
        Parent window1;
        window1 = FXMLLoader.load(getClass().getResource("innings1.fxml"));

        Stage mainStage;
        mainStage = CricTrack.parentWindow;
        mainStage.getScene().setRoot(window1);
        
    }

    @FXML
    private void cancelMatch(ActionEvent event) throws IOException {
        Parent window1;
        window1 = FXMLLoader.load(getClass().getResource("menu.fxml"));

        Stage mainStage;
        mainStage = CricTrack.parentWindow;
        mainStage.getScene().setRoot(window1);
        
    }
    
}
