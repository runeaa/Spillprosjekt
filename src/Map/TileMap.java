/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Map;

import Main.GamePanel;
import java.awt.Graphics2D;
import java.awt.Image;
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

    public void setX(int x) {
        this.x = x;
        if (x < minX) {
            this.x = minX;
        }
        if (x > maxX) {
            this.x = maxX;
        }
    }

    public void setY(int y) {
        this.y = y;
        if (y < minY) {
            this.y = minY;
        }
        if (y > maxY) {
            this.y = maxY;
        }
    }
    
    public void loadTiles(String s){
        try{
            tileset = ImageIO.read(new File(s));
            int numTilesWidth = (tileset.getWidth() +1) / (tileSize +1);
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
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }
    
    public void update(){}
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
        return x / tileSize;
    }

    public int getRowTile(int y) {
        return y / tileSize;
    }

    public int getTile(int row, int col) {
        return map[row][col];
    }

    public int getTileSize() {
        return tileSize;
    }

//    public void readFile() {
//        try {
//            BufferedReader br = new BufferedReader(new FileReader("res/levels/map.txt"));
//            width = Integer.parseInt(br.readLine());
//            height = Integer.parseInt(br.readLine());
//            map = new int[height][width];
//            for (int i = 0; i < height; i++) {
//                String mapLine = br.readLine();
//                String[] element = mapLine.split("\\s+");
//                for (int j = 0; j < width; j++) {
//                    map[i][j] = Integer.parseInt(element[j]);
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
////    }
//
//    public String toString() {
//        readFile();
//        String s = "";
//        for (int i = 0; i < height; i++) {
//            for (int j = 0; j < width; j++) {
//                s += map[i][j] + " ";
//            }
//            s += "\n";
//        }
//        return s;
//    }
}
//
//class test {
//
//    public static void main(String[] args) {
//        TileMap map = new TileMap();
//        System.out.println(map.toString());
//    }
//}