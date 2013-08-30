/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package level;

import game.entities.Entity;
import gfx.Font;
import gfx.Screen;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import level.tiles.Tile;

/**
 *
 * @author Rune
 */
public class Level {

    private byte[] tiles;
    public int width;
    public int height;
    private List<Entity> entities = new ArrayList<Entity>();
    private String imagePath;
    private BufferedImage image;

    public Level(String imagePath) {
        if (imagePath != null) {
            this.imagePath = imagePath;
            this.loadLevelFromFile();
        } else {
            this.width = 64;
            this.height = 64;
            tiles = new byte[width * height];
            this.generateLevel();
        }
    }

    private void loadLevelFromFile() {
        try {
            this.image = ImageIO.read(Level.class.getResource(this.imagePath));
            this.width = image.getWidth();
            this.height = image.getHeight();
            tiles = new byte[width * height];
            this.loadTiles();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadTiles() {
        int[] tileColours = this.image.getRGB(0, 0, width, height, null, 0, width);
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                tileCheck:
                for (Tile t : Tile.tiles) {
                    if (t != null && t.getlevelColour() == tileColours[x + y * width]) {
                        this.tiles[x + y * width] = t.getId();
                        break tileCheck;
                    }
                }
            }
        }
    }

    public void saveLevelToFile() {
        try {
            ImageIO.write(image, "png", new File(Level.class.getResource(this.imagePath).getFile()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void alterTile(int x, int y, Tile newTile) {
        this.tiles[x + y * width] = newTile.getId();
        image.setRGB(x, y, newTile.getlevelColour());
    }

    public void generateLevel() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (x * y % 10 < 7) {
                    tiles[x + y * width] = Tile.GRASS.getId();
                } else {
                    tiles[x + y * width] = Tile.WALL.getId();
                }
            }
        }
    }

    public synchronized List<Entity> getEntity() {
        return this.entities;
    }

    public void tick() {
        for (Entity e : getEntity()) {
            e.tick();
        }
        for (Tile t : Tile.tiles) {
            if (t == null) {
                break;
            }
            t.tick();
        }
    }

    public void renderTiles(Screen screen, int xOffset, int yOffset) {
        if (xOffset < 0) {
            xOffset = 0;
        }
        if (xOffset > ((width << 3) - screen.width)) {
            xOffset = ((width << 3) - screen.width);
        }
        if (yOffset < 0) {
            yOffset = 0;
        }
        if (yOffset > ((height << 3) - screen.height)) {
            yOffset = ((height << 3) - screen.height);
        }
        screen.setOffset(xOffset, yOffset);

        for (int y = (yOffset >> 3); y < (yOffset + screen.height >> 3) + 1; y++) {
            for (int x = (xOffset >> 3); x < (xOffset + screen.width >> 3) + 1; x++) {
                getTile(x, y).render(screen, this, x << 3, y << 3);
            }

        }
    }

    public void renderEntities(Screen screen) {
        for (Entity e : getEntity()) {
            e.update(screen);
        }
    }

    public void renderText(String text, Screen screen, int x, int y, int colour, int scale) {
        Font.render(text, screen, x, y, colour, scale);
    }

    public Tile getTile(int x, int y) {
        if (0 > x || x >= width || 0 > y || y >= height) {
            return Tile.VOID;
        }
        return Tile.tiles[tiles[x + y * width]];
    }

    public void addEntity(Entity entity) {
        this.getEntity().add(entity);
    }
//    public void movePlayer(String username, int x,int y, int numSteps,
//        boolean isMoving, int movingDir){
//        int index = getPlayerMPIndex(username);
//        PlayerMP player = (PlayerMP)this.getEntity().get(index);
//        player.x = x;
//        player.y = y;
//        player.setMoving(isMoving);
//        player.setNumSteps(numSteps);
//        player.setMovingDir(movingDir);
//    }
}
