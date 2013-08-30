/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package level.tiles;

import gfx.Colours;
import gfx.Screen;
import level.Level;

/**
 *
 * @author Rune
 */
public abstract class Tile {
    public static final Tile[] tiles = new Tile[256];
    public static final Tile VOID = new BasicSolidTile(0, 0, 0, Colours.get(000,-1,-1,-1), 0xFF000000);
    public static final Tile WALL = new BasicSolidTile(1, 1, 1, Colours.get(-1, 100, 200, 200), 0xFF555555);
    public static final Tile GRASS = new BasicTile(2, 2, 0, Colours.get(-1, 131, 141, -1), 0xFF00FF00);
    public static final Tile WATER = new AnimatedTile(3, new int[][]{{0,5}, {1,5},{2,5},{1,5}}, 
            Colours.get(-1, 004, 115, -1), 0xFF0000FF, 1000);
    public static final Tile FLOOR = new BasicTile(4, 3, 0, Colours.get(-1, 329, 66, 50), 0xFF663333);
    public static final Tile DESK = new BasicSolidTile(5, 0, 3, Colours.get(-1, 131, 141, 100), 0xFFfffc00);
    public static final Tile DESK2 = new BasicSolidTile(6, 1, 3, Colours.get(-1, 131, 141, 100), 0xFF848203);
    public static final Tile CHAIR = new BasicTile(7, 2, 3, Colours.get(-1, 111, 145, 329), 0xFFff0000);



    
    protected byte id;
    protected boolean solid;
    protected boolean emitter;
    private int levelColour;
    
    public Tile(int id, boolean isSolid, boolean isEmitter, int levelColour){
        this.id = (byte)id;
        if(tiles[id] != null) throw new RuntimeException("Duplicate tile id on "+id);
        this.solid = isSolid;
        this.emitter = isEmitter;
        this.levelColour = levelColour;
        tiles[id] = this;
    }
    
    public byte getId(){
        return id;
    }
    
    public boolean isSolid(){
        return solid;
    }
    
    public boolean isEmitter(){
        return emitter;
    }

    public void render(Screen screen, Level level, int x, int y) {
        
    }

    public int getlevelColour() {
        return levelColour;
    }
    
    public abstract void tick();

}
