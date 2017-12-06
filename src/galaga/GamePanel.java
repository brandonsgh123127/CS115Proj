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
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import java.util.ArrayList;
import javax.swing.Timer;
  


public class GamePanel extends JPanel{ 
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //gets dimensions of user
                                                                        //screen for fullscreen
    public final double WIDTH =  screenSize.getWidth(), HEIGHT = screenSize.getHeight() - 75;
    public final static int rate = 50;
    private int enemyNum = 12;
    private int[] spawnPos = new int[2]; //Keeps track of spawn positions (x,y)
    Timer update;
    
    
    /*
    * Create new Controlled_Player in center bottom of screen
    */
    private Controlled_Player p = new Controlled_Player((int)(WIDTH / 2),(int) HEIGHT - 75, (int)(WIDTH / 50.0), (int)(WIDTH / 50.0),3,5,5);
    Graphics p1;
    //ArrayList to count enemies
    private ArrayList<Enemy_Player> enemies = new ArrayList<Enemy_Player>();
    //ArrayList to keep track of shots
    private ArrayList<Shot> shots = new ArrayList<Shot>();
    /*
    *Create initial Enemies through gamepanel
    */
    public GamePanel(){
        
        
        //Creates spawn positions for the enemies on display
        for(int i = 0; i <1; i++){
            spawnPos[0] = (int)(WIDTH / (enemyNum / (i + 1)));
            spawnPos[1] = 10;
            enemies.add(new Enemy_Player(spawnPos[0],spawnPos[1],15,15,1,5,5));
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
        p.paint(g, "Galaga_ship.png");
        for(int i = 0; i <enemies.size(); i++){
            enemies.get(i).paint(g, "Boss_Galaga.png");
        } 
        g.drawString("Score:"+Integer.toString(p.getScore()), 10, 20);
      g.drawString("Lives:"+Integer.toString(p.getLives()), 10, 40);
      
      for(int i =0; i < shots.size(); i++)
      {
          shots.get(i).paint(g);
      }
    //if player doesn't have any lives, display game over
      if(p.isDead()){
          update.stop();
          g.drawString("GAME OVER", (int)(WIDTH / 2), (int)(HEIGHT / 2));
          g.drawString("Press \"ESC\" to play again...",(int) (WIDTH / 2),(int) (HEIGHT / 2) + 200);
                  
      }
         
    }
    
    public class AListener implements ActionListener{
     
    private int counter = 20;
    
        @Override
        public void actionPerformed(ActionEvent e) { 
            
            //update counter
            counter = (counter - 1)%(GamePanel.rate / 2) / 2;
            
         if (ControllerListener.isLeft()){ p.move_left(); }
         if (ControllerListener.isRight()){ p.move_right(); }
            //Update current state of the game and draw
         
         //Checks to see if player is shooting
         if(ControllerListener.isShooting()){p.shoot(shots);}
         

            process_collisions();
            repaint();
        }
        
        
        public void process_collisions(){
        for(int i =0; i < enemies.size(); i++){
            //checks to see if enemy hit player 
            if(enemies.get(i).hit(p)){
                 enemies.remove(i);
                 p.loseLife();
                 
            }
        
        
            
        }

}
    }
}

