/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameElements;

import java.awt.Color;
import java.awt.Graphics2D;
import Player.NPC;
/**
 *
 * @author espen
 */
public class Oval {

    public void draw(Graphics2D g, NPC npc, Text text) {
        int x = text.getText().length() / ;
        
        g.setColor(Color.WHITE);
        g.fillOval(Integer.parseInt(s[1]) - 10, Integer.parseInt(s[2]) - 60, 150, 40);
        g.setColor(Color.BLACK);
        g.drawString(s[0], Integer.parseInt(s[1]), Integer.parseInt(s[2]) - 37);
    }
}
