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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class MatchEndController implements Initializable {

    @FXML
    private Label t1vst2;
    @FXML
    private Label result;
    @FXML
    private Label team1N;
    @FXML
    private Label team2N;
    @FXML
    private Label t1run;
    @FXML
    private Label t1ov;
    @FXML
    private Label t2run;
    @FXML
    private Label t2ov;
    public static String rrs = null;
    public static String t1s = null;
    public static String t2s = null;
    public static String tn = null;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            int x  = Innings1Controller.totalBall/6;
            int y = Innings1Controller.totalBall % 6;
            double f = new Double(y);
            double d = f/10;
            double bb = x + d;
            bb = Double.parseDouble(String.format("%.2f", bb));
            t1ov.setText(Double.toString(bb) + " ov");
            t1run.setText(Integer.toString(Innings1Controller.totalRun) + " / " + Integer.toString(Innings1Controller.totalWicket));
            t1s = NewMatchController._team1 + " " + Integer.toString(Innings1Controller.totalRun) + " / " + Integer.toString(Innings1Controller.totalWicket);
            t1s += " ( " + bb + " ) ov";
            x  = Innings2Controller.totalBall/6;
            y = Innings2Controller.totalBall % 6;
            f = new Double(y);
            d = f/10;
            bb = x + d;
            bb = Double.parseDouble(String.format("%.2f", bb));
            t2ov.setText(Double.toString(bb) + " ov");
            t2run.setText(Integer.toString(Innings2Controller.totalRun) + " / " + Integer.toString(Innings2Controller.totalWicket));
            t2s = NewMatchController._team2 + " " + Integer.toString(Innings2Controller.totalRun) + " / " + Integer.toString(Innings2Controller.totalWicket);
            t2s += " ( " + bb + " ) ov";
            team1N.setText(NewMatchController._team1);
            team2N.setText(NewMatchController._team2);
            t1vst2.setText(NewMatchController._team1 + " vs " + NewMatchController._team2);
            tn = NewMatchController._team1 + " vs " + NewMatchController._team2;
            if(Innings2Controller.totalRun < Innings1Controller.totalRun){
                result.setText(NewMatchController._team1 + " won by " + Integer.toString(Innings1Controller.totalRun - Innings2Controller.totalRun) + " runs");
                rrs = NewMatchController._team1 + " won by " + Integer.toString(Innings1Controller.totalRun - Innings2Controller.totalRun) + " runs";
            }
            else if(Innings2Controller.totalRun > Innings1Controller.totalRun){
                result.setText(NewMatchController._team2 + " won by " + Integer.toString(10 - Innings2Controller.totalWicket) + " wickets");
                rrs = NewMatchController._team2 + " won by " + Integer.toString(10 - Innings2Controller.totalWicket) + " wickets";
            }
            else{
                result.setText("Match tied !!!");
                rrs = "Match tied !!!";
            }   
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crictrack", "root", "");
            Statement stat = con.createStatement();
            String query = "INSERT INTO `" + CricTrack.usernAme + "matches`(`teams`, `team1`, `team2`, `result`) VALUES (" + "'" + tn + "'" + ",'" + t1s + "','" + t2s + "','" + rrs + "')";
            stat.execute(query);
            
            stat.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(MatchEndController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void report(ActionEvent event) throws IOException {
        Parent window1;
        window1 = FXMLLoader.load(getClass().getResource("matchReport.fxml"));

        Stage mainStage;
        mainStage = CricTrack.parentWindow;
        mainStage.getScene().setRoot(window1);
    }

    @FXML
    private void home(ActionEvent event) throws IOException {
        Parent window1;
        window1 = FXMLLoader.load(getClass().getResource("menu.fxml"));

        Stage mainStage;
        mainStage = CricTrack.parentWindow;
        mainStage.getScene().setRoot(window1);
    }
    
}
