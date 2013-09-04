/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameElements;

import java.awt.Color;
import java.awt.Graphics2D;
import Player.NPC;
import java.util.ArrayList;

/**
 *
 * @author espen
 */
public class Oval {

    private NPC npc;
    private Text text;
    private int lines;
    private ArrayList<String> s;

    public Oval(NPC npc, Text text) {
        this.npc = npc;
        this.text = text;
    }

    public void draw(Graphics2D g) {
        s = text.getString();
        lines = text.getLines();
        g.setColor(Color.WHITE);
        g.fillOval(npc.getX() - 10, npc.getY() - 60, 300, 40 * lines);
        g.setColor(Color.BLACK);
        int x = npc.getX();
        int y = npc.getY();
        String string = "";
        for (int i = 0; i < lines; i++) {
            string = s.get(i);
            g.drawString(string, x, y += g.getFontMetrics().getHeight());
        }
    }
}
