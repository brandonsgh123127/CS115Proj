/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galaga;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author bspada
 */
public class ControllerListener implements KeyListener {
    public static boolean[] key_pressed = new boolean[4];
    private final static int 
                    LEFT = KeyEvent.VK_LEFT,   //used to move left
                    RIGHT = KeyEvent.VK_RIGHT,  //used to move right
                    SHOOT = KeyEvent.VK_SPACE, //used to switch the player between attack and defense
                    RESTART = KeyEvent.VK_ENTER;  //used for menu entering, ect
   
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case LEFT:
               key_pressed[0] = true;
               break;
            case RIGHT:
               key_pressed[1] = true;
               break;
            case SHOOT:
               key_pressed[2] = true;
               break;
            case RESTART:
               key_pressed[3] = true;
               break;
         }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()){
            case LEFT:
               key_pressed[0] = false;
               break;
            case RIGHT:
               key_pressed[1] = false;
               break;
            case SHOOT:
               key_pressed[2] = false;
               break;
            case RESTART:
               key_pressed[3] = false;
               break;
         }
    }
    /*
    *Not necessary, abstract method required
    */
    @Override
    public void keyTyped(KeyEvent e) {}    
    //Accessor methods
    public static boolean isLeft(){return key_pressed[0];}
    public static boolean isRight(){return key_pressed[1];}
    public static boolean isShooting(){return key_pressed[2];}
    public static boolean isRestarted(){return key_pressed[3];}
}
