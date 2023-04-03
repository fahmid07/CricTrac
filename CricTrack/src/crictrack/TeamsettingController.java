/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crictrack;

import static crictrack.NewMatchController.isImported1;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class TeamsettingController implements Initializable {

    @FXML
    private ComboBox<String> teamlist;
    @FXML
    private TextField t1p1;
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
    private TextField t1p12;
    @FXML
    private TextField t1p13;
    @FXML
    private TextField team;
    @FXML
    private Label selectWarning;
    @FXML
    private TextField t1p11;
    ObservableList<String> _teamList = FXCollections.observableArrayList(CricTrack.teams);
    //teamlist.setItems(_teamList);
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //ObservableList<String> _teamList = FXCollections.observableArrayList(CricTrack.teams);
        teamlist.getItems().clear();
        teamlist.setItems(_teamList);
    }    

    @FXML
    private void importBt(ActionEvent event) throws SQLException {
        String str = teamlist.getValue();
        if(!str.equals("") && !str.equals("Select Team")){
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crictrack", "root", "");
                Statement stat = con.createStatement();
                String query = "SELECT `captain`, `player1`, `player2`, `player3`, `player4`, `player5`, `player6`, `player7`, `player8`, `player9`, `player10`, `player11`, `player12`, `teamFull` FROM `" + CricTrack.usernAme + "` WHERE `teamname` = '" + str + "'";
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
                team.setText(rs.getString("teamFull"));
                
                stat.close();
                con.close();
        }
        else{
            selectWarning.setText("Team name can not be empty");
        }
    }

    @FXML
    private void backBt(ActionEvent event) throws IOException {
        Parent window1;
        window1 = FXMLLoader.load(getClass().getResource("menu.fxml"));

        Stage mainStage;
        mainStage = CricTrack.parentWindow;
        mainStage.getScene().setRoot(window1);
    }

    @FXML
    private void updateBt(ActionEvent event) throws SQLException {
        String str = teamlist.getValue();
        if(!(str==null) && !str.equals("") && !str.equals("Select Team")){
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
            if(team.getText().equals("")) t1p13.setText("null");
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crictrack", "root", "");
            Statement stat = con.createStatement();
//                String query1 = NewMatchController._team1 + "','" + t1p1.getText() + "' , '" + t1p2.getText() + "' , '" + t1p3.getText() + "' , '" + t1p4.getText() + "' , '" + t1p5.getText() + "' , '" + t1p6.getText() + "' , '" + t1p7.getText() + "' , '" + t1p8.getText() + "' , '";
//            String query2 =  t1p9.getText() + "' , '" + t1p10.getText() + "' , '" + t1p11.getText() + "' , '" + t1p12.getText() + "' , '" + t1p13.getText() + "',0,0) ";
                String query = "UPDATE `" + CricTrack.usernAme + "` SET `captain`='" + t1p1.getText() + "',`player1`='" + t1p2.getText() + "',`player2`='" + t1p3.getText() + "',`player3`='" + t1p4.getText() + "',`player4`='" + t1p5.getText() + "',`player5`='" + t1p6.getText() + "',`player6`='" + t1p7.getText() + "',`player7`='" + t1p8.getText() + "',`player8`='" + t1p9.getText() +"',`player9`='" + t1p10.getText() + "',`player10`='" + t1p11.getText() + "',`player11`='" + t1p12.getText() + "',`player12`='" + t1p13.getText() + "'" + ",`teamFull`='" + team.getText() + "'" + " WHERE `teamName` = '" + str + "'";
                // String query = "SELECT `captain`, `player1`, `player2`, `player3`, `player4`, `player5`, `player6`, `player7`, `player8`, `player9`, `player10`, `player11`, `player12` FROM `" + CricTrack.usernAme + "` WHERE `teamname` = '" + NewMatchController._team1 + "'";
                stat.executeUpdate(query);

                stat.close();
                con.close();
        }
        else selectWarning.setText("Team name can not be empty");
    }
    
}
