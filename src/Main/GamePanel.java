/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import GameElements.DialogBox;
import GameElements.FeedbackBox;
import Map.TileMap;
import Player.NPC;
import Player.Player;
import Settings.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.sound.sampled.AudioSystem;
import javax.swing.JPanel;

/**
 *
 * @author Rune
 */
public class GamePanel extends JPanel implements Runnable {

    private Settings settings;
    private boolean running;
    private BufferedImage image;
    private int maxrameCount = 60;
    private GameStateSettings optionState;
    int frameCount = 1;
    private TileMap tileMap;
    private TileMap tileMap2;
    private Thread thread;
    private Graphics2D g;
    private Player player;
    private int currentLevel;
    private NPC npc1;
    private NPC npc2;
    private NPC npc3;
    private NPC npc4;
    private ArrayList<NPC> npcs = new ArrayList<NPC>();
    private PlayerSettings playersettings;
    private DialogBox dialogbox;

    public GamePanel(PlayerSettings playersettings, Settings settings) {
        super();
        this.settings = settings;
        this.playersettings = playersettings;
        this.dialogbox = new DialogBox(playersettings);
        setPreferredSize(new Dimension(settings.WITDH, settings.HEIGHT));
        setFocusable(true);
        requestFocus();
        if (settings.sound) {
            try {
                settings.clip = AudioSystem.getClip();
                settings.startMusic(this);
            } catch (Exception e) {
                e.printStackTrace();
    }
        }
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
        tileMap = new TileMap("res/levels/tutorial.txt", 32);
        tileMap.loadTiles("res/levels/tileset2.png");
        tileMap2 = new TileMap("res/levels/level1.txt", 32);
        tileMap2.loadTiles("res/levels/tileset2.png");
        player = new Player(tileMap, 0, -200, 200, 5, "blue");
        npc1 = new NPC(1, 130, 180, "mentorside");
        npcs.add(npc1);
        npc2 = new NPC(2, 405, 125, "blueNPC");
        npcs.add(npc2);
        player.setNPCs(npcs);
        optionState = new GameStateSettings(settings);
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
        currentLevel = player.getLevel();
        if(currentLevel == 1){
            player.updateTitleMap(tileMap);
        }else if(currentLevel == 2){
            player.updateTitleMap(tileMap2);
        }
        
    }

    private String[] drawText() {
        String[] s = new String[3];
        int interaction = player.interaction();
        s[0] = "O hi young programmer";
        if (interaction == 0) {
            s[1] = ((Integer) npcs.get(interaction).getX()).toString();
            s[2] = ((Integer) npcs.get(interaction).getY()).toString();
            return s;
        }
        return null;
    }

    public void render() {

        if (!player.getOptionValue()) {
            //          remove(dialogbox);
            if (!player.getInterOk()) {
                if (player.answer != -1) {
                        FeedbackBox feedback = new FeedbackBox(dialogbox.question.getAnswers().get(player.answer));
                        feedback.paintComponent(g);
                        add(feedback);
                        if(player.confirmedFeedback)
                    player.answer = -1;
                } else {
                if (currentLevel == 1) {
                    tileMap.draw(g);
                    npc1.draw(g);
                    npc2.draw(g);
                    String[] s = drawText();
                    if (s != null) {
                        g.setColor(Color.WHITE);
                        g.fillOval(Integer.parseInt(s[1]) - 10, Integer.parseInt(s[2]) - 60, 150, 40);
                        g.setColor(Color.BLACK);
                        g.drawString(s[0], Integer.parseInt(s[1]), Integer.parseInt(s[2]) - 37);
                    }
                } else if (currentLevel == 2) {
                    tileMap2.draw(g);
                }
                player.draw(g);
                }
            } else {
                if (!player.finishedInteractedNPCs.contains(player.interactedNPCID)) {
                    dialogbox.setInteractedNPCID(player.interactedNPCID);
                dialogbox.paintComponent(g);
                add(dialogbox);
                    player.setDialogBoxDrawn(true);
            }
            }
        } else {
            optionState.draw(g);
        }
    }

    public void draw() {
        Graphics g2 = this.getGraphics();
        g2.drawImage(image, 0, 0, null);
        g2.dispose();
    }
}