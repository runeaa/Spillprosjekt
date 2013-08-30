package Listeners;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import GameElements.*;
import Main.GameMenu;

/**
 *
 * @author
 * haavamoa
 */
public class GameMenuMouseListener implements MouseListener {

    private GameMenu gamem;
    private JButton button;
    private String buttonTitle;

    public GameMenuMouseListener(JButton button, GameMenu gamem) {
        this.gamem = gamem;
        this.button = button;
        this.buttonTitle = button.getToolTipText();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (buttonTitle.equalsIgnoreCase("Start Spill")) {
            for (Component c : gamem.getComponents()) {
                gamem.remove(c);
            }
            try {
                gamem.setImg(ImageIO.read(new File("./res/img/navn.png")));
            } catch (IOException er) {
                er.printStackTrace();
            }
            gamem.nameSetup();
            gamem.revalidate();
            gamem.repaint();
        } else if (buttonTitle.equalsIgnoreCase("Innstillinger")) {
            for (Component c : gamem.getComponents()) {
                gamem.remove(c);
            }

            try {
                gamem.setImg(ImageIO.read(new File("./res/img/Innstillingerbg.png")));
            } catch (IOException er) {
                er.printStackTrace();
            }
            gamem.settingsSetup();
            gamem.revalidate();
            gamem.repaint();
        } else if (buttonTitle.equalsIgnoreCase("Lyd")) {
            gamem.settings.setSound((gamem.settings.sound) ? false : true);
            button.setIcon((gamem.settings.sound) ? new ImageIcon("./res/img/speakeronhoover.png") : new ImageIcon("./res/img/speakermutehoover.png"));
            gamem.setCursor(new Cursor(Cursor.HAND_CURSOR));
        } else if (buttonTitle.equalsIgnoreCase("Tilbake til Hovedmenyen")) {
            for (Component c : gamem.getComponents()) {
                gamem.remove(c);
            }

            try {
                gamem.setImg(ImageIO.read(new File("./res/img/menu.png")));
            } catch (IOException er) {
                er.printStackTrace();
            }
            gamem.startMenuSetup();
            gamem.revalidate();
            gamem.repaint();
        } else if (buttonTitle.equalsIgnoreCase("Gå til systemtype valg")) {
            for (Component c : gamem.getComponents()) {
                gamem.remove(c);
            }

            try {
                gamem.setImg(ImageIO.read(new File("./res/img/systemtype.png")));
            } catch (IOException er) {
                er.printStackTrace();
            }
            gamem.systemTypeSetup();
            gamem.revalidate();
            gamem.repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        gamem.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }

    @Override
    public void mouseEntered(MouseEvent e) {

        gamem.setCursor(new Cursor(Cursor.HAND_CURSOR));
        if (button.getName() != null) {
            if (button.getName().equalsIgnoreCase("tilbake")) {
                button.setIcon(new ImageIcon("./res/img/tilbakehoover.png"));
            } else if (button.getName().equalsIgnoreCase("frem")) {
                button.setIcon(new ImageIcon("./res/img/fremhoover.png"));
            }
        }


        if (buttonTitle.equalsIgnoreCase("Start spill")) {
            button.setIcon(new ImageIcon("./res/img/Startspillhoover.png"));;
        } else if (buttonTitle.equalsIgnoreCase("Last spill")) {
            button.setIcon(new ImageIcon("./res/img/Lastspillhoover.png"));
        } else if (buttonTitle.equalsIgnoreCase("Avslutt spill")) {
            button.setIcon(new ImageIcon("./res/img/Avsluttspillhoover.png"));
        } else if (buttonTitle.equalsIgnoreCase("Innstillinger")) {
            button.setIcon(new ImageIcon("./res/img/Innstillingerhoover.png"));
        } else if (buttonTitle.equalsIgnoreCase("Lyd")) {
            button.setIcon((gamem.settings.sound) ? new ImageIcon("./res/img/speakeronhoover.png") : new ImageIcon("./res/img/speakermutehoover.png"));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        gamem.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        if (button.getName() != null) {
            if (button.getName().equalsIgnoreCase("tilbake")) {
                button.setIcon(new ImageIcon("./res/img/tilbake.png"));
            } else if (button.getName().equalsIgnoreCase("frem")) {
                button.setIcon(new ImageIcon("./res/img/frem.png"));
            }
        }

        if (buttonTitle.equalsIgnoreCase("Start spill")) {
            button.setIcon(new ImageIcon("./res/img/Startspill.png"));
        } else if (buttonTitle.equalsIgnoreCase("Last spill")) {
            button.setIcon(new ImageIcon("./res/img/Lastspill.png"));
        } else if (buttonTitle.equalsIgnoreCase("Avslutt spill")) {
            button.setIcon(new ImageIcon("./res/img/Avsluttspill.png"));
        } else if (buttonTitle.equalsIgnoreCase("Innstillinger")) {
            button.setIcon(new ImageIcon("./res/img/Innstillinger.png"));
        } else if (buttonTitle.equalsIgnoreCase("Lyd")) {
            button.setIcon((gamem.settings.sound) ? new ImageIcon("./res/img/speakeron.png") : new ImageIcon("./res/img/speakermute.png"));
        }
    }
}
