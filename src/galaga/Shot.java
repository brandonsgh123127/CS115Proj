/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galaga;

import java.awt.Graphics;

/**
 *
 * @author owner
 */
public class Shot extends Game_Object
{

    public Shot(int x_pos, int y_pos, int height, int width, int x_move, int y_move) 
    {
        super(x_pos, y_pos, height, width, x_move, y_move);
    }
    
    @Override
    public void paint(Graphics g)
    {
        move_up();
        g.fillOval(get_xpos(), get_ypos(), get_width(), get_height());
    }
    
}
