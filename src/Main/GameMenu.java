package Main;

import java.awt.GridBagLayout;
import javax.swing.*;
import Settings.*;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author
 * haavamoa
 */
public class GameMenu extends JPanel {

    public Settings settings = new Settings();
    private BufferedImage img;

    public GameMenu() {
        try {
            img = ImageIO.read(new File("./res/img/menu.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(settings.WITDH, settings.HEIGHT));
        setSize(settings.WITDH, settings.HEIGHT);
        menuSetup();
    }

    public void setButtonSetup(final JButton button) {
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setBorder(null);
        button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                String buttonTitle = button.getToolTipText();
                if (buttonTitle.equalsIgnoreCase("Start spill")) {
                    button.setIcon(new ImageIcon("./res/img/Startspillhoover.png"));
                } else if (buttonTitle.equalsIgnoreCase("Last spill")) {
                    button.setIcon(new ImageIcon("./res/img/Lastspillhoover.png"));
                } else if (buttonTitle.equalsIgnoreCase("Avslutt spill")) {
                    button.setIcon(new ImageIcon("./res/img/Avsluttspillhoover.png"));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                String buttonTitle = button.getToolTipText();
                if (buttonTitle.equalsIgnoreCase("Start spill")) {
                    button.setIcon(new ImageIcon("./res/img/Startspill.png"));
                } else if (buttonTitle.equalsIgnoreCase("Last spill")) {
                    button.setIcon(new ImageIcon("./res/img/Lastspill.png"));
                } else if (buttonTitle.equalsIgnoreCase("Avslutt spill")) {
                    button.setIcon(new ImageIcon("./res/img/Avsluttspill.png"));
                }
            }
        });
    }

    public void menuSetup() {
        GridBagConstraints c = new GridBagConstraints();
        JButton button;


        //TODO: Start game
        button = new JButton();
        button.setToolTipText("Start Spill");
        setButtonSetup(button);
        button.setIcon(new ImageIcon("./res/img/Startspill.png"));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(70, 80, 0, 100);
        c.gridx = 0;
        c.gridy = 1;
        add(button, c);

        //TODO: Load game
        button = new JButton();
        button.setToolTipText("Last Spill");
        setButtonSetup(button);
        button.setIcon(new ImageIcon("./res/img/Lastspill.png"));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(70, 0, 0, 100);
        c.gridx = 1;
        c.gridy = 1;
        add(button, c);

        //TODO: Exit game
        button = new JButton();
        button.setToolTipText("Avslutt Spill");
        setButtonSetup(button);
        button.setIcon(new ImageIcon("./res/img/Avsluttspill.png"));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 1;
        add(button, c);

        //TODO: Settings
       /* button = new JButton("Innstillinger");
         setButtonSetup(button);
         c.fill = GridBagConstraints.HORIZONTAL;
         c.gridx = 5;
         c.gridy = 2;
         add(button, c);*/

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // paint the background image and scale it to fill the entire space
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }
}
