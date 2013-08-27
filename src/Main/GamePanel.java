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
    private boolean running;
    private Thread thread;

    public GamePanel() {
        super();
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }
    
    public void addNotify(){
        super.addNotify();
        if(thread == null){
            thread = new Thread();
            running = true;
        }
    }
    
    public void init(){}
    
    public void run(){
        init();
        while(running){
           //gameloop
            update();
            render();
            draw();
        }
    }
    
    public void update(){}
    
    public void render(){
        
    }
    
    public void draw(){}
    
}
