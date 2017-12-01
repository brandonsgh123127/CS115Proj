package galaga;

/**
 *
 * @author bspada
 */
public class Enemy_Player extends Player{
    int health;
    public Enemy_Player(int xPos, int yPos, int width, int height, int health){
        super(xPos, yPos, width, height);
        this.health = health;
    }
    
}
