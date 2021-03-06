/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Settings.PlayerSettings;
import javax.swing.JFrame;

/**
 *
 * @author Rune
 */
public class Game {

    public static void main(String[] args) {
        JFrame window = new JFrame("A Programmer's Tale - You will be taught");
//         window.setContentPane(new GamePanel());
        GameMenu gamemenu = new GameMenu(window);
        gamemenu.playerSettings.setPlayerName("test subject");
        gamemenu.playerSettings.setDifficulity(PlayerSettings.EASY);
        gamemenu.playerSettings.setDevMethod("SCRUM");
        gamemenu.settings.clip.stop();
        gamemenu.settings.setSound(false);
        window.setContentPane(new GamePanel(gamemenu.playerSettings, gamemenu.settings, window));
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
