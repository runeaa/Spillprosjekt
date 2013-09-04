/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Quiz;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author espen
 */
public class Quiz {

    public int valg;
    public List<Question> questions;

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
            String s = "res/up.txt";
            readFromFile(s);
        }
        if (valg == 3) {
            String s = "res/scrum.txt";
            readFromFile(s);
        }
    }
    
    private void readFromFile(String s) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(s));
            int numQuiz = Integer.parseInt(br.readLine());
            //String delimiters = "\\n";
            int answersPerQuestion = 3;
            //quizTab = new String[numQuiz][linesPerQuestion];
            questions = new ArrayList<>();
            for (int i = 0; i < numQuiz; i++) {
                String question = br.readLine();
                List<Answer> answers = new ArrayList<>();
                for (int j = 0; j < answersPerQuestion; j++) {
                    String line = br.readLine();
                    String[] answer = line.split("#");
                    answers.add(new Answer(answer[0], answer[1].equals("R")));
//                    quizTab[i][j] = line;
                }
                questions.add(new Question(question, answers));
            }

            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public String toString(){
        String s = "";
        for(Question q: questions){
            s += q.getQuestion() + "\n";
            for(Answer a: q.getAnswers()){
                s += a.getAnswer() + " " + a.isIsCorrect() + "\n";
            }
        }
        return s;
    }
}