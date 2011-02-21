/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Spawn;

import GUIComponents.BaseFrame;
import Spawn.Spawn;
import Unit.Enemy;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author danielcecil
 */
public class SpawnTest {

    Spawn sp;
    Enemy en;
    int width = 800;

    public SpawnTest() {
        sp = new Spawn();

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
     * testRandom tests if the spawn class produces a random number for the y
     * coordinate between 0 and the given frame width (default 800).
     */
    @Test
    public void testRandom() {
        int yCoord = en.getY();
        int expMin = 0;
        int expMax = width;
        boolean result;
        if (yCoord <= expMax && yCoord >= expMin) {
            result = true;
        } else {
            result = false;
            assertTrue(result);
        }

    }
}
