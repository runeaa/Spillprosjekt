/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Player;

import Main.GamePanel;
import com.sun.xml.internal.bind.v2.model.core.Adapter;
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
    private boolean up, down, left, right, facingLeft;
    private final int spriteWidth = 16;
    private final int spriteHeight = 17;
    private BufferedImage[] walking_sideways;
    private BufferedImage[] walking_up;
    private BufferedImage[] walking_down;
    private BufferedImage[] idleSprite = new BufferedImage[1];
    private Animation animation;

    public Player(int x, int y, int speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;

        try {

            idleSprite = new BufferedImage[1];
            walking_sideways = new BufferedImage[2];
            walking_up = new BufferedImage[2];
            walking_down = new BufferedImage[2];
            idleSprite[0] = ImageIO.read(new File("res/bob_sideways_idle.png"));
            BufferedImage img = ImageIO.read(new File("res/bob_sideways.png"));
            BufferedImage img2 = ImageIO.read(new File("res/bob_up.png"));
            BufferedImage img3 = ImageIO.read(new File("res/bob_down.png"));
            for (int i = 0; i < walking_up.length; i++) {
                walking_sideways[i] = img.getSubimage(i * spriteWidth, 0, spriteWidth, spriteHeight);
                walking_up[i] = img2.getSubimage(i * spriteWidth, 0, spriteWidth, spriteHeight);
                walking_down[i] = img3.getSubimage(i * spriteWidth, 0, spriteWidth, spriteHeight);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        animation = new Animation();
        facingLeft = false;
    }

    public void update() {
        System.out.println("DY: " + dy + ", DX: " + dx);
//        dy = 0;
//        dx = 0;
        if (up) {
            dy -= speed;
        }
        if (down) {
            dy += speed;
        }
        if (left) {
            dx += speed;
        }
        if (right) {
            dx -= speed;
        }
        x = dx;
        y = dy;

        //sprite animation
        if (left || right) {
            animation.setFrames(walking_sideways);
            animation.setDelay(200);
        } else {
            animation.setFrames(idleSprite);
            animation.setDelay(-1);
        }

        if (up) {
            animation.setFrames(walking_up);
            animation.setDelay(1000);
        }
        if (down) {
            animation.setFrames(walking_down);
            animation.setDelay(500);
        }
        animation.update();

    }

    public void draw(Graphics2D g) {
        //filler verdier, bruk tikeMap.getX/Y for å gi størrelsen til mappet
        int tx = 50;
        int ty = 50;

        if (facingLeft) {
            g.drawImage(animation.getImage(), (int) (tx - x - spriteWidth / 2), (int) (ty + y - spriteWidth / 2), null);
        } else {
            g.drawImage(animation.getImage(), (tx - x - spriteWidth / 2 + spriteWidth), (int) (ty + y - spriteHeight / 2),
                    -spriteWidth, spriteHeight, null);
        }

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
            facingLeft = false;
            left = true;
        }
        if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) {
            down = true;
        }
        if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
            facingLeft = true;

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
