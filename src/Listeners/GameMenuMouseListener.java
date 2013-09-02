package Listeners;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import Main.GameMenu;
import Main.GamePanel;

/**
 *
 * @author
 * haavamoa
 */
public class GameMenuMouseListener implements MouseListener {

    private GameMenu gamem;
    private JButton button;
    private String buttonTitle;
    private String currentPage;
    JFrame frame;

    public GameMenuMouseListener(JButton button, GameMenu gamem,JFrame frame) {
        this.gamem = gamem;
        this.frame = frame;
        this.button = button;
        this.buttonTitle = button.getName();
        this.currentPage = gamem.currentPage;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (currentPage.equalsIgnoreCase("startMenu")) {
            if (buttonTitle.equalsIgnoreCase("startGame")) {
                removeOldComponents();
                paintBackground("navn.png");
                setComponents();
            } else if (buttonTitle.equalsIgnoreCase("settings")) {
                removeOldComponents();
                paintBackground("Innstillingerbg.png");
                gamem.settingsSetup();
                gamem.revalidate();
                gamem.repaint();
            } else if (buttonTitle.equalsIgnoreCase("loadGame")) {
                JFileChooser opener = new JFileChooser("./res/saveGame");
               gamem.add(opener);
               opener.showOpenDialog(gamem);
               
            } else if (buttonTitle.equalsIgnoreCase("exitGame")) {
                System.exit(0);
            }
        } else if (currentPage.equalsIgnoreCase("settings")) {
            if (buttonTitle.equalsIgnoreCase("Lyd")) {
                gamem.setCursor(new Cursor(Cursor.HAND_CURSOR));
                if (gamem.settings.sound) {
                    gamem.clip.stop();
                    gamem.settings.setSound((gamem.settings.sound) ? false : true);
                } else {
                    gamem.clip.start();
                    gamem.settings.setSound((gamem.settings.sound) ? false : true);
                }
            }
            button.setIcon((gamem.settings.sound) ? new ImageIcon("./res/img/speakeronhoover.png") : new ImageIcon("./res/img/speakermutehoover.png"));
            setNextAndPrevious("", "menu.png");
        } else if (currentPage.equalsIgnoreCase("name")) {
            setNextAndPrevious("systemtype.png", "menu.png");
        } else if (currentPage.equalsIgnoreCase("systemType")) {
            setNextAndPrevious("utviklingsmodell.png", "navn.png");
        } else if (currentPage.equalsIgnoreCase("devmethod")) {
            setNextAndPrevious("vanskelighetsgrad.png", "systemtype.png");
        } else if (currentPage.equalsIgnoreCase("difficulity")) {
            setNextAndPrevious("valgteinnstillinger.png", "utviklingsmodell.png");
        } else if(currentPage.equalsIgnoreCase("chosenSettings") && buttonTitle.equalsIgnoreCase("startGame")){
            frame.removeAll();
            frame.setContentPane(new GamePanel());
        }
        else if(currentPage.equalsIgnoreCase("chosenSettings")){
            setNextAndPrevious("", "vanskelighetsgrad.png");
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
            if (button.getName().equalsIgnoreCase("previous")) {
                button.setIcon(new ImageIcon("./res/img/tilbakehoover.png"));
            } else if (button.getName().equalsIgnoreCase("next")) {
                button.setIcon(new ImageIcon("./res/img/fremhoover.png"));
            }
        }

        if (buttonTitle.equalsIgnoreCase("startGame") && currentPage.equalsIgnoreCase("startMenu")) {
            button.setIcon(new ImageIcon("./res/img/Startspillhoover.png"));;
        } else if (buttonTitle.equalsIgnoreCase("loadGame")) {
            button.setIcon(new ImageIcon("./res/img/Lastspillhoover.png"));
        } else if (buttonTitle.equalsIgnoreCase("exitGame")) {
            button.setIcon(new ImageIcon("./res/img/Avsluttspillhoover.png"));
        } else if (buttonTitle.equalsIgnoreCase("settings")) {
            button.setIcon(new ImageIcon("./res/img/Innstillingerhoover.png"));
        } else if (buttonTitle.equalsIgnoreCase("Lyd")) {
            button.setIcon((gamem.settings.sound) ? new ImageIcon("./res/img/speakeronhoover.png") : new ImageIcon("./res/img/speakermutehoover.png"));
        }
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        gamem.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        if (button.getName() != null) {
            if (button.getName().equalsIgnoreCase("previous")) {
                button.setIcon(new ImageIcon("./res/img/tilbake.png"));
            } else if (button.getName().equalsIgnoreCase("next")) {
                button.setIcon(new ImageIcon("./res/img/frem.png"));
            }
        }

        if (buttonTitle.equalsIgnoreCase("startGame") && currentPage.equalsIgnoreCase("startMenu")) {
            button.setIcon(new ImageIcon("./res/img/Startspill.png"));
        } else if (buttonTitle.equalsIgnoreCase("loadGame")) {
            button.setIcon(new ImageIcon("./res/img/Lastspill.png"));
        } else if (buttonTitle.equalsIgnoreCase("exitGame")) {
            button.setIcon(new ImageIcon("./res/img/Avsluttspill.png"));
        } else if (buttonTitle.equalsIgnoreCase("settings")) {
            button.setIcon(new ImageIcon("./res/img/Innstillinger.png"));
        } else if (buttonTitle.equalsIgnoreCase("Lyd")) {
            button.setIcon((gamem.settings.sound) ? new ImageIcon("./res/img/speakeron.png") : new ImageIcon("./res/img/speakermute.png"));
        }
    }

