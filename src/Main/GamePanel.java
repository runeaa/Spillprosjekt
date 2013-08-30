/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Player2.Player;
import Settings.*;
import gfx.Screen;
import gfx.SpriteSheet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import level.Level;

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
    private int[] colors = new int[6 * 6 * 6];
    private Thread thread;
    private Graphics2D g;
    private Screen screen;
    private game.entities.Player player;
    public Level level;


    public GamePanel() {
        super();
        setPreferredSize(new Dimension(settings.WITDH, settings.HEIGHT));
        setFocusable(true);
        requestFocus();
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
        addKeyListener(player);

        int index = 0;
        for (int r = 0; r < 6; r++) {
            for (int g = 0; g < 6; g++) {
                for (int b = 0; b < 6; b++) {
                    int rr = (r * 255 / 5);
                    int gg = (g * 255 / 5);
                    int bb = (b * 255 / 5);

                    colors[index++] = rr << 16 | gg << 8 | bb;
                }
            }
        }
        screen = new Screen(WIDTH, HEIGHT, new SpriteSheet("/sprite_sheet.png"));
        level = new Level("/levels/water_test_level.png");

        player = new game.entities.Player(level, 100, 100, 5, "BOB");
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
        player.tick();
    }

    public void render() {
        g.setColor(new Color(0, 100, 255));
        g.fillRect(0, 0, settings.WITDH, settings.HEIGHT);
        g.drawImage(image, 0, 0, null);

        player.update(screen);

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