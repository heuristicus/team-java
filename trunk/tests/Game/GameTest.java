/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import B3.trunk.src.Unit.Enemy;
import B3.trunk.src.Game.Game;
import B3.trunk.src.Projectile.Projectile;
import B3.trunk.src.Unit.Unit;
import Projectile.BasicProjectile;
import Weapon.BasicWeapon;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
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
public class GameTest {

    Game g;
    Unit u;
    Projectile p;

    public GameTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        g = new Game();
        u = new Enemy(300, 100, new Rectangle2D.Double(), new BasicWeapon(), 20);
        p = new BasicProjectile();
    }

    @After
    public void tearDown() {
        g = null;
        u = null;
        p = null;
    }

    /**
     * Test of addUnitToArray method, of class Game.
     */
    @Test
    public void testAddUnitToArray() {
        
    }

    /**
     * Test of addProjectileToArray method, of class Game.
     */
    @Test
    public void testAddProjectileToArray() {
        System.out.println("addProjectileToArray");
        Projectile addProjectile = null;
        Game instance = new Game();
        instance.addProjectileToArray(addProjectile);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUnitArray method, of class Game.
     */
    @Test
    public void testGetUnitArray() {
        System.out.println("getUnitArray");
        Game instance = new Game();
        ArrayList expResult = null;
        ArrayList result = instance.getUnitArray();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProjectileArray method, of class Game.
     */
    @Test
    public void testGetProjectileArray() {
        System.out.println("getProjectileArray");
        Game instance = new Game();
        ArrayList expResult = null;
        ArrayList result = instance.getProjectileArray();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
