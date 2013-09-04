package GameElements;

import Quiz.Quiz;
import Settings.PlayerSettings;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author haavamoa
 */
public class DialogBox extends JLabel {
        private int interactedNPCID;
        private ImageIcon NPCImage;
        private Quiz quiz;
        private PlayerSettings playersettings;

    public DialogBox(PlayerSettings playersettings) {
        this.playersettings = playersettings;
        setText("heihei");
    }

    public void generateQuizText(){
        //GET DEV METODE
            //GI SPØRSMÅL GITT METHODE
               //GET NPC SPØRSMÅL (NPC ID)
                 //GENERER QUIZ FRA QUIZFIL
    }

    public void setInteractedNPCID(int interactedNPCID) {
        this.interactedNPCID = interactedNPCID;
    }
    
    
}
