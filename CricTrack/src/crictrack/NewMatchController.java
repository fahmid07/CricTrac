/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crictrack;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class NewMatchController implements Initializable {

    @FXML
    private TextField t2;
    @FXML
    private TextField t1;
    @FXML
    private CheckBox tossT1;
    @FXML
    private CheckBox tossT2;
    @FXML
    private TextField venue;
    @FXML
    private Label t1Warning;
    @FXML
    private Label t2Warning;
    @FXML
    private Label venueWarn;
    /**
     * Initializes the controller class.
     */
    int imp1 = 0;
    int imp2 = 0;
    public static int isImported1 = 0;
    public static int isImported2 = 0;
    public static String _team1;
    public static String _team2;
    
    public static int overs = 0;
    public static String tossWin = null;
    public static int opt = 0;
    
    public static String _venue;
    
    @FXML
    private CheckBox bat;
    @FXML
    private CheckBox bowl;
    @FXML
    private ChoiceBox<String> Team1List;
    @FXML
    private ChoiceBox<String> Team2List;
    @FXML
    private ComboBox<String> oversBox;
    @FXML
    private Label oversWarning;
    @FXML
    private Label teamNameAlert;
    ObservableList<String> teamList = FXCollections.observableArrayList(CricTrack.teams);
    ObservableList<String> overList = FXCollections.observableArrayList("1",  "2",  "3",  "4",  "5",  "6",  "7",  "8",  "9",  "10",  "11",  "12",  "13",  "14",  "15",  "16",  "17",  "18",  "19",  "20",  "21",  "22",  "23",  "24",  "25",  "26",  "27",  "28",  "29",  "30",  "31",  "32",  "33",  "34",  "35",  "36",  "37",  "38",  "39",  "40",  "41",  "42",  "43",  "44",  "45",  "46",  "47",  "48",  "49",  "50");
        
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        imp1 = 0;
        imp2 = 0;
        isImported1 = 0;
        isImported2 = 0;
        tossT1.setSelected(true);
        tossT2.setSelected(false);
        bat.setSelected(true);
        bowl.setSelected(false);
        Team1List.getItems().clear();
        Team1List.setItems(teamList);
        Team2List.getItems().clear();
        Team2List.setItems(teamList);
        oversBox.getItems().clear();
        oversBox.setItems(overList);
    }    

    @FXML
    private void t1WarningShow(KeyEvent event) {
        String str = t1.getText();
        
        if(str.equals(t2.getText())) t1Warning.setText("Team name must be different");
        else if(str.length() > 40) t1Warning.setText("Team name length can not exceed 40");
        else t1Warning.setText("");
    }

    @FXML
    private void t2WarningShow(KeyEvent event) {
        String str = t2.getText();
        
        if(str.equals(t1.getText())) t2Warning.setText("Team name must be different");
        else if(str.length() > 40) t2Warning.setText("Team name length can not exceed 40");
        else t2Warning.setText("");
    }
    
    // Number of overs must be selected
    // Team name can not be empty
    @FXML
    private void backBt(ActionEvent event) throws IOException {
        Parent window1;
        window1 = FXMLLoader.load(getClass().getResource("menu.fxml"));

        Stage mainStage;
        mainStage = CricTrack.parentWindow;
        mainStage.getScene().setRoot(window1);
    }


    @FXML
    private void venueWarning(KeyEvent event) {
        String str = venue.getText();
        
        if(str.length() > 90) venueWarn.setText("Venue name length can not exceed 90");
        else venueWarn.setText("");
    }

    @FXML
    private void tosst1(ActionEvent event) {
        if(tossT2.isSelected()){
            tossT1.setSelected(true);
            tossT2.setSelected(false);
        }
        else tossT1.setSelected(true);
    }

    @FXML
    private void tosst2(ActionEvent event) {
        if(tossT2.isSelected()){
            tossT2.setSelected(true);
            tossT1.setSelected(false);
        }
        else tossT2.setSelected(true);
    }

    @FXML
    private void optBat(ActionEvent event) {
        if(bowl.isSelected()){
            bat.setSelected(true);
            bowl.setSelected(false);
        }
        else bat.setSelected(true);
    }

    @FXML
    private void optBowl(ActionEvent event) {
        if(bat.isSelected()){
            bowl.setSelected(true);
            bat.setSelected(false);
        }
        else bowl.setSelected(true);
    }

    @FXML
    private void imp1Click(ActionEvent event) {
        String str = Team1List.getValue();
        if(!str.equals("") && !str.equals(t2.getText())){
            t1.setText(str);
            t1.setDisable(true);
            isImported1 = 1;
        }
        else{
            t1Warning.setText("Team name can not be same or empty");
            isImported1 = 0;
        }
    }

    @FXML
    private void imp2Click(ActionEvent event) {
        String str = Team2List.getValue();
        if(!str.equals("") && !str.equals(t1.getText())){
            t2.setText(str);
            t2.setDisable(true);
            isImported2 = 1;
        }
        else{
            t2Warning.setText("Team name can not be same or empty");
            isImported2 = 0;
        }
    }

    @FXML
    private void startButton(ActionEvent event) throws IOException {
        int flag1 = 1, flag2 = 1, flag3 = 1;
        if(!t1.getText().equals("") && !t2.getText().equals("") && !t1.getText().equals(t2.getText())){
            if(isImported1 == 0){
                for(String str : CricTrack.teams){
                    if(str.equals(t1.getText())){
                        t1Warning.setText("Team name can not be same");
                        flag1 = 0;
                        break;
                    }
                }
            }
            
            if(isImported2 == 0){
                for(String str : CricTrack.teams){
                    if(str.equals(t2.getText())){
                        t2Warning.setText("Team name can not be same");
                        flag1 = 0;
                        break;
                    }
                }
            }
        }
        else{
            flag1 = 0;
            teamNameAlert.setText("Team name can not be empty or same");
        }
      
        String ov = oversBox.getValue();
        if(ov == null){
            flag2 = 0;
            oversWarning.setText("Number of overs must be selected");
        }
        else{
             overs = Integer.parseInt(ov);
        }
        
        if(venue.getText().equals("")){
            flag3 = 0;
            venueWarn.setText("Enter a venue name");
        }
        
        if(tossT1.isSelected()){
            tossWin = t1.getText();
        }
        else tossWin = t2.getText();
        
        if(bat.isSelected()) opt = 1;
        else opt = 2;
        
        int flag = flag1*flag2*flag3;
        
        if(flag==1){
            if(tossWin.equals(t1.getText())){
                if(opt == 1){
                    _team1 = t1.getText();
                    _team2 = t2.getText();
                }
                else{
                    _team2 = t1.getText();
                    _team1 = t2.getText();
                    int temp;
                    temp = isImported1;
                    isImported1 = isImported2;
                    isImported2 = temp;
                }
            }
            else{
                if(opt == 1){
                    _team2 = t1.getText();
                    _team1 = t2.getText();
                    int temp;
                    temp = isImported1;
                    isImported1 = isImported2;
                    isImported2 = temp;
                }
                else{
                    _team1 = t1.getText();
                    _team2 = t2.getText();
                }
            }
//            System.out.println(_team1);
//            System.out.println(_team2);
            
            _venue = venue.getText();
            
            
            
            Parent window1;
            window1 = FXMLLoader.load(getClass().getResource("teams.fxml"));

            Stage mainStage;
            mainStage = CricTrack.parentWindow;
            mainStage.getScene().setRoot(window1);
        }
    }



    
}
