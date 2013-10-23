/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Settings;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
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
       try{
        BufferedImage img = ImageIO.read(new File("./res/img/pause.png"));
        g.drawImage(img, null, this);
       }catch(IOException e){
           e.printStackTrace();
       }

    }
}
