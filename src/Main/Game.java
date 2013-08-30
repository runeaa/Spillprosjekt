/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import javax.swing.JFrame;

/**
 *
 * @author Rune
 */
public class Game {
    public static void main(String[] args) {
        JFrame window = new JFrame("OLD SCRUMIE");
        window.setContentPane(new GameMenu());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.pack();
        window.setVisible(true);
    }
}
