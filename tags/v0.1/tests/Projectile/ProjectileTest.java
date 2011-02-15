/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Projectile;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
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
public class ProjectileTest {

    private static Projectile PROJ;
    private static final int DAMAGE = 200, SPEED = 400, X = 40, Y = 40;
    private static final boolean IS_ENEMY = true;
    private static final Shape SHAPE = new Rectangle2D.Double(10, 10, 5, 5);
    private static final Color COLOUR = Color.blue;

    public ProjectileTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        PROJ = null;
    }

    @Before
    public void setUp() {
        PROJ = new ComplexProjectile(X, Y, DAMAGE, SPEED, IS_ENEMY, SHAPE, COLOUR);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getDamage method, of class Projectile.
     */
    @Test
    public void testGetDamage() {
        int expResult = DAMAGE;
        int actualResult = PROJ.getDamage();
        assertEquals(expResult, actualResult);
    }

    /**
     * Test of getShape method, of class Projectile.
     */
    @Test
    public void testGetShape() {
        Shape expResult = SHAPE;
        Shape actualResult = PROJ.getShape();
        assertEquals(expResult, actualResult);
    }

    /**
     * Test of getEnemy method, of class Projectile.
     */
    @Test
    public void testIsEnemy() {
        boolean expResult = IS_ENEMY;
        boolean actualResult = PROJ.isEnemy();
        assertEquals(expResult, actualResult);
    }

    /**
     * Test of getSpeed method, of class Projectile.
     */
    @Test
    public void testGetSpeed() {
        int expResult = SPEED;
        int actualResult = PROJ.getSpeed();
        assertEquals(expResult, actualResult);
    }

    /**
     * Test of getColor method, of class Projectile.
     */
    @Test
    public void testGetColor() {
        Color expResult = COLOUR;
        Color actualResult = PROJ.getColor();
        assertEquals(expResult, actualResult);
    }

    /**
     * Test of getLocation method, of class Projectile.
     */
    @Test
    public void testGetLocation() {
        Point expResult = new Point(X, Y);
        Point actualResult = PROJ.getLocation();
        assertEquals(expResult, actualResult);
    }

    /**
     * Test of setShape method, of class Projectile.
     */
    @Test
    public void testSetShape() {
        Shape newShape = new Ellipse2D.Double(50, 50, 100, 100);
        Shape expResult = newShape;
        PROJ.setShape(newShape);
        Shape actualResult = PROJ.getShape();
        assertEquals(expResult, actualResult);
    }

    /**
     * Test of move method, of class Projectile.
     */
    @Test
    public void testMove() {
        Point expResult = new Point(300,300);
        PROJ.move(300, 300);
        Point actualResult = PROJ.getLocation();
        assertEquals(expResult, actualResult);
    }
}
