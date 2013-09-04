/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;
import Quiz.Quiz;
/**
 *
 * @author espen
 */
public class testmain {
    public static void main(String[] args) {
        for(int i=0;i<4;i++){
        Quiz quiz = new Quiz(i);
        System.out.println(quiz.toString());
        }
        
    }
}
