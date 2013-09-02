/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Map.TileMap;
import Player.NPC;
import Player.Player;
import Settings.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author Rune
 */
public class GamePanel extends JPanel implements Runnable {

    Settings settings = new Settings();
    private boolean running;
    private BufferedImage image;
    private int maxrameCount = 60;
    int frameCount = 1;
    private TileMap tileMap;
    private Thread thread;
    private Graphics2D g;
    private Player player;
    private NPC npc1;
    private NPC npc2;
    private NPC npc3;
    private NPC npc4;

    public GamePanel() {
        super();
        setPreferredSize(new Dimension(settings.WITDH, settings.HEIGHT));
        setFocusable(true);
        requestFocusInWindow();
        setFocusable(true);
        getFocusTraversalKeysEnabled();
        
    }

    @Override
    public void addNotify() {
        super.addNotify();
        if (thread == null) {
            thread = new Thread(this);
            thread.start();
            running = true;
        }
    }

    public void init() {
        image = new BufferedImage(settings.WITDH, settings.HEIGHT, BufferedImage.TYPE_INT_ARGB);
        g = (Graphics2D) image.getGraphics();

        //Anti-aliasing
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        //Quiz quiz = new Quiz(int valg);
        //player = new Player(quiz, 200, 200, 5);
        tileMap = new TileMap("res/levels/floored.txt", 32);
        tileMap.loadTiles("res/levels/tileset.gif");
        player = new Player(tileMap, 200, 200, 5);
        addKeyListener(player);
    }

    public void run() {
        init();
        long start, loopTime, wait;
        long targetTime = 1000 / settings.FPS;
        long totalTime = 0;

        //gameloop
        while (running) {
            start = System.nanoTime();
            
            update();
            render();
            draw();
            

            loopTime = (System.nanoTime() - start) / 1000000;

            wait = targetTime - loopTime;
            if (wait < 0) {
                wait = 0;
            }
            try {
                thread.sleep(wait);
            } catch (Exception e) {
                e.printStackTrace();
            }
            totalTime += System.nanoTime() - start;
            frameCount++;

            if (frameCount == maxrameCount) {
                settings.setAvrageFPS(1000D / ((totalTime / frameCount) / 1000000));
                totalTime = 0;
                frameCount = 0;
            }
        }
    }

    public void update() {
        player.update();
    }

    public void render() {
     
        tileMap.draw(g);
        player.draw(g);
//        npc1.draw(g);
        g.setColor(Color.BLACK);
        g.drawString("FPS:" + settings.avrageFPS, settings.WITDH / 2, settings.HEIGHT / 2);
        g.drawString("FrameCount:" + frameCount, settings.WITDH / 2, (settings.HEIGHT / 2) + 20);
    }

    public void draw() {
        Graphics g2 = this.getGraphics();
        g2.drawImage(image, 0, 0, null);
        g2.dispose();
    }
}
