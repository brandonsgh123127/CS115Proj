package galaga;

/**
 *
 * @author Samuel
 */
public class Extra_Life extends Powerup{
    
    public Extra_Life(int WIDTH, int HEIGHT){
        super(WIDTH, HEIGHT);
    }
    
    public void addLife(Controlled_Player p){
        p.gainLife();
    }
}
