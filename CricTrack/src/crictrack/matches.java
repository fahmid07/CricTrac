/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crictrack;

/**
 *
 * @author Asus
 */
public class matches {
    private String teams;
    private String team1;
    private String team2;
    private String result;

    public matches() {
        
    }

    public matches(String teams, String team1, String team2, String result) {
        this.teams = teams;
        this.team1 = team1;
        this.team2 = team2;
        this.result = result;
    }

    public String getTeams() {
        return teams;
    }

    public void setTeams(String teams) {
        this.teams = teams;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
    
    
}
