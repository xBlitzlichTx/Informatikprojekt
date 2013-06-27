/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Manuel
 */
public class Terrain {
    private int type;
    private Unit unit;
    private int player;
    
    public Terrain(int ty, Unit u, int play){
        type=ty;
        unit=u;
        player=play;
    }
    
    public int getType(){
        return type;
    }
    
    public Unit getUnit(){
        return unit;
    }
    
    public void setUnit(Unit un){
        unit=un;
    }
    
    //Wenn auf dem Feld eine Einheit ist, dann true, wenn nicht false
    public boolean occupied(){
        return unit!=null;
    }
}
