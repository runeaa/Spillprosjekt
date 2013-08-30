package Main;
import java.awt.GridBagLayout;
import javax.swing.*;
import Settings.*;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
/**
 *
 * @author haavamoa
 */
public class GameMenu extends JPanel {

    public Settings settings = new Settings();
    private BufferedImage img;
    public GameMenu(){
        try{
            img = ImageIO.read(new File("./res/img/menu.png"));
        }catch(IOException e){
        e.printStackTrace();
        }
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(settings.WITDH, settings.HEIGHT));
        setSize(settings.WITDH, settings.HEIGHT);
        menuSetup();
    }
    public void menuSetup(){
        GridBagConstraints c = new GridBagConstraints();
        JButton button;
        //TODO: Start game
        button = new JButton("Start spill");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 2;
        add(button,c);
        
        //TODO: Load game
        button = new JButton("Last spill");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 3;
        c.gridy = 2;
        add(button,c);
        
        //TODO: Exit game
        button = new JButton("Avslutt spill");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 4;
        c.gridy = 2;
        add(button,c);
        
        //TODO: Settings
        button = new JButton("Innstillinger");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 5;
        c.gridy = 2;
        add(button,c);

    }
   @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    // paint the background image and scale it to fill the entire space
    g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
  }
}
