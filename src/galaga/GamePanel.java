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
    private int enemyNum = 0;
    private int[] spawnPos = new int[2]; //Keeps track of spawn positions (x,y)
    Timer update;
    private boolean isGameOver = false;
    public Random r = new Random();
    
    private int enemy_health = 1;
    private int enemy_speed = 5;
    public final static int LEVELS = 30;
    private int level = 1;
    Timer restart;
    
    
    /*
    * Create new Controlled_Player in center bottom of screen
    *///
    private Controlled_Player p = new Controlled_Player((int)(WIDTH / 2),(int) HEIGHT - 75, (int)WIDTH / 30, (int)WIDTH / 30 ,15,0,3);
    //ArrayList to count enemies
    private ArrayList<Enemy_Player> enemies = new ArrayList<Enemy_Player>();
    //The powerup object. It will use polymorphism to switch between powerups
    private Powerup powerup;
    private Triple_Shot ts = new Triple_Shot((int)WIDTH, (int)HEIGHT);
    private Extra_Life el = new Extra_Life((int)WIDTH, (int)HEIGHT);
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
            enemies.get(i).paint(g, "Boss_Galaga.png");
            enemies.get(i).move();
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
        if(enemyNum < 24){
        enemyNum += 6;
        }
        else   //reset the round
        {
            enemyNum = 12;
            enemy_health++;
            enemy_speed++;
        }
         //Creates spawn positions for the enemies on display
        for(int i = 0; i < enemyNum; i++)
        {   
            boolean moveRight = true;
            spawnPos[0] = (int)(WIDTH/30)*2*i;
            spawnPos[1] = 10;
            if(i > 12){
                spawnPos[0] = (int)(WIDTH/30)*2*(25- i);
                spawnPos[1] = 10 + (int) WIDTH/25;
                moveRight = false;
            }
                enemies.add(new Enemy_Player(spawnPos[0],spawnPos[1],(int)WIDTH / 30,(int)WIDTH / 30,enemy_speed,(int)WIDTH / 25, enemy_health, (int)WIDTH, moveRight));
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
                    //Makes it so the player can't go off the screen to the left
                    if(p.get_xpos() - p.get_xmove() >= 0){
                        p.move_left(); 
                    }
                }
            }
            if (ControllerListener.isRight())
            {
                if(update.isRunning())
                {
                    //Makes it so the player can't go off the screen to the right
                    if(p.get_xpos() + p.get_width() + p.get_xmove() < WIDTH - 8){
                        p.move_right();
                    }
                } 
            }
         
            //Checks to see if player is shooting
            if((ControllerListener.isShooting() && !ControllerListener.isPressed()))
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
