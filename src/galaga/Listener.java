/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galaga;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author bspada
 */
public class Listener implements KeyListener {
    private boolean[] key_pressed = new boolean[6];
    private final static int UP = KeyEvent.VK_UP,     //used to move up
                    DOWN = KeyEvent.VK_DOWN,   //used to move down
                    LEFT = KeyEvent.VK_LEFT,   //used to move left
                    RIGHT = KeyEvent.VK_RIGHT,  //used to move right
                    SHOOT = KeyEvent.VK_SPACE, //used to switch the player between attack and defense
                    ESCAPE = KeyEvent.VK_ENTER;  //used for menu entering, ect

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case UP:
               key_pressed[0] = true;
               break;
            case DOWN:
               key_pressed[1] = true;
               break;
            case LEFT:
               key_pressed[2] = true;
               break;
            case RIGHT:
               key_pressed[3] = true;
               break;
            case SHOOT:
               key_pressed[4] = true;
               break;
            case ESCAPE:
               key_pressed[5] = true;
               break;
         }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }
    


public class AListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
    
}
}