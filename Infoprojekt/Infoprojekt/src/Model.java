/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Manuel
 */
public class Model {
    
    private View view;
    private int player; // Der Spieler der gerade an der Reihe ist
    
    public Terrain[][] battlefield;
    
    //Fixed Game Values
    public static int[][] unitFRangeMatrix;
    public static double[][] unitDamageMatrix;
    
    public static int[] unitDefValues;
    public static int[] unitMoveValues;
    public static int[] terrainDefValues;
    public static boolean[] terrainCapturable;
    public static int[][] terrainMoveValues;
    public static boolean[] terrainCrossable;
    
    public static String[] terrainImages;
    public static String[] unitImages;
    
    
    public Model(View v){
        int n_units=10;
        int n_terrain=11;
        
        int bfSizeX=15;
        int bfSizeY=15;
        
        view = v;
        
        battlefield=new Terrain[bfSizeX][bfSizeY];
        
        //Anzahl der Einheitenklassen n_units
        unitFRangeMatrix = new int[n_units][2];
        unitDamageMatrix = new double[n_units][n_units];
        
        unitDefValues =new int[n_units];
        unitMoveValues =new int[n_units];
        //Anzahl der Terrainklassen n_terrain
        terrainDefValues = new int[n_terrain];
        terrainMoveValues = new int[n_terrain][n_units];
        terrainCapturable = new boolean[n_terrain];
        
        //Dateipfade zu den Bildern
        unitImages=new String[n_terrain];
        terrainImages=new String[n_terrain];
        
        /////////////////////////////////////////////////////////
        //Hier die Werte für die Matrixes und Values definieren//
        /////////////////////////////////////////////////////////

        /*
         * Unit 0: Infantry
         * Unit 1: Mechanised
         * Unit 2: Motorised
         * Unit 3: Light Tank
         * Unit 4: Medium Tank
         * Unit 5: Heavy Tank
         * Unit 6: Walker
         * Unit 7: Anti Tank
         * Unit 8: SPG
         * Unit 9: Rocket Artillery
         */
        //Fireringrange Werte für die Einheiten
        unitFRangeMatrix[0][0]=1;
        unitFRangeMatrix[0][1]=1;
        unitFRangeMatrix[1][0]=1;
        unitFRangeMatrix[1][1]=1;
        unitFRangeMatrix[2][0]=1;
        unitFRangeMatrix[2][1]=1;
        unitFRangeMatrix[3][0]=1;
        unitFRangeMatrix[3][1]=1;
        unitFRangeMatrix[4][0]=1;
        unitFRangeMatrix[4][1]=1;
        unitFRangeMatrix[5][0]=1;
        unitFRangeMatrix[5][1]=1;
        unitFRangeMatrix[6][0]=1;
        unitFRangeMatrix[6][1]=1;
        
        //Units mit höherer Fireringrange
        
        unitFRangeMatrix[7][0]=1;
        unitFRangeMatrix[7][1]=4;
        unitFRangeMatrix[8][0]=2;
        unitFRangeMatrix[8][1]=5;
        unitFRangeMatrix[9][0]=3;
        unitFRangeMatrix[9][1]=7;

        //Damage Werte für die Einheiten
        unitDamageMatrix[0][0]=0.55;

        
    }
    
    
    public void setView(View v){
        view=v;
    }
    
    
    
    
    public void checkActions(Unit unit, int posx,int posy){
        
        //ist auf den umliegenden Feldern eine feindliche Einheit?
        boolean fight=  isEnemy(posx+1, posy)||isEnemy(posx-1, posy)||isEnemy(posx, posy+1)||isEnemy(posx, posy-1);
        //Kann man hier einnehmen?
        boolean take =  terrainCapturable[battlefield[posx][posy].getType()];
        
        view.displayMenu(fight,take);
        
        
    }
    
    public void battle(Unit unit1, Unit unit2){
        
    }
    
    public void move(Unit unit, int posx, int posy){
        battlefield[unit.x][unit.y].setUnit(null);
        unit.x=posx;
        unit.y=posy;
        battlefield[posx][posy].setUnit(unit);
        view.move(unit, posx, posy);
    }
    
    private boolean isEnemy(int posx, int posy){
        //Ist auf dem Feld eine Einheit?
        if(battlefield[posx][posy].occupied()){
            //Wenn ja, ist sie feindlich?
            if(battlefield[posx][posy].getUnit().getPlayer()!=player){
                return true;
            } else {
                //Wenn nein, dann ist kein feind auf dem Feld
                return false;
            }
        } else {
            //Wenn nein, dann ist keine einheit auf dem Feld
            return false;
        }
    }
    
    
}
