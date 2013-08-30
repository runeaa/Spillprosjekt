/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.entities;

import gfx.Colours;
import gfx.Font;
import gfx.Screen;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import level.Level;
import level.tiles.Tile;

/**
 *
 * @author Rune
 */
public class Player extends Entity implements KeyListener {

    private int colour = Colours.get(-1, 111, 145, 543);
    private int scale = 1;
    protected boolean isSwimming = false;
    private int tickCount = 0;
    private String userName;
    private int xa, ya;
    protected String name;
    protected int speed;
    protected int numSteps = 0;
    protected boolean isMoving;
    protected int movingDir = 1;
    public int x, y;
    protected Level level;
    private boolean up, down, right, left;

    public Player(Level level, int x, int y, int speed, String userName) {
        super(level);
        this.userName = userName;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.userName = userName;
    }

    /*
     * 
     */
    public void move(int xa, int ya) {
        if (xa != 0 && ya != 0) {
            move(xa, 0);
            move(0, ya);
            numSteps--;
            return;
        }
        numSteps++;
        if (!hasCollided(xa, ya)) {
            if (ya < 0) {
                movingDir = 0;
            }
            if (ya > 0) {
                movingDir = 1;
            }
            if (xa < 0) {
                movingDir = 2;
            }
            if (xa > 0) {
                movingDir = 3;
            }
            x += xa * speed;
            y += ya * speed;
        }
    }

    protected boolean isSolidTile(int xa, int ya, int x, int y) {
        if (level == null) {
            return false;
        }
        Tile lastTile = level.getTile((this.x + x) >> 3, (this.y + y) >> 3);
        Tile newTile = level.getTile((this.x + x + xa) >> 3, (this.y + y + ya) >> 3);
        if (!lastTile.equals(newTile) && newTile.isSolid()) {
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public boolean isMoving() {
        return isMoving;
    }

    public int getMovingDir() {
        return movingDir;
    }

    public void setMoving(boolean isMoving) {
        this.isMoving = isMoving;
    }

    public void setMovingDir(int movingDir) {
        this.movingDir = movingDir;
    }

    /*
     * 
     */
    public void tick() {
        xa = 0;
        ya = 0;
        if (up) {
            ya--;
        }

        if (down) {
            ya++;
        }

        if (left) {
            xa--;
        }

        if (right) {
            xa++;
        }
        if (xa != 0 || ya != 0) {
            move(xa, ya);
            isMoving = true;

        } else {
            isMoving = false;
        }
        if (level.getTile(this.x >> 3, this.y >> 3).getId() == 3) {
            isSwimming = true;
        }
        if (isSwimming && level.getTile(this.x >> 3, this.y >> 3).getId() != 3) {
            isSwimming = false;
        }
        tickCount++;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void update(Screen screen) {
        int xTile = 0;
        int yTile = 28;
        int walkingSpeed = 4;
        int flipTop = (numSteps >> walkingSpeed) & 1;
        int flipBottom = (numSteps >> walkingSpeed) & 1;
        if (movingDir == 1) {
            xTile += 2;
        } else if (movingDir > 1) {
            xTile += 4 + ((numSteps >> walkingSpeed) & 1) * 2;
            flipTop = (movingDir - 1) % 2;
        }

        int modifier = 8 * scale;
        int xOffset = x - modifier / 2;
        int yOffset = y - modifier / 2 - 4;

        if (isSwimming) {
            int waterColour = 0;
            yOffset += 4;
            if (tickCount % 60 < 15) {
                waterColour = Colours.get(-1, -1, 225, -1);
            } else if (15 <= tickCount % 60 && tickCount % 60 < 30) {
                yOffset -= 1;
                waterColour = Colours.get(-1, 225, 115, -1);
            } else if (30 <= tickCount % 60 && tickCount % 60 < 45) {
                waterColour = Colours.get(-1, 115, -1, 225);
            } else {
                yOffset -= 1;
                waterColour = Colours.get(-1, 225, 115, -1);
            }
            screen.render(xOffset, yOffset + 3, 0 + 27 * 32, waterColour,
                    0x00, 1);
            screen.render(xOffset + 8, yOffset + 3, 0 + 27 * 32, waterColour,
                    0x01, 1);
        }

        screen.render(xOffset + (modifier * flipTop), yOffset,
                xTile + yTile * 32, colour, flipTop, scale);
        screen.render(xOffset + modifier - (modifier * flipTop), yOffset,
                xTile + 1 + yTile * 32,
                colour, flipTop, scale);

        if (!isSwimming) {
            screen.render(xOffset + (modifier * flipBottom), yOffset + modifier, xTile
                    + (yTile + 1) * 32, colour, flipBottom, scale);
            screen.render(xOffset + modifier - (modifier * flipBottom), yOffset + modifier, (xTile + 1)
                    + (yTile + 1) * 32, colour, flipBottom, scale);
        }
        if (userName != null) {
            Font.render(userName, screen, xOffset - ((userName.length() - 1) / 2 * 8), yOffset - 10,
                    Colours.get(-1, -1, -1, 555), 1);
            level.renderText("Ole", screen, 100, 100, Colours.get(-1, -1, -1, 555), 1);
        }
    }

    /**
     * Checing if the player character has collided with an solid object
     *
     * @param xa the x value of the player
     * @param ya the y value of the player.
     * @return returns a value of true if a collision has occured, otherwise
     * returns false.
     */
    public boolean hasCollided(int xa, int ya) {
        int xMin = 0;
        int xMax = 7;
        int yMin = 3;
        int yMax = 7;
        for (int x = xMin; x < xMax; x++) {
            if (isSolidTile(xa, ya, x, yMin)) {
                return true;
            }
        }
        for (int x = xMin; x < xMax; x++) {
            if (isSolidTile(xa, ya, x, yMax)) {
                return true;
            }
        }
        for (int y = yMin; y < yMax; y++) {
            if (isSolidTile(xa, ya, xMin, y)) {
                return true;
            }
        }
        for (int y = yMin; y < yMax; y++) {
            if (isSolidTile(xa, ya, xMax, y)) {
                return true;
            }
        }
        return false;
    }

    public String getUsername() {
        return userName;
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
