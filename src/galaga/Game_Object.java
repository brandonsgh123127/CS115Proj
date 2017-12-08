
package galaga;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.PixelGrabber;


public class Game_Object
{
    private int x_pos;
    private int y_pos;
    private int height;
    private int width;
    private int x_move;
    private int y_move;
    private Color color;

    public Game_Object(int x_pos, int y_pos, int height, int width, int x_move, int y_move)
    {
        this.x_pos = x_pos;
        this.y_pos = y_pos;
        this.height = height;
        this.width = width;
        this.x_move = x_move;
        this.y_move = y_move;
    }

    public int get_xpos() { return x_pos;}
    public void set_xpos(int x_pos) { this.x_pos = x_pos;}

    public int get_ypos() { return y_pos;}
    public void set_ypos(int y_pos) { this.y_pos = y_pos;}

    public int get_height() { return height;}
    public void set_height(int height) { this.height = height;}

    public int get_width() { return width;}
    public void set_width(int width) { this.width = width;}

    public int get_xmove() { return x_move;}
    public void set_xmove(int x_move) { this.x_move = x_move;}

    public int get_ymove() { return y_move;}
    public void set_ymove(int y_move) { this.y_move = y_move;}

    public Color get_color() { return color;}
    public void set_color(Color color) { this.color = color;}
    
    public void set_pos(int x, int y)
    {
        this.x_pos = x;
        this.y_pos = y;
    }
    
    public void move_up()
    {
        y_pos -= y_move;
    }
    public void move_down()
    {
        y_pos += y_move;
    }
    public void move_right()
    {
        x_pos += x_move;
    }
    public void move_left()
    {
        x_pos -= x_move;
    }
    
    public void paint(Graphics g)
    {
        g.fillRect(x_pos, y_pos, width, height);
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
    
    public boolean out_of_bounds(int screen_width, int screen_height)
    {
        return (x_pos > screen_width || y_pos > screen_height || x_pos + width < 0 || y_pos + height < 0);
    }
    
    /**
     * Paints the image
     * @param g the graphics
     * @param imageName the name of the image file
     */
    public void paint(Graphics g, String imageName) {
        ImageIcon icon = new ImageIcon(imageName);
        Image img = icon.getImage();
        Image newimg = img.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimg);
        icon.paintIcon(null, g, x_pos, y_pos);
    }
    /*
    * returns if coordinates are empty or not in a 2d array
    */
  //  public boolean[][] getCoordinates(ImageIcon icon){
  //       boolean[][] coordinates = new boolean[icon.getIconWidth()][icon.getIconHeight()];
  //      for(int i = 0; i < coordinates.length;i++){
   //         for(int j = 0; j < coordinates[i].length;j++){
  //              if(icon.)
   //         }
   //     }
  //  }
    
}
