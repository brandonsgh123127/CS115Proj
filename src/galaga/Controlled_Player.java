package galaga;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author soslovic
 */
public class Controlled_Player extends Player{
    private int lives;
    private int score = 0; //Sets the initial score of the player to 0
    
    /**
     * The constructor
     * @param xPos the x position
     * @param yPos the y position
     * @param width the width of each pixel of the player
     * @param height the height of each pixel of the player
     * @param lives how many lives the player starts with
     */
    public Controlled_Player(int xPos, int yPos, int width, int height, int lives){
        super(xPos, yPos, width, height);
        this.lives = lives;
    }
    
    /**
     * Decreases the players lives by 1
     */
    public void loseLife(){    
            lives--;
    }
    
    /**
     * Increases the players lives by 1
     */
    public void gainLife(){
        lives++;
    }
    
    /**
     * Gets the players score
     * @return the score of the player
     */
    public int getScore(){
        return score;
    }
    
    /**
     * Increases the players score
     * @param inc how much the score is increased by
     */
    public void incScore(int inc){
        score += inc;
    }
    
    /**
     * Returns true if the player is dead
     * @return whether the player is dead or not
     */
    public boolean isDead(){
        if(lives <= 0){
            return true;
        }
        return false;
    }
    
    /**
     * Shoots a projectile
     */
    public void shoot(){
        //Insert code for shooting once the projectile object is done
    }
    
