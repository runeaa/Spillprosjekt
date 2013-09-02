/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Quiz;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.annotation.PostConstruct;
import javax.imageio.IIOException;

/**
 *
 * @author espen
 */
public class Quiz {

    public int valg;
    public String[][] quizTab;

    public Quiz(int valg) {
        this.valg = valg;
        buildQuiz(valg);

    }
    
    public void buildQuiz(int valg) {
        if (valg == 0) {
            String s = "res/fossefall.txt";
            readFromFile(s);

        }
        if (valg == 1) {
            String s = "res/spiral.txt";
            readFromFile(s);
        }
        if (valg == 2) {
            String s = "/res/up.txt";
            readFromFile(s);
        }
        if (valg == 3) {
            String s = "/res/scrum.txt";
            readFromFile(s);
        }
    }
    
    private void readFromFile(String s) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(s));
            int numQuiz = Integer.parseInt(br.readLine());
            String delimiters = "\\n";
            quizTab = new String[numQuiz][4];
            for (int i = 0; i < numQuiz; i++) {
                for (int j = 0; j < 3; j++) {
                    String line = br.readLine();
                    quizTab[i][j] = line;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String toString(){
        String s = " ";
        for(int i = 0; i < quizTab.length; i++){
            for(int j = 0; j < quizTab[0].length;j++){
                s += quizTab[i][j] + "\n";
            }
        }
        return s;
    }
}