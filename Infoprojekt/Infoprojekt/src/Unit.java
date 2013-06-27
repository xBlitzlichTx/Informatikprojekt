/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Manuel
 */
public class Unit {
    private int type;
    private double hp;
    private int player;
    
    public int x;
    public int y;
    
    public Unit(int typ, int play, int posx, int posy){
        type=typ;
        player=play;
        x=posx;
        y=posy;
        hp=10.0;
    }
    
    public int getType(){
        return type;
    }
    
    public double getHP(){
        return hp;
    }
    
    public int getPlayer(){
        return player;
    }
    
    public void setHP(double hpnew){
        hp=hpnew;
    }
}
