package GameElements;

import Quiz.Answer;
import Quiz.Question;
import Quiz.Quiz;
import Settings.PlayerSettings;
import java.awt.Graphics2D;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Quiz.Libary;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author haavamoa
 */
public class DialogBox extends Popup {
    private ImageIcon dialogImage = new ImageIcon("./res/npc/dialogprogrammerfade.png");
    private ImageIcon mentorImage = new ImageIcon("./res/npc/dialogmentorfade.png");
    private ImageIcon libaryImage = new ImageIcon("./res/img/book.png");
    public Quiz quiz;
    private PlayerSettings playersettings;
    public Question question;
    Libary libary = new Libary();
    
    public DialogBox(PlayerSettings playersettings) {
        this.playersettings = playersettings;
        quiz = new Quiz(playersettings.getDevMethodInt());
    }

    public int drawText(Graphics2D g, String s, int x, int y) {
        Text text = new Text(s);
        text.makeTab(70);
        for (String st : text.getString()) {
            g.drawString(st, x, y += 15);
        }
        return y;
    }
    
    public void paintComponent(Graphics2D g) {
        //dialogImage.paintIcon(null, g, 0, 420 - 147);
        if (interactedNPCID == 100) {
            libaryImage.paintIcon(null, g, 0, 0 - 0);
            libary.drawLibary(g);
        } else if (interactedNPCID < 9000) {
            dialogImage.paintIcon(null, g, 0, 420 - 147);

            g.setColor(Color.BLACK);
            g.drawString("Programmerer", 36, 295);

            question = quiz.getQuestions().get(interactedNPCID);
            String questionString = question.getQuestion();
            int y = 280;
            int x = 155;
            //g.drawString(questionString, x, y);
            drawText(g, questionString, x, y);
            y += 25;
//answer
            List<Answer> answers = question.getAnswers();
            for (int i = 0; i < answers.size(); i++) {
                y = drawText(g, i + 1 + ". " + answers.get(i).getAnswer(), x, y);
            }
//g.drawString("1. " + answers.get(0).getAnswer(), x, y + (g.getFontMetrics().getHeight()) * 2);
//            g.drawString("2. " + answers.get(1).getAnswer(), x, y + (g.getFontMetrics().getHeight()) * 3);
//            g.drawString("3. " + answers.get(2).getAnswer(), x, y + (g.getFontMetrics().getHeight()) * 4);

        } else {
            mentorImage.paintIcon(null, g, 0, 420 - 147);
            g.drawString("Tore", 60, 295);
            g.setColor(Color.BLACK);

            String line1 = "God dag, "+playersettings.getPlayerName();
            String line2 = "I dag skal du starte på ett nytt prosjekt, et spill.";
            String line3 = "Kunden vil ha et produkt som kan brukes som et supplement i en ";
            String line4 = "tradisjonell utdanning, det skal lære spilleren om programvareutvikling.";
            String line5 = "Det er ingen krav om hvilken type spill det skal være, bare at det skal være ";
            String line6 = "lærerikt. Spilleren skal kunne gå fra krav til kjørbart system, og forstå";
            String line7 = "sammenhengen mellom stegene.";
            String[] dialog = {line1,line2,line3,line4,line5,line6,line7};
            int y = 265;
            y += 25;
            for (int i = 0; i < dialog.length; i++) {
                y = drawText(g, dialog[i], 160, y);
            }

        }
        super.paintComponent(g);
    }
}
