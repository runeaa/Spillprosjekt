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
<<<<<<< HEAD
<<<<<<< HEAD

    public Textt(String text) {
=======
    //private String s = "";
    private final int stringLength = 25;
    ArrayList<String> s = new ArrayList<>();

    public Text(String text) {
>>>>>>> branch 'master' of https://github.com/runeaa/Spillprosjekt.git
=======
    //private String s = "";
    private final int stringLength = 25;
    ArrayList<String> s = new ArrayList<>();

    public Text(String text) {
>>>>>>> 69dcbcb3bf1725811d46d9b174773e48d9fe92ac
        this.text = text;
    }

    public String getText() {
        return text;
    }

<<<<<<< HEAD
<<<<<<< HEAD
=======
    public int getLines() {
        return s.size();
    }

>>>>>>> branch 'master' of https://github.com/runeaa/Spillprosjekt.git
=======
    public int getLines() {
        return s.size();
    }

>>>>>>> 69dcbcb3bf1725811d46d9b174773e48d9fe92ac
    public void makeTab() {
        int counter = 0;
        String string = "";
        String[] parts = text.split(" ");

        for (int i = 0; i < parts.length; i++) {
<<<<<<< HEAD
<<<<<<< HEAD
=======
            if (counter + parts[i].length() > stringLength) {
                s.add(string);
                counter = 0;
                string = "";
            }
            counter += parts[i].length();
            string += parts[i] + " ";
>>>>>>> branch 'master' of https://github.com/runeaa/Spillprosjekt.git
        }
<<<<<<< HEAD

=======
        s.add(string);
>>>>>>> branch 'master' of https://github.com/runeaa/Spillprosjekt.git
    }

<<<<<<< HEAD
    public void drawString() {
=======
    public ArrayList<String> getString() {
        return s;
>>>>>>> branch 'master' of https://github.com/runeaa/Spillprosjekt.git
    }
}
=======
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
>>>>>>> 69dcbcb3bf1725811d46d9b174773e48d9fe92ac
