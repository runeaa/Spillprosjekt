/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Settings;

import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Rune
 */
public class GameStateSettings extends JPanel {

    private Settings setting;

    public GameStateSettings(Settings setting) {
        this.setting = setting;
    }

    public void update() {
    }

    public void render() {
    }

    public void draw(Graphics2D g) {
        g.setColor(Color.YELLOW);
        g.fillRect(0, 0, setting.WITDH, setting.HEIGHT);
    }
}
