/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GUIComponents;

import GUIComponents.BaseFrame;
import javax.swing.JPanel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author michal
 */
public class BaseFrameTest {

    public BaseFrameTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addPanel method, of class BaseFrame.
     */
    @Test
    public void testAddPanel() {
        System.out.println("addPanel");
        JPanel addPanel = null;
        BaseFrame instance = null;
        instance.addPanel(addPanel);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}