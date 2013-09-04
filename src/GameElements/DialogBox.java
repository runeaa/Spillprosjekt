package GameElements;

import Quiz.Answer;
import Quiz.Question;
import Quiz.Quiz;
import Settings.PlayerSettings;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author
 * haavamoa
 */
public class DialogBox extends JLabel {

    public int interactedNPCID;
    private ImageIcon dialogImage = new ImageIcon("./res/npc/dialogprogrammerfade.png");
    public Quiz quiz;
    private PlayerSettings playersettings;
    public Question question;

    public DialogBox(PlayerSettings playersettings) {
        this.playersettings = playersettings;
        quiz = new Quiz(playersettings.getDevMethodInt());
    }

    public void paintComponent(Graphics2D g) {
        dialogImage.paintIcon(null, g, 0, 420 - 147);
        if (interactedNPCID < 9000) {
            g.drawString("Programmerer", 36, 295);
            //question:
            question = quiz.getQuestions().get(interactedNPCID);
            String questionString = question.getQuestion();
            int y = 295;
            int x = 155;
            g.drawString(questionString, x, y);
            //answer
            List<Answer> answers = question.getAnswers();
            g.drawString("1. " + answers.get(0).getAnswer(), x, y + (g.getFontMetrics().getHeight()) * 2);
            g.drawString("2. " + answers.get(1).getAnswer(), x, y + (g.getFontMetrics().getHeight()) * 3);
            g.drawString("3. " + answers.get(2).getAnswer(), x, y + (g.getFontMetrics().getHeight()) * 4);

        } else {
            g.drawString("Tore", 60, 295);
        }
        super.paintComponent(g);
    }

    public void setInteractedNPCID(int interactedNPCID) {
        this.interactedNPCID = interactedNPCID;
    }
}
