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
import java.util.Random;

/**
 *
 * @author espen
 */
public class Quiz {

    private int valg;
    private List<Question> questions;

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
            final int answersPerQuestion = 3;
            String question;
            questions = new ArrayList<>();
            while ((question = br.readLine()) != null) {
                List<Answer> answers = new ArrayList<>();
                for (int j = 0; j < answersPerQuestion; j++) {
                    String line = br.readLine();
                    String[] answer = line.split("#");
                    answers.add(new Answer(answer[0], answer[1].equals("R")));
                }
                getQuestions().add(new Question(question, answers));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        String s = "";
        for (Question q : getQuestions()) {
            s += q.getQuestion() + "\n";
            for (Answer a : q.getAnswers()) {
                s += a.getAnswer() + " " + a.isIsCorrect() + "\n";
            }
        }
        return s;
    }

    /**
     * @return the valg
     */
    public int getValg() {
        return valg;
    }

    /**
     * @param valg the valg to set
     */
    public void setValg(int valg) {
        this.valg = valg;
    }

    /**
     * @return the questions
     */
    public List<Question> getQuestions() {
        return questions;
    }

    /**
     * @param questions the questions to set
     */
    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public Question getRandomQuestion() {
        return questions.get(new Random().nextInt(questions.size()));
    }
}