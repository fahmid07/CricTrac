/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crictrack;

import static java.awt.SystemColor.window;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.print.PrinterJob;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class MatchReportController implements Initializable {

    @FXML
    private Label result;
    @FXML
    private Label t1s;
    @FXML
    private Label t2s;
    @FXML
    private TableView<Player> t1bat;
    @FXML
    private TableView<Player> t2bowl;
    @FXML
    private TableView<Player> t2bat;
    @FXML
    private TableView<Player> t1bowl;
    @FXML
    private TableColumn<Player, String> t1w;
    @FXML
    private TableColumn<Player, Integer> t1r;
    @FXML
    private TableColumn<Player, Integer> t1b;
    @FXML
    private TableColumn<Player, Integer> t14;
    @FXML
    private TableColumn<Player, Integer> t16;
    @FXML
    private TableColumn<Player, Double> t1sr;
    @FXML
    private TableColumn<Player, Double> t2ov;
    @FXML
    private TableColumn<Player, Integer> t2m;
    @FXML
    private TableColumn<Player, Integer> t2br;
    @FXML
    private TableColumn<Player, Integer> t2bw;
    @FXML
    private TableColumn<Player, Double> t2ec;
    @FXML
    private TableColumn<Player, String> t2w;
    @FXML
    private TableColumn<Player, Integer> t2r;
    @FXML
    private TableColumn<Player, Integer> t2b;
    @FXML
    private TableColumn<Player, Integer> t24;
    @FXML
    private TableColumn<Player, Integer> t26;
    @FXML
    private TableColumn<Player, Double> t2sr;
    @FXML
    private TableColumn<Player, Double> t1ov;
    @FXML
    private TableColumn<Player, Integer> t1m;
    @FXML
    private TableColumn<Player, Integer> t1br;
    @FXML
    private TableColumn<Player, Integer> t1bw;
    @FXML
    private TableColumn<Player, Double> t1ec;
    @FXML
    private TableColumn<Player, String> t1batt;
    @FXML
    private TableColumn<Player, String> t2batt;
    @FXML
    private TableColumn<Player, String> t2bowll;
    @FXML
    private TableColumn<Player, String> t1bowll;

    
    ObservableList<Player> obs1;
    ObservableList<Player> obs2;
    ObservableList<Player> obs3;
    ObservableList<Player> obs4;
    @FXML
    private AnchorPane myPane;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        result.setText(MatchEndController.rrs);
        t1s.setText(MatchEndController.t1s);
        t2s.setText(MatchEndController.t2s);
        
            obs1 = FXCollections.observableArrayList(Innings1Controller.team1Bat);
            obs2 = FXCollections.observableArrayList(Innings2Controller._team1Bat);
            obs3 = FXCollections.observableArrayList(Innings1Controller.team2Bowl);
            obs4 = FXCollections.observableArrayList(Innings2Controller._team2Bowl);
                    
            t1batt.setCellValueFactory(new PropertyValueFactory<>("name"));
            t1w.setCellValueFactory(new PropertyValueFactory<>("wkType"));
            t1r.setCellValueFactory(new PropertyValueFactory<>("run"));
            t1b.setCellValueFactory(new PropertyValueFactory<>("ball"));
            t14.setCellValueFactory(new PropertyValueFactory<>("four"));
            t16.setCellValueFactory(new PropertyValueFactory<>("six"));
            t1sr.setCellValueFactory(new PropertyValueFactory<>("sr"));
            
            
            t2batt.setCellValueFactory(new PropertyValueFactory<>("name"));
            t2w.setCellValueFactory(new PropertyValueFactory<>("wkType"));
            t2r.setCellValueFactory(new PropertyValueFactory<>("run"));
            t2b.setCellValueFactory(new PropertyValueFactory<>("ball"));
            t24.setCellValueFactory(new PropertyValueFactory<>("four"));
            t26.setCellValueFactory(new PropertyValueFactory<>("six"));
            t2sr.setCellValueFactory(new PropertyValueFactory<>("sr"));
            
            t2bowll.setCellValueFactory(new PropertyValueFactory<>("name"));
            t2m.setCellValueFactory(new PropertyValueFactory<>("maiden"));
            t2bw.setCellValueFactory(new PropertyValueFactory<>("wicket"));
            t2br.setCellValueFactory(new PropertyValueFactory<>("brun"));
            t2ec.setCellValueFactory(new PropertyValueFactory<>("ec"));
            t2ov.setCellValueFactory(new PropertyValueFactory<>("ovv"));
            
            t1bowll.setCellValueFactory(new PropertyValueFactory<>("name"));
            t1m.setCellValueFactory(new PropertyValueFactory<>("maiden"));
            t1bw.setCellValueFactory(new PropertyValueFactory<>("wicket"));
            t1br.setCellValueFactory(new PropertyValueFactory<>("brun"));
            t1ec.setCellValueFactory(new PropertyValueFactory<>("ec"));
            t1ov.setCellValueFactory(new PropertyValueFactory<>("ovv"));
            
            t1bat.setItems(obs1);
            t2bat.setItems(obs2);
            t1bowl.setItems(obs4);
            t2bowl.setItems(obs3);
    }    

    @FXML
    private void home(ActionEvent event) throws IOException {
        Parent window1;
        window1 = FXMLLoader.load(getClass().getResource("menu.fxml"));

        Stage mainStage;
        mainStage = CricTrack.parentWindow;
        mainStage.getScene().setRoot(window1);
    }

    @FXML
    private void print(ActionEvent event) {
        PrinterJob job = PrinterJob.createPrinterJob();
        if(job != null){
          job.showPrintDialog(CricTrack.parentWindow);
          myPane.setMinSize(500, 300);
          job.printPage(myPane);
          job.endJob();
        }
    }
    
}
