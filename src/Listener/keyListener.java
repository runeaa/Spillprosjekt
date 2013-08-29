/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Rune
 */
public class keyListener implements KeyListener{

    
    public class Key{
        private boolean isPressed;
        
        public void pressKey(boolean value){
            isPressed = value;
        }
    }
    
    Key up = new Key();
    Key down = new Key();
    Key left = new Key();
    Key right = new Key();
    
    
    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
