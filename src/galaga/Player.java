package galaga;

import java.awt.Graphics;
import java.awt.Color;

public class Player {
    private int xPos, yPos, width, height;
    
    /**
     * The constructor
     * @param xPos the x position of the player
     * @param yPos the y position of the player
     * @param width the width of each pixel of the player
     * @param height the height of each pixel of the player
     */
    public Player(int xPos, int yPos, int width, int height) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;
    }
    
    /**
     * Gets the x position of the player
     * @return the x position
     */
    public int getXPos(){
        return xPos;
    }
    /**
     * Gets the y position of the player
     * @return the y position
     */
    public int getYPos(){
        return yPos;
    }
    /**
     * Gets the width of each pixel of the player
     * @return the width of each pixel of the player
     */
    public int getWidth(){
        return width;
    }
    /**
     * Gets the height of each pixel of the player
     * @return the height of each pixel of the player
     */
    public int getHeight(){
        return height;
    }
    /**
     * Moves the player to the right one pixel
     */
    public void moveRight(){
        xPos += getWidth();
    }
    /**
     * Moves the player to the left one pixel
     */
    public void moveLeft(){
        xPos -= getWidth();
    }
    /**
     * Moves the player up one pixel
     */
    public void moveUp(){
        yPos += getHeight();
    }
    /**
     * Moves the player down one pixel
     */
    public void moveDown(){
        yPos -= getHeight();
    }
}
