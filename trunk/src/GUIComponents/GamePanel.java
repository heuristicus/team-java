/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIComponents;

import Controls.Controls;
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
    int player1_x = 500;
    int player1_y = 500;
    Controls a;

    public GamePanel() {
        base = new BasicWeapon();
        System.out.println("gamepanel constructor");
        shootGame = new Game();
        one = new Player(200, 200, base, 200, player1_x, player1_y, Color.BLUE);
        a = new Controls();
        setFocusable(true);
        addMouseListener(a);
        addKeyListener(a);
        addMouseMotionListener(a);
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
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        setBackground(bgColor);
        shootGame.pruneArrays(this.getSize());
        one = new Player(200, 200, base, 200, player1_x, player1_y, Color.BLUE);
        // Polygon shipone = one.ship(g2);
        movement();
        g2.setColor(Color.green);
        // g2.fill(ship
        shootGame.addUnitToArray(one);
        shootGame.getUnitArray().get(0).draw(g2);
        drawBackground();
        drawShips();
        drawProjectiles();
        repaint();

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

    private void movement() {
        player1_x = a.getMouseX();
        player1_y = a.getMouseY();


//        if () {
//            y1 -= 1;
//        }
//        if (down) {
//            y1 += 1;
//        }
//        if (left) {
//            x1 -= 1;
//        }
//        if (right) {
//            x1 += 1;
//        }
    }

    private void drawProjectiles() {
    }
}
