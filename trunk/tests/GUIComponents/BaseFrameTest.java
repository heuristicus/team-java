/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GUIComponents;

import java.awt.Dimension;
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
 * @modified David
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
        Dimension DEFAULT_WINDOW_SIZE = new Dimension(800, 600);
        JPanel addPanel = new GamePanel();
        BaseFrame instance = new BaseFrame(DEFAULT_WINDOW_SIZE);
        instance.addPanel(addPanel);
        assertNotNull(instance);       
    }

}