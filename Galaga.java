
package galaga;

import javax.swing.JFrame;

public class Galaga {

    public static void main(String[] args) 
    {
        JFrame frame = new JFrame ("Game");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new GamePanel());
        frame.pack();
        frame.setVisible(true);
    }
 
    
    //hello
}
