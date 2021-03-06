/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Player;

import Map.TileMap;
//import com.sun.xml.internal.bind.v2.model.core.Adapter;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author Rune
 */
public class Player extends NPC {

    private int x, y;
    private int dx, dy;
    private int speed;
    private TileMap tileMap;
    public boolean up, down, left, right, facingLeft, interOk;
    private final int spriteWidth = 32;
    private final int spriteHeight = 34;
    private int idleDirection = 3;
    private BufferedImage[] walking_sideways;
    private BufferedImage[] walking_up;
    private BufferedImage[] walking_down;
    private BufferedImage[] idleSprite = new BufferedImage[1];
    private BufferedImage[] idleSprite_up = new BufferedImage[1];
    private BufferedImage[] idleSprite_down = new BufferedImage[1];
    private Animation animation;
    private boolean OptionTrigger;
    private int level = 1;
    public int lock = 1;
    private ArrayList<NPC> npcs = new ArrayList<NPC>();
    public int interactedNPCID = -1;
    public boolean dialogBoxDrawn, confirmedFeedback;
    public int answer = -1;
    public ArrayList<Integer> finishedInteractedNPCs = new ArrayList<Integer>();

    public Player(TileMap tileMap, int npcID, int x, int y, int speed, String color) {
        super(npcID, x, y, color);
        this.tileMap = tileMap;
        this.x = x;
        this.y = y;
        this.speed = speed;

        try {
            idleSprite = new BufferedImage[1];
            walking_sideways = new BufferedImage[2];
            walking_up = new BufferedImage[2];
            walking_down = new BufferedImage[2];
            idleSprite[0] = ImageIO.read(new File("res/player/playeridle.png"));
            idleSprite_up[0] = ImageIO.read(new File("res/player/playeridleup.png"));
            idleSprite_down[0] = ImageIO.read(new File("res/player/playeridledown.png"));
            BufferedImage img = ImageIO.read(new File("res/player/playersidewalk.png"));
            BufferedImage img2 = ImageIO.read(new File("res/player/playerup.png"));
            BufferedImage img3 = ImageIO.read(new File("res/player/playerdown.png"));
            for (int i = 0; i < walking_up.length; i++) {
                walking_up[i] = img2.getSubimage(i * spriteWidth, 0, spriteWidth, spriteHeight);
                walking_sideways[i] = img.getSubimage(i * spriteWidth, 0, spriteWidth, spriteHeight);

                walking_down[i] = img3.getSubimage(i * spriteWidth, 0, spriteWidth, spriteHeight);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        animation = new Animation();
        facingLeft = false;
    }

    public int getLevel() {
        return level;
    }

    private boolean interX(int interactionDist, int tx) {
        return (tx + interactionDist > x + 20 && tx - interactionDist < x + 20);

    }

    public void setNPCs(ArrayList<NPC> npcs) {
        this.npcs = npcs;
    }

    private boolean interY(int interactionDist, int ty) {
        return (ty + interactionDist > y && ty - interactionDist < y);

    }

    private boolean interact(int tx, int ty) {
        int interactionDist = 20;
        if (interY(interactionDist, ty) && interX(interactionDist, tx)) {
            return true;
        }
        return false;
    }

    public int interaction() {
        for (NPC n: npcs) {
            int a = -n.getX();
            int b = n.getY();
            if (!finishedInteractedNPCs.contains(n.getID())) {
                if (interact(a, b)) {                
                    return n.getID();
                }
            }
        }
        return -1;
    }

    public boolean wall() {
        //boolean outsideOfMap = ((dy/32)>=20 || (dx/32) >= 20)? false:true;
        int tempx = ((-dx - 21) / 32);
        int tempy = ((dy - 16) / 32);
        tempy = (tempy > 0) ? tempy + 1 : tempy;
        tempx = (tempx > 0) ? tempx + 1 : tempx;
        boolean outsideOfMap = ((tempx) >= 20 || tempy >= 20) ? true : false;
        return (!outsideOfMap && tileMap.getTile(tempy, tempx) >= 2);
    }

    public void updatePlayerPosition(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
        x = dx;
        y = dy;
    }

    public void updateTileMap(TileMap tileMap) {
        this.tileMap = tileMap;
    }

    public void update() {
        //System.out.println("X: "+x+ "Y: "+y);
        if (level == 1 && y >= 305 && x < -615) {
            updatePlayerPosition(-25, 380);
            level++;
        } else if (level == 2 && y >= 370 && x > -20) {
            updatePlayerPosition(-615, 310);
            level--;
        }
        if(level == 2 && y>=145 && x < -620){
            updatePlayerPosition(-30, 385);
            level++;
        } else if(level == 3 && y >=380 && x > -30){
            updatePlayerPosition(-590, 160);
            level--;
        }
        
        if(level == 3 && y >= 145 && x < -615){
            updatePlayerPosition(-40, 385);
            level++;
        }else if(level == 4 && y > 370 && x > -20 ){
            updatePlayerPosition(-590, 160);
            level --;
        }
        //System.out.println("X: "+x+" Y: "+y);
        if (!OptionTrigger && !interOk) {
            if (up && y != 0) {
                dy -= speed;
            }
            if (down && y != 410) {
                dy += speed;
            }
            if (left && x != 0) {
                dx += speed;
            }
            if (right && x != -630) {
                dx -= speed;
            }
        }

        if (wall()) {// || outsideOfMap) {
            dx = x;
            dy = y;
        } else {
            x = dx;
            y = dy;
        }

        //sprite animation
        if (((right || left) && up) || (up && y != 0)) {
            animation.setFrames(walking_up);
            animation.setDelay(200);
        } else if (((right || left) && down || (down && y != 410))) {
            animation.setFrames(walking_down);
            animation.setDelay(200);
        } else if (left && x != 0 || right && x != -640) {
            animation.setFrames(walking_sideways);
            animation.setDelay(200);
        } else {
            if (idleDirection == 1) {
                animation.setFrames(idleSprite_up);
                animation.setDelay(-1);
            } else if (idleDirection == 2) {
                animation.setFrames(idleSprite);
                animation.setDelay(-1);
            } else if (idleDirection == 3) {
                animation.setFrames(idleSprite_down);
                animation.setDelay(-1);
            } else {
                animation.setFrames(idleSprite);
                animation.setDelay(-1);
            }

        }
        animation.update();
    }

    public boolean getOptionValue() {
        return OptionTrigger;
    }

    public void setOptionTrigger(boolean OptionTrigger) {
        this.OptionTrigger = OptionTrigger;
    }
    
    

    @Override
    public void draw(Graphics2D g) {
        //filler verdier, bruk tikeMap.getX/Y for å gi størrelsen til mappet
        int tx = tileMap.getX() + 10;
        int ty = tileMap.getY() + 10;
        if (facingLeft) {
            g.drawImage(animation.getImage(), (tx - x - spriteWidth / 2 + spriteWidth), (int) (ty + y - spriteHeight / 2),
                    -spriteWidth, spriteHeight, null);
        } else {
            g.drawImage(animation.getImage(), (int) (tx - x - spriteWidth / 2), (int) (ty + y - spriteWidth / 2), null);
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
            idleDirection = 1;
        }
        if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
            facingLeft = true;
            left = true;
            idleDirection = 2;
        }
        if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) {
            down = true;
            idleDirection = 3;
        }
        if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
            facingLeft = false;
            right = true;
            idleDirection = 4;
        }
        if (key == KeyEvent.VK_E || key == KeyEvent.VK_ENTER) {
            interactedNPCID = interaction();
            if (answer != -1) {
                confirmedFeedback = true;
            } else {
                confirmedFeedback = false;
                if (interactedNPCID != -1 && interOk == false) {
                    interOk = true;
                } else if (interOk == true) {
                    interOk = false;
                }
            }
        }

        if (key == KeyEvent.VK_ESCAPE) {
            if (lock % 2 != 0) {
                OptionTrigger = true;
                lock--;
            } else {
                OptionTrigger = false;
                lock++;
            }
        }
        if (interOk) { //Keyboard events when you interact
            if (key == KeyEvent.VK_1 || key == KeyEvent.VK_2 || key == KeyEvent.VK_3) {
                if (key == KeyEvent.VK_1) {
                    answer = 0;
                } else if (key == KeyEvent.VK_2) {
                    answer = 1;
                } else if (key == KeyEvent.VK_3) {
                    answer = 2;
                }
                finishedInteractedNPCs.add(interactedNPCID);
                interOk = false;
            }
        }
    }

    public boolean getInterOk() {
        return interOk;
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

    public void setDialogBoxDrawn(boolean dialogBoxDrawn) {
        this.dialogBoxDrawn = dialogBoxDrawn;
    }

    public void setInterOk(boolean interOk) {
        this.interOk = interOk;
    }
    
}
