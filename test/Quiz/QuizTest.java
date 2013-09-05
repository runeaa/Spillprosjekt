/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Quiz;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author amund
 */
public class QuizTest {
    
    public QuizTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of buildQuiz method, of class Quiz.
     */
    @Test
    public void testBuildQuiz() {
        System.out.println("buildQuiz");
        int valg = 0;
        Quiz instance = new Quiz(valg);
        instance.buildQuiz(valg);
        String question = "Hva er det første steget i fossefallsmodellen?";
        String ans1 = "Design";
        String ans2 = "Kravspesifikasjon";
        String ans3 = "Implementasjon";
        assertEquals(instance.getQuestions().get(0).getQuestion(),question);
        assertEquals(instance.getQuestions().get(0).getAnswers().get(0).getAnswer(), ans1);
        assertEquals(instance.getQuestions().get(0).getAnswers().get(1).getAnswer(), ans2);
        assertEquals(instance.getQuestions().get(0).getAnswers().get(2).getAnswer(), ans3);
    }
}