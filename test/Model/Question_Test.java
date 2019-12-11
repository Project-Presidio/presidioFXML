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
public class Question_Test {
    
    public Question_Test() {
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
     * Test of importFromJSON method, of class Question_.
     */
    @Test
    public void testImportFromJSON() {
        System.out.println("importFromJSON");
        String json = "{\n" +
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
"  }";
        Question expResult = null;
        Question result = Question.importFromJSON(json);
        System.out.println(result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class Question_.
     */
//    @Test
//    public void testGetId() {
//        System.out.println("getId");
//        Question_ instance = new Question_();
//        int expResult = 0;
//        int result = instance.getId();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getTitle method, of class Question_.
//     */
//    @Test
//    public void testGetTitle() {
//        System.out.println("getTitle");
//        Question_ instance = new Question_();
//        String expResult = "";
//        String result = instance.getTitle();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getResponse method, of class Question_.
//     */
//    @Test
//    public void testGetResponse() {
//        System.out.println("getResponse");
//        Question_ instance = new Question_();
//        HashMap<String, String> expResult = null;
//        HashMap<String, String> result = instance.getResponse();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getRedirect method, of class Question_.
//     */
//    @Test
//    public void testGetRedirect() {
//        System.out.println("getRedirect");
//        Question_ instance = new Question_();
//        HashMap<String, Integer> expResult = null;
//        HashMap<String, Integer> result = instance.getRedirect();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