    /**
     * Paints the players space ship pixel by pixel
     * @param g the graphics
     */
    public void paint(Graphics g){
        g.setColor(Color.WHITE);
        //Line 1
        g.fillRect(getXPos() + getWidth()*6, getYPos() + getHeight(), getWidth(), getHeight());
        
        //Line 2
        g.fillRect(getXPos() + getWidth()*6, getYPos() + getHeight()*2, getWidth(), getHeight());
        
        //Line 3
        g.fillRect(getXPos() + getWidth()*6, getYPos() + getHeight()*3, getWidth(), getHeight());
        
        //Line 4
        g.setColor(Color.RED);
        g.fillRect(getXPos() + getWidth()*3, getYPos() + getHeight()*4, getWidth(), getHeight());
        g.fillRect(getXPos() + getWidth()*9, getYPos() + getHeight()*4, getWidth(), getHeight());
        
        g.setColor(Color.WHITE);
        g.fillRect(getXPos() + getWidth()*5, getYPos() + getHeight()*4, getWidth(), getHeight());
        g.fillRect(getXPos() + getWidth()*6, getYPos() + getHeight()*4, getWidth(), getHeight());
        g.fillRect(getXPos() + getWidth()*7, getYPos() + getHeight()*4, getWidth(), getHeight());
 
        //Line 5
        g.fillRect(getXPos() + getWidth()*3, getYPos() + getHeight()*5, getWidth(), getHeight());
        g.fillRect(getXPos() + getWidth()*9, getYPos() + getHeight()*5, getWidth(), getHeight());
        g.fillRect(getXPos() + getWidth()*5, getYPos() + getHeight()*5, getWidth(), getHeight());
        g.fillRect(getXPos() + getWidth()*6, getYPos() + getHeight()*5, getWidth(), getHeight());
        g.fillRect(getXPos() + getWidth()*7, getYPos() + getHeight()*5, getWidth(), getHeight());
        
        //Line 6
        g.setColor(Color.BLUE);
        g.fillRect(getXPos() + getWidth()*4, getYPos() + getHeight()*6, getWidth(), getHeight());
        g.fillRect(getXPos() + getWidth()*8, getYPos() + getHeight()*6, getWidth(), getHeight());
        
        
        g.setColor(Color.RED);
        g.fillRect(getXPos() + getWidth()*6, getYPos() + getHeight()*6, getWidth(), getHeight());
        
        g.setColor(Color.WHITE);
        g.fillRect(getXPos() + getWidth()*3, getYPos() + getHeight()*6, getWidth(), getHeight());
        g.fillRect(getXPos() + getWidth()*5, getYPos() + getHeight()*6, getWidth(), getHeight());
        g.fillRect(getXPos() + getWidth()*7, getYPos() + getHeight()*6, getWidth(), getHeight());
        g.fillRect(getXPos() + getWidth()*9, getYPos() + getHeight()*6, getWidth(), getHeight());
        
        //Line 7
        g.setColor(Color.BLUE);
        g.fillRect(getXPos() + getWidth()*3, getYPos() + getHeight()*7, getWidth(), getHeight());
        g.fillRect(getXPos() + getWidth()*9, getYPos() + getHeight()*7, getWidth(), getHeight());
        
        g.setColor(Color.RED);
        g.fillRect(getXPos() + getWidth(), getYPos() + getHeight()*7, getWidth(), getHeight());
        g.fillRect(getXPos() + getWidth()*5, getYPos() + getHeight()*7, getWidth(), getHeight());
        g.fillRect(getXPos() + getWidth()*6, getYPos() + getHeight()*7, getWidth(), getHeight());
        g.fillRect(getXPos() + getWidth()*7, getYPos() + getHeight()*7, getWidth(), getHeight());
        g.fillRect(getXPos() + getWidth()*11, getYPos() + getHeight()*7, getWidth(), getHeight());
        
        g.setColor(Color.WHITE);
        g.fillRect(getXPos() + getWidth()*4, getYPos() + getHeight()*7, getWidth(), getHeight());
        g.fillRect(getXPos() + getWidth()*8, getYPos() + getHeight()*7, getWidth(), getHeight());
        
        //Line 8
        g.setColor(Color.RED);
        g.fillRect(getXPos() + getWidth()*5, getYPos() + getHeight()*8, getWidth(), getHeight());
        g.fillRect(getXPos() + getWidth()*7, getYPos() + getHeight()*8, getWidth(), getHeight());
        
        g.setColor(Color.WHITE);
        g.fillRect(getXPos() + getWidth(), getYPos() + getHeight()*8, getWidth(), getHeight());
        g.fillRect(getXPos() + getWidth()*3, getYPos() + getHeight()*8, getWidth(), getHeight());
        g.fillRect(getXPos() + getWidth()*4, getYPos() + getHeight()*8, getWidth(), getHeight());
        g.fillRect(getXPos() + getWidth()*6, getYPos() + getHeight()*8, getWidth(), getHeight());
        g.fillRect(getXPos() + getWidth()*8, getYPos() + getHeight()*8, getWidth(), getHeight());
        g.fillRect(getXPos() + getWidth()*9, getYPos() + getHeight()*8, getWidth(), getHeight());
        g.fillRect(getXPos() + getWidth()*11, getYPos() + getHeight()*8, getWidth(), getHeight());
        
        //Line 9
        for(int i = 1; i < 12; i++){
            g.fillRect(getXPos() + getWidth()*i, getYPos() + getHeight()*9, getWidth(), getHeight());
        
        }
        //Line 10
        g.setColor(Color.RED);
        g.fillRect(getXPos() + getWidth()*4, getYPos() + getHeight()*10, getWidth(), getHeight());
        g.fillRect(getXPos() + getWidth()*5, getYPos() + getHeight()*10, getWidth(), getHeight());
        g.fillRect(getXPos() + getWidth()*7, getYPos() + getHeight()*10, getWidth(), getHeight());
        g.fillRect(getXPos() + getWidth()*8, getYPos() + getHeight()*10, getWidth(), getHeight());
        
        g.setColor(Color.WHITE);
        g.fillRect(getXPos() + getWidth(), getYPos() + getHeight()*10, getWidth(), getHeight());
        g.fillRect(getXPos() + getWidth()*2, getYPos() + getHeight()*10, getWidth(), getHeight());
        g.fillRect(getXPos() + getWidth()*6, getYPos() + getHeight()*10, getWidth(), getHeight());
        g.fillRect(getXPos() + getWidth()*10, getYPos() + getHeight()*10, getWidth(), getHeight());
        g.fillRect(getXPos() + getWidth()*11, getYPos() + getHeight()*10, getWidth(), getHeight());
        
        //Line 11
        g.fillRect(getXPos() + getWidth(), getYPos() + getHeight()*11, getWidth(), getHeight());
        g.fillRect(getXPos() + getWidth()*6, getYPos() + getHeight()*11, getWidth(), getHeight());
        g.fillRect(getXPos() + getWidth()*11, getYPos() + getHeight()*11, getWidth(), getHeight());
    }
}