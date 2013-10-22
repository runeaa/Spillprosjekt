/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameElements;

import Tasks.Task;
import java.awt.Graphics2D;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author amund
 */
public class TodoBoard extends JPanel {
    private List<Task> todo;
    private List<Task> doing;
    private List<Task> done;
    private static int TODO = 0, DOING = 1, DONE = 2;
    private int showPart = TODO;
    private ImageIcon scrumBoard;
    
    public TodoBoard(List<Task> todo, List<Task> doing, List<Task> done) {
        this.todo = todo;
        this.doing = doing;
        this.done = done;
    }
    
    /*public TodoBoard(List<Task> todo) {
        this.todo = todo;
        doing = new ArrayList<Task>();
        done = new ArrayList<Task>();
    }*/
    
    /*
     * TODO: add post its with tasks
     */
    public void paintComponent(Graphics2D g) {
        if (showPart == TODO) {
            scrumBoard = new ImageIcon("./res/img/todo.png");
        } else if (showPart == DOING) {
            scrumBoard = new ImageIcon("./res/img/doing.png");
        } else {
            scrumBoard = new ImageIcon("./res/img/done.png");
        }
        scrumBoard.paintIcon(null, g, 0, 0);
        super.paintComponent(g);
    }
    
}
