/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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
public class ArticleTest {
    
    public ArticleTest() {
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

//    /**
//     * Test of getTitle method, of class Article.
//     */
//    @Test
//    public void testGetTitle() {
//        System.out.println("getTitle");
//        Article instance = null;
//        String expResult = "";
//        String result = instance.getTitle();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getContent method, of class Article.
//     */
//    @Test
//    public void testGetContent() {
//        System.out.println("getContent");
//        Article instance = null;
//        String expResult = "";
//        String result = instance.getContent();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of toString method, of class Article.
//     */
//    @Test
//    public void testToString() {
//        System.out.println("toString");
//        Article instance = null;
//        String expResult = "";
//        String result = instance.toString();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getId method, of class Article.
//     */
//    @Test
//    public void testGetId() {
//        System.out.println("getId");
//        Article instance = null;
//        int expResult = 0;
//        int result = instance.getId();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of extractTitle method, of class Article.
     */
    @Test
    public void testExtractTitle() {
        System.out.println("extractTitle");
        Article instance = new Article(-1, "<!DOCTYPE html>\n" +
"<html>\n" +
"\n" +
"<head>\n" +
"  <meta charset=\"utf-8\">\n" +
"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"  <title>Welcome file</title>\n" +
"  <link rel=\"stylesheet\" href=\"https://stackedit.io/style.css\" />\n" +
"</head>\n" +
"\n" +
"<body class=\"stackedit\">\n" +
"  <div class=\"stackedit__html\"><h1 id=\"how-to-stay-safe-during-and-after-tropical-storms\">How to Stay Safe During and After Tropical Storms</h1>\n" +
"<p><img src=\"https://media.nature.com/lw800/magazine-assets/d41586-019-01544-5/d41586-019-01544-5_16719378.jpg\" alt=\"enter image description here\"></p>\n" +
"<ol>\n" +
"<li>Turn off the power at the main breaker in your house if the device is still plugged in. Wait for an electrician to check the device before using it.</li>\n" +
"<li>If the power is out, use flashlights instead of candles.</li>\n" +
"<li>If you have a CO detector and it starts beeping, leave your home right away and call 911.</li>\n" +
"<li>Leave your home or building if you hear shifting or unusual noises. Strange noises could mean the building about to fall.</li>\n" +
"<li>Watch out for fallen power lines that may be hanging overhead.</li>\n" +
"<li>Throw away food that may have come in contact with flood or storm water. Unsafe food can make you sick even if it looks, smells, and tastes normal.</li>\n" +
"</ol>\n" +
"</div>\n" +
"</body>\n" +
"\n" +
"</html>");
        System.out.println(instance.getTitle());
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
