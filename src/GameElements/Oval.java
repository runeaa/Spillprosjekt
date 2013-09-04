/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameElements;

import java.awt.Color;
import java.awt.Graphics2D;
import Player.NPC;
<<<<<<< HEAD
=======
import java.util.ArrayList;
>>>>>>> branch 'master' of https://github.com/runeaa/Spillprosjekt.git

/**
 *
 * @author espen
 */
public class Oval {

<<<<<<< HEAD
    /*    public void draw(Graphics2D g, NPC npc, Text text) {
     int x = text.getText().length() / ;
=======
    private NPC npc;
    private Text text;
    private int lines;
    private ArrayList<String> s;

    public Oval(NPC npc, Text text) {
        this.npc = npc;
        this.text = text;
        text.makeTab();
    }

    public void draw(Graphics2D g) {
>>>>>>> branch 'master' of https://github.com/runeaa/Spillprosjekt.git
        
<<<<<<< HEAD
     g.setColor(Color.WHITE);
     g.fillOval(Integer.parseInt(s[1]) - 10, Integer.parseInt(s[2]) - 60, 150, 40);
     g.setColor(Color.BLACK);
     g.drawString(s[0], Integer.parseInt(s[1]), Integer.parseInt(s[2]) - 37);
     }*/
=======
        s = text.getString();
        lines = text.getLines();
        System.out.println(lines);
        g.setColor(Color.WHITE);
        g.fillOval(npc.getX() - 10, npc.getY() - 60, 275, 40 * lines);
        g.setColor(Color.BLACK);
        int x = npc.getX()+10;
        int y = npc.getY()-35;
        String string = "";
        for (int i = 0; i < lines; i++) {
            string = s.get(i);
            g.drawString(string, x, y += g.getFontMetrics().getHeight());
        }
    }
>>>>>>> branch 'master' of https://github.com/runeaa/Spillprosjekt.git
}
