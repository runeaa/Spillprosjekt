package Main;

import java.awt.GridBagLayout;
import javax.swing.*;
import Settings.*;
import java.awt.Component;
import java.awt.Cursor;
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
    private JPanel pan = this;

    public GameMenu() {
        try {
            img = ImageIO.read(new File("./res/img/menu.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(settings.WITDH, settings.HEIGHT));
        setSize(settings.WITDH, settings.HEIGHT);
        startMenuSetup();
    }

    public void setButtonSetup(final JButton button) {
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setBorder(null);
        button.addMouseListener(new MouseListener() {
            public String buttonTitle = button.getToolTipText();

            @Override
            public void mouseClicked(MouseEvent e) {
                if (buttonTitle.equalsIgnoreCase("Innstillinger")) {
                    for (Component c : pan.getComponents()) {
                        pan.remove(c);
                    }

                    try {
                        img = ImageIO.read(new File("./res/img/Innstillingerbg.png"));
                    } catch (IOException er) {
                        er.printStackTrace();
                    }
                    settingsSetup();
                    pan.revalidate();
                    pan.repaint();
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mouseEntered(MouseEvent e) {

                setCursor(new Cursor(Cursor.HAND_CURSOR));
                if (buttonTitle.equalsIgnoreCase("Start spill")) {
                    button.setIcon(new ImageIcon("./res/img/Startspillhoover.png"));;
                } else if (buttonTitle.equalsIgnoreCase("Last spill")) {
                    button.setIcon(new ImageIcon("./res/img/Lastspillhoover.png"));
                } else if (buttonTitle.equalsIgnoreCase("Avslutt spill")) {
                    button.setIcon(new ImageIcon("./res/img/Avsluttspillhoover.png"));
                } else if (buttonTitle.equalsIgnoreCase("Innstillinger")) {
                    button.setIcon(new ImageIcon("./res/img/Innstillingerhoover.png"));
                } else if (buttonTitle.equalsIgnoreCase("sound")) {
                    button.setIcon((settings.sound) ? new ImageIcon("./res/img/speakermute.png") : new ImageIcon("./res/img/speakeron.png"));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                if (buttonTitle.equalsIgnoreCase("Start spill")) {
                    button.setIcon(new ImageIcon("./res/img/Startspill.png"));
                } else if (buttonTitle.equalsIgnoreCase("Last spill")) {
                    button.setIcon(new ImageIcon("./res/img/Lastspill.png"));
                } else if (buttonTitle.equalsIgnoreCase("Avslutt spill")) {
                    button.setIcon(new ImageIcon("./res/img/Avsluttspill.png"));
                } else if (buttonTitle.equalsIgnoreCase("Innstillinger")) {
                    button.setIcon(new ImageIcon("./res/img/Innstillinger.png"));
                } else if (buttonTitle.equalsIgnoreCase("sound")) {
                    button.setIcon((settings.sound) ? new ImageIcon("./res/img/speakeron.png") : new ImageIcon("./res/img/speakermute.png"));
                }
            }
        });
    }

    private void settingsSetup() {
        GridBagConstraints c = new GridBagConstraints();
        JButton button;

        //TODO: Sound enable ( disable
        button = new JButton();
        button.setToolTipText("Sound");
        setButtonSetup(button);
        button.setIcon((settings.sound) ? new ImageIcon("./res/img/speakeron.png") : new ImageIcon("./res/img/speakermute.png"));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0, 20, 0, 0);
        c.gridx = 1;
        c.gridy = 1;
        add(button, c);

        //TODO: Back
        button = new JButton("Back");
        button.setToolTipText("Back");
        setButtonSetup(button);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        add(button, c);
    }

    private void startMenuSetup() {
        GridBagConstraints c = new GridBagConstraints();
        JButton button;


        //TODO: Start game
        button = new JButton();
        button.setToolTipText("Start Spill");
        setButtonSetup(button);
        button.setIcon(new ImageIcon("./res/img/Startspill.png"));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(180, 80, 0, 100);
        c.gridx = 0;
        c.gridy = 1;
        add(button, c);

        //TODO: Load game
        button = new JButton();
        button.setToolTipText("Last Spill");
        setButtonSetup(button);
        button.setIcon(new ImageIcon("./res/img/Lastspill.png"));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(180, 0, 0, 100);
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
        button = new JButton();
        button.setToolTipText("Innstillinger");
        setButtonSetup(button);
        button.setIcon(new ImageIcon("./res/img/Innstillinger.png"));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(80, 80, 0, 100);
        c.gridx = 0;
        c.gridy = 2;
        add(button, c);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // paint the background image and scale it to fill the entire space
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }
}
