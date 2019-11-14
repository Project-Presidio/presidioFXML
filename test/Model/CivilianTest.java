/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;
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
public class CivilianTest {
    
    public CivilianTest() {
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
     * Test of getFullname method, of class Civilian.
     */
    @Test
    public void testGetFullname() {
        System.out.println("getFullname");
        Civilian instance = null;
        String expResult = "";
        String result = instance.getFullname();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBirthday method, of class Civilian.
     */
    @Test
    public void testGetBirthday() {
        System.out.println("getBirthday");
        Civilian instance = null;
        Date expResult = null;
        Date result = instance.getBirthday();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isSex method, of class Civilian.
     */
    @Test
    public void testIsSex() {
        System.out.println("isSex");
        Civilian instance = null;
        boolean expResult = false;
        boolean result = instance.isSex();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWeight method, of class Civilian.
     */
    @Test
    public void testGetWeight() {
        System.out.println("getWeight");
        Civilian instance = null;
        double expResult = 0.0;
        double result = instance.getWeight();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHeight method, of class Civilian.
     */
    @Test
    public void testGetHeight() {
        System.out.println("getHeight");
        Civilian instance = null;
        double expResult = 0.0;
        double result = instance.getHeight();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPreexistingDisability method, of class Civilian.
     */
    @Test
    public void testGetPreexistingDisability() {
        System.out.println("getPreexistingDisability");
        Civilian instance = null;
        String expResult = "";
        String result = instance.getPreexistingDisability();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generateReport method, of class Civilian.
     */
    @Test
    public void testGenerateReport() {
        System.out.println("generateReport");
        Civilian instance = new Civilian("John Doe", new Date(), true, 185, 150, "N/A");
        String expResult = "";
        String result = instance.generateReport();
        System.out.println(result);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
