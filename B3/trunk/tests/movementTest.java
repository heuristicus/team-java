/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trunk.tests;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Robot;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author michal
 */
public class movementTest extends JPanel implements KeyListener, MouseListener, MouseMotionListener {

    JFrame frame = new JFrame();
    int x1 = 10, y1 = 10, x2 = 20, y2 = 20;
    Rectangle2D rect = new Rectangle2D.Double(x1, y1, x2, y2);
    ArrayList<Shape> toDraw = new ArrayList<Shape>();
    Robot mouseRobot;
    boolean up = false;
    boolean down = false;
    boolean left = false;
    boolean right = false;
    boolean space = false;
    boolean kb = false;
    boolean mouse = false;

    public static void main(String[] args) {
        new movementTest();
    }

    public movementTest() {

        initFrame();
        hideMouse();

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
            //System.out.println(shape);
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
            if (line.getY1() < 0) {
                toDraw.remove(shape);
            }

        }
    }

    public void initFrame() {
        try {
            mouseRobot = new Robot();
        } catch (AWTException ex) {
            System.out.println("robot init failed.");
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addPanel();
        frame.setSize(800, 600);
        frame.setVisible(true);
    }

    public void addPanel() {
        addMouseListener(this);
        addMouseMotionListener(this);
        frame.add(this);
        frame.addKeyListener(this);
        addKeyListener(this);
    }

    public void keyTyped(KeyEvent e) {
        kb = true;
        // System.out.println("asdsad");
    }

    public void keyPressed(KeyEvent e) {
        kb = true;

        // System.out.println(e.getKeyCode());
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
        kb = true;

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

    public void hideMouse() {
        ImageIcon invisi = new ImageIcon(new byte[0]);
        Cursor invisible = getToolkit().createCustomCursor(
                invisi.getImage(), new Point(0, 0), "Hiding");
        this.setCursor(invisible);
    }

    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mousePressed(MouseEvent e) {
        space = true;

    }

    public void mouseReleased(MouseEvent e) {
        space = false;
    }

    public void mouseEntered(MouseEvent e) {
        mouse = true;
        mouseRobot.mouseMove((int) rect.getX(), (int) rect.getY());
        x1 = e.getX();
        y1 = e.getY();

    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {
        if (kb == true) {
            mouseRobot.mouseMove(x1, y1);
            kb = false;
        }
        mouse = true;
        x1 = e.getX();
        y1 = e.getY();

    }

    public void mouseMoved(MouseEvent e) {
        if (kb == true) {
            mouseRobot.mouseMove(x1, y1);
            kb = false;
        }
        mouse = true;
        x1 = e.getX();
        y1 = e.getY();



        //rect = new Rectangle2D.Double(e.getX(), e.getY(), (e.getX() +10), (e.getY()+10));
    }
}
