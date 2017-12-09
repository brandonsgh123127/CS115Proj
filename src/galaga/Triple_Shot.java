/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galaga;

/**
 *
 * @author Samuel
 */
public class Triple_Shot extends Powerup{
    private boolean activated = false;
    
    public Triple_Shot(int WIDTH, int HEIGHT){
        super(WIDTH, HEIGHT);
    }
    
    public void activate(){
        activated = true;
    }
    
    public void deactivate(){
        activated = false;
    }
    
    public boolean isActive(){
        return activated;
    }
}
