/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameElements;

import java.util.ArrayList;

/**
 *
 * @author espen
 */
class Textt {

    private String text;
    private ArrayList<String> tabS = new ArrayList<>();

    public Textt(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void makeTab() {
        int counter = 0;
        String[] parts = text.split(" ");

        for (int i = 0; i < parts.length; i++) {
        }

    }

    public void drawString() {
    }
}