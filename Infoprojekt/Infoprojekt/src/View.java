
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 *
 * @author Dominik Schön
 */
public class View extends JFrame {
    
    private Model model;

int auswahlx = 0;      //Koordinaten für das zeichnen des Auswahlfenster
int auswahly = 0;     
JLabel auswahl;         //Das Auswahl-Label
ImageIcon grass = new ImageIcon("pictures/terrain/50x50/grassplains.png"); 
ImageIcon swamp = new ImageIcon("pictures/terrain/50x50/swamp.png"); 
JLabel[][] moveFeld = new JLabel[15][15];


public View(Model mdl) {
    
    model=mdl;
    
setSize(850, 850);              //Fenstergröße
setResizable(false);            //Manuelle Größenveränderung deaktiviert

JPanel panel = new JPanel(null);
panel.setSize(850, 850);        //Panel in Fenster einfügen
add(panel);

JLabel[][] bfield = new JLabel[15][15];     //TerrainFeld

auswahl = new JLabel("");            //Auswahl für Tastatursteuerung
auswahl.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.black));
auswahl.setBounds(48,48, 54,54);    //Position der Auswahl, abhängig von zwei int
panel.add(auswahl);
for(int k=0; k<15; k++){            //Darstellung des Terrains
    for(int l=0; l<15; l++){ 
       moveFeld[k][l] = new JLabel(); 
       
       moveFeld[k][l].setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.blue));//Bild setzen
       moveFeld[k][l].setBounds((50+k*50), (50+l*50), 50, 50);    //Position abhängig von i
       panel.add(moveFeld[k][l]);
       moveFeld[k][l].setVisible(false);
    }
}
for(int i=0; i<15; i++){            //Darstellung des Terrains
    for(int j=0; j<15; j++){ 
       bfield[i][j] = new JLabel(); 
       bfield[i][j].setOpaque(true);
       if(model.battlefield[i][j].getType()==1){
           bfield[i][j].setIcon(grass);
       }
       else if(model.battlefield[i][j].getType()==1){
           bfield[i][j].setIcon(swamp);
       }
       bfield[i][j].setBounds((50+i*50), (50+j*50), 50, 50);    //Position abhängig von i
       panel.add(bfield[i][j]);
    }
}



//Input durch die Tastatur
this.addKeyListener(
        new KeyListener(){
            @Override
            public void keyPressed(KeyEvent e) {
               if(e.getKeyCode()==KeyEvent.VK_DOWN){        //Wenn der untere Arrow-Key gedrückt wird, wird die Methode zum nach unten bewegen aufgerufen
                    moveSelectDown(); 
                }
               else if(e.getKeyCode()==KeyEvent.VK_UP){     //Wenn der obere Arrow-Key gedrückt wird, wird die Methode zum nach oben bewegen aufgerufen
                    moveSelectUp();
                }
               else if(e.getKeyCode()==KeyEvent.VK_LEFT){   //Wenn der links Arrow-Key gedrückt wird, wird die Methode zum links bewegen aufgerufen
                    moveSelectLeft();
                }
               else if(e.getKeyCode()==KeyEvent.VK_RIGHT){  //Wenn der rechts Arrow-Key gedrückt wird, wird die Methode zum rechts bewegen aufgerufen
                    moveSelectRight();
                }
               else if(e.getKeyCode()==KeyEvent.VK_SPACE){  //Wenn der rechts Arrow-Key gedrückt wird, wird die Methode zum rechts bewegen aufgerufen
                    //Àuswahl
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {  
            }
            
            @Override
            public void keyTyped(KeyEvent e) {   
            }
});     
}

//Methoden der Auswahlverschiebung
public void moveSelectUp(){   
    if((auswahly*50)+50>50){            //Wenn die Auswahl noch nicht ganz oben ist
        auswahly-=1;           
        auswahl.setBounds((auswahlx*50)+48,(auswahly*50)+48,54,54);     //wird sie um 50 Einheiten nach oben gesetzt
        } 
}
public void moveSelectDown(){   //Wenn die Auswahl noch nicht ganz unten ist
    if((auswahly*50)+50<750){
        auswahly+=1;
        auswahl.setBounds((auswahlx*50)+48,(auswahly*50)+48,54,54);      //wird sie um 50 Einheiten nach unten gesetzt
    }
}
public void moveSelectLeft(){    //Wenn die Auswahl noch nicht ganz links ist
    if((auswahlx*50)+50>50){
        auswahlx-=1;
        auswahl.setBounds((auswahlx*50)+48,(auswahly*50)+48,54,54);      //wird sie um 50 Einheiten nach links gesetzt   
    }
}
public void moveSelectRight(){   //Wenn die Auswahl noch nicht ganz rechts ist
    if((auswahlx*50)+50<750){
        auswahlx+=1;
        auswahl.setBounds((auswahlx*50)+48,(auswahly*50)+48,54,54);      //wird sie um 50 Einheiten nach rechtsgesetzt
    }
}

public boolean fieldAction(){
    if(false/*wenn das Terrain ungeeignet ist, oder keine Aktion vorhanden ist*/){
        return false;
    }
    else{
        if(true/*wenn auf dem Feld eine Truppe steht*/){
            for(int i= auswahlx; i<auswahlx+5; i++){
                for(int j= auswahly; j<auswahly+5; j++){
                    moveFeld[i][j].setVisible(true);
                }
            }
        }
        return true;
    }
    }
    

    
    

    /*
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
   /* /*
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
     */





    public void move(Unit unit1, int locationx, int locationy) {

        
    }
    
    public void displayMenu(boolean battle, boolean take){
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
