/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Player;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author espen
 */
public class NPC implements KeyListener {

    private final int x;
    private final int y;
    private String npc1 = "/res/npcsprite1";
    private String npc2 = "/res/npcsprite2";
    private String npc3 = "/res/npcsprite3";
    private BufferedImage[] idleSprite = new BufferedImage[2];
    private final int spriteWidth = 32;
    private final int spriteHeight = 34;
    private Animation animation;
    private int npcID;

    public NPC(int npcID, int x, int y, String color) {
        this.x = x;
        this.y = y;
        this.npcID = npcID;
        try {
            BufferedImage img = ImageIO.read(new File("res/npc/" + color + ".png"));
            for (int i = 0; i < idleSprite.length; i++) {
                idleSprite[i] = img.getSubimage(i * spriteWidth, 0, spriteWidth, spriteHeight);
            }
        } catch (Exception e) {
            //System.out.println("NPC konstruktør:  " + e + npcID);
        }
        animation = new Animation();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
   

    public void draw(Graphics2D g) {
        // g.drawImage(idleSprite[0], (int) (tx - x - spriteWidth / 2), (int) (ty + y - spriteWidth / 2), null);
        g.drawImage(idleSprite[0], x, y, null);   
    }
    public int getID(){
        return npcID;
    }

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