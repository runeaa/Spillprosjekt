package Main;

import Listeners.GameMenuMouseListener;
import Settings.PlayerSettings;
import Settings.Settings;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.sound.sampled.*;

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
    public String currentPage;
    public Clip clip;

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
        try {
            clip = AudioSystem.getClip();
            startMusic();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setButtonSetup(final JButton button) {
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setBorder(null);
        GameMenuMouseListener gamemenulistener = new GameMenuMouseListener(button, this);
        button.addMouseListener(gamemenulistener);
    }

    public void startMenuSetup() {
        currentPage = "startMenu";
        GridBagConstraints c = new GridBagConstraints();
        JButton button;


        button = new JButton();
        button.setToolTipText("Start Spill");
        button.setName("startGame");
        setButtonSetup(button);
        button.setIcon(new ImageIcon("./res/img/Startspill.png"));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(180, 80, 0, 100);
        c.gridx = 0;
        c.gridy = 1;
        add(button, c);

        button = new JButton();
        button.setToolTipText("Last Spill");
        button.setName("loadGame");
        setButtonSetup(button);
        button.setIcon(new ImageIcon("./res/img/Lastspill.png"));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(180, 0, 0, 100);
        c.gridx = 1;
        c.gridy = 1;
        add(button, c);

        button = new JButton();
        button.setToolTipText("Avslutt Spill");
        button.setName("exitGame");
        setButtonSetup(button);
        button.setIcon(new ImageIcon("./res/img/Avsluttspill.png"));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 1;
        add(button, c);

        button = new JButton();
        button.setToolTipText("Innstillinger");
        button.setName("settings");
        setButtonSetup(button);
        button.setIcon(new ImageIcon("./res/img/Innstillinger.png"));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(80, 80, 0, 100);
        c.gridx = 0;
        c.gridy = 2;
        add(button, c);

    }

    public void nameSetup() {
        currentPage = "name";
        GridBagConstraints c = new GridBagConstraints();
        JButton button;
        button = new JButton();
        button.setToolTipText("Tilbake til Hovedmenyen");
        button.setName("previous");
        setButtonSetup(button);
        button.setIcon(new ImageIcon("./res/img/tilbake.png"));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0, 110, 0, 110);
        c.gridx = 0;
        c.gridy = 1;
        add(button, c);

        button = new JButton();
        button.setToolTipText("Gå til Systemtype valg");
        button.setName("next");
        setButtonSetup(button);
        button.setIcon(new ImageIcon("./res/img/frem.png"));

        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0, 110, 0, 110);
        c.gridx = 2;
        c.gridy = 1;

        add(button, c);

        final JTextField name = new JTextField((playerSettings.getPlayerName() == null) ? "Skriv inn navnet ditt her" : playerSettings.getPlayerName());
        name.setToolTipText("Skriv inn navnet ditt");
        name.setName("navn");
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
        currentPage = "settings";
        GridBagConstraints c = new GridBagConstraints();
        JButton button;

        //TODO: Sound enable / disable
        button = new JButton();
        button.setToolTipText("Lyd");
        button.setName("Lyd");
        setButtonSetup(button);
        button.setIcon((settings.sound) ? new ImageIcon("./res/img/speakeron.png") : new ImageIcon("./res/img/speakermute.png"));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0, 60, 0, 220);
        c.gridx = 1;
        c.gridy = 1;
        add(button, c);

        button = new JButton();
        button.setToolTipText("Tilbake til hovedmenyen");
        button.setName("previous");
        setButtonSetup(button);
        button.setIcon(new ImageIcon("./res/img/tilbake.png"));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0, 20, 0, 40);
        c.gridx = 0;
        c.gridy = 1;
        add(button, c);
    }

    public void systemTypeSetup() {
        currentPage = "systemType";
        GridBagConstraints c = new GridBagConstraints();
        JButton button;

        button = new JButton();
        button.setToolTipText("Tilbake til navn valg");
        button.setName("previous");
        setButtonSetup(button);
        button.setIcon(new ImageIcon("./res/img/tilbake.png"));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0, 100, 0, 100);
        c.gridx = 0;
        c.gridy = 1;
        add(button, c);

        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement("Spillsystem");
        model.addElement("Sikkerhetskritiskesystem");
        model.addElement("Sanntidssystem");
        model.addElement("Informasjonssystem");
        model.addElement("Telekommunikasjonssystem");
        model.addElement("Feiltolerantsystem");
        final JComboBox comboBox = new JComboBox(model);
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String system = comboBox.getSelectedItem().toString();
                playerSettings.setSystem(system);
            }
        });
        if (playerSettings.getSystem() != null) {
            int i = model.getIndexOf(playerSettings.getSystem());
            comboBox.setSelectedIndex(i);
        }
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0, 0, 0, 0);
        c.gridx = 1;
        c.gridy = 1;
        add(comboBox, c);

        button = new JButton();
        button.setToolTipText("Gå til Utviklingsmodell valg");
        button.setName("next");
        setButtonSetup(button);
        button.setIcon(new ImageIcon("./res/img/frem.png"));

        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0, 95, 0, 95);
        c.gridx = 2;
        c.gridy = 1;

        add(button, c);
    }

    public void devMethodSetup() {
        currentPage = "devmethod";

        GridBagConstraints c = new GridBagConstraints();
        JButton button;

        button = new JButton();
        button.setToolTipText("Tilbake til systemtype valg");
        button.setName("previous");
        setButtonSetup(button);
        button.setIcon(new ImageIcon("./res/img/tilbake.png"));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0, 130, 0, 130);
        c.gridx = 0;
        c.gridy = 1;
        add(button, c);

        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement("SCRUM");
        model.addElement("Fossefallsmetoden");
        model.addElement("Spiralmetoden");
        model.addElement("Unified Processing");

        final JComboBox comboBox = new JComboBox(model);
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String devMethod = comboBox.getSelectedItem().toString();
                playerSettings.setDevMethod(devMethod);
            }
        });
        if (playerSettings.getDevMethod() != null) {
            int i = model.getIndexOf(playerSettings.getDevMethod());
            comboBox.setSelectedIndex(i);
        }
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0, 0, 0, 0);
        c.gridx = 1;
        c.gridy = 1;
        add(comboBox, c);

        button = new JButton();
        button.setToolTipText("Gå til vannskelighetsgrad valg");
        button.setName("next");
        setButtonSetup(button);
        button.setIcon(new ImageIcon("./res/img/frem.png"));

        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0, 130, 0, 130);
        c.gridx = 2;
        c.gridy = 1;

        add(button, c);
    }

    public void difficulitySetup() {
        currentPage = "difficulity";
        GridBagConstraints c = new GridBagConstraints();
        JButton button;

        button = new JButton();
        button.setToolTipText("Tilbake til Utviklingsmodell valg");
        button.setName("previous");
        setButtonSetup(button);
        button.setIcon(new ImageIcon("./res/img/tilbake.png"));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0, 160, 0, 160);
        c.gridx = 0;
        c.gridy = 1;
        add(button, c);

        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement("Enkelt");
        model.addElement("Normalt");
        model.addElement("Vanskelig");

        final JComboBox comboBox = new JComboBox(model);
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String difficulity = comboBox.getSelectedItem().toString();
                if (difficulity.equalsIgnoreCase("enkelt")) {
                    playerSettings.setDifficulity(PlayerSettings.EASY);
                } else if (difficulity.equalsIgnoreCase("normalt")) {
                    playerSettings.setDifficulity(PlayerSettings.NORMAL);
                } else if (difficulity.equalsIgnoreCase("vanskelig")) {
                    playerSettings.setDifficulity(PlayerSettings.HARD);
                }
            }
        });
        if (playerSettings.difficulity != -1) {
            comboBox.setSelectedIndex(playerSettings.difficulity);
        }
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0, 0, 0, 0);
        c.gridx = 1;
        c.gridy = 1;
        add(comboBox, c);

        button = new JButton();
        button.setToolTipText("Gå til Informasjonsskjerm");
        button.setName("next");
        setButtonSetup(button);
        button.setIcon(new ImageIcon("./res/img/frem.png"));

        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0, 160, 0, 160);
        c.gridx = 2;
        c.gridy = 1;

        add(button, c);
    }

    public void informationSetup() {
        currentPage = "information";
    }

    public void startMusic() throws Exception {
        ArrayList<String> musicFiles = new ArrayList();
        musicFiles.add("wakemeup.mid");

        File file = new File("./res/music/wakemeup.mid");
        // getAudioInputStream() also accepts a File or InputStream
        AudioInputStream ais = AudioSystem.
                getAudioInputStream(file);
        clip.open(ais);
        clip.loop(Clip.LOOP_CONTINUOUSLY);

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