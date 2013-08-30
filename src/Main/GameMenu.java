package Main;

import Listeners.GameMenuMouseListener;
import java.awt.GridBagLayout;
import javax.swing.*;
import Settings.*;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author
 * haavamoa
 */
public class GameMenu extends JPanel {

    public PlayerSettings playerSettings = new PlayerSettings();
    public Settings settings = new Settings();
    public BufferedImage img;
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
        GameMenuMouseListener gamemenulistener = new GameMenuMouseListener(button, this);
        button.addMouseListener(gamemenulistener);
    }

    public void nameSetup() {
        GridBagConstraints c = new GridBagConstraints();
        JButton button;
        button = new JButton();
        button.setToolTipText("Tilbake til Hovedmenyen");
        button.setName("tilbake");
        setButtonSetup(button);
        button.setIcon(new ImageIcon("./res/img/tilbake.png"));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0, 110, 0, 110);
        c.gridx = 0;
        c.gridy = 1;
        add(button, c);

        button = new JButton();
        button.setToolTipText("Gå til Systemtype valg");
        button.setName("frem");
        setButtonSetup(button);
        button.setIcon(new ImageIcon("./res/img/frem.png"));

        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0, 110, 0, 110);
        c.gridx = 2;
        c.gridy = 1;

        add(button, c);

        final JTextField name = new JTextField((playerSettings.getPlayerName() == null) ? "Skriv inn navnet ditt her" : playerSettings.getPlayerName());
        name.setToolTipText("navn");
        name.setMinimumSize(new Dimension(200, 20));
        name.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                name.selectAll();
            }

            @Override
            public void focusLost(FocusEvent e) {
            }
        });
        name.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                playerSettings.setPlayerName(name.getText());
            }
        });
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0, 0, 0, 0);
        c.gridx = 1;
        c.gridy = 1;

        add(name, c);



    }

    public void settingsSetup() {
        GridBagConstraints c = new GridBagConstraints();
        JButton button;

        //TODO: Sound enable ( disable
        button = new JButton();
        button.setToolTipText("Lyd");
        setButtonSetup(button);
        button.setIcon((settings.sound) ? new ImageIcon("./res/img/speakeron.png") : new ImageIcon("./res/img/speakermute.png"));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0, 60, 0, 220);
        c.gridx = 1;
        c.gridy = 1;
        add(button, c);

        //TODO: Back
        button = new JButton();
        button.setToolTipText("Tilbake til Hovedmenyen");
        button.setName("tilbake");
        setButtonSetup(button);
        button.setIcon(new ImageIcon("./res/img/tilbake.png"));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0, 20, 0, 40);
        c.gridx = 0;
        c.gridy = 1;
        add(button, c);
    }

    public void systemTypeSetup() {
    }

    public void startMenuSetup() {
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

    public BufferedImage getImg() {
        return img;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }
}
