/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Map;

import Main.GamePanel;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Rune
 */
public class TileMap {

    private int x, y;
    private int minX, minY;
    private int maxX = 0;
    private int maxY = 0;
    private String s;
    private BufferedImage tileset;
    private int width, height, tileSize;
    private int[][] map;
    private Tile[][] tiles;

    public TileMap(String s, int tileSize) {
        this.s = s;
        this.tileSize = tileSize;
        try {
            BufferedReader br = new BufferedReader(new FileReader(s));
            width = Integer.parseInt(br.readLine());
            height = Integer.parseInt(br.readLine());
            System.out.println("Width: " + width + "Height: " + height);

            minX = GamePanel.WIDTH - width * tileSize;
            minY = GamePanel.HEIGHT - height * tileSize;
            map = new int[height][width];
            for (int i = 0; i < height; i++) {
                String mapLine = br.readLine();
                String[] element = mapLine.split("\\s+");
                for (int j = 0; j < width; j++) {
                    map[i][j] = Integer.parseInt(element[j]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getMapWidth() {
        return width * tileSize;
    }

    public int getMapHeight() {
        return height * tileSize;
    }

    public void setX(int x) {
        this.x = x;
        System.out.println("MINX: " + minX);
        System.out.println("MAXX: " + maxX);
        if (x < minX) {
            this.x = minX;
        }
        if (x > maxX) {
            this.x = maxX;
        }
    }

    public void setY(int y) {
        this.y = y;
        System.out.println("MINY: " + minY);
//        System.out.println("MAXY: " + maxY);

        if (y < minY) {
            this.y = minY;
        }
        if (y > maxY) {
            this.y = maxY;
        }
    }

    public void loadTiles(String s) {
        try {
            tileset = ImageIO.read(new File(s));
            int numTilesWidth = (tileset.getWidth() + 1) / (tileSize + 1);
            tiles = new Tile[2][numTilesWidth];

            BufferedImage subImage;
            for (int col = 0; col < numTilesWidth; col++) {
                subImage = tileset.getSubimage(col * tileSize + col,
                        0, tileSize, tileSize);

                tiles[0][col] = new Tile(subImage, false);
                subImage = tileset.getSubimage(col * tileSize + col,
                        tileSize + 1, tileSize, tileSize);

                tiles[1][col] = new Tile(subImage, true);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void update() {
    }

    public void draw(Graphics2D g) {
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                int rc = map[row][col];
                int r = rc / tiles[0].length;
                int c = rc % tiles[0].length;

                g.drawImage(tiles[r][c].getImage(), x + col * tileSize,
                        y + row * tileSize, null);
            }
        }
    }

    public int getColTile(int x) {
        //System.out.println("COL TILE"+ -(x/tileSize));
        return -(x / tileSize);
    }

    public int getRowTile(int y) {
        //System.out.println("ROW TILE"+ y/tileSize);
        return y / tileSize;
    }

    public int getTile(int row, int col) {
        return map[row][col];
    }

    public int getTileSize() {
        return tileSize;
    }

    public boolean isBlocked(int row, int col) {
        if (row < 0 || col < 0) {
            return false;
        }

        int rc = map[row][col];
        int r = rc / tiles[0].length;
        int c = rc % tiles[0].length;
        System.out.println(tiles[r][c].isBlocked());
        return tiles[r][c].isBlocked();
    }
}