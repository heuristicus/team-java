/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.awt.Dimension;
import java.awt.Color;
import Unit.Enemy;
import Projectile.Projectile;
import Unit.Unit;
import Projectile.BasicProjectile;
import Unit.DefaultUnit;
import Unit.Player;
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
    Unit enemy;
    Unit player;
    Projectile proj;
    Projectile outF1;
    Unit outF2;

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
        enemy = new Enemy(300, 100, new Rectangle2D.Double(), new BasicWeapon(), 20, 10, 10, Color.red);
        player = new Player(300, 200, new BasicWeapon(), 0, 40, 40, Color.green);
        proj = new BasicProjectile(20, 20);
        outF1 = new BasicProjectile(-300, -300);
        outF2 = new DefaultUnit(-400, -400);
    }

    @After
    public void tearDown() {
        g = null;
        enemy = null;
        proj = null;
    }

    /**
     * Array getter methods should be tested first, since if they don't work
     * properly, everything else is going to be broken as well, probably.
     */
    /**
     * Test of getUnitArray method, of class Game.
     */
    @Test
    public void testGetUnitArray() {
        ArrayList<Unit> expRes = new ArrayList<Unit>();
        assertArrayEquals(expRes.toArray(), g.getUnitArray().toArray());
    }

    /**
     * Test of getProjectileArray method, of class Game.
     */
    @Test
    public void testGetProjectileArray() {
        ArrayList<Projectile> expRes = new ArrayList<Projectile>();
        assertArrayEquals(expRes.toArray(), g.getProjectileArray().toArray());
    }

    /**
     * Test of addUnitToArray method, of class Game.
     */
    @Test
    public void testAddUnitToArray() {
        ArrayList<Unit> expArray = new ArrayList<Unit>();
        expArray.add(player);
        g.addUnitToArray(player);
        assertArrayEquals(expArray.toArray(), g.getUnitArray().toArray());
    }

    /**
     * Test of addProjectileToArray method, of class Game.
     */
    @Test
    public void testAddProjectileToArray() {
        ArrayList<Projectile> expArray = new ArrayList<Projectile>();
        expArray.add(proj);
        g.addProjectileToArray(proj);
        assertArrayEquals(expArray.toArray(), g.getProjectileArray().toArray());
    }

    @Test
    public void testPruneUnitArray() {
        ArrayList<Unit> expUnit = new ArrayList<Unit>();
        ArrayList<Projectile> expProj = new ArrayList<Projectile>();
        g.addProjectileToArray(outF1);
        g.addUnitToArray(outF2);
        g.pruneArrays(new Dimension(800, 600));
        assertArrayEquals(expProj.toArray(), g.getProjectileArray().toArray());
        assertArrayEquals(expUnit.toArray(), g.getUnitArray().toArray());
    }

    @Test
    public void testPruneProjectileArray() {
        ArrayList<Projectile> expProj = new ArrayList<Projectile>();
        g.addProjectileToArray(outF1);
        g.pruneProjectileArray(800, 600);
        assertArrayEquals(expProj.toArray(), g.getProjectileArray().toArray());
    }

    @Test
    public void testPruneArray() {
        ArrayList<Unit> expUnit = new ArrayList<Unit>();
        g.addUnitToArray(outF2);
        g.pruneUnitArray(800, 600);
        assertArrayEquals(expUnit.toArray(), g.getUnitArray().toArray());
    }
}
