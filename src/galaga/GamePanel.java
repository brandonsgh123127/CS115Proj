  package galaga;

import galaga.Listener.AListener;
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
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //gets dimensions of user
                                                                        //screen for fullscreen
    public final double WIDTH =  screenSize.getWidth(), HEIGHT = screenSize.getHeight();
    public final static int rate = 32;
    private int enemyNum = 12;
    private int[] spawnPos = new int[2]; //Keeps track of spawn positions (x,y)
    Timer update;
    
    
    /*
    * Create new Controlled_Player in center bottom of screen
    */
    private Controlled_Player p = new Controlled_Player((int)(WIDTH / 2),(int) HEIGHT, 20, 20);
    
    //ArrayList to count enemies
    private ArrayList<Enemy_Player> enemies = new ArrayList<Enemy_Player>();
    /*
    *Create initial Enemies through gamepanel
    */
    protected GamePanel(){
        //Creates spawn positions for the enemies on display
        for(int i = 0; i <enemyNum / 2; i++){
            spawnPos[0] = (int)(WIDTH / (enemyNum / i));
            spawnPos[1] = 10;
            enemies.add(new Enemy_Player(spawnPos[0],spawnPos[1],15,15,1));
        }
        
        //update = new Timer(rate,AListener);
    }
}
