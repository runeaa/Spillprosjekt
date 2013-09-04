/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameElements;

import java.util.ArrayList;
import javax.annotation.PostConstruct;

/**
 *
 * @author espen
 */
public class Text {

    private String text;
    private ArrayList<String> tabS = new ArrayList<>();
    //private String s = "";
    private final int stringLength = 25;
    ArrayList<String> s = new ArrayList<>();

    public Text(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public int getLines() {
        return s.size();
    }

    public void makeTab() {
        int counter = 0;
        String string = "";
        String[] parts = text.split(" ");

        for (int i = 0; i < parts.length; i++) {
            if (counter + parts[i].length() > stringLength) {
                s.add(string);
                counter = 0;
                string = "";
            }
            counter += parts[i].length();
            string += parts[i] + " ";
        }
        s.add(string);
    }

    public ArrayList<String> getString() {
        return s;
    }
}