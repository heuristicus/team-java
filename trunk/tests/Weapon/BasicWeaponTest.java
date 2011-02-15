
package Weapon;

import java.awt.Point;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jere
 */
public class BasicWeaponTest {


    public BasicWeaponTest() {
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
     * Test of fire method, of class BasicWeapon.
     */
    @Test
    public void testFire() {
        System.out.println("fire");
        int x = 150;
        int y = 150;
        BasicWeapon instance = new BasicWeapon();

        // Cause of the range being 10 pixels per one.
        Point expResult = new Point(150, y-(instance.getRange()*10));

        instance.fire(x, y);
        assertEquals(expResult, instance.getProjectile().getLocation());

    }

}