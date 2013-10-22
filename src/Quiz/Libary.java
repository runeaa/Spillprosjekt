/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Quiz;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author Marius
 */
public class Libary {

    private List<String> libList = new ArrayList<>();

    public Libary() {
        readFromFile();
    }

    @PostConstruct
    private void readFromFile() {
        String s = "";
        String file = "res/dialog//libary.txt";

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String text;
            while ((text = br.readLine()) != null) {
                s += text;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        makeTab(s, 35);
    }

    public void makeTab(String s, int grense) {
        int counter = 0;
        String string = "";
        String[] parts = s.split(" ");

        for (int i = 0; i < parts.length; i++) {
            if (counter + parts[i].length() > grense) {
                libList.add(string);
                counter = 0;
                string = "";
            }
            counter += parts[i].length();
            string += parts[i] + " ";
        }
        libList.add(string);
    }

    public void drawLibary(Graphics2D g) {
        int x = 50;
        int y = 50;
        g.setColor(Color.black);
        List<String> text = getList();
        for (int i = 0; i < text.size(); i++) {
            if (i < 23) {
                g.drawString(text.get(i), x, y+(15*i));

            }else{
                x=340;
                g.drawString(text.get(i), x, y+(15*(i-23)));
            }
        }
    }

    public List<String> getList() {
        return libList;
    }

}
