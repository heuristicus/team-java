/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIComponents;

import Game.Game;
import Unit.Unit;
import java.awt.Graphics;
import java.awt.Color;
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
//    Controls a;

    public GamePanel() {
        System.out.println("gamepanel constructor");
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
