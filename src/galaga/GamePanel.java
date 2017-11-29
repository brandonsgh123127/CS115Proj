  package galaga;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.ArrayList;
import java.util.Timer;
  
public class GamePanel extends JPanel{ 


public class GamePanel extends JPanel{ 
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //gets dimensions of user
                                                                        //screen for fullscreen
    public final double WIDTH =  screenSize.getWidth(), HEIGHT = screenSize.getHeight();
    public final static int rate = 32;
    public int enemies = 12;
    private final static int UP = KeyEvent.VK_UP,     //used to move up
                            DOWN = KeyEvent.VK_DOWN,   //used to move down
                            LEFT = KeyEvent.VK_LEFT,   //used to move left
                            RIGHT = KeyEvent.VK_RIGHT,  //used to move right
                            SHOOT = KeyEvent.VK_SPACE, //used to switch the player between attack and defense
                            AMMO = KeyEvent.VK_SPACE,  //used to do an attack or defens action
                            ESCAPE = KeyEvent.VK_ENTER;  //used for menu entering, ect
    
}

}
