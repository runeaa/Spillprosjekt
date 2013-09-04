/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Quiz;

import java.util.List;

/**
 *
 * @author amund
 */
public class Question {
    private String question;
    private List<Answer> answers;
    
    public Question(String question, List<Answer> answers){
        this.question = question;
        this.answers = answers;
    }

    /**
     * @return the question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * @param question the question to set
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * @return the answers
     */
    public List<Answer> getAnswers() {
        return answers;
    }

    /**
     * @param answers the answers to set
     */
    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
