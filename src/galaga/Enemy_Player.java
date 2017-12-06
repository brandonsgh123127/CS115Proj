package galaga;
/**
 *
 * @author soslovic
 */
public class Enemy_Player extends Player{
    private int health; //The number of hits it takes to kill the enemy
    private final int screenWidth;
    private boolean moveRight = true;
    /**
     * The constructor for the Enemy_Player object
     * @param xPos the enemy's starting x position
     * @param yPos the enemy's starting y position
     * @param width the width of each pixel for the enemy
     * @param height the height of each pixel for the enemy
     * @param health the health of the enemy
     */
    public Enemy_Player(int xPos, int yPos, int width, int height, int x_move, int y_move, int health, int screenWidth){
        super(xPos, yPos, width, height, x_move, y_move);
        this.health = health;
        this.screenWidth = screenWidth;
    }
    
    /**
     * Makes the enemy players move across the screen
     */
    public void move(){
        if(moveRight){
            if(super.get_xpos() + super.get_xmove()*2 + super.get_width()>= screenWidth){
                moveRight = false;
                super.move_down();
            }
            else{
                super.move_right();
            }
        }
        else{
            if(super.get_xpos() <= 0){
                moveRight = true;
                super.move_down();
            }
            else{
                super.move_left();
            }
        }
        
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
    
    
