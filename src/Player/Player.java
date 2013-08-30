/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Player;

import Main.GamePanel;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Rune
 */
public class Player implements KeyListener {

    private int x, y;
    private int dx, dy;
    private int speed;
    private boolean up,down,left,right;
    private final int spriteWidth = 16;
    private final int spriteHeight = 17;
    private BufferedImage[] walking_sideways;
    private BufferedImage[] walking_up;
    private BufferedImage[] idleSprite;

    public Player(int x, int y, int speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        
        try{
            idleSprite[0] = ImageIO.read(new File("res/bob_sideways_idle.png"));
            walking_sideways = new BufferedImage[2];
            walking_up = new BufferedImage[2];
            BufferedImage img = ImageIO.read(new File("res/bob_sideways.png"));
            BufferedImage img2 = ImageIO.read(new File("res/bob_up.png"));
            for (int i = 0; i < walking_up.length; i++) {
                walking_sideways[i] = img.getSubimage(i*spriteWidth+i, 0, spriteWidth, spriteHeight);
                walking_up[i] = img2.getSubimage(i*spriteWidth+i, 0, spriteWidth, spriteHeight);
            }
            
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void update() {
        if (up) {
            dy -= speed;
        }
        if (down) {
            dy += speed;
        }
        if (left) {
            dx -= speed;
        }
        if (right) {
            dx += speed;
        }
        x = dx;
        y = dy;
    }

    public void draw(Graphics2D g) {
        g.setColor(Color.red);
        g.fillOval(x, y, 20, 20);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_W || key == KeyEvent.VK_UP) {
            up = true;
        }
        if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
            left = true;
        }
        if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) {
            down = true;
        }
        if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
            right = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_W || key == KeyEvent.VK_UP) {
            up = false;
        }
        if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
            left = false;
        }
        if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) {
            down = false;
        }
        if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
            right = false;
        }
    }
}
