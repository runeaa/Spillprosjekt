package GameElements;

import Quiz.Answer;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author haavamoa
 */
public class FeedbackBox extends JLabel {
    private Answer answer;
    private ImageIcon feedbackImage;
    

    public FeedbackBox(Answer answer) {
        this.answer = answer;
    }

    public void paintComponent(Graphics2D g) {
        
        if(answer.isIsCorrect()){
            feedbackImage = new ImageIcon("./res/img/riktigsvar.png");
           
        }else{
            feedbackImage = new ImageIcon("./res/img/feilsvar.png");
            
        }
        feedbackImage.paintIcon(null, g,235, 120);
        super.paintComponent(g);
    }
}
    