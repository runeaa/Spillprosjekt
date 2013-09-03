/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Quiz;

import Settings.Settings;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author marius
 */
public class Interact {
    private Settings setting;

    public Interact( Settings setting) {
        this.setting=setting;
    }
    
    public void update(){}
    
    public void render(){}
    public void lol(){
        System.out.println("HEEEEIA");
    }
    public void draw(Graphics2D g){
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, setting.WITDH, setting.HEIGHT);
    }
}
