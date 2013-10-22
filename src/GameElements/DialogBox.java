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
import static GameElements.TodoBoard.DONE;
import static GameElements.TodoBoard.TODO;
import Quiz.Libary;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

/**
 *
 * @author haavamoa
 */
public class DialogBox extends JLabel {
    public int interactedNPCID;
    private ImageIcon dialogImage = new ImageIcon("./res/npc/dialogprogrammerfade.png");
    private ImageIcon libaryImage = new ImageIcon("./res/img/book.png");
    public Quiz quiz;
    private PlayerSettings playersettings;
    public Question question;
    Libary libary = new Libary();
    TodoBoard tb = new TodoBoard();
    
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
        } else if (interactedNPCID == 101) {
            tb.paintComponent(g);
            return;
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
            dialogImage.paintIcon(null, g, 0, 420 - 147);
            g.drawString("Tore", 60, 295);
        }
        super.paintComponent(g);
    }

    public void setInteractedNPCID(int interactedNPCID) {
        this.interactedNPCID = interactedNPCID;
    }
//    private void setKeyBindings() {
//        System.out.println("HELLO?");
//        tb.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "goLeft");
//        tb.getActionMap().put("goLeft", new AbstractAction() {
//            @Override
//            public void actionPerformed(ActionEvent e){
//                if (tb.getShowPart()!=TodoBoard.TODO) {
//                    tb.setShowPart(tb.getShowPart()-1);
//                }              
//                System.out.println("LEFT NIGGA");
//            }
//        });
//        
//        tb.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("RIGHT"), "goRight");
//        tb.getActionMap().put("goRight", new AbstractAction() {
//            @Override
//            public void actionPerformed(ActionEvent e){
//                if (tb.getShowPart()!=TodoBoard.DONE) {
//                    tb.setShowPart(tb.getShowPart()+1);
//                }                
//                System.out.println("RIGHT NIGGA");
//            }
//        });
//    }
}
