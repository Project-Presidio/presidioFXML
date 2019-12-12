/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author amersel
 */
public class QuestionListTest {
    
    public QuestionListTest() {
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
     * Test of getQuestionList method, of class QuestionList.
     */
//    @Test
//    public void testGetQuestionList() {
//        System.out.println("getQuestionList");
//        QuestionList instance = new QuestionList();
//        HashMap<Integer, Question_> expResult = null;
//        HashMap<Integer, Question_> result = instance.getQuestionList();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of importJSON method, of class QuestionList.
     */
    @Test
    public void testImportJSON() {
        System.out.println("importJSON");
        String json = "{\n" +
"  \"0\": {\n" +
"    \"id\": 0,\n" +
"    \"title\": \"What best describes your current situation?\",\n" +
"    \"response\": {\n" +
"      \"a\": \"Seismic\",\n" +
"      \"b\": \"Flood\",\n" +
"      \"c\": \"Inclement Weather\",\n" +
"      \"d\": \"Emergency\"\n" +
"    },\n" +
"    \n" +
"    \"redirect\":{\n" +
"      \"a\": 1,\n" +
"      \"b\": 1,\n" +
"      \"c\": 1,\n" +
"      \"d\": 1\n" +
"    }\n" +
"  },\n" +
"  \"1\": {\n" +
"    \"id\": 1,\n" +
"    \"title\": \"Is this a true false question?\",\n" +
"    \"response\": {\n" +
"      \"a\": \"Yes\",\n" +
"      \"b\": \"No\"\n" +
"    },\n" +
"    \n" +
"    \"redirect\":{\n" +
"      \"a\": -1,\n" +
"      \"b\": -2\n" +
"    }\n" +
"  }\n" +
"}";
        QuestionList expResult = null;
        QuestionList result = QuestionList.importJSON(json);
        System.out.println(result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
