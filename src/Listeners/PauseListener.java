/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author haavamoa
 */
public class PauseListener implements MouseListener{

    private boolean optionValue;
    public PauseListener(boolean optionValue) {
        this.optionValue = optionValue;
    }
    
    

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
                System.out.println(optionValue);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
