/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crictrack;

import static crictrack.Innings1Controller.totalBall;
import static crictrack.Innings1Controller.totalRun;
import static crictrack.Innings1Controller.totalWicket;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
public class MidController implements Initializable {

    @FXML
    private Label needed;
    @FXML
    private Label team1N;
    @FXML
    private Label team2N;
    @FXML
    private Label rr;
    @FXML
    private Label ov;
    @FXML
    private Label t1run;
    @FXML
    private Label t1ov;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        needed.setText(Integer.toString(totalRun+1));
        
        double r = (double)((double)(totalRun+1) / (double)(NewMatchController.overs));
        r = Double.parseDouble(String.format("%.2f", r));
        rr.setText(Double.toString(r));
        
        ov.setText(Integer.toString(NewMatchController.overs) + " ov");
        
        team1N.setText(NewMatchController._team1);
        team2N.setText(NewMatchController._team2);
        
        int x  = totalBall/6;
        int y = totalBall % 6;
        double f = new Double(y);
        double d = f/10;
        
        double bb = x + d;
        bb = Double.parseDouble(String.format("%.2f", bb));
        t1ov.setText(Double.toString(bb) + " ov");
        
        t1run.setText(Integer.toString(totalRun) + " / " + Integer.toString(totalWicket));
    }    

    @FXML
    private void start2nd(ActionEvent event) throws IOException {
        Parent window1;
        window1 = FXMLLoader.load(getClass().getResource("innings2.fxml"));

        Stage mainStage;
        mainStage = CricTrack.parentWindow;
        mainStage.getScene().setRoot(window1);
    }
    
}
