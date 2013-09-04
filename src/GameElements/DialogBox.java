package GameElements;

import Quiz.Quiz;
import Settings.PlayerSettings;
import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

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
