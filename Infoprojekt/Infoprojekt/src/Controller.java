
import java.awt.event.KeyEvent;



/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dominik
 */
public class Controller {
    private Model model;
    private View view;
    
    
    public void Controller(){
        model=new Model(null);
        view = new View(model);
        model.setView(view);
        view.setVisible(true);
        
    }
    
    public boolean moveUnit(int posx, int posy, Unit move){
        if(model.battlefield[posx][posy].getUnit()==null){
            model.battlefield[posx][posy].setUnit(move);
            model.battlefield[posx][posy].getUnit().x = posx;
            model.battlefield[posx][posy].getUnit().y = posy;
            
            return true;   
        }
        else{
            return false;
        }
    
    }
    
}
