/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIComponents;

import Controls.Controls;
import Game.Game;
import Projectile.Projectile;
import Unit.Player;
import Weapon.BasicWeapon;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.Point;
import javax.swing.ImageIcon;
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
    Boolean mouse; //if mouse is being used or not

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
        hideMouse();
        mouse = a.isMouse();

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
     * Code that hides the mouse pointer
     */
    public void hideMouse() {
        ImageIcon invisi = new ImageIcon(new byte[0]);
        Cursor invisible = getToolkit().createCustomCursor(
                invisi.getImage(), new Point(0, 0), "Hiding");
        this.setCursor(invisible);
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
        // Polygon shipone = one.ship(g2);
        movement();
        g2.setColor(Color.green);
        one.setLocation(new Point(player1_x, player1_y));
        mouse = a.isMouse();
        shootGame.addUnitToArray(one);
        try {
            shootGame.getUnitArray().get(shootGame.getUnitArrayLength() - 1).draw(g2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
            }
        }
        drawBackground();
        drawShips();
        drawProjectiles(g2);
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

    private void drawProjectiles(Graphics2D g2) {
        for (Projectile p : shootGame.getProjectileArray()) {
            p.doMove();
            p.draw(g2);
        }
    }

/**
 * used to control the movement
 */
    private void movement() {

        if (mouse) {
            player1_x = a.getMouseX();
            player1_y = a.getMouseY();
        } else {
            if (a.isUp()) {
                player1_y -= 1;
            }
            if (a.isDown()) {
                player1_y += 1;
            }
            if (a.isLeft()) {
                player1_x -= 1;
            }
            if (a.isRight()) {
                player1_x += 1;
            }
        }
    }

    
}
