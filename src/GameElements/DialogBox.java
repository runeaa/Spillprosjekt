package GameElements;

import Quiz.Answer;
import Quiz.Question;
import Quiz.Quiz;
import Settings.PlayerSettings;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import GameElements.Text;

/**
 *
 * @author haavamoa
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

    public int drawText(Graphics2D g, String s, int x, int y) {
       
       
        Text text = new Text(s);
        text.makeTab(70);
        for (String st : text.getString()) {
            g.drawString(st, x, y +=15);
        }
        return y;
    }

    public void paintComponent(Graphics2D g) {
        dialogImage.paintIcon(null, g, 0, 420 - 147);
        if (interactedNPCID < 9000) {

            g.setColor(Color.BLACK);
            g.drawString("Programmerer", 36, 295);

            question = quiz.getQuestions().get(interactedNPCID);
            String questionString = question.getQuestion();
            int y = 280;
            int x = 155;
            //g.drawString(questionString, x, y);
            drawText(g, questionString,x,y);
            y+=25;
//answer
            List<Answer> answers = question.getAnswers();
            for (int i = 0; i < answers.size(); i++) {
                y = drawText(g, i+1+". "+answers.get(i).getAnswer(),x,y);
            }
//g.drawString("1. " + answers.get(0).getAnswer(), x, y + (g.getFontMetrics().getHeight()) * 2);
//            g.drawString("2. " + answers.get(1).getAnswer(), x, y + (g.getFontMetrics().getHeight()) * 3);
//            g.drawString("3. " + answers.get(2).getAnswer(), x, y + (g.getFontMetrics().getHeight()) * 4);

        } else {
            g.drawString("Tore", 60, 295);
        }
        super.paintComponent(g);
    }

    public void setInteractedNPCID(int interactedNPCID) {
        this.interactedNPCID = interactedNPCID;
    }
}
