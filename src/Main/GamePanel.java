/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.awt.Dimension;
import javax.swing.JPanel;

/**
 *
 * @author Rune
 */
public class GamePanel extends JPanel{
    
    private static int WIDTH = 240;
    private static int HEIGHT = 240;

    public GamePanel() {
        super();
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }
    
    
    
}
