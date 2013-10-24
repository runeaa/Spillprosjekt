/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameElements;

import Tasks.Task;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

/**
 *
 * @author amund
 */
public class TodoBoard extends Popup{
    private List<Task> todo;
    private List<Task> doing;
    private List<Task> done;
    public static final int TODO = 0, DOING = 1, DONE = 2;
    private int showPart = TODO;
    private ImageIcon scrumBoard;
    
    public TodoBoard(List<Task> todo, List<Task> doing, List<Task> done) {
        this.todo = todo;
        this.doing = doing;
        this.done = done;
        setKeyBindings();
    }

    public TodoBoard() {
        todo = new ArrayList<>();
        doing = new ArrayList<>();
        done = new ArrayList<>();
        setKeyBindings();
    }
    
    private void setKeyBindings() {        
        System.out.println("TodoBoard setKeyBindings");
        
        String l = "goLeft";
        getInputMap().put(KeyStroke.getKeyStroke("LEFT"), l);
        getActionMap().put(l, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("goLeft actionPerformed");
                
                if (showPart!=TODO) {
                    showPart--;
                }              
            }
        });
        String r = "goRight";
        getInputMap().put(KeyStroke.getKeyStroke("RIGHT"),r);
        getActionMap().put(r, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("goRight actionPerformed");
                
                if (showPart!=DONE) {
                    showPart++;
                }                
            }
        });
    }
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

    /**
     * @return the todo
     */
    public List<Task> getTodo() {
        return todo;
    }

    /**
     * @param todo the todo to set
     */
    public void setTodo(List<Task> todo) {
        this.todo = todo;
    }

    /**
     * @return the doing
     */
    public List<Task> getDoing() {
        return doing;
    }

    /**
     * @param doing the doing to set
     */
    public void setDoing(List<Task> doing) {
        this.doing = doing;
    }

    /**
     * @return the done
     */
    public List<Task> getDone() {
        return done;
    }

    /**
     * @param done the done to set
     */
    public void setDone(List<Task> done) {
        this.done = done;
    }

    /**
     * @return the showPart
     */
    public int getShowPart() {
        return showPart;
    }

    /**
     * @param showPart the showPart to set
     */
    public void setShowPart(int showPart) {
        this.showPart = showPart;
    }

    /**
     * @return the scrumBoard
     */
    public ImageIcon getScrumBoard() {
        return scrumBoard;
    }

    /**
     * @param scrumBoard the scrumBoard to set
     */
    public void setScrumBoard(ImageIcon scrumBoard) {
        this.scrumBoard = scrumBoard;
    }
}
