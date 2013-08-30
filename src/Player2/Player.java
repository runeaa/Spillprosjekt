/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Player2;

import Main.GamePanel;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Rune
 */
public class Player implements KeyListener {

    private int x, y;
    private int dx, dy;
    private int speed;
    private boolean up,down,left,right;

    public Player(int x, int y, int speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
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
            //dy -= 1;
        }
        if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
            left = true;

            //dx -= 1;
        }
        if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) {
            down = true;

           // dy += 1;
        }
        if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
            right = true;

            //dx += 1;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_W || key == KeyEvent.VK_UP) {
            up = false;

//            dy = y;
        }
        if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
            left = false;
//            dx = x;
        }
        if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) {
            down = false;
//            dx = x;
        }
        if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
            right = false;
//            dy = y;
        }
    }
}
