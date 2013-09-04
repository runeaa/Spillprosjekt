package GameElements;

import Quiz.Quiz;
import Settings.PlayerSettings;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.KeyStroke;

/**
 *
 * @author haavamoa
 */
public class DialogBox extends JLabel {
        private int interactedNPCID;
        private ImageIcon dialogImage = new ImageIcon("./res/npc/dialog.png");
        private Quiz quiz;
        private PlayerSettings playersettings;

    public DialogBox(PlayerSettings playersettings) {
        this.setBorder(BorderFactory.createBevelBorder(TOP, Color.white, Color.black));
        this.playersettings = playersettings;
        setFocusable(true);
        Action doSomething = new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("yes");
            }
        };
        KeyStroke F1 = KeyStroke.getKeyStroke(KeyEvent.VK_F1,0);
        getInputMap().put(F1, doSomething);
    }

    public void generateQuizText(){
        //GET DEV METODE
            //GI SPØRSMÅL GITT METHODE
               //GET NPC SPØRSMÅL (NPC ID)
                 //GENERER QUIZ FRA QUIZFIL
    }
    public void paintComponent(Graphics2D g){
                dialogImage.paintIcon(null, g, 0, 0);
                super.paintComponent(g);
    }
    public void setInteractedNPCID(int interactedNPCID) {
        this.interactedNPCID = interactedNPCID;
    }
    
    
}
