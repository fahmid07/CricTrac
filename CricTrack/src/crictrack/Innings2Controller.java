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
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class Innings2Controller implements Initializable {

    private ChoiceBox<String> bat1;
    @FXML
    private Label team1vsteam2;
    @FXML
    private Label tossOrTarget;
    @FXML
    private Label optOrScore;
    @FXML
    private Label innings1Or2;
    @FXML
    private Label bt1;
    @FXML
    private Label bt1r;
    @FXML
    private Label bt1b;
    @FXML
    private Label bt14;
    @FXML
    private Label bt16;
    @FXML
    private Label bt1sr;
    @FXML
    private Label bt2;
    @FXML
    private Label bt2r;
    @FXML
    private Label bt2b;
    @FXML
    private Label bt24;
    @FXML
    private Label bt26;
    @FXML
    private Label bt2sr;
    @FXML
    private Label score;
    @FXML
    private Label wckt;
    @FXML
    private Label ovr;
    @FXML
    private Label crr;
    @FXML
    private Label thisover;
    @FXML
    private Label bowl1;
    @FXML
    private Label bowl1ov;
    @FXML
    private Label bowl1m;
    @FXML
    private Label bowl1r;
    @FXML
    private Label bowl1w;
    @FXML
    private Label bowl1ec;
    @FXML
    private Label bowl2;
    @FXML
    private Label bowl2ov;
    @FXML
    private Label bowl2m;
    @FXML
    private Label bowl2r;
    @FXML
    private Label bowl2w;
    @FXML
    private Label bowl2ec;
    @FXML
    private ChoiceBox<String> bowl;
    @FXML
    private CheckBox gone;
    @FXML
    private ChoiceBox<String> wkType;
    String batsman1 = null;
    String batsman2 = null;
    String bowler = null;
    @FXML
    private Label warning;
    ObservableList<String> _teamList1;
    ObservableList<String> _teamList2;
    public static ArrayList<String> _team1 = new ArrayList<>();
    public static ArrayList<String> _team2 = new ArrayList<>();
    @FXML
    private CheckBox wide;
    @FXML
    private CheckBox noball;
    @FXML
    private CheckBox byes;
    @FXML
    private CheckBox lbyes;
    @FXML
    private Label venuename;
    
    ObservableList<String> WicketTypes = FXCollections.observableArrayList("Run Out",  "Bowled",  "Catch Out",  "Hit Wicket",  "LBW");
     
    public static int totalRun = 0;
    public static int totalWicket = 0;
    public static double totalOver = 0;
    public static int totalBall = 0;
    int BallsCanPlay = NewMatchController.overs * 6;
    public static double cRunRate = 0;
    int batSelected = 0;
    int bowlSelected = 0;
    public static ArrayList<Player> _team1Bat = new ArrayList<Player>();
    public static ArrayList<Player> _team2Bowl = new ArrayList<Player>();
    String prevBowler = null;
    int strike = 1;
    public static int extras = 0;
    Player obj1, obj2, obj3, obj4;
    int gg = 0;
    public static int runNeeded = 0;
    @FXML
    private Label rRate;
    @FXML
    private ChoiceBox<String> bat_1;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            runNeeded = Innings1Controller.totalRun + 1;
            if(_team1.size()>0) _team1.clear();
            if(_team2.size()>0) _team2.clear();
            if(_team1Bat.size()>0) _team1Bat.clear();
            if(_team2Bowl.size()>0) _team2Bowl.clear();
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crictrack", "root", "");
            Statement stat = con.createStatement();
            String query = "SELECT `captain`, `player1`, `player2`, `player3`, `player4`, `player5`, `player6`, `player7`, `player8`, `player9`, `player10`, `player11`, `player12` FROM `" + CricTrack.usernAme + "` WHERE `teamname` = '" + NewMatchController._team2 + "'";
            ResultSet rs = stat.executeQuery(query);
            rs.next();
            
            _team1.add(rs.getString("captain"));
            _team1.add(rs.getString("player1"));
            _team1.add(rs.getString("player2"));
            _team1.add(rs.getString("player3"));
            _team1.add(rs.getString("player4"));
            _team1.add(rs.getString("player5"));
            _team1.add(rs.getString("player6"));
            _team1.add(rs.getString("player7"));
            _team1.add(rs.getString("player8"));
            _team1.add(rs.getString("player9"));
            _team1.add(rs.getString("player10"));
            _team1.add(rs.getString("player11"));
            _team1.add(rs.getString("player12"));
            stat.close();
            con.close();
                
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crictrack", "root", "");
            stat = con.createStatement();
            query = "SELECT `captain`, `player1`, `player2`, `player3`, `player4`, `player5`, `player6`, `player7`, `player8`, `player9`, `player10`, `player11`, `player12` FROM `" + CricTrack.usernAme + "` WHERE `teamname` = '" + NewMatchController._team1 + "'";
            rs = stat.executeQuery(query);
            rs.next();
            
            _team2.add(rs.getString("captain"));
            _team2.add(rs.getString("player1"));
            _team2.add(rs.getString("player2"));
            _team2.add(rs.getString("player3"));
            _team2.add(rs.getString("player4"));
            _team2.add(rs.getString("player5"));
            _team2.add(rs.getString("player6"));
            _team2.add(rs.getString("player7"));
            _team2.add(rs.getString("player8"));
            _team2.add(rs.getString("player9"));
            _team2.add(rs.getString("player10"));
            _team2.add(rs.getString("player11"));
            _team2.add(rs.getString("player12"));
            stat.close();
            con.close();
            
            
            _teamList1 = FXCollections.observableArrayList();
            _teamList2 = FXCollections.observableArrayList();
            
            for(String ss : _team1){
                _teamList1.add(ss);
            }
            for(String ss : _team2){
                _teamList2.add(ss);
            }
            
            bat_1.getItems().clear();
            bat_1.setItems(_teamList1);
            bowl.getItems().clear();
            bowl.setItems(_teamList2);
            wkType.getItems().clear();
            wkType.setItems(WicketTypes);
            batSelected = 0;
            bowlSelected = 1;
            warning.setText("Select two batsman and a bowler");
            strike = 1;
            team1vsteam2.setText(NewMatchController._team1 + " vs " + NewMatchController._team2);
            venuename.setText("Live from: " + NewMatchController._venue);
            tossOrTarget.setText("Target: " + Integer.toString(runNeeded));
            optOrScore.setText(Integer.toString(runNeeded) + " needed from " + Integer.toString(BallsCanPlay) + " balls");
            innings1Or2.setText(NewMatchController._team2 + " , 1st innings");
            score.setText(Integer.toString(totalRun));
            wckt.setText(Integer.toString(totalWicket));
            crr.setText(Double.toString(cRunRate));
            ovr.setText(Double.toString(totalOver));
            thisover.setText("");
            bowl1.setText("");
            bowl1ov.setText("");
            bowl1m.setText("");
            bowl1r.setText("");
            bowl1w.setText("");
            bowl1ec.setText("");
            bowl2.setText("");
            bowl2ov.setText("");
            bowl2m.setText("");
            bowl2r.setText("");
            bowl2w.setText("");
            bowl2ec.setText("");
            bt1.setText("");
            bt1r.setText("");
            bt1b.setText("");
            bt14.setText("");
            bt16.setText("");
            bt1sr.setText("");
            bt2.setText("");
            bt2r.setText("");
            bt2b.setText("");
            bt24.setText("");
            bt26.setText("");
            bt2sr.setText("");
            
            gone.setSelected(false);
            wide.setSelected(false);
            noball.setSelected(false);
            byes.setSelected(false);
            lbyes.setSelected(false);
            rRate.setText("0.0");
        } catch (SQLException ex) {
            Logger.getLogger(Innings2Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    public void setALL(){
                if(strike==1) bt1.setText(batsman1 + " *");
                else bt1.setText(batsman1);
                bt1r.setText(String.valueOf(obj1.getRun()));
                bt1b.setText(String.valueOf(obj1.getBall()));
                bt14.setText(String.valueOf(obj1.getFour()));
                bt16.setText(String.valueOf(obj1.getSix()));
                
                double b1d = new Double(obj1.getRun());
                double b1dd = 0.0;
                if(b1d>0.0) b1dd = b1d / obj1.getBall();
                b1dd *= 100;
                b1dd = Double.parseDouble(String.format("%.2f", b1dd));
                obj1.setSr(b1dd);
                bt1sr.setText(String.valueOf(obj1.getSr()));
                
                if(strike==2) bt2.setText(batsman2 + " *");
                else bt2.setText(batsman2);
                bt2r.setText(String.valueOf(obj2.getRun()));
                bt2b.setText(String.valueOf(obj2.getBall()));
                bt24.setText(String.valueOf(obj2.getFour()));
                bt26.setText(String.valueOf(obj2.getSix()));
                
                double b2d = new Double(obj2.getRun());
                double b2dd = 0.0;
                if(b2d>0.0) b2dd = b2d / obj2.getBall();
                b2dd *= 100;
                b2dd = Double.parseDouble(String.format("%.2f", b2dd));
                obj2.setSr(b2dd);
                bt2sr.setText(String.valueOf(obj2.getSr()));
                
                score.setText(Integer.toString(totalRun));
                wckt.setText(Integer.toString(totalWicket));
                
                
                double dd = new Double(totalRun);
                if(totalBall > 0.0) cRunRate = dd / totalBall;
                else cRunRate = 1;
                cRunRate *= 6;
                cRunRate = Double.parseDouble(String.format("%.2f", cRunRate));
                crr.setText(Double.toString(cRunRate));
                ovr.setText(Double.toString(totalOver));
                
                double xx = runNeeded-totalRun;
                double yy = BallsCanPlay-totalBall;
                double oo;
                if(yy > 0.0) oo = xx / yy;
                else oo = 1;
                oo *= 6;
                oo = Double.parseDouble(String.format("%.2f", oo));
                rRate.setText(Double.toString(oo));
                
                double bd = 0.0;
                int bx = (int) (obj3.getOv() / 6);
                double bdd = obj3.getOv() % 6;
                double fb = bdd/10;
                double ovc = bx + fb;
                ovc = Double.parseDouble(String.format("%.1f", ovc));
                obj3.setOvv(ovc);
                bowl1ov.setText(String.valueOf(ovc));
                bowl1m.setText(String.valueOf(obj3.getMaiden()));
                bowl1r.setText(String.valueOf(obj3.getBrun()));
                bowl1w.setText(String.valueOf(obj3.getWicket()));
                
                if(obj3.getOv() > 0.0) bd = obj3.getBrun() / obj3.getOv();
                else bd = 0;
                bdd = bd * 6;
                bdd = Double.parseDouble(String.format("%.2f", bdd));
                bowl1ec.setText(String.valueOf(bdd));
                
                if(prevBowler!=null){
                    bx = (int) (obj4.getOv() / 6);
                    bdd = obj4.getOv() % 6;
                    fb = bdd/10;
                    ovc = bx + fb;
                    ovc = Double.parseDouble(String.format("%.1f", ovc));
                    obj4.setOvv(ovc);
                    bowl2ov.setText(String.valueOf(ovc));
                    bowl2m.setText(String.valueOf(obj4.getMaiden()));
                    bowl2r.setText(String.valueOf(obj4.getBrun()));
                    bowl2w.setText(String.valueOf(obj4.getWicket()));
                    
                    
                    if(obj4.getOv() > 0.0) bd = obj4.getBrun() / obj4.getOv();
                    else bd = 0;
                    bdd = bd * 6;
                    bdd = Double.parseDouble(String.format("%.2f", bdd));
                    bowl2ec.setText(String.valueOf(bdd));
                }
                if(gone.isSelected()){
                    gg = 1;
                }
                else gg = 0;
                gone.setSelected(false);
                wide.setSelected(false);
                noball.setSelected(false);
                byes.setSelected(false);
                lbyes.setSelected(false);
                
        optOrScore.setText(Integer.toString(runNeeded-totalRun) + " needed from " + Integer.toString(BallsCanPlay-totalBall) + " balls");
        
    }
    
    @FXML
    private void selectBat(ActionEvent event) {
        if(bat_1.getValue() != null && batSelected<2){
            if(batsman1 == null){
                batsman1 = bat_1.getValue();
                bat_1.setValue(null);
                batSelected++;
                _team1.remove(new String(batsman1));
                //_teamList1.clear();
                _teamList1 = FXCollections.observableArrayList();
                for(String ss : _team1){
                    _teamList1.add(ss);
                }
                bat_1.getItems().clear();
                bat_1.setItems(_teamList1);
                obj1 = new Player(batsman1, 0, 0, 0, 0, 0.0);
                if(strike==1) bt1.setText(batsman1 + " *");
                else bt1.setText(batsman1);
                bt1r.setText(String.valueOf(obj1.getRun()));
                bt1b.setText(String.valueOf(obj1.getBall()));
                bt14.setText(String.valueOf(obj1.getFour()));
                bt16.setText(String.valueOf(obj1.getSix()));
                bt1sr.setText(String.valueOf(obj1.getSr()));
            }
            else if(batsman2 == null){
                batsman2 = bat_1.getValue();
                bat_1.setValue(null);
                batSelected++;
                _team1.remove(new String(batsman2));
                //_teamList1.clear();
                _teamList1 = FXCollections.observableArrayList();
                for(String ss : _team1){
                    _teamList1.add(ss);
                }
                bat_1.getItems().clear();
                bat_1.setItems(_teamList1);
                obj2 = new Player(batsman2, 0, 0, 0, 0, 0.0);
                if(strike==2) bt2.setText(batsman2 + " *");
                else bt2.setText(batsman2);
                bt2r.setText(String.valueOf(obj2.getRun()));
                bt2b.setText(String.valueOf(obj2.getBall()));
                bt24.setText(String.valueOf(obj2.getFour()));
                bt26.setText(String.valueOf(obj2.getSix()));
                bt2sr.setText(String.valueOf(obj2.getSr()));
            }
            else warning.setText("Already Selected");
        }
        else warning.setText("Already Selected");
    }

    @FXML
    private void selectBowl(ActionEvent event) {
        if(bowl.getValue() != null){
            if(bowler == null){
                bowler = bowl.getValue();
                bowl.setValue(null);
                if(prevBowler != null){
                    _team2.add(prevBowler);
                    prevBowler = bowler;
                    obj4 = obj3;
                    _team2Bowl.add(obj4);
                    bowl2.setText(obj4.getName());
                    bowl2ov.setText(String.valueOf(obj4.getOv()));
                    bowl2m.setText(String.valueOf(obj4.getMaiden()));
                    bowl2r.setText(String.valueOf(obj4.getBrun()));
                    bowl2w.setText(String.valueOf(obj4.getWicket()));
                    bowl2ec.setText(String.valueOf(obj4.getEc()));
                }
                obj3 = new Player(bowler, 0.0, 0, 0, 0, 0.0);
                bowl1.setText(bowler + " *");
                bowl1ov.setText(String.valueOf(obj3.getOv()));
                bowl1m.setText(String.valueOf(obj3.getMaiden()));
                bowl1r.setText(String.valueOf(obj3.getBrun()));
                bowl1w.setText(String.valueOf(obj3.getWicket()));
                bowl1ec.setText(String.valueOf(obj3.getEc()));
                _team2.remove(new String(bowler));
                //_teamList2.clear();
                _teamList2 = FXCollections.observableArrayList();
                for(String ss : _team2){
                    _teamList2.add(ss);
                }
                bowl.getItems().clear();
                bowl.setItems(_teamList2);
            }
            else warning.setText("Already Selected");
        }
        else warning.setText("Already Selected");
    }

    @FXML
    private void wideClick(ActionEvent event) {
            if(lbyes.isSelected()){
                lbyes.setSelected(false);
                wide.setSelected(true);
            }
            else{
                wide.setSelected(true);
            }
            
            if(noball.isSelected()) {
                noball.setSelected(false);
                wide.setSelected(true);
            }
            else{
                wide.setSelected(true);
            }
            
            if(byes.isSelected()){
                byes.setSelected(false);
                wide.setSelected(true);
            }
            else{
                wide.setSelected(true);
            }
        
    }

    @FXML
    private void noballClick(ActionEvent event) {
        if(wide.isSelected()){
            noball.setSelected(true);
            wide.setSelected(false);
        }
        else{
            noball.setSelected(true);
        }
    }

    @FXML
    private void byesClick(ActionEvent event) {
        if(lbyes.isSelected()){
            byes.setSelected(true);
            lbyes.setSelected(false);
        }
        else{
            byes.setSelected(true);
        }
        
        if(wide.isSelected()){
            byes.setSelected(true);
            wide.setSelected(false);
        }
        else{
            byes.setSelected(true);
        }
    }

    @FXML
    private void lbyesClick(ActionEvent event) {
        if(byes.isSelected()){
            lbyes.setSelected(true);
            byes.setSelected(false);
        }
        else{
            lbyes.setSelected(true);
        }
        
        if(wide.isSelected()){
            lbyes.setSelected(true);
            wide.setSelected(false);
        }
        else{
            lbyes.setSelected(true);
        }
    }

    

    @FXML
    private void zero(ActionEvent event) throws IOException {
        if(batSelected==2 && bowler!=null){
            if(wide.isSelected() || noball.isSelected()){
                totalRun += 1;
                extras += 1;
                obj3.setBrun(obj3.getBrun() + 1);
                if(wide.isSelected()){
                    if(gone.isSelected()) thisover.setText(thisover.getText() + " 0WD,W ");
                    else thisover.setText(thisover.getText() + " 0WD ");
                }
                else if(noball.isSelected()){
                    if(gone.isSelected()) thisover.setText(thisover.getText() + " 0NB,W ");
                    else thisover.setText(thisover.getText() + " 0NB ");
                }
            }
            else{
                obj3.setOv(obj3.getOv() + 1);
                totalBall += 1;
                if(gone.isSelected()) thisover.setText(thisover.getText() + " W ");
                else thisover.setText(thisover.getText() + " 0 ");
            }
            
                if(strike==1){
                        if(!wide.isSelected()) obj1.setBall(obj1.getBall() + 1);
                }
                else{
                        if(!wide.isSelected()) obj2.setBall(obj2.getBall() + 1);
                }
            
            if(gone.isSelected()){
                totalWicket++;
                batSelected--;
                obj3.setWicket(obj3.getWicket() + 1);
                if(strike==1){
                    obj1.setWkType(wkType.getValue());
                    _team1Bat.add(obj1);
                    batsman1 = null;
                }
                else{
                    obj2.setWkType(wkType.getValue());
                    _team1Bat.add(obj2);
                    batsman2 = null;
                }
            }
            setALL();

            if(totalBall<BallsCanPlay && totalWicket<10 && totalRun<runNeeded){
                int x  = totalBall/6;
                int y = totalBall % 6;
                double f = new Double(y);
                double d = f/10;
                totalOver = x;
                totalOver += d;
                if(y==0){
                    _team2Bowl.add(obj3);
                    bowler = null;
                    bowlSelected--;
                    if(strike == 1) strike = 2;
                    else strike = 1;
                    thisover.setText("");
                }
                setALL();
            }
            else{
                _team1Bat.add(obj1);
                _team1Bat.add(obj2);
                _team2Bowl.add(obj3);
                Parent window1;
                window1 = FXMLLoader.load(getClass().getResource("matchEnd.fxml"));

                Stage mainStage;
                mainStage = CricTrack.parentWindow;
                mainStage.getScene().setRoot(window1);
            }
        }
    }

    @FXML
    private void one(ActionEvent event) throws IOException {
        if(batSelected==2 && bowler!=null){
            if(wide.isSelected() || noball.isSelected()){
                obj3.setBrun(obj3.getBrun() + 2);
                totalRun += 2;
                extras += 1;
                if(wide.isSelected()){
                    if(gone.isSelected()) thisover.setText(thisover.getText() + " 1WD,W ");
                    else thisover.setText(thisover.getText() + " 1WD ");
                }
                else if(noball.isSelected()){
                    if(gone.isSelected()) thisover.setText(thisover.getText() + " 1NB,W ");
                    else thisover.setText(thisover.getText() + " 1NB ");
                }
            }
            else{
                totalRun += 1;
                totalBall += 1;
                obj3.setBrun(obj3.getBrun() + 1);
                obj3.setOv(obj3.getOv() + 1);
                if(gone.isSelected()) thisover.setText(thisover.getText() + " 1,W ");
                else thisover.setText(thisover.getText() + " 1 ");
            }
            if(!byes.isSelected() && !lbyes.isSelected()){
                    if(strike==1){
                        obj1.setRun(obj1.getRun() + 1);
                        obj1.setBall(obj1.getBall() + 1);
                        strike = 2;
                    }
                    else{
                        obj2.setRun(obj2.getRun() + 1);
                        obj2.setBall(obj2.getBall() + 1);
                        strike = 1;
                    }
                }
            else{
                extras += 1;
                if(strike==1){
                        if(!wide.isSelected()) obj1.setBall(obj1.getBall() + 1);
                        strike = 2;
                }
                else{
                        if(!wide.isSelected()) obj2.setBall(obj2.getBall() + 1);
                        strike = 1;
                }
            }
            if(gone.isSelected()){
                totalWicket++;
                batSelected--;
                if(strike==1){
                    obj1.setWkType(wkType.getValue());
                    _team1Bat.add(obj1);
                    batsman1 = null;
                }
                else{
                    obj2.setWkType(wkType.getValue());
                    _team1Bat.add(obj2);
                    batsman2 = null;
                }
            }
            setALL();
            //warning.setText();
            if(totalBall<BallsCanPlay && totalWicket<10 && totalRun<runNeeded){
                int x  = totalBall/6;
                int y = totalBall % 6;
                double f = new Double(y);
                double d = f/10;
                totalOver = x;
                totalOver += d;
                if(y==0){
                    _team2Bowl.add(obj3);
                    bowler = null;
                    if(strike == 1) strike = 2;
                    else strike = 1;
                    thisover.setText("");
                }
                setALL();
            }
            else{
                _team1Bat.add(obj1);
                _team1Bat.add(obj2);
                _team2Bowl.add(obj3);
                Parent window1;
                window1 = FXMLLoader.load(getClass().getResource("matchEnd.fxml"));

                Stage mainStage;
                mainStage = CricTrack.parentWindow;
                mainStage.getScene().setRoot(window1);
            }
        }
    }

    @FXML
    private void two(ActionEvent event) throws IOException {
        if(batSelected==2 && bowler!=null){
            if(wide.isSelected() || noball.isSelected()){
                totalRun += 3;
                extras += 1;
                obj3.setBrun(obj3.getBrun() + 3);
                if(wide.isSelected()){
                    if(gone.isSelected()) thisover.setText(thisover.getText() + " 2WD,W ");
                    else thisover.setText(thisover.getText() + " 2WD ");
                }
                else if(noball.isSelected()){
                    if(gone.isSelected()) thisover.setText(thisover.getText() + " 2NB,W ");
                    else thisover.setText(thisover.getText() + " 2NB ");
                }
            }
            else{
                totalRun += 2;
                totalBall += 1;
                obj3.setBrun(obj3.getBrun() + 2);
                obj3.setOv(obj3.getOv() + 1);
                if(gone.isSelected()) thisover.setText(thisover.getText() + " 2,W ");
                else thisover.setText(thisover.getText() + " 2 ");
            }
            if(!byes.isSelected() && !lbyes.isSelected()){
                    if(strike==1){
                        obj1.setRun(obj1.getRun() + 2);
                        obj1.setBall(obj1.getBall() + 1);
                    }
                    else{
                        obj2.setRun(obj2.getRun() + 2);
                        obj2.setBall(obj2.getBall() + 1);
                    }
                }
            else{
                extras += 2;
                if(strike==1){
                        if(!wide.isSelected()) obj1.setBall(obj1.getBall() + 1);
                }
                else{
                        if(!wide.isSelected()) obj2.setBall(obj2.getBall() + 1);
                }
            }
            if(gone.isSelected()){
                totalWicket++;
                batSelected--;
                if(strike==1){
                    obj1.setWkType(wkType.getValue());
                    _team1Bat.add(obj1);
                    batsman1 = null;
                }
                else{
                    obj2.setWkType(wkType.getValue());
                    _team1Bat.add(obj2);
                    batsman2 = null;
                }
            }
            setALL();

            if(totalBall<BallsCanPlay && totalWicket<10 && totalRun<runNeeded){
                int x  = totalBall/6;
                int y = totalBall % 6;
                double f = new Double(y);
                double d = f/10;
                totalOver = x;
                totalOver += d;
                if(y==0){
                    _team2Bowl.add(obj3);
                    bowler = null;
                    if(strike == 1) strike = 2;
                    else strike = 1;
                    thisover.setText("");
                }
                setALL();
            }
            else{
                _team1Bat.add(obj1);
                _team1Bat.add(obj2);
                _team2Bowl.add(obj3);
                Parent window1;
                window1 = FXMLLoader.load(getClass().getResource("matchEnd.fxml"));

                Stage mainStage;
                mainStage = CricTrack.parentWindow;
                mainStage.getScene().setRoot(window1);
            }
        }
    }

    @FXML
    private void three(ActionEvent event) throws IOException {
        if(batSelected==2 && bowler!=null){
            if(wide.isSelected() || noball.isSelected()){
                totalRun += 1;
                totalRun += 3;
                extras += 1;
                obj3.setBrun(obj3.getBrun() + 4);
                if(wide.isSelected()){
                    if(gone.isSelected()) thisover.setText(thisover.getText() + " 3WD,W ");
                    else thisover.setText(thisover.getText() + " 3WD ");
                }
                else if(noball.isSelected()){
                    if(gone.isSelected()) thisover.setText(thisover.getText() + " 3NB,W ");
                    else thisover.setText(thisover.getText() + " 3NB ");
                }
            }
            else{
                totalRun += 3;
                totalBall += 1;
                obj3.setBrun(obj3.getBrun() + 3);
                obj3.setOv(obj3.getOv() + 1);
                if(gone.isSelected()) thisover.setText(thisover.getText() + " 3,W ");
                else thisover.setText(thisover.getText() + " 3 ");
            }
            if(!byes.isSelected() && !lbyes.isSelected()){
                    if(strike==1){
                        obj1.setRun(obj1.getRun() + 3);
                        obj1.setBall(obj1.getBall() + 1);
                    }
                    else{
                        obj2.setRun(obj2.getRun() + 3);
                        obj2.setBall(obj2.getBall() + 1);
                    }
                }
            else{
                extras += 3;
                if(strike==1){
                        if(!wide.isSelected()) obj1.setBall(obj1.getBall() + 1);
                        strike = 2;
                }
                else{
                        if(!wide.isSelected()) obj2.setBall(obj2.getBall() + 1);
                        strike = 1;
                }
            }
            if(gone.isSelected()){
                totalWicket++;
                batSelected--;
                if(strike==1){
                    obj1.setWkType(wkType.getValue());
                    _team1Bat.add(obj1);
                    batsman1 = null;
                }
                else{
                    obj2.setWkType(wkType.getValue());
                    _team1Bat.add(obj2);
                    batsman2 = null;
                }
            }
            setALL();

            if(totalBall<BallsCanPlay && totalWicket<10 && totalRun<runNeeded){
                int x  = totalBall/6;
                int y = totalBall % 6;
                double f = new Double(y);
                double d = f/10;
                totalOver = x;
                totalOver += d;
                if(y==0){
                    _team2Bowl.add(obj3);
                    bowler = null;
                    bowlSelected--;
                    if(strike == 1) strike = 2;
                    else strike = 1;
                    thisover.setText("");
                }
                setALL();
            }
            else{
                _team1Bat.add(obj1);
                _team1Bat.add(obj2);
                _team2Bowl.add(obj3);
                Parent window1;
                window1 = FXMLLoader.load(getClass().getResource("matchEnd.fxml"));

                Stage mainStage;
                mainStage = CricTrack.parentWindow;
                mainStage.getScene().setRoot(window1);
            }
        }
    }

    @FXML
    private void four(ActionEvent event) throws IOException {
        if(batSelected==2 && bowler!=null){
            if(wide.isSelected() || noball.isSelected()){
                totalRun += 1;
                totalRun += 4;
                extras += 1;
                obj3.setBrun(obj3.getBrun() + 5);
                if(wide.isSelected()){
                    if(gone.isSelected()) thisover.setText(thisover.getText() + " 4WD,W ");
                    else thisover.setText(thisover.getText() + " 4WD ");
                }
                else if(noball.isSelected()){
                    if(gone.isSelected()) thisover.setText(thisover.getText() + " 4NB,W ");
                    else thisover.setText(thisover.getText() + " 4NB ");
                }
            }
            else{
                totalRun += 4;
                totalBall += 1;
                obj3.setBrun(obj3.getBrun() + 4);
                obj3.setOv(obj3.getOv() + 1);
                if(gone.isSelected()) thisover.setText(thisover.getText() + " 4,W ");
                else thisover.setText(thisover.getText() + " 4 ");
            }
            if(!byes.isSelected() && !lbyes.isSelected()){
                    if(strike==1){
                        obj1.setRun(obj1.getRun() + 4);
                        obj1.setBall(obj1.getBall() + 1);
                        obj1.setFour(obj1.getFour() + 1);
                    }
                    else{
                        obj2.setRun(obj2.getRun() + 4);
                        obj2.setBall(obj2.getBall() + 1);
                        obj2.setFour(obj2.getFour() + 1);
                    }
                }
            else{
                extras += 4;
                if(strike==1){
                        if(!wide.isSelected()) obj1.setBall(obj1.getBall() + 1);
                        strike = 2;
                }
                else{
                        if(!wide.isSelected()) obj2.setBall(obj2.getBall() + 1);
                        strike = 1;
                }
            }
            if(gone.isSelected()){
                totalWicket++;
                batSelected--;
                if(strike==1){
                    obj1.setWkType(wkType.getValue());
                    _team1Bat.add(obj1);
                    batsman1 = null;
                }
                else{
                    obj2.setWkType(wkType.getValue());
                    _team1Bat.add(obj2);
                    batsman2 = null;
                }
            }
            setALL();

            if(totalBall<BallsCanPlay && totalWicket<10 && totalRun<runNeeded){
                int x  = totalBall/6;
                int y = totalBall % 6;
                double f = new Double(y);
                double d = f/10;
                totalOver = x;
                totalOver += d;
                if(y==0){
                    _team2Bowl.add(obj3);
                    bowler = null;
                    bowlSelected--;
                    if(strike == 1) strike = 2;
                    else strike = 1;
                    thisover.setText("");
                }
                setALL();
            }
            else{
                _team1Bat.add(obj1);
                _team1Bat.add(obj2);
                _team2Bowl.add(obj3);
                Parent window1;
                window1 = FXMLLoader.load(getClass().getResource("matchEnd.fxml"));

                Stage mainStage;
                mainStage = CricTrack.parentWindow;
                mainStage.getScene().setRoot(window1);
            }
        }
    }

    @FXML
    private void six(ActionEvent event) throws IOException {
        if(batSelected==2 && bowler!=null){
            if(wide.isSelected() || noball.isSelected()){
                totalRun += 1;
                totalRun += 6;
                extras += 1;
                obj3.setBrun(obj3.getBrun() + 7);
                if(wide.isSelected()){
                    if(gone.isSelected()) thisover.setText(thisover.getText() + " 6WD,W ");
                    else thisover.setText(thisover.getText() + " 6WD ");
                }
                else if(noball.isSelected()){
                    if(gone.isSelected()) thisover.setText(thisover.getText() + " 6NB,W ");
                    else thisover.setText(thisover.getText() + " 6NB ");
                }
            }
            else{
                totalRun += 6;
                totalBall += 1;
                obj3.setBrun(obj3.getBrun() + 6);
                obj3.setOv(obj3.getOv() + 1);
                if(gone.isSelected()) thisover.setText(thisover.getText() + " 6,W ");
                else thisover.setText(thisover.getText() + " 6 ");
            }
            if(!byes.isSelected() && !lbyes.isSelected()){
                    if(strike==1){
                        obj1.setRun(obj1.getRun() + 6);
                        obj1.setBall(obj1.getBall() + 1);
                        obj1.setSix(obj1.getSix() + 1);
                    }
                    else{
                        obj2.setRun(obj2.getRun() + 6);
                        obj2.setBall(obj2.getBall() + 1);
                        obj2.setSix(obj2.getSix() + 1);
                    }
                }
            else{
                extras += 6;
                if(strike==1){
                        if(!wide.isSelected()) obj1.setBall(obj1.getBall() + 1);
                        strike = 2;
                }
                else{
                        if(!wide.isSelected()) obj2.setBall(obj2.getBall() + 1);
                        strike = 1;
                }
            }
            if(gone.isSelected()){
                totalWicket++;
                batSelected--;
                if(strike==1){
                    obj1.setWkType(wkType.getValue());
                    _team1Bat.add(obj1);
                    batsman1 = null;
                }
                else{
                    obj2.setWkType(wkType.getValue());
                    _team1Bat.add(obj2);
                    batsman2 = null;
                }
            }
            setALL();

            if(totalBall<BallsCanPlay && totalWicket<10 && totalRun<runNeeded){
                int x  = totalBall/6;
                int y = totalBall % 6;
                double f = new Double(y);
                double d = f/10;
                totalOver = x;
                totalOver += d;
                if(y==0){
                    _team2Bowl.add(obj3);
                    bowler = null;
                    bowlSelected--;
                    if(strike == 1) strike = 2;
                    else strike = 1;
                    thisover.setText("");
                }
                setALL();
            }
            else{
                _team1Bat.add(obj1);
                _team1Bat.add(obj2);
                _team2Bowl.add(obj3);
                Parent window1;
                window1 = FXMLLoader.load(getClass().getResource("matchEnd.fxml"));

                Stage mainStage;
                mainStage = CricTrack.parentWindow;
                mainStage.getScene().setRoot(window1);
            }
        }
    }

    @FXML
    private void undoButton(ActionEvent event) {
    }

    @FXML
    private void retireButton(ActionEvent event) {
        if(batSelected==2){
            if(strike == 1){
                batSelected--;
                batsman1 = null;
                _team1Bat.add(obj1);
            }
            else{
                batSelected--;
                batsman2 = null;
                _team1Bat.add(obj2);
            }
            
            setALL();
        }
    }

    @FXML
    private void swapButton(ActionEvent event) {
        if(batSelected==2){
            if(strike==1) strike = 2;
            else strike = 1;
            setALL();
        }
    }

    @FXML
    private void wicketClick(ActionEvent event) {
        if(wkType.getValue() != null){
            gone.setSelected(true);
        }
        else{
            warning.setText("Select a wicket type");
            gone.setSelected(false);
        }
    }

    @FXML
    private void start2nd(ActionEvent event) throws IOException {
        Parent window1;
        window1 = FXMLLoader.load(getClass().getResource("matchEnd.fxml"));

        Stage mainStage;
        mainStage = CricTrack.parentWindow;
        mainStage.getScene().setRoot(window1);
    }
    
}
