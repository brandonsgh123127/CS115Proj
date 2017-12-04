package galaga;
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
    public Enemy_Player(int xPos, int yPos, int width, int height, int x_move, int y_move, int health){
        super(xPos, yPos, width, height, x_move, y_move);
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
    
}
    
    
