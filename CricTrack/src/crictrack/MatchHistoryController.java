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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class MatchHistoryController implements Initializable {

    @FXML
    private TableColumn<matches, String> teams;
    @FXML
    private TableColumn<matches, String> team1;
    @FXML
    private TableColumn<matches, String> team2;
    @FXML
    private TableColumn<matches, String> result;

    ObservableList<matches> obs1;
    ArrayList<matches> obs = new ArrayList<matches>();
    
    @FXML
    private TableView<matches> myTable;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            if(obs.size() > 0) obs.clear();
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crictrack", "root", "");
            Statement stat = con.createStatement();
            String query = "SELECT `teams`, `team1`, `team2`, `result` FROM `" + CricTrack.usernAme + "matches`";
            ResultSet rs = stat.executeQuery(query);
            
            while(rs.next()){
                matches mobj = new matches();
                mobj.setTeams(rs.getString("teams"));
                mobj.setTeam1(rs.getString("team1"));
                mobj.setTeam2(rs.getString("team2"));
                mobj.setResult(rs.getString("result"));
                
                obs.add(mobj);
            }
            
            obs1 = FXCollections.observableArrayList(obs);
            
            teams.setCellValueFactory(new PropertyValueFactory<>("teams"));
            team1.setCellValueFactory(new PropertyValueFactory<>("team1"));
            team2.setCellValueFactory(new PropertyValueFactory<>("team2"));
            result.setCellValueFactory(new PropertyValueFactory<>("result"));
            
            myTable.setItems(obs1);
            
        } catch (SQLException ex) {
            Logger.getLogger(MatchHistoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void back(ActionEvent event) throws IOException {
        Parent window1;
        window1 = FXMLLoader.load(getClass().getResource("menu.fxml"));

        Stage mainStage;
        mainStage = CricTrack.parentWindow;
        mainStage.getScene().setRoot(window1);
    }
    
}
