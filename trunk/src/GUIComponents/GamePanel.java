/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIComponents;

import Game.Game;
import Unit.Player;
import Unit.Unit;
import Weapon.BasicWeapon;
import com.sun.org.apache.xpath.internal.axes.OneStepIterator;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author michal
 */
public class GamePanel extends JPanel {

    /*
     *  The panel needs to have somewhere to get data from, and logically this is
     * the game that is currently taking place. Perhaps have this as a constructor
     * parameter, or have it passed in using another method.
     */
    Game shootGame;
    JPanel gPanel;
	Color bgColor = Color.BLACK;
        Player one;
        BasicWeapon base;
//    Controls a;

    public GamePanel() {
        base = new BasicWeapon();
        System.out.println("gamepanel constructor");
        shootGame = new Game();
        one = new Player(200, 200, base, 200, 20, 20, Color.BLUE);
 //     a = new Controls();

    }

    /**
     * Initialises the panel. (not sure what needs to be done here)
     */
    private void initPanel() {
        gPanel = new JPanel();
//        gPanel.addMouseListener(a);
//        gPanel.addKeyListener(a);
//        gPanel.addMouseMotionListener(a);
    }

    /**
     * Most important method here. Draws all objects that need to be drawn.
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
      
       // Polygon shipone = one.ship(g2);
        g2.setColor(Color.green);
      // g2.fill(ship
        shootGame.addUnitToArray(one);
        shootGame.getUnitArray().get(0).draw(g2);
        drawBackground();
        drawShips();
        drawProjectiles();

    }

    /**
     * Draws the background
     */
    private void drawBackground() {
	// gPanel.setBackground(bgColor);
        // Background now set in BaseFrame
    }

    private void drawShips() {
        /*
         * Get the unit array from Game.java
         * For each unit call it's draw method passing Graphics g
         *
         */




    }

    private void drawProjectiles() {
    }
}
