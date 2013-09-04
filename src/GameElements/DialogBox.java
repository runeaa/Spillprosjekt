package GameElements;

import Quiz.Answer;
import Quiz.Question;
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
        public int interactedNPCID;
        private ImageIcon dialogImage = new ImageIcon("./res/npc/dialog.png");
        private Quiz quiz;
        private PlayerSettings playersettings;

    public DialogBox(PlayerSettings playersettings) {
        this.setBorder(BorderFactory.createBevelBorder(TOP, Color.white, Color.black));
        this.playersettings = playersettings;
        quiz = new Quiz(playersettings.getDevMethodInt());
    }
    
    public void paintComponent(Graphics2D g){
                dialogImage.paintIcon(null, g, 0, 0);
                g.drawString("NPC ID: "+interactedNPCID,7,295);
                //question:
            Question question= quiz.getQuestions().get(interactedNPCID);
            String questionString = question.getQuestion();
            g.drawString(questionString, 250, 640/2);
                //answer
                for(Answer a:question.getAnswers()){
                    System.out.println(a.getAnswer());
                }
                super.paintComponent(g);
    }
    public void setInteractedNPCID(int interactedNPCID) {
        this.interactedNPCID = interactedNPCID;
    }
    
    
}
