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
        String firstLine = "Hvem er den beste i verden?";
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(instance.quizTab[0][0],firstLine);
    }
}