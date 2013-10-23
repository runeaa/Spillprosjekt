/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Listeners;

import Player.Player;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author haavamoa
 */
public class PauseListener implements MouseListener{

    private Player player;
    public PauseListener(Player player) {
        this.player = player;
    }
    
    

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //Inne i pausemenyen
        if(player.getOptionValue()){
            int x = e.getX();
            int y = e.getY();
            if(x>= 210 && x<=435){
                //resume
                if(y>=220 && y<=261){
                    player.setOptionTrigger(false);
                    player.lock++;
                }
                //end game
                else if(y>=292 && y<=340){
                    System.exit(0);
                }
                
                
            }
           }
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
