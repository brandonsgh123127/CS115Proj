package galaga;

import java.awt.Graphics;
import java.util.ArrayList;
/**
 *
 * @author soslovic
 */
public class Controlled_Player extends Player{
    private int lives;
    private int score = 0; //Sets the initial score of the player to 0
    private boolean tripleShot = false;
    private int shotCounter = 0;
    
    /**
     * The constructor
     * @param xPos the x position
     * @param yPos the y position
     * @param width the width of each pixel of the player
     * @param height the height of each pixel of the player
     * @param lives how many lives the player starts with
     */
    public Controlled_Player(int xPos, int yPos, int width, int height, int x_move, int y_move, int lives){
        super(xPos, yPos, width, height, x_move, y_move);
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
     * Gets the players lives
     * @return the score of the player
     */
    public int getLives(){
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public void setScore(int score) {
        this.score = score;
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
    
    public void canTripleShoot(){
        tripleShot = true;
        shotCounter = 0;
    }
    
    /**
     * Shoots a projectile
     */
    public void shoot(ArrayList<Shot> shots)
    {
        //Insert code for shooting once the projectile object is done
        if(tripleShot){
        shots.add(new Shot(get_xpos()+(get_width()/2),get_ypos(),12,7,0,30));
        shots.add(new Shot(get_xpos()+(get_width()/2) - 20,get_ypos() + 5,12,7,0,30));
        shots.add(new Shot(get_xpos()+(get_width()/2) + 20,get_ypos() + 5,12,7,0,30));
        shotCounter++;
        }
        else{; 
        shots.add(new Shot(get_xpos()+(get_width()/2),get_ypos(),12,7,0,30));
        }
        if(shotCounter == 30){
            tripleShot = false;
            shotCounter = 0;
        }
    }
    
}