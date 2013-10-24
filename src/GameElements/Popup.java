package GameElements;

import java.awt.Graphics2D;
import javax.swing.JLabel;

/**
 *
 * @author amund
 */
public class Popup extends JLabel {
    public int interactedNPCID;
    public void paintComponent(Graphics2D g){
        super.paintComponent(g);
    }

    public void setInteractedNPCID(int interactedNPCID) {
        this.interactedNPCID = interactedNPCID;
    }
}