    private void paintBackground(String url) {
        try {
            gamem.setImg(ImageIO.read(new File("./res/img/" + url)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setComponents() {
        if (currentPage.equalsIgnoreCase("startMenu")) {
            if (buttonTitle.equalsIgnoreCase("startGame")) {
                gamem.nameSetup();
            } else if (buttonTitle.equalsIgnoreCase("settings")) {
                gamem.settingsSetup();
            }
        } else if (currentPage.equalsIgnoreCase("settings") && buttonTitle.equalsIgnoreCase("previous")) {
            gamem.startMenuSetup();
        } else if (currentPage.equalsIgnoreCase("name")) {
            if (buttonTitle.equalsIgnoreCase("next")) {
                gamem.systemTypeSetup();
            } else if (buttonTitle.equalsIgnoreCase("previous")) {
                gamem.startMenuSetup();
            }
        } else if (currentPage.equalsIgnoreCase("systemType")) {
            if (buttonTitle.equalsIgnoreCase("next")) {
                gamem.devMethodSetup();
            } else if (buttonTitle.equalsIgnoreCase("previous")) {
                gamem.nameSetup();
            }
        } else if (currentPage.equalsIgnoreCase("devmethod")) {
            if (buttonTitle.equalsIgnoreCase("next")) {
                gamem.difficulitySetup();
            } else if (buttonTitle.equalsIgnoreCase("previous")) {
                gamem.systemTypeSetup();

            }
        } else if (currentPage.equalsIgnoreCase("difficulity")) {
            if (buttonTitle.equalsIgnoreCase("next")) {
                gamem.chosenSettingsSetup();
            } else if (buttonTitle.equalsIgnoreCase("previous")) {
                gamem.devMethodSetup();
            }
        }else if(currentPage.equalsIgnoreCase("chosenSettings")){
            if (buttonTitle.equalsIgnoreCase("startGame")) {
                
            } else if (buttonTitle.equalsIgnoreCase("previous")) {
                gamem.difficulitySetup();
            }
        }
        gamem.revalidate();
        gamem.repaint();
    }

    private void removeOldComponents() {
        for (Component c : gamem.getComponents()) {
            gamem.remove(c);
        }
    }

    private void setNextAndPrevious(String nextURL, String previousURL) {
        if (buttonTitle.equalsIgnoreCase("next")) {
            removeOldComponents();
            paintBackground(nextURL);
            setComponents();
        } else if (buttonTitle.equalsIgnoreCase("previous")) {
            removeOldComponents();
            paintBackground(previousURL);
            setComponents();
        }
    }
}