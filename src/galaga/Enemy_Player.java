package galaga;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author soslovic
 */
public class Enemy_Player extends Player{
    private int health; //The number of hits it takes to kill the enemy
    
    /**
     * The constructor for the Enemy_Player object
     * @param xPos the enemy's starting x position
     * @param yPos the enemy's starting y position
     * @param width the width of each pixel for the enemy
     * @param height the height of each pixel for the enemy
     * @param health the health of the enemy
     */
    public Enemy_Player(int xPos, int yPos, int width, int height, int health){
        super(xPos, yPos, width, height);
        this.health = health;
    }
    
    /**
     * Gets the enemy's health
     * @return the enemy's health
     */
    public int getHealth(){
        return health;
    }
    
    /**
     * Decreases the enemy's health
     */
    public void loseHealth(){
        if(health > 0){
            health--;
        }
    }
    
    /**
     * Returns true if the player is dead
     * @return whether the player is dead
     */
    public boolean isDead(){
        if(health <= 0){
            return true;
        }
        return false;
    }
    
    /**
     * Paints the enemy sprite pixel by pixel,   NOT COMPLETE
     * @param g the graphics
     */
    public void paint(Graphics g){
        g.setColor(Color.WHITE);
        //Line 1
        
        
        //Line 2
        
        //Line 3
        
        //Line 4
        
 
        //Line 5
        
        //Line 6
        g.setColor(Color.BLUE);
        
        
        g.setColor(Color.RED);
        
        g.setColor(Color.WHITE);
        
        //Line 7
        g.setColor(Color.BLUE);
        
        g.setColor(Color.RED);
        
        g.setColor(Color.WHITE);
        
        //Line 8
        g.setColor(Color.RED);
        
        g.setColor(Color.WHITE);
        
        //Line 9
        
        }
        //Line 10
        
        
        //Line 11
    }
    
    
