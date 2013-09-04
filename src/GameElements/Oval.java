/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameElements;

import java.awt.Color;
import java.awt.Graphics2D;
import Player.NPC;
<<<<<<< HEAD
<<<<<<< HEAD
=======
import java.util.ArrayList;
>>>>>>> branch 'master' of https://github.com/runeaa/Spillprosjekt.git
=======
import java.util.ArrayList;
>>>>>>> 69dcbcb3bf1725811d46d9b174773e48d9fe92ac

/**
 *
 * @author espen
 */
public class Oval {

<<<<<<< HEAD
<<<<<<< HEAD
    /*    public void draw(Graphics2D g, NPC npc, Text text) {
     int x = text.getText().length() / ;
=======
=======
>>>>>>> 69dcbcb3bf1725811d46d9b174773e48d9fe92ac
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
<<<<<<< HEAD
>>>>>>> branch 'master' of https://github.com/runeaa/Spillprosjekt.git
        
<<<<<<< HEAD
     g.setColor(Color.WHITE);
     g.fillOval(Integer.parseInt(s[1]) - 10, Integer.parseInt(s[2]) - 60, 150, 40);
     g.setColor(Color.BLACK);
     g.drawString(s[0], Integer.parseInt(s[1]), Integer.parseInt(s[2]) - 37);
     }*/
=======
=======
        
>>>>>>> 69dcbcb3bf1725811d46d9b174773e48d9fe92ac
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
<<<<<<< HEAD
>>>>>>> branch 'master' of https://github.com/runeaa/Spillprosjekt.git
=======
>>>>>>> 69dcbcb3bf1725811d46d9b174773e48d9fe92ac
}
