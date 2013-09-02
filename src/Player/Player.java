/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Player;

import Main.GamePanel;
//import com.sun.xml.internal.bind.v2.model.core.Adapter;
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
public class Player extends NPC {

    private int x, y;
    private int dx, dy;
    private int speed;
    private boolean up, down, left, right, facingLeft, interaction;
    private final int spriteWidth = 32;
    private final int spriteHeight = 34;
    private BufferedImage[] walking_sideways;
    private BufferedImage[] walking_up;
    private BufferedImage[] walking_down;
    private BufferedImage[] idleSprite = new BufferedImage[1];
    private Animation animation;
    private int[][] npc = {{30, 30}, {0, 0}, {100, 100}};

    public Player(int x, int y, int speed) {
        super(x,y);
        this.x = x;
        this.y = y;
        this.speed = speed;

        try {

            idleSprite = new BufferedImage[1];
            walking_sideways = new BufferedImage[2];
            walking_up = new BufferedImage[2];
            walking_down = new BufferedImage[2];
            idleSprite[0] = ImageIO.read(new File("res/player/playeridle.png"));
            BufferedImage img = ImageIO.read(new File("res/player/playersidewalk.png"));
            BufferedImage img2 = ImageIO.read(new File("res/player/playerup.png"));
            BufferedImage img3 = ImageIO.read(new File("res/player/playerdown.png"));
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

    private boolean interX(int interactionDist, int tx) {
        return (tx + interactionDist > x && tx - interactionDist < x);

    }

    private boolean interY(int interactionDist, int ty) {
        return (ty + interactionDist > x && ty - interactionDist < y);

    }

    private boolean interact(int tx, int ty) {
        int interactionDist = 10;
        if (interY(interactionDist, tx) && interX(interactionDist, ty)) {
            return true;
        }
        return false;
            
    }

    public int interaction() {
        for (int i = 0; i < npc.length; i++) {
            int a = npc[i][0];
            int b = npc[i][1];
            if(interact(a,b)){
                return i;
            }
        }
        return -1;
    }

    public void update() {
        System.out.println("Y: " + y + ", X: " + x);
//        dy = 0;
//        dx = 0;
        System.out.println(interaction());
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
        if(interaction){
            if(interaction()!= -1){
            System.out.println("MORRADIIIFAGGOT");
            }
            // interact();
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
        if (key == KeyEvent.VK_E || key == KeyEvent.VK_ENTER) {
            interaction = true;
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
        if (key == KeyEvent.VK_E || key == KeyEvent.VK_ENTER) {
            interaction = false;
        }
    }
}
