/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package B3.trunk.tests;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author michal
 */
public class movementTest extends JPanel implements KeyListener {

    JFrame frame = new JFrame();
    int x1 = 10, y1 = 10, x2 = 20, y2 = 20;
    Rectangle2D rect = new Rectangle2D.Double(x1, y1, x2, y2);
    ArrayList<Shape> toDraw = new ArrayList<Shape>();
    boolean up = false;
    boolean down = false;
    boolean left = false;
    boolean right = false;
    boolean space = false;

    public static void main(String[] args) {
        new movementTest();
    }

    public movementTest() {
        initFrame();

    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g_ = (Graphics2D) g;
        //g_.setXORMode(frame.getBackground());
        g_.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g_.setColor(Color.blue);
        g_.fillRect(frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
        g_.setColor(Color.red);
        g_.fill(rect);
        g_.setColor(Color.blue);
        for (Shape shape : toDraw) {
            System.out.println(shape);
            g_.setColor(Color.black);
            g_.draw(shape);
        }
        doMove();
    }

    public void doMove() {
        if (up) {
            y1 -= 1;
        }
        if (down) {
            y1 += 1;
        }
        if (left) {
            x1 -= 1;
        }
        if (right) {
            x1 += 1;
        }
        if (space) {
            toDraw.add(new Line2D.Double(rect.getCenterX(), rect.getCenterY(), rect.getCenterX(), rect.getCenterY() - 10));
        }
        updateArray();
        rect = new Rectangle2D.Double(x1, y1, x2, y2);
        repaint();

    }

    public void updateArray() {
        for (Shape shape : toDraw) {
            Line2D line = (Line2D) shape;
            line.setLine(line.getX1(), line.getY1() - 10, line.getX2(), line.getY2() - 10);
        }
    }

    public void pruneArray() {
        for (Shape shape : toDraw) {
            Line2D line = (Line2D) shape;
            if (line.getY1() < 0){
                toDraw.remove(shape);
            }

        }
    }

    public void initFrame() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addPanel();
        frame.setSize(800, 600);
        frame.setVisible(true);
    }

    public void addPanel() {
        frame.add(this);
        frame.addKeyListener(this);
        addKeyListener(this);
    }

    public void keyTyped(KeyEvent e) {
        System.out.println("asdsad");
    }

    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());
        // System.out.println("press");
        if (e.getKeyCode() == 40) {//down
            down = true;
        }

        if (e.getKeyCode() == 37) {//left
            left = true;
        }
        if (e.getKeyCode() == 38) {//up
            up = true;
        }
        if (e.getKeyCode() == 39) {//right
            right = true;
        }
        if (e.getKeyCode() == 32) {//space
            space = true;
        }

    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == 40) {//down
            down = false;
        }

        if (e.getKeyCode() == 37) {//left
            left = false;
        }
        if (e.getKeyCode() == 38) {//up
            up = false;
        }
        if (e.getKeyCode() == 39) {//right
            right = false;
        }
        if (e.getKeyCode() == 32) {//space
            space = false;
        }
    }
}
