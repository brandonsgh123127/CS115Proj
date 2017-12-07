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
    public final static int RATE = 50;
    private int enemyNum = 12;
    private int[] spawnPos = new int[2]; //Keeps track of spawn positions (x,y)
    Timer update;
    private boolean isGameOver = false;
    
    private int enemy_speed = 5;
    public final static int LEVELS = 5;
    private int level = 1;
    Timer restart;
    
    
    /*
    * Create new Controlled_Player in center bottom of screen
    *///
    private Controlled_Player p = new Controlled_Player((int)(WIDTH / 2),(int) HEIGHT - 75, (int)(WIDTH / 50.0), (int)(WIDTH / 50.0),15,0,5);
    //ArrayList to count enemies
    private ArrayList<Enemy_Player> enemies = new ArrayList<Enemy_Player>();
    //ArrayList to keep track of shots
    private ArrayList<Shot> shots = new ArrayList<Shot>();
    /*
    *Create initial Enemies through gamepanel
    */
    public GamePanel()
    {
        reset_enemies();
        //initialize the timer based on RATE and Action Listener
        update = new Timer(RATE, new AListener());
        addKeyListener (new ControllerListener());
        setPreferredSize (new Dimension((int)WIDTH, (int)HEIGHT));
        setBackground (Color.black);
        setFocusable(true);
        //starts the updating
        update.start(); 
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        g.setColor(Color.WHITE);
        super.paintComponent(g);
        p.paint(g, "Galaga_ship.png");
        for(int i = 0; i <enemies.size(); i++)
        {
            enemies.get(i).move();
            enemies.get(i).paint(g, "Boss_Galaga.png");
        } 
        g.drawString("Score:"+Integer.toString(p.getScore()), 10, 20);
        g.drawString("Lives:"+Integer.toString(p.getLives()), 10, 40);
        g.drawString("Level:"+level, 10, 60);
      
        for(int i =0; i < shots.size(); i++)
        {
            shots.get(i).paint(g);
        }
        //if player doesn't have any lives, display game over or if they beat all the levels
        if(p.isDead() || (enemies.size() <= 0 && level >= LEVELS))
        {
            game_over(g);
        }     
    }
    
    public void reset()
    {
        p.setScore(0);
        p.setLives(5);
        level = 1;
        enemy_speed=5;
        
        p.set_xpos((int)(WIDTH / 2));
        p.set_ypos((int) HEIGHT - 75); 
    }
    
    public void reset_enemies()
    {
         //Creates spawn positions for the enemies on display
        for(int i = 0; i <1; i++)
        {
            spawnPos[0] = (int)(WIDTH / (enemyNum / (i + 1)));
            spawnPos[1] = 10;
            enemies.add(new Enemy_Player(spawnPos[0],spawnPos[1],15,15,enemy_speed,5,5, (int)WIDTH));
        }
    }
    
    public class AListener implements ActionListener
    {
     
        private int counter = 20;
    
        @Override
        public void actionPerformed(ActionEvent e)
        {  
            //update counter
            counter = (counter - 1)%(GamePanel.RATE / 2) / 2;
            
            if (ControllerListener.isLeft())
            {
                if(update.isRunning())
                {
                    p.move_left(); 
                }
            }
            if (ControllerListener.isRight())
            {
                if(update.isRunning())
                {
                    p.move_right();
                } 
            }
         
            //Checks to see if player is shooting
            if(ControllerListener.isShooting())
            {
                if(update.isRunning())
                {
                    p.shoot(shots);
                }
            }
         
            if(ControllerListener.isRestarted())
            {
                if(restart.isRunning())
                {
                    reset();
                    reset_enemies();
                    restart.stop();
                    update.start();
                }
            }

            //Update current state of the game and draw
            process_collisions();
            repaint();
        }  
    }   
    
    public void process_collisions()
    {
        for(int i =0; i < enemies.size(); i++)
        {
            //checks to see if enemy hit player 
            if(enemies.get(i).hit(p))
            {
                enemies.remove(i);
                p.loseLife();
            }   
            //checks to see if shot hit enemy
            for(int j=0; j < shots.size(); j++)
            {
                if(enemies.get(i).hit(shots.get(j)))
                {
                    enemies.get(i).setHealth(enemies.get(i).getHealth()-1);
                    shots.remove(j);
                    p.incScore(50);      
                }
            }
            //checks to see if enemy is dead 
            if(enemies.get(i).isDead())
            {
                enemies.remove(i);
                p.incScore(50);
            }
            if(enemies.size() <= 0 && level < LEVELS)
            {
                level_up();
                level++;
            }
        }
    }
       
    public void level_up()
    {
        reset_enemies();
        enemy_speed+=5;
    }
        
    public void game_over(Graphics g)
    {
        update.stop();
        g.drawString("Game Over", (int)WIDTH/2, (int)HEIGHT/4);
        g.drawString("Press Enter to play again...", (int)WIDTH/2, (int)HEIGHT/2);
        g.drawString("SCORE:"+ p.getScore(), (int)WIDTH/2, (int)(HEIGHT/4)+(int)(HEIGHT/8));
        restart = new Timer(RATE, new AListener());
        restart.start();
    }
}

