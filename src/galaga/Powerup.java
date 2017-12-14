package galaga;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.util.Random;

/**
 *
 * @author Samuel
 */
public class Powerup {
    private final int WIDTH, HEIGHT;
    private int x_pos, y_pos, width, height;
    private Random r = new Random();
    private boolean canPaint;
    
    
    public Powerup(int WIDTH, int HEIGHT) {
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        x_pos = r.nextInt(WIDTH/2 + 100);
        y_pos = r.nextInt(HEIGHT/2 + 100);
        width = WIDTH/30;
        height = WIDTH/30;
        canPaint = true;
    }
    
    public int get_xpos() { return x_pos;}

    public int get_ypos() { return y_pos;}
    
    public int get_height() { return height;}

    public int get_width() { return width;}
    
    public void remove(){
        canPaint = false;
    }
    public void add(){
        canPaint = true;
    }
    public boolean isVisible(){
        return canPaint;
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
    
    public boolean hit(Game_Object p)
    {
        for(int x = 0; x <= this.get_width(); x++){
            for(int y = 0; y <= this.get_height(); y++){
                if(x + this.get_xpos() == p.get_xpos() && y + this.get_ypos() == p.get_ypos() ){
                    return true;
                }
            }
        }
        return false;
    }
}
