package galaga;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.util.Random;

/**
 *
 * @author Samuel
 */
public class Powerup{
    private final int WIDTH, HEIGHT;
    private int x_pos, y_pos, width, height;
    private Random r = new Random();
    private boolean canPaint = true;
    
    public Powerup(int WIDTH, int HEIGHT) {
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        x_pos = r.nextInt(WIDTH/2 + 100);
        y_pos = r.nextInt(HEIGHT/2 + 100);
        width = WIDTH/30;
        height = HEIGHT/30;
    }
    
    public void remove(){
        canPaint = true;
    }
    
    public void reposition(){
        x_pos = r.nextInt(WIDTH/2 + 100);
        y_pos = r.nextInt(HEIGHT/2 + 100);
        canPaint = true;
    }
    
    public void paint(Graphics g, String imageName) {
        if(canPaint){
        ImageIcon icon = new ImageIcon(imageName);
        Image img = icon.getImage();
        Image newimg = img.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimg);
        icon.paintIcon(null, g, x_pos, y_pos);
        }
    }
}
