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
import javax.swing.Timer;
  


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
    private Controlled_Player p = new Controlled_Player((int)(WIDTH / 2),(int) HEIGHT, 20, 20,3);
    
    //ArrayList to count enemies
    private ArrayList<Enemy_Player> enemies = new ArrayList<Enemy_Player>();
    /*
    *Create initial Enemies through gamepanel
    */
    public GamePanel(){
        //Creates spawn positions for the enemies on display
        for(int i = 0; i <enemyNum / 2; i++){
            spawnPos[0] = (int)(WIDTH / (enemyNum / (i + 1)));
            spawnPos[1] = 10;
            enemies.add(new Enemy_Player(spawnPos[0],spawnPos[1],15,15,1));
        }
        //initialize the timer based on rate and Action Listener
        update = new Timer(rate, new AListener());
        addKeyListener (new ControllerListener());
      setPreferredSize (new Dimension((int)WIDTH, (int)HEIGHT));
      setBackground (Color.black);
      setFocusable(true);
      //starts the updating
      update.start(); 
    }
    @Override
    public void paintComponent(Graphics g){
        g.setColor(Color.WHITE);
        super.paintComponent(g);
        
        
        /*
        * If enemy collides with player, remove enemy from screen
        */
        for(int i =0; i < enemies.size(); i++){
            if((p.getXPos()<=enemies.get(i).getXPos())&& (p.getYPos()<= enemies.get(i).getYPos())
                  &&(p.getXPos() + p.getWidth() >= enemies.get(i).getXPos() && ((p.getYPos() >= (enemies.get(i).getYPos() +enemies.get(i).getHeight()))) ))
                enemies.remove(i);
        
        else{
                enemies.get(i).paint(g);
                }
    
        }
    }
    public class AListener implements ActionListener{
     
    private int counter = 20;
    
        @Override
        public void actionPerformed(ActionEvent e) {
            //update counter
            counter = (counter - 1)%(GamePanel.rate / 2) / 2;
            
         if (ControllerListener.isLeft()){ p.moveLeft(); }
         if (ControllerListener.isRight()){ p.moveRight(); }
            //Update current state of the game and draw
            process_collisions();
            repaint();
            
        }
        
        
        public void process_collisions(){
            
        }


}
}
