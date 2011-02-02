/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIComponents;

import B3.trunk.src.Game.Game;
import java.awt.Graphics;
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

    public GamePanel() {
        System.out.println("gamepanel constructor");
    }


    /**
     * Initialises the panel. (not sure what needs to be done here)
     */
    private void initPanel() {
        gPanel = new JPanel();
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
    }

    private void drawShips() {
    }

    private void drawProjectiles() {
    }
}
