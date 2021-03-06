/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameElements;

import Tasks.Task;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

/**
 *
 * @author amund
 */
public class TodoBoard extends Popup{
    private List<Task> todo;
    private List<Task> doing;
    private List<Task> done;
    public static final int TODO = 0, DOING = 1, DONE = 2;
    public int showPart = TODO;
    private ImageIcon scrumBoard;
    private ImageIcon postit;
    
    public TodoBoard(int showPart, List<Task> todo, List<Task> doing, List<Task> done) {
        this.showPart = showPart;
        this.todo = todo;
        this.doing = doing;
        this.done = done;
    }

    public TodoBoard(int showPart) {
        this.showPart = showPart;
        todo = new ArrayList<>();
        doing = new ArrayList<>();
        done = new ArrayList<>();
    }
    

    /*
     * TODO: add post its with tasks
     */
    @Override
    public void paintComponent(Graphics2D g) {
        if (showPart == TODO) {
            scrumBoard = new ImageIcon("./res/img/todo.png");
            postit = new ImageIcon("./res/img/PostItA.png");
        } else if (showPart == DOING) {
            scrumBoard = new ImageIcon("./res/img/doing.png");
            postit = new ImageIcon("./res/img/PostItA.png");
        } else {
            scrumBoard = new ImageIcon("./res/img/done.png");
            postit = new ImageIcon("./res/img/PostItA.png");
        }
        scrumBoard.paintIcon(null, g, 0, 0);
        postit.paintIcon(null, g, 50,50);
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
