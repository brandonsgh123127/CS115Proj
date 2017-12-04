package galaga;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class Player extends Game_Object{
    
    /**
     * The constructor
     * @param xPos the x position of the player
     * @param yPos the y position of the player
     * @param width the width of each pixel of the player
     * @param height the height of each pixel of the player
     */
    public Player(int xPos, int yPos, int width, int height,int x_move, int y_move) {
        super(xPos, yPos, width, height,x_move, y_move);
        
    }
    
}
