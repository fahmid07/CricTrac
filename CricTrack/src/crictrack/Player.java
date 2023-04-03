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
public class Player {
    private String name = null;
    private int run = 0;
    private int ball = 0;
    private int four = 0;
    private int six = 0;
    private double sr = 0.0;
    private double ov = 0.0;
    private double ovv = 0.0;
    private int maiden = 0;
    private int wicket = 0;
    private int brun = 0;
    private double ec = 0.0;
    private String wkType = null;

    public double getOvv() {
        return ovv;
    }

    public void setOvv(double ovv) {
        this.ovv = ovv;
    }

    public Player() {
    }

    public String getWkType() {
        return wkType;
    }

    public void setWkType(String wkTRype) {
        this.wkType = wkType;
    }
    
    public Player(String name, double ov, int maiden, int wicket, int brun, double ec) {
        this.name = name;
        this.ov = ov;
        this.maiden = maiden;
        this.wicket = wicket;
        this.brun = brun;
        this.ec = ec;
    }

    public Player(String name, int run, int ball, int four, int six, double sr) {
        this.name = name;
        this.run = run;
        this.ball = ball;
        this.four = four;
        this.six = six;
        this.sr = sr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRun() {
        return run;
    }

    public void setRun(int run) {
        this.run = run;
    }

    public int getBall() {
        return ball;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    public int getFour() {
        return four;
    }

    public void setFour(int four) {
        this.four = four;
    }

    public int getSix() {
        return six;
    }

    public void setSix(int six) {
        this.six = six;
    }

    public double getSr() {
        return sr;
    }

    public void setSr(double sr) {
        this.sr = sr;
    }

    public double getOv() {
        return ov;
    }

    public void setOv(double ov) {
        this.ov = ov;
    }

    public int getMaiden() {
        return maiden;
    }

    public void setMaiden(int maiden) {
        this.maiden = maiden;
    }

    public int getWicket() {
        return wicket;
    }

    public void setWicket(int wicket) {
        this.wicket = wicket;
    }

    public int getBrun() {
        return brun;
    }

    public void setBrun(int brun) {
        this.brun = brun;
    }

    public double getEc() {
        return ec;
    }

    public void setEc(double ec) {
        this.ec = ec;
    }
    
    
}
