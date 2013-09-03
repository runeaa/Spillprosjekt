/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Settings;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author Rune
 */
public class GameStateSettings {
    private Settings setting = new Settings();

    public GameStateSettings() {
    }
    
    public void update(){}
    
    public void render(){}
    
    public void draw(Graphics2D g){
        g.setColor(Color.blue);
        g.fillRect(0, 0, setting.WITDH, setting.HEIGHT);
    }
}
