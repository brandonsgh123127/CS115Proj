package galaga;

import java.awt.Color;
import java.awt.Graphics;
/**
 *
 * @author soslovic
 */
public class Controlled_Player extends Player{
    private int ammo;
    
    /**
     * The constructor
     * @param xPos the x position
     * @param yPos the y position
     * @param width the width of each pixel of the player
     * @param height the height of each pixel of the player
     */
    public Controlled_Player(int xPos, int yPos, int width, int height){
        super(xPos, yPos, width, height);
    }
    
    /**
     * Paints the players space ship
     * @param g the graphics
     */
    @Override
    public void paint(Graphics g){
        g.setColor(Color.WHITE);
        //Line 1
        g.fillRect(getXPos() - getWidth()*7, getYPos(), getWidth(), getHeight());
        
        //Line 2
        g.fillRect(getXPos() - getWidth()*7, getYPos(), getWidth(), getHeight());
        
        //Line 3
        
        //Line 4
        
        //Line 5
        
        //Line 6
        
        //Line 7
        
        //Line 7
        
        //Line 8
        
        //Line 9
        
        //Line 10
        
        //Line 11
        
        //Line 12
        
        //Line 13
        
        //Line 14
        
        //Line 15
    }
    
}
