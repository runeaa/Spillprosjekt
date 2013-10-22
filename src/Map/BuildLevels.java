/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Map;
import java.util.ArrayList;

/**
 *
 * @author Rune
 */
public class BuildLevels {
    private ArrayList<TileMap> levels = new ArrayList();
    
    public ArrayList<TileMap> getLevels(){
        levels.removeAll(levels);
        levels.add(new TileMap("res/levels/tutorial.txt",32));
        levels.add(new TileMap("res/levels/level1.txt",32));
        levels.add(new TileMap("res/levels/level2.txt",32));
        return levels;
    }
    
    public void loadTilesLevel(ArrayList<TileMap> level){
        for (int i = 0; i < level.size(); i++) {
         level.get(i).loadTiles("res/levels/tileset2.png");
        }
    }
}
